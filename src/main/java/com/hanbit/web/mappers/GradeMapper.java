package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.GradeDTO;
@Repository
public interface GradeMapper {
	public int insert(GradeDTO grade);
	public int update(GradeDTO grade);
	public int delete(GradeDTO grade);
	public List<?> list();
	public GradeDTO findBySeq(int seq);
	public List<?> findById(String id);
	public int count(String examDate);
}
