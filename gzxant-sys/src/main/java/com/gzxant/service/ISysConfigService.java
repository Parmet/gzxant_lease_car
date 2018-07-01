package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.base.vo.PCAjaxVO;
import com.gzxant.entity.SysConfig;

/**
 *
 * @author chen
 * @date 2017/9/21
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系統数据字典
 */
public interface ISysConfigService extends IBaseService<SysConfig> {

    void insert(String dicKey, String dicValue, Long dicPid, String type, String desc, String sort, String invalid, String path, String value);

    boolean update(Long id, String dicKey, String dicValue, String type, String desc, String sort, String invalid, String value);

    List<JsTree> getConfigTree();
    
    /**
     * 根据jkey获取其子项
     * @param code
     * @return
     */
    List<SysConfig> getSub(String jkey);

    PCAjaxVO delete(Long id);


}
