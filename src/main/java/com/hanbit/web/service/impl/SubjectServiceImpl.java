package com.hanbit.web.service.impl;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.services.SubjectService;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectServiceImpl.java 
 * @story  :
 */
@Service
public class SubjectServiceImpl implements SubjectService{
	private  SubjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	
	public static SubjectServiceImpl getInstance() {
		return instance;
	}

	@Override
	public void insert(SubjectDTO sub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubjectDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
