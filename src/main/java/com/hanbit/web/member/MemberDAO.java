package com.hanbit.web.member;

import java.util.List;
public interface MemberDAO {
	public int insert(MemberVO stu);
	public int update(MemberVO stu);
	public int delete(String id);
	public List<MemberVO> list();
	public MemberVO findById(String pk);
	public List<?> findByName(String name);
	public int count();
	public boolean login(MemberVO param);
	public int findByGender(String gender);
	public int findId(String id);
	public int findPw(MemberVO mem);
	public boolean existId(String id);
}
