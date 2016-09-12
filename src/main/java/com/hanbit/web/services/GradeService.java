package com.hanbit.web.services;

import com.hanbit.web.domains.GradeDTO;

public interface GradeService extends com.hanbit.web.util.CommonService{
	// 총 7개의 기본 패턴이 존재하더라
	// exeu
	public String insert(GradeDTO grade);
	public String update(GradeDTO grade);
	public String delete(GradeDTO grade);
	// exeQ
	public int count(String examDate);
	public String score(String[] a);
}
