package com.hanbit.web.grade;

public interface GradeService extends com.hanbit.web.util.CommonService{
	// 총 7개의 기본 패턴이 존재하더라
	// exeu
	public String insert(GradeBean grade);
	public String update(GradeBean grade);
	public String delete(GradeBean grade);
	// exeQ
	public GradeBean findBySeq(int seq);
	public int count(String examDate);
	public String score(String[] a);
}
