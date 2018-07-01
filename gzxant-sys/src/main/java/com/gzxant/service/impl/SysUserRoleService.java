package com.gzxant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.SysUserRoleDao;
import com.gzxant.entity.SysUserRole;
import com.gzxant.service.ISysUserRoleService;

/**
 *
 * @author chen
 * @date 2017/9/1
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系统用户角色中间表
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysUserRoleService extends BaseService<SysUserRoleDao, SysUserRole> implements ISysUserRoleService {
}
