/**
 * 
 */
package com.hanbit.web.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date   :2016. 6. 20.
 * @author :ckan
 * @file   :AccountServiceImpl.java
 * @story  :계좌 인터페이스
 */
public class AccountServiceImpl implements AccountService {
	AccountDAO dao = null;
	private Map<?,?> map;
	private AccountServiceImpl() {
		dao = AccountDAO.getInstance();
		map = new HashMap<String,AccountMemberBean>();
	}
	private static AccountServiceImpl instance = new AccountServiceImpl();
	public static AccountServiceImpl getInstance() {
		return instance;
	}
	public String openAccount(String spec) {
		AccountBean account = new AccountBean();
		String msg = "";
		String specArry[] = spec.split(",");
		account.setName(specArry[0]);
		account.setId(specArry[1]);
		account.setPw(specArry[2]);
		while (true) {
			account.setAccountNo();
			if(findAccount(account.getAccountNo()) == 0) {
				break;
			}else{
				continue;
			}
		}
		if (dao.findId(account.getId()) == 0) {
			msg = "존재하지 않는 ID 입니다.";
			return msg;
		}
		if (dao.findName(account.getId(),account.getName()) == 0) {
			msg = "존재하지 않는 성명 입니다.";
			return msg;
		}
		if (dao.insert(account) == 0){
			msg = "계좌개설 실패 했습니다.";
		} else{
			msg = "계좌개설을 성공 했습니다.";
		}
		return msg;
	}
	public String deposit(int accountNo,int inputMoney) {
		AccountBean account1 = new AccountBean();
		String msg = "";
		account1.setAccountNo(accountNo);
		account1.setMoney(inputMoney);
		if (findAccount(accountNo) == 0) {
			msg = "계좌번호가 존재 하지않습니다.";
		}
		msg = (dao.deposit(accountNo,inputMoney) == 0)?"입금이 실패했습니다.":"입금이 완료 되었습니다.";
		return msg;
	}
	public String withdrawal(AccountBean account) {
		String msg = "";
		AccountBean acct = new AccountBean();
		if (findAccount(account.getAccountNo()) == 0) {
			msg = "계좌번호가 존재 하지않습니다.";
			return msg;
		}
		if(dao.findPw(account) == 0){
			msg = "비밀 번호가 맞지 않습니다.";
			return msg;
		}
		if (acct.getMoney() < account.getMoney()) {
			msg = "잔액이 부족 합니다.";
		}else{
			msg = (dao.withdrawal(account.getAccountNo(),account.getMoney()) == 0)?"출금이 실패했습니다.":"출금이 완료 되었습니다.";
		}
		return msg;
	}
	public String updateAccount(AccountBean acc) {
		String msg = "";
		if (dao.findAccount(acc.getAccountNo()) == 0) {
			return "존재하지 않는 계좌 입니다.";
		}
		if(dao.findPw(acc) == 0){
			return "비밀 번호가 맞지 않습니다.";
		}
		if (dao.updateAccount(acc) == 0) {
			msg = "비밀번호 수정 실패 했습니다.";
		} else{
			msg = "비밀번호 수정 완료 했습니다.";
		}
		return msg;
	}
	public String deleteAccount(int accountNo) {
		String msg = "";
		if (dao.findAccount(accountNo) == 0) {
			msg = "존재하지 않는 계좌 입니다.";
			return msg;
		}
		if (dao.delete(accountNo) == 0) {
			msg = "계좌해제가 실패 했습니다.";
		} else{
			msg = "계좌해제가 완료 했습니다.";
		}
		return msg;
	}
	public List<?> list() {
		return dao.selectAll();
	}
	public AccountMemberBean findByAccountNo(int accountNo) {
		return dao.findByAccountNo(accountNo);
	}
	public List<?> findBy(String name) {
		return dao.findByName(name);
	}
	public int count() {
		return dao.count();
	}
	public int findId(String id) {
		return dao.findId(id);
	}
	@Override
	public int findAccount(int accountNo) {
		
		return dao.findAccount(accountNo);
	}
	@Override
	public int findName(String id,String name) {
		return dao.findName(id,name);
	}
	@Override
	public int findPw(AccountBean account) {
		return dao.findPw(account);
	}
	@Override
	public Map<?, ?> map() {
		map = dao.selectMap();
		return map;
	}
}
