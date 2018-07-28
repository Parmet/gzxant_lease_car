package com.gzxant.service.accident;

import java.util.List;

import com.gzxant.controller.vo.AccidentVo;
import com.gzxant.entity.accident.Accident;

public interface AccidentService {

	/**
	 * 添加
	 */
	void insert(Accident accident);
	
	/**
	 * 查询
	 */
	List<Accident> query(AccidentVo aVo);

	/**
	 * 根据id查询
	 */
	Accident getAccidentById(Integer id);

	/**
	 * 修改
	 */
	void update(Accident accident);

	/**
	 * 删除
	 */
	void delete(Integer id);

}
