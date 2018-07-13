package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.CarArea;

public interface ICarAreaService extends IBaseService<CarArea> {
     
     /**
      * 查询某个车辆设置的所有信息
      *
      * @param id
      * @return
      */
      CarArea selectCarAreaAllInfoById(Long id) ;
      
      /**
       * 创建一个车辆设置对象
       *
       * @param CarArea
       */
      boolean insertCarArea(CarArea carArea) ;
      
      /**
       * 更新车辆设置对象
       *
       * @param CarArea
       */
       boolean updateCarArea(CarArea carAreaNew) ;
       
       /**
        * 查询所有车辆设置对象信息列表
        * @return
        */
       List<CarArea> selectAllCarAreaInfoList();
}
