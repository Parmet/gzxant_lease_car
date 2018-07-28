package com.gzxant.dto;

import java.io.Serializable;
import java.util.UUID;

public class WebJsonBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	/**返回码*/
	private int code;
	/**说明*/
	private String desc;
	/**请求随机UUID*/
	private String tid = UUID.randomUUID().toString();
	/**返回数据*/
	private Object data;
	
	public WebJsonBean() {}
	
	public WebJsonBean(CODE code) {
		this.code = code.getIndex();
		this.desc = code.getMsg();
	}
	
	public WebJsonBean(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public WebJsonBean(int code, String desc, Object data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}
	
	public WebJsonBean(CODE code, Object data) {
		this.code = code.getIndex();
		this.desc = code.getMsg();
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
