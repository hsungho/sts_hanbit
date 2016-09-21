package com.hanbit.web.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.Command;
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
	@Autowired Command command;
	MemberServiceImpl() {
		
	}
	@Override
	public String open(MemberDTO stu) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int cnt = findId(stu.getId());
		if (cnt == 0) {
			return "";		
		} else {
			return "중복 ID 입니다.";
		}
	}
	@Override
	public MemberDTO show() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return member;
	}
	@Override
	public void update(MemberDTO stu) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	}
	@Override
	public String delete(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String msg = "";
		return msg;
	}
	public int count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return 0;
	}
	@Override
	public Map<?, ?> map() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	@Override
	public void logout(MemberDTO mem) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		if (member.getId().equals(mem.getId()) &&
			member.getPw().equals(mem.getPw())	
		   ) {
			member = null;
		} 
	}
	@Override
	public List<?> list() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	@Override
	public List<?> findBy(String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	@Override
	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command);
	}
	@Override
	public int genderCount(String gender) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return 0;
	}
	@Override
	public int findId(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
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
		Command command = new Command();
		command.setKeyword(member.getId());
		command.setOption("mem_id");
		MemberDTO mem = this.findOne(command);
		if (member.getPw().equals(mem.getPw())) {
			logger.info("MemberService LOGIN IS {}","SUCCESS");
			return mem;
		}
		mem.setId("NONE");
		logger.info("MemberService LOGIN IS {}","FAIL");
		return mem;
	}
	@Override
	public int existId(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		logger.info("MemberService existid ID is {}",id);
		return mapper.existId(id);
	}
	
}