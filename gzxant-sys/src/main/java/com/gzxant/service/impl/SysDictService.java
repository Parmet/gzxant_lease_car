package com.gzxant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.base.vo.PCAjaxVO;
import com.gzxant.constant.Global;
import com.gzxant.dao.SysDictDao;
import com.gzxant.entity.SysDict;
import com.gzxant.service.ISysDictService;

/**
 *
 * @author chen
 * @date 2017/8/9
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysDictService extends BaseService<SysDictDao, SysDict> implements ISysDictService {

    /**
     * 更新节点
     *
     * @param id
     * @param dicKey
     * @param dicValue
     * @param type
     * @param desc
     * @param sort
     * @param invalid
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean update(Long id, String dicKey, String dicValue, String type, String desc, String sort, String invalid) {
        SysDict sysDict = selectById(id);
        if (null == sysDict) {
            return false;
        }
        sysDict.setJkey(dicKey);
        sysDict.setJvalue(dicValue);
        if (!Strings.isNullOrEmpty(sort)) {
            sysDict.setSort(Integer.parseInt(sort));
        }
        if (!Strings.isNullOrEmpty(type)) {
            sysDict.setType(type);
        }
        sysDict.setRemark(desc);
        sysDict.setInvalid(invalid);
        updateById(sysDict);
        return true;
    }

    @Override
    public List<JsTree> getDictTree() {
        logger.info("查找字段树");
        List<SysDict> sysDicts = this.baseMapper.selectList(Condition.create().orderBy("sort", true));
        List<JsTree> jts = Lists.newArrayList();
        for (SysDict sysDict : sysDicts) {
            JsTree jt = new JsTree();
            jt.setId(sysDict.getId().toString());
            jt.setParent(sysDict.getParentId().compareTo(0L) > 0 ? sysDict.getParentId().toString() : "#");
            jt.setText(sysDict.getJvalue());
            if ("C".equals(sysDict.getType())) {
                jt.setIcon("fa fa-home");
            } else {
                jt.setIcon("glyphicon glyphicon-tint");
            }
            jts.add(jt);
        }
        return jts;

    }

    /**
     * @param dicKey
     * @param dicValue
     * @param dicPid
     * @param type
     * @param desc
     * @param sort
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insert(String dicKey, String dicValue, Long dicPid, String type, String desc, String
            sort, String invalid, String path) {
        SysDict sysDict = new SysDict();

        if (null != dicPid) {
            sysDict.setParentId(dicPid);
        } else {
            sysDict.setParentId(0L);
        }
        sysDict.setJkey(dicKey);
        sysDict.setJvalue(dicValue);
        if (!Strings.isNullOrEmpty(sort)) {
            sysDict.setSort(Integer.parseInt(sort));
        }
        if (!Strings.isNullOrEmpty(type)) {
            sysDict.setType(type);
        }
        sysDict.setRemark(desc);
        sysDict.setInvalid(invalid);
        insert(sysDict);

        if (Global.TOP_TREE_NODE.equals(sysDict.getParentId())) {
            sysDict.setPath(sysDict.getId() + ".");
        } else {

            sysDict.setPath(path + sysDict.getId() + ".");
        }

        updateById(sysDict);

    }


    /**
     * 删除节点和子节点
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public PCAjaxVO delete(Long id) {
        PCAjaxVO status = new PCAjaxVO(true);
        //是否为类，以及类下是否有引用
        SysDict sysDict = selectById(id);

        if (sysDict != null) {
            //删除
            delete(Condition.create().like("path", sysDict.getPath(), SqlLike.RIGHT));

        } else {
            status.setSuccess(false);
            status.setMessage("该数据不存在");
        }
        status.setMessage("删除成功");
        return status;
    }

	@Override
	public List<SysDict> getSub(String jkey) {
		List<SysDict> sub = Lists.newArrayList();
		if (StringUtils.isBlank(jkey)) {
			return sub;
		}
		
		sub = this.baseMapper.getSub(jkey);
		return sub;
	}
    @Override
    public List<SysDict> getDictTree(String jkey) {
        List<SysDict> sub = Lists.newArrayList();
        if (StringUtils.isBlank(jkey)) {
            return sub;
        }

        sub = this.baseMapper.getSub(jkey);
        return sub;
    }
    private  List<JsTree> getSysDictParseJsTree( List<SysDict> sysDicts){
        List<JsTree> jts = Lists.newArrayList();
        for (SysDict sysDict : sysDicts) {
            JsTree jt = new JsTree();
            jt.setId(sysDict.getId().toString());
            jt.setParent( "#");
            jt.setText(sysDict.getJvalue());
            if ("C".equals(sysDict.getType())) {
                jt.setIcon("fa fa-home");
            } else {
                jt.setIcon("glyphicon glyphicon-tint");
            }
            jts.add(jt);
        }
        return jts;
    }

    /**
     * Compress the return map, only contain the required jkey to jvalue pair.
     * @param keyToJkey A map from entity's key to jkey.
     * @return
     */
    @Override
    public Map<String, Object> getDictMapByMap(Map<String, String> keyToJkey) {
        // Store the dict mapping that would need
        Map<String, Map<String, String>> dictMap = new HashMap<>();

        // do the query for all the needed mapping
        for(Map.Entry<String, String> entry : keyToJkey.entrySet()) {
            // construct an empty list
            Map<String, String> mp = new HashMap<>();

            for (SysDict each :
                    this.getDictTree(entry.getValue())) {
                // put the key value pair in this map
                mp.put(each.getJkey(),each.getJvalue());
            }

            // put the dict list into dict map
            dictMap.put(entry.getKey(),mp);

        }

        // construct the return map
        Map <String, Object>returnMap = new HashMap<>();
        returnMap.put("dict",dictMap);

        // return the final dict map
        return returnMap;
    }
}
