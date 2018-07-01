package com.gzxant.dao;


import java.util.List;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.SysConfig;

/**
 * Created by chen on 2017/4/10.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系统配置dao
 */
public interface SysConfigDao extends CrudDao<SysConfig> {
	List<SysConfig> getSub(String jkey);
}
