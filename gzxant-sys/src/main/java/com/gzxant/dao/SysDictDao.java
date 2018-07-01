package com.gzxant.dao;


import java.util.List;

import com.gzxant.base.dao.TreeDao;
import com.gzxant.base.vo.JsTree;
import com.gzxant.entity.SysDict;

/**
 * Created by chen on 2017/4/10.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系统数据字典dao
 */
public interface SysDictDao extends TreeDao<SysDict>  {

	List<SysDict> getSub(String jkey);
}
