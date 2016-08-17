/**
 * 
 */
package com.hanbit.web.account;

import com.hanbit.web.global.CommonService;

/**
 * @date   :2016. 6. 20.
 * @author :ckan
 * @file   :AccountService.java
 * @story  :
 */
public interface AccountService extends CommonService{
	    // 1개설 2입금 3출금 4수정 5해지 6조회(전체) 7조회(계좌번호) 8조회(이름) 9조회(전체통장수)
		// AccountBean account = null; 인터페이스는 iv 를 갔지않는다.
		// 1개설
		public abstract String openAccount(String spec);// abstract 추상 있어도 없어도 됨
		// 2입금
		public String deposit(int accountNo, int inputMoney);
		// 3출금
		public String withdrawal(AccountBean account);
		// 4.수정.. 사용자의 요청에 의해 비번만 전환가능
		public String updateAccount(AccountBean acc);// AccountNo,PW
		// 5해지
		public String deleteAccount(int accountNo);
		// 7조회(계좌번호)
		public AccountMemberBean findByAccountNo(int accountNo);
		// 10 id 존재여부 조회
		public int findId(String id);
		// 11 계좌번호 존재여부 조회
		public int findAccount(int accountNo);
		// 12 이름 존재여부 조회
		public int findName(String id,String name);
		// 13 PW 맞는지 조회
		public int findPw(AccountBean account);
}
