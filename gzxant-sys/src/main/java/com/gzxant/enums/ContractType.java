package com.gzxant.enums;

/**
 * 合约类型
 * @author ZCRong
 *
 */
public enum ContractType {
	A("以租代购"),
	B("直租"),
	C("挂靠"),
	D("内部指派"),
	E("短租"),
	F("组牌"),
	G("长包"),
	H("转租"),
	I("长租"),
	J("经租");
	
	
	private final String contractType;

	public String getContractType() {
		return this.contractType;
	}
	ContractType(final String contractType) {
        this.contractType = contractType;
    }

}
