package com.hanbit.web.mappers;

import com.hanbit.web.domains.SubjectDTO;

public interface SubjectMapper {
	public void insert(SubjectDTO sub);
	public SubjectDTO findById(String id);
	public int findId(String id);
}
