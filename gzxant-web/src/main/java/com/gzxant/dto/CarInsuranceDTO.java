package com.gzxant.dto;

import com.gzxant.entity.car.insurance.CarInsurance;
import com.gzxant.entity.car.insurance.type.CarInsuranceType;

import java.util.List;

public class CarInsuranceDTO {
    private CarInsurance info;
    private List<CarInsuranceType> types;

    public CarInsurance getInfo() {
        return info;
    }

    public void setInfo(CarInsurance info) {
        this.info = info;
    }

    public List<CarInsuranceType> getTypes() {
        return types;
    }

    public void setTypes(List<CarInsuranceType> types) {
        this.types = types;
    }
}
