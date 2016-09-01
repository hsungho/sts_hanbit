package com.hanbit.web.subject;

public interface SubjectDAO {
	public void insert(SubjectMemberVO sub);
	public SubjectMemberVO findById(String id);

}
