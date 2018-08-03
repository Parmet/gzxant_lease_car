package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.Car;
import com.gzxant.entity.CarSet;

public interface ICarSetService extends IBaseService<CarSet> {
     
     /**
      * 查询某个车辆设置的所有信息
      *
      * @param id
      * @return
      */
      CarSet selectCarSetAllInfoById(Long id) ;
      
      /**
       * 创建一个车辆设置对象
       *
       * @param carSet
       */
      boolean insertCarSet(CarSet carSet) ;
      
      /**
       * 更新车辆设置对象
       *
       * @param carset
       */
       boolean updateCarSet(CarSet carSetNew) ;
       
       /**
        * 查询所有车辆设置对象信息列表
        * @return
        */
       List<CarSet> selectAllCarSetInfoList();
}
