package com.gzxant.dao;


import java.util.List;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.SysRole;

/**
 * Created by chen on 2017/3/2.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 角色 dao接口
 */

public interface SysRoleDao extends CrudDao<SysRole> {


    /**
     * 获取某个用户的角色和菜单
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRoleByUserId(Long userId);

}
