package com.hanbit.web.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;
@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired private SqlSession sqlSession;
	@Autowired private MemberDTO member;
	@Autowired private SubjectDTO subject;
	private MemberServiceImpl() {
		
	}
	@Override
	public String open(MemberDTO stu) {
		int cnt = findId(stu.getId());
		if (cnt == 0) {
			return "";		
		} else {
			return "중복 ID 입니다.";
		}
	}
	@Override
	public MemberDTO show() {
		return member;
	}
	@Override
	public void update(MemberDTO stu) {
		
	}
	@Override
	public String delete(String id) {
		String msg = "";
		return msg;
	}
	public int count() {
		return 0;
	}
	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void logout(MemberDTO mem) {
		if (member.getId().equals(mem.getId()) &&
			member.getPw().equals(mem.getPw())	
		   ) {
			member = null;
		} 
	}
	@Override
	public List<?> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<?> findBy(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberDTO findById(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// TODO Auto-generated method stub	
		return mapper.findById(id);
	}
	@Override
	public int genderCount(String gender) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int findId(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int findPw(MemberDTO mem) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public MemberDTO login(MemberDTO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		logger.info("MemberService login ID = {}",member.getId());
		MemberDTO mem = this.findById(member.getId());
		if (member.getPw().equals(mem.getPw())) {
			logger.info("MemberService LOGIN IS ","SUCCESS");
			return mem;
		}
		mem.setId("NONE");
		logger.info("MemberService LOGIN IS ","FAIL");
		return mem;
	}
}
