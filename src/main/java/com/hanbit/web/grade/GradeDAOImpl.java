package com.hanbit.web.grade;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @date   :2016. 7. 1.
 * @author :ckan
 * @file   :GradeDAO.java 
 * @story  :
 */
@Repository
public class GradeDAOImpl implements GradeDAO{
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	private static final String NAMESPACE = "mapper.grade.";
	private SqlSessionFactory sqlSessionFactory = null;
	private static GradeDAOImpl instance = new GradeDAOImpl();
	private GradeDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			logger.info("session build fail");
		}
	}
	public static GradeDAOImpl getInstance() {
		if (instance==null) {
			logger.info("GradeDAOImpl instance is created ||");
			instance = new GradeDAOImpl();
		}
		return instance;
	}
	public GradeDAOImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public int insert(GradeVO grade){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",grade);
	}
	@Override
	public int update(GradeVO grade){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",grade);
	}
	@Override
	public int delete(GradeVO grade) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",grade);
	}
	@Override
	public List<?> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public GradeVO findBySeq(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findBySeq",seq); 
		} finally {
			session.close();
		}
	}
	@Override
	public List<?> findById(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList(NAMESPACE + "findById",id); 
		} finally {
			session.close();
		}
	}
	public int count(String examDate) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",examDate);
	}
}
