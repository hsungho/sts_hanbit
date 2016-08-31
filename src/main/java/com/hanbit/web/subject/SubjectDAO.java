package com.hanbit.web.subject;

public interface SubjectDAO {
	public void insert(SubjectVO sub);
	public SubjectVO findById(String id);
	public int findId(String id);
}
