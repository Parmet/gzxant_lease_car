package com.gzxant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.CarArea;

public interface CarAreaDao extends CrudDao<CarArea> {
	
    /**
     * 查询某个车辆设置对象的所有信息
     * @param id
     * @return
     */
    CarArea selectCarAreaInfoById(@Param("id") Long id);
    
    /**
     * 查询所有车辆设置对象信息
     * @return
     */
    List<CarArea> selectAllCarAreaInfo();
    
    /**
     * 创建车辆设置对象
     * @param CarArea
     */
    void insertCarArea(CarArea carArea);
    	
    
}
