package com.gzxant.enums;


/**
 * 事故管理-处理状态
 */
public enum AccidentStatus {
	SUSPENDING("未处理",1),HANDING("处理中",2),SOLVED("已处理",3);
	private String name;
	private Integer index;
	private AccidentStatus(String name,int index){
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
		for (AccidentStatus c : AccidentStatus.values()) {
	        if (c.getIndex() == index) {
	            return c.name;
	        }
	    }
		return null;
	}
	
	public static Integer getIndex(String Name){
		for (AccidentStatus c : AccidentStatus.values()) {
	        if (c.getName() == Name) {
	            return c.index;
	        }
	    }
		return null;
	}
}
