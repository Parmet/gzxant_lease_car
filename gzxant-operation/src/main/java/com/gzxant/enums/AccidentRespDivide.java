package com.gzxant.enums;

/**
 * 事故管理-责任划分
 */
public enum AccidentRespDivide {
	WHOLE("全责",1),UNRESPONSIBILITY("无责",2),SUB("次责",3),UNKNOWN("不详",4),
	EQUAL("同等",5),MAIN("主责",6);
	
	private String name;
	private Integer index;
	private AccidentRespDivide(String name,int index){
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
		for (AccidentRespDivide c : AccidentRespDivide.values()) {
	        if (c.getIndex() == index) {
	            return c.name;
	        }
	    }
		return null;
	}
	
	public static Integer getIndex(String Name){
		for (AccidentRespDivide c : AccidentRespDivide.values()) {
	        if (c.getName() == Name) {
	            return c.index;
	        }
	    }
		return null;
	}
	
}
