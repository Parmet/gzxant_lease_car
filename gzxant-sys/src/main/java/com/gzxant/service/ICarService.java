package com.gzxant.service;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.Car;

public interface ICarService extends IBaseService<Car> {
	
    /**
     * 保存菜单
     * @param car
     */
     void add(Car car);
}
