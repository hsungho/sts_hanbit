package com.hanbit.web.subject;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.member.MemberDAOImpl;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectDAO.java 
 * @story  :
 */
@Repository
public class SubjectDAOImple implements SubjectDAO{
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static SubjectDAOImple instance = new SubjectDAOImple();
	private static final String NAMESPACE = "mapper.subject.";
	private SqlSessionFactory sqlSessionFactory = null;
	private SubjectDAOImple() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			logger.info("session build fail");
		}
	}
	public static SubjectDAOImple getInstance() {
		return instance;
	}
	public void SubjectDAOImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public void insert(SubjectVO sub){
		SqlSession session = sqlSessionFactory.openSession();
	}
	public SubjectMemberVO findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findById",id); 
		} finally {
			session.close();
		}
	}
	public int findId(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",id);
	}
}
