package com.hanbit.web.util;

import com.hanbit.web.grade.GradeServiceImpl;
import com.hanbit.web.grade.GradeVO;

public class GradeTest {
	public static void main(String[] args) {
		GradeVO a = GradeServiceImpl.getInstance().findBySeq(1020);
        
		System.out.println(a.getName());
	}
}
