package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.Car;
import com.gzxant.entity.SysUser;

public interface ICarService extends IBaseService<Car> {
     
     /**
      * 查询某个汽车对象的所有信息
      *
      * @param id
      * @return
      */
      Car selectCarAllInfoById(Long id) ;
      
      /**
       * 创建一个汽车 或者更新一个汽车
       *
       * @param car
       */
      boolean insertCar(Car car) ;
      
      /**
       * 更新用户
       *
       * @param car
       */
       boolean updateCar(Car carNew) ;
       
       /**
        * 查询所有汽车对象信息列表
        * @return
        */
       List<Car> selectAllCarInfoList();
}
