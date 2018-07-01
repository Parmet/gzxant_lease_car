package com.gzxant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.SysRoleMenuDao;
import com.gzxant.entity.SysRoleMenu;
import com.gzxant.service.ISysRoleMenuService;

/**
 *
 * @author chen
 * @date 2017/10/26
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRoleMenuService  extends BaseService<SysRoleMenuDao, SysRoleMenu> implements ISysRoleMenuService {
}
