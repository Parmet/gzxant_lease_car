package com.gzxant.enums;

/**
 * 事故管理-事故性质
 */
public enum AccidentOperNature {
	UNILATERAL("单方事故",1),MUTUAL("双方事故",2),MULTIPARTY("多方事故",3);
	
	private String name;
	private Integer index;
	private AccidentOperNature(String name,int index){
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
		for (AccidentOperNature c : AccidentOperNature.values()) {
	        if (c.getIndex() == index) {
	            return c.name;
	        }
	    }
		return null;
	}
	
	public static Integer getIndex(String Name){
		for (AccidentOperNature c : AccidentOperNature.values()) {
	        if (c.getName() == Name) {
	            return c.index;
	        }
	    }
		return null;
	}
	
}
