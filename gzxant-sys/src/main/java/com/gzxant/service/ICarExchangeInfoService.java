package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.CarExchangeInfo;

public interface ICarExchangeInfoService extends IBaseService<CarExchangeInfo> {
     
     /**
      * 查询某个车辆申请交换对象的所有信息
      *
      * @param id
      * @return
      */
	  CarExchangeInfo selectCarExchangeInfoAllInfoById(Long id) ;
      
      /**
       * 创建一个车辆申请交换对象或者更新一个车辆申请交换对象
       *
       * @param CarExchangeInfo
       */
      boolean insertCarExchangeInfo(CarExchangeInfo CarExchangeInfo) ;
      
      /**
       * 更新合同车辆申请交换对象
       *
       * @param CarExchangeInfoNew
       */
       boolean updateCarExchangeInfo(CarExchangeInfo CarExchangeInfoNew) ;
       
       /**
        * 查询所有车辆申请交换对象信息列表
        * @return
        */
       List<CarExchangeInfo> selectAllCarExchangeInfoList();
}
