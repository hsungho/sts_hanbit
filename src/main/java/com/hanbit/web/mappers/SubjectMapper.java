package com.hanbit.web.mappers;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.SubjectDTO;
@Repository
public interface SubjectMapper {
	public void insert(SubjectDTO sub);
	public SubjectDTO findById(String id);
	public int findId(String id);
}
