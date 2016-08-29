package com.hanbit.web.subject;
/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectServiceImpl.java 
 * @story  :
 */
public class SubjectServiceImpl implements SubjectService{
	SubjectDAO dao = SubjectDAO.getInstance();
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

}
