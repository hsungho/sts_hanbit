package com.hanbit.web.util;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.subject.SubjectServiceImpl;

public class SubjectTest {
	public static void main(String[] args) {
		SubjectMemberVO a = SubjectServiceImpl.getInstance().findById("kim");
		System.out.println(a.getName());
	}
}
