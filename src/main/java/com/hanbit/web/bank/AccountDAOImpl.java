package com.hanbit.web.bank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.home.HomeController;
import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

@Repository
public class AccountDAOImpl implements AccountDAO {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String NAMESPACE = "mapper.member.";
	private SqlSessionFactory sqlSessionFactory = null;
    
	private AccountDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	private static AccountDAOImpl instance = new AccountDAOImpl();

	public static AccountDAOImpl getInstance() {
		if (instance == null) {
			logger.info("AccountDAOImpl instance is created ");
			instance = new AccountDAOImpl();
		}
		return instance;
	}
	public int openAccount(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",acc);
	}
	public int selectMoney(int accNo) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("", accNo);
	}
	public void deposit(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
	}
	public void withdraw(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		
	}
	public List<AccountMemberVO> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");	
		
		}
	public Map<?, ?> selectMap() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectMap("","");
	}
}














