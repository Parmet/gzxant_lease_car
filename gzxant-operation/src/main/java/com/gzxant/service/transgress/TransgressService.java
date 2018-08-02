package com.gzxant.service.transgress;

import java.util.Date;
import java.util.List;

import com.gzxant.controller.vo.TransgressVo;
import com.gzxant.entity.transgress.Transgress;

public interface TransgressService {
	
	/**
	 * 查詢
	 */
	List<Transgress> query(TransgressVo tgVo);
	
	/**
	 * 添加
	*/
	void add(Transgress tg);

	/**
	 * 统计
	 */
	Integer count(Long userUnit, Date beginDate, Date endDate);

}
