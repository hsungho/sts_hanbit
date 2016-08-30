package com.hanbit.web.account;

import java.util.List;
import java.util.Map;

public interface AccountDAO {
	public int insert(AccountVO acct);
	public int findId(String id);
	public int findAccount(int accountNo);
	public int deposit(AccountVO acct);
	public int withdrawal(AccountVO account);
	public int updateAccount(AccountVO acc);
	public int delete(int accountNo);
	public AccountMemberVO findByAccountNo(int accountNo);
	public int findName(String name);
	public List<?> selectAll();
	public List<?> findByName(String name);
	public int count();
	public int findPw(AccountVO account);
	public Map<?, ?> selectMap();
}
