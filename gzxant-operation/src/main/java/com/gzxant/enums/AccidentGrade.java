package com.gzxant.enums;

/**
 * 事故管理-事故等级
 */
public enum AccidentGrade {
	SLIGHT("轻微事故",1),COMMONLY("一般事故",2),MAJOR("重大事故",3),OVERSIZE("特大事故",4);
	
	private String name;
	private Integer index;
	private AccidentGrade(String name,int index){
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
		for (AccidentGrade c : AccidentGrade.values()) {
	        if (c.getIndex() == index) {
	            return c.name;
	        }
	    }
		return null;
	}
	
	public static Integer getIndex(String Name){
		for (AccidentGrade c : AccidentGrade.values()) {
	        if (c.getName() == Name) {
	            return c.index;
	        }
	    }
		return null;
	}
	
}
