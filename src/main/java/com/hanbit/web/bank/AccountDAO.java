package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

import com.hanbit.web.bank.AccountVO;

public interface AccountDAO {
	
	public int openAccount(AccountVO acc);
	public int selectMoney(int accNo);
	public void deposit(AccountVO acc);
	public void withdraw(AccountVO acc);
	public List<AccountMemberVO> selectAll();
	public Map<?, ?> selectMap();
}
