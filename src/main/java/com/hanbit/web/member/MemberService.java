/**
 * 
 */
package com.hanbit.web.member;

import com.hanbit.web.global.CommonService;
import com.hanbit.web.subject.SubjectMember;

/**
 * @date   :2016. 6. 17.
 * @author :ckan
 * @file   :StudentService.java
 * @story  :
 */
public interface MemberService extends CommonService{
	public String open(MemberBean stu);
	public MemberBean show();
	public void update(MemberBean stu);
	public String delete(String id);
	public MemberBean findById(String id);
	public SubjectMember login(MemberBean member);
	public int genderCount(String gender);
	public int findId(String id);
	public int findPw(MemberBean mem);
	public void logout(MemberBean mem);
}
