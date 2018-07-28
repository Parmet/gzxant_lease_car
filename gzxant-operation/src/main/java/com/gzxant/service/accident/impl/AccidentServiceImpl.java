package com.gzxant.service.accident.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gzxant.controller.vo.AccidentVo;
import com.gzxant.dao.accident.AccidentMapper;
import com.gzxant.entity.accident.Accident;
import com.gzxant.service.accident.AccidentService;

@Service
public class AccidentServiceImpl implements AccidentService{

	private AccidentMapper aMapper;
	
	@Override
	public void insert(Accident accident) {
		aMapper.insert(accident);
	}

	@Override
	public List<Accident> query(AccidentVo aVo) {
		return aMapper.query(aVo);
	}

	@Override
	public Accident getAccidentById(Integer id) {
		List<Accident> aList = aMapper.getAccidentById(id);
		return aList.get(0);
	}

	@Override
	public void update(Accident accident) {
		aMapper.update(accident);
	}

	@Override
	public void delete(Integer id) {
		aMapper.delete(id);
	}

}
