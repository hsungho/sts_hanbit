package com.hanbit.web.member;

import java.util.List;

public interface MemberDAO {
	public int insert(MemberBean stu);
	public int update(MemberBean stu);
	public int delete(String id);
	public List<MemberBean> list();
	public MemberBean findById(String pk);
	public List<?> findByName(String name);
	public int count();
	public boolean login(MemberBean param);
	public int findByGender(String gender);
	public int findId(String id);
	public int findPw(MemberBean mem);
	public boolean existId(String id);

}
