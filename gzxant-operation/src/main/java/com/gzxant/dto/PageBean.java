package com.gzxant.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<K> implements Serializable
{
	private static final long serialVersionUID = 5500246242886020271L;

	/** 数据 */
	private List<K> record;
	/** 整个数据集总记录数 */
	private long totalNum;
	/** 分页每页大小 */
	private int pageSize;
	/** 当前分页的页码 */
	private int pageNo;
	
	/**
	 * 默认构造函数
	 */
	public PageBean()
	{
		this.record = new ArrayList<K>();
		this.totalNum = 0;
		this.pageSize = 1;
		this.pageNo = 1;
	}	
	
	/**
	 * 构造函数
	 * @param record
	 * @param totalRecord
	 * @param pageSize
	 * @param pageNo
	 */
	public PageBean(List<K> record,long totalRecord,int pageSize,int pageNo)
	{
		this.record = record;
		this.totalNum = totalRecord;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}

	public List<K> getRecord() {
		return record;
	}

	public void setRecord(List<K> record) {
		this.record = record;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}