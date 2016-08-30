package com.hanbit.web.subject;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectService.java 
 * @story  :
 */
public interface SubjectService {
	public void insert(SubjectVO sub);
	public SubjectMemberVO findById(String id);
}
