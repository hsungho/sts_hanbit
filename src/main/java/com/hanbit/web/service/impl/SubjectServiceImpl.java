package com.hanbit.web.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.mappers.SubjectMapper;
import com.hanbit.web.services.SubjectService;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectServiceImpl.java 
 * @story  :
 */
@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired SqlSession sqlSession;

	@Override
	public void insert(SubjectDTO sub) {
		// TODO Auto-generated method stub
		SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);
	}

	@Override
	public SubjectDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
