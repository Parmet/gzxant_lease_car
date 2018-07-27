package com.gzxant.enums;

/**
 * 事故管理-使用性质
 */
public enum AccidentUseNature {
	LEASE("营运租赁",1),NONOPERATION("非营运企业",2),FAMILY("家庭自用",3),TRANSIT("营业城市公交",4),
	GOVERNMENT("非营业党政机关",5),TRANSPORT("营业公路客运",6),ENTERPRISE("营业企业",7);
	
	private String name;
	private Integer index;
	private AccidentUseNature(String name,int index){
		this.name = name;
		this.index = index;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public static String getName(Integer index){
		for (AccidentUseNature c : AccidentUseNature.values()) {
	        if (c.getIndex() == index) {
	            return c.name;
	        }
	    }
		return null;
	}
	
	public static Integer getIndex(String Name){
		for (AccidentUseNature c : AccidentUseNature.values()) {
	        if (c.getName() == Name) {
	            return c.index;
	        }
	    }
		return null;
	}
	
}
