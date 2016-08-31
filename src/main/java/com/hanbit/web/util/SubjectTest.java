package com.hanbit.web.util;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.subject.SubjectServiceImpl;
import com.hanbit.web.subject.SubjectVO;

public class SubjectTest {
	public static void main(String[] args) {
		SubjectVO a = SubjectServiceImpl.getInstance().findById("kim");
		System.out.println(a.getId());
	}
}
