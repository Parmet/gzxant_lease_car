package com.gzxant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.CarSet;

public interface CarSetDao extends CrudDao<CarSet> {
	
    /**
     * 查询某个车辆设置对象的所有信息
     * @param id
     * @return
     */
    CarSet selectCarSetInfoById(@Param("id") Long id);
    
    /**
     * 查询所有车辆设置对象信息
     * @return
     */
    List<CarSet> selectAllCarSetInfo();
    
    /**
     * 创建车辆设置对象
     * @param carSet
     */
    void insertCarSet(CarSet carSet);
    	
    
}
