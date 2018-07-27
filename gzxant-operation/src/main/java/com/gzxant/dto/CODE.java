package com.gzxant.dto;

import java.io.Serializable;

public class CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8307227849303766357L;

	public int index;

	public String msg;
	public static CODE SUCCESS = new CODE(1000, "成功");
	public static CODE PARAMERROR = new CODE(1001, "参数异常");
	public static CODE SYSTEMERROR = new CODE(1002, "系统异常");
	public static CODE NOTLOGIN = new CODE(1003, "用户未登录");
	public static CODE FAIL = new CODE(1004, "失败 ");
	public static CODE NO_USER = new CODE(1005, "用户不存在或者密码错误 ");
	public static CODE METHOD_TIME_OUT = new CODE(1006, "当前接口已作废");
	public static CODE HESSION_TIME_OUT = new CODE(1007, "服务连接超时，稍后请重试");
	public static CODE ACCOUNT_IS_FREEZE = new CODE(1008, "该帐号已被冻结");
	public static CODE ACCESE_NO = new CODE(1009, "权限不足");
	public static CODE NO_OWNER = new CODE(1010, "未选择货主");
	public static CODE NO_PALT = new CODE(1011, "没有选择平台");
	public static CODE API_IS_ERROR = new CODE(1012, "调用的接口存在内部错误");
	public static CODE REPORT_SUCCESS = new CODE(10000, "提交成功，请在邮箱里查收！");

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CODE(int index, String msg) {
		super();
		this.index = index;
		this.msg = msg;
	}

	public CODE() {
		super();
		// TODO Auto-generated constructor stub
	}
}
