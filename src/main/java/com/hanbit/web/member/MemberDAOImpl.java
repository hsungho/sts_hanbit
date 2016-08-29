package com.hanbit.web.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @date :2016. 7. 1.
 * @author :ckan
 * @file :MemberDAO.java
 * @story :
 */
@Repository
public class MemberDAOImpl implements MemberDAO{
	private SqlSessionFactory sqlSessionFactory = null;
	public MemberDAOImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public int insert(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",member);
	}
	@Override
	public int update(MemberVO member){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",member);
	}
	@Override
	public int delete(String id){
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",id);
	}
	@Override
	public List<MemberVO> list(){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}	
	@Override
	public MemberVO findById(String pk) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne(pk);
	}
	@Override
	public List<?> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("",name);
	}
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
	@Override
	public boolean login(MemberVO param) {
		boolean loginOk= false;
		if(param.getId()!=null 
				&& param.getPw()!=null 
				&& this.existId(param.getId())){
			MemberVO member = this.findById(param.getId());
			if(member.getPw().equals(param.getPw())){
				loginOk = true;
			}
		}
		return loginOk;
	}
	@Override
	public int findByGender(String gender) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",gender);
	}
	@Override
	public int findId(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",id);
	}
	@Override
	public int findPw(MemberVO mem) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",mem);
	}
	@Override
	public boolean existId(String id){
		SqlSession session = sqlSessionFactory.openSession();
		int temp = session.selectOne("",id);
		return false;
	}
}
