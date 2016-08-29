/**
 * 
 */
package com.hanbit.web.member;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.util.CommonService;

/**
 * @date   :2016. 6. 17.
 * @author :ckan
 * @file   :StudentService.java
 * @story  :
 */
public interface MemberService extends CommonService{
	public String open(MemberVO stu);
	public MemberVO show();
	public void update(MemberVO stu);
	public String delete(String id);
	public MemberVO findById(String id);
	public SubjectMemberVO login(MemberVO member);
	public int genderCount(String gender);
	public int findId(String id);
	public int findPw(MemberVO mem);
	public void logout(MemberVO mem);
}
