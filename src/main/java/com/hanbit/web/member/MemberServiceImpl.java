package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.account.AccountService;
import com.hanbit.web.account.AccountServiceImpl;
import com.hanbit.web.subject.SubjectDAOImple;
import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.subject.SubjectVO;
@Service
public class MemberServiceImpl implements MemberService{
	private MemberDAOImpl dao;
	private SubjectDAOImple subjDao;
	@Autowired private MemberVO member;
	@Autowired private SubjectVO subject;
	@Autowired private SubjectMemberVO subjectMember;
	private AccountService accService;
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		subjDao = SubjectDAOImple.getInstance();
	}
	@Override
	public String open(MemberVO stu) {
		int cnt = findId(stu.getId());
		if (cnt == 0) {
			return (dao.insert(stu) == 1)?"회원가입 축하합니다.":"회원가입 실패";		
		} else {
			return "중복 ID 입니다.";
		}
	}
	@Override
	public MemberVO show() {
		return member;
	}
	@Override
	public void update(MemberVO stu) {
		dao.update(stu);
	}
	@Override
	public String delete(String id) {
		String msg = "";
		if (dao.delete(id) != 0) {
			member = this.findById(id);
			msg = "삭제 성공 입니다.";
		}else{
			msg = "삭제 실패입니다.";
		}
		return msg;
	}
	public int count() {
		return dao.count();
	}
	public MemberVO findById(String id) {
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
	public SubjectMemberVO login(MemberVO member) {
		if (dao.findId(member.getId()) == 0){
			subjectMember.setId("ID Faile");
		} else{
			if(dao.findPw(member) == 0){
				subjectMember.setId("PW Faile");
			} else {
				if (dao.login(member)) {
					member = dao.findById(member.getId());
					//accService.map();
					if(subjDao.findId(member.getId()) == 0){
						subjectMember.setId("Subject ID fail");
					}else {
						subject = subjDao.findById(member.getId());
						subjectMember.setEmail(member.getEmail());
						subjectMember.setId(member.getId());
						subjectMember.setImg(member.getProfileImg());
						subjectMember.setMajor(subject.getMajor());
						subjectMember.setName(member.getName());
						subjectMember.setPhone(member.getPhone());
						subjectMember.setPw(member.getPw());
						subjectMember.setReg_date(member.getRegDate());
						subjectMember.setSsn_id(member.getSsn());
						subjectMember.setSubjects(subject.getSubjects());
					}	
				} else{
					subjectMember.setId("fail");
				}
			}
		}
		System.out.println("서비스로그인결과?"+subjectMember.getId());
		return subjectMember;
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
	public int findPw(MemberVO mem) {
		return dao.findPw(mem);
	}
	@Override
	public void logout(MemberVO mem) {
		if (member.getId().equals(mem.getId()) &&
			member.getPw().equals(mem.getPw())	
		   ) {
			member = null;
		} 
	}
}
