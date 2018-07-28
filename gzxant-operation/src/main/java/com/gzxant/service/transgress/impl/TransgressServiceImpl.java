package com.gzxant.service.transgress.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzxant.controller.vo.TransgressVo;
import com.gzxant.dao.transgress.TransgressMapper;
import com.gzxant.entity.transgress.Transgress;
import com.gzxant.service.transgress.TransgressService;

@Service
public class TransgressServiceImpl implements TransgressService{

	@Autowired
	private TransgressMapper tgMapper;
	
	@Override
	public List<Transgress> query(TransgressVo tgVo) {
		return tgMapper.query(tgVo);
	}

	@Override
	public void add(Transgress tg) {
		tgMapper.add(tg);
	}
	
}
