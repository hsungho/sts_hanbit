package com.hanbit.web.member;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * @date :2016. 7. 1.
 * @author :ckan
 * @file :MemberDAO.java
 * @story :
 */
@Repository
public class MemberDAOImpl implements MemberDAO{
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static MemberDAOImpl instance = new MemberDAOImpl();
	private static final String NAMESPACE = "mapper.member.";
	private SqlSessionFactory sqlSessionFactory = null;
	private MemberDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			logger.info("session build fail");
		}
	}
	public static MemberDAOImpl getInstance() {
		if (instance==null) {
			logger.info("MemberDAOImpl instance is created ||");
			instance = new MemberDAOImpl();
		}
		return instance;
	}
	
	
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
		try {
			return session.selectOne(NAMESPACE + "findById",pk); 
		} finally {
			session.close();
		}
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
		System.out.println("LOGIN OK ?"+loginOk);
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
		try {
			return session.selectOne(NAMESPACE + "findId",id); 
		} finally {
			session.close();
		}
	}
	@Override
	public int findPw(MemberVO mem) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findPw",mem); 
		} finally {
			session.close();
		}
	}
	@Override
	public boolean existId(String id){
		int count = 0;
		boolean flag = false;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			count = session.selectOne("mapper.member.existId", id);
			if(count==1){flag = true;}
		} finally {
			session.close();
		}
		return flag;
	}
}
