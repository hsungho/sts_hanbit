package com.hanbit.web.account;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
 * @file   :BankDAO.java 
 * @story  :
 */
@Repository
public class AccountDAOImpl implements AccountDAO{
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	private AccountDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			logger.info("session build fail");
		}
	}
	private static AccountDAOImpl instance = new AccountDAOImpl();
	public static AccountDAOImpl getInstance() {
		if (instance==null) {
			logger.info("AccountDAOImpl instance is created ||");
			instance = new AccountDAOImpl();
		}
		return instance;
	}
	private static final String NAMESPACE = "mapper.account.";
	private SqlSessionFactory sqlSessionFactory = null;
	public AccountDAOImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public int insert(AccountVO acct) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",acct);
	}
	@Override
	public int updateAccount(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",acc);
	}
	@Override
	public int deposit(AccountVO acct) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",acct);
	}
	@Override
	public int withdrawal(AccountVO account) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",account);
	}
	@Override
	public int delete(int accountNo) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",accountNo);
	}
	@Override
	public int findId(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",id);
	}
	@Override
	public int findAccount(int accountNo) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",accountNo);
	}
	@Override
	public AccountMemberVO findByAccountNo(int accountNo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findByAccountNo",accountNo); 
		} finally {
			session.close();
		}
	}
	@Override
	public int findName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findName",name); 
		} finally {
			session.close();
		}
	}
	@Override
	public List<?> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public List<?> findByName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}
	@Override
	public int findPw(AccountVO account) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",account);
	}
	@Override
	public Map<?, ?> selectMap() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectMap(null, null);
	}
}
