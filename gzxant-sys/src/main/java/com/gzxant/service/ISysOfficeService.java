package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.entity.SysOffice;

/**
 *
 * @author chen
 * @date 2017/11/13
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 组织
 */
public interface ISysOfficeService  extends IBaseService<SysOffice> {
    /**
     * 获取组织架构树
     * @return
     */
    List<JsTree> getOfficeTree();

    /**
     * 保存office （添加）
     * @param sysOffice
     */
    void add(SysOffice sysOffice);

    /**
     * 更新组织
     * @param sysOffice
     */
    void update(SysOffice sysOffice);
}
