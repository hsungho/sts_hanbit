package com.hanbit.web.subject;

import org.springframework.stereotype.Service;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectServiceImpl.java 
 * @story  :
 */
@Service
public class SubjectServiceImpl implements SubjectService{
	SubjectDAOImple dao = SubjectDAOImple.getInstance();
	private  SubjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	@Override
	public void insert(SubjectVO sub) {
		dao.insert(sub);
	}
	@Override
	public SubjectMemberVO findById(String id) {
		SubjectMemberVO subject = new SubjectMemberVO();
		subject = dao.findById(id);
		return subject;
	}

}
