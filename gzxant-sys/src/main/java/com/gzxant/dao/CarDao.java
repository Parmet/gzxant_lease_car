package com.gzxant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.Car;

public interface CarDao extends CrudDao<Car> {
	
    /**
     * 查询某个汽车的所有信息
     * @param id
     * @return
     */
    Car selectCarInfoById(@Param("id") Long id);
    
    /**
     * 查询所有汽车信息
     * @return
     */
    List<Car> selectAllCarInfo();
    
    /**
     * 新建汽车对象
     */
    void insertCar(Car car);
    
}
