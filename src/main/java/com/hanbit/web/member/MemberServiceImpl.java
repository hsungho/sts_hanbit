package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import com.hanbit.web.account.AccountService;
import com.hanbit.web.account.AccountServiceImpl;
import com.hanbit.web.subject.SubjectBean;
import com.hanbit.web.subject.SubjectDAO;
import com.hanbit.web.subject.SubjectMember;

public class MemberServiceImpl implements MemberService{
	private MemberDAOImpl dao = MemberDAOImpl.getInstance(); // 싱글톤 패턴
	private AccountService accService = AccountServiceImpl.getInstance();
	private MemberBean session;
	private SubjectDAO subjDao = SubjectDAO.getInstance();
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	private MemberServiceImpl() {
	}
	@Override
	public String open(MemberBean stu) {
		int cnt = findId(stu.getId());
		if (cnt == 0) {
			return (dao.insert(stu) == 1)?"회원가입 축하합니다.":"회원가입 실패";		
		} else {
			return "중복 ID 입니다.";
		}
	}
	@Override
	public MemberBean show() {
		return session;
	}
	@Override
	public void update(MemberBean stu) {
		dao.update(stu);
	}
	@Override
	public String delete(String id) {
		String msg = "";
		if (dao.delete(id) != 0) {
			session = this.findById(id);
			msg = "삭제 성공 입니다.";
		}else{
			msg = "삭제 실패입니다.";
		}
		return msg;
	}
	public int count() {
		return dao.count();
	}
	public MemberBean findById(String id) {
		return dao.findById(id);
	}
	public List<?> list() {
		return dao.list();
	}
	public List<?> findBy(String name) {
		return dao.findByName(name);
	}
	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	public SubjectMember login(MemberBean member) {
		SubjectMember sm = new SubjectMember();
		SubjectBean sb =new SubjectBean();
		if(dao.findId(member.getId()) == 0) {
			sm.setId("fail");
		} else {
			// 2.로그인
			if (dao.login(member)) {
				session = dao.findById(member.getId());
				accService.map();
				if(subjDao.findId(session.getId()) == 0){
					sm.setId("fail");
				} else {
					sb = subjDao.findById(member.getId());
					sm.setEmail(session.getEmail());
					sm.setId(session.getId());
					sm.setImg(session.getProfileImg());
					sm.setMajor(sb.getMajor());
					sm.setName(session.getName());
					sm.setPhone(session.getPhone());
					sm.setPw(session.getPw());
					sm.setReg_date(session.getRegDate());
					sm.setSsn_id(session.getSsn());
					sm.setSubjects(sb.getSubjects());
					sm.setBirth(session.getSsn().substring(0,6));
					sm.setGender(session.getGender());
				}
			}else{
				sm.setId("fail");
			}
		}
		return sm;
	}
	@Override
	public int genderCount(String gender) {
		return dao.findByGender(gender);
	}
	@Override
	public int findId(String id) {
		return dao.findId(id);
	}
	@Override
	public int findPw(MemberBean mem) {
		return dao.findPw(mem);
	}
	@Override
	public void logout(MemberBean mem) {
		if (session.getId().equals(mem.getId()) &&
			session.getPw().equals(mem.getPw())	
		   ) {
			session = null;
		} 
	}
}
