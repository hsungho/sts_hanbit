package com.hanbit.web.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date   :2016. 7. 1.
 * @author :ckan
 * @file   :BankDAO.java 
 * @story  :
 */
public class AccountDAO {
	private Connection con = null;
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	private AccountDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE,Constants.USER_ID,Constants.USER_PW).getConnection();
	}
	private static AccountDAO instance = new AccountDAO();
	public static AccountDAO getInstance() {
		return instance;
	}
	public int insert(AccountVO acct) {
		int result = 0;
		String sql = "insert into account(account_no,money,id,pw)"
				+ "values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acct.getAccountNo());
			pstmt.setInt(2, 0);
			pstmt.setString(3, acct.getId());
			pstmt.setString(4, acct.getPw());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int findId(String id) {
		int result = 0;
		String sql = "select count(*) count from member where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int findAccount(int accountNo) {
		int result = 0;
		String sql = "select count(*) count from account where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,accountNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deposit(int accountNo, int inputMoney) {
		int result = 0;
		String sql = "update account "
				+ "set money = NVL(money,0) + ? "
				+ "where account_no = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inputMoney);
			pstmt.setInt(2, accountNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int withdrawal(int accountNo, int outputMoney) {
		int result = 0;
		String sql = "update account "
				+ "set money = NVL(money,0) - ? "
				+ "where account_no = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, outputMoney);
			pstmt.setInt(2, accountNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateAccount(AccountVO acc) {
		int result = 0;
		String sql = "update account "
				+ "set pw = ? "
				+ "where account_no = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acc.getChagePw());
			pstmt.setInt(2, acc.getAccountNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int delete(int accountNo) {
		int result = 0;
		String sql = "delete account "
				+ "where account_no = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public AccountMemberVO findByAccountNo(int accountNo) {
		String sql = "select * from account_member where account_no = ? ";
		AccountMemberVO tempBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tempBean = new AccountMemberVO();
				tempBean.setAccountNo(rs.getInt("ACCOUNT_NO"));
				tempBean.setName(rs.getString("NAME"));
				tempBean.setId(rs.getString("ID"));
				tempBean.setMoney(rs.getInt("MONEY"));
				tempBean.setPw(rs.getString("PW"));
				tempBean.setSsn(rs.getString("SSN_ID").substring(0, 6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempBean;
	}
	public int findName(String id,String name) {
		int result = 0;
		String sql = "select count(*) count from member where id = ? and name = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<?> selectAll() {
		String sql = "select "
				+ "account_no,"
				+ "id,"
				+ "name,"
				+ "money,"
				+ "pw, "
				+ "ssn_id "
				+ "from account_member "
				+ "order by name,id,account_no";
		List<AccountMemberVO> tempList = new ArrayList<AccountMemberVO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountMemberVO mem = new AccountMemberVO();
				mem.setAccountNo(rs.getInt("account_no"));
				mem.setName(rs.getString("name"));
				mem.setId(rs.getString("id"));
				mem.setMoney(rs.getInt("money"));
				mem.setPw(rs.getString("pw"));
				mem.setSsn(rs.getString("ssn_id").substring(0, 6));
				tempList.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	public List<?> findByName(String name) {
		String sql = "select * from account_member "
				+ " where name = ? "
				+ "order by name,id,account_no ";
		List<AccountMemberVO> tempList = new ArrayList<AccountMemberVO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountMemberVO mem = new AccountMemberVO();
				mem.setAccountNo(rs.getInt("ACCOUNT_NO"));
				mem.setName(rs.getString("NAME"));
				mem.setId(rs.getString("ID"));
				mem.setMoney(rs.getInt("MONEY"));
				mem.setPw(rs.getString("PW"));
				mem.setSsn(rs.getString("SSN_ID").substring(0, 6));
				tempList.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	public int count() {
		int result = 0;
		String sql = "select count(*) count from account ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int findPw(AccountVO account) {
		int result = 0;
		String sql = "select count(*) count "
				+ "from account "
				+ "where account_no = ? "
				+ "and pw = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account.getAccountNo());
			pstmt.setString(2, account.getPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Map<?, ?> selectMap() {
		Map<String, AccountMemberVO> map = new HashMap<String,AccountMemberVO>();
		String sql = "select * from account_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountMemberVO mm = new AccountMemberVO();
				mm.setAccountNo(rs.getInt("account_no"));
				mm.setName(rs.getString("name"));
				mm.setId(rs.getString("id"));
				mm.setMoney(rs.getInt("money"));
				mm.setPw(rs.getString("pw"));
				mm.setBirth(rs.getString("ssn_id").substring(0, 6));
				map.put(String.valueOf(mm.getAccountNo()), mm);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
