/**
 * 
 */
package com.hanbit.web.account;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @date   :2016. 6. 16.
 * @author :ckan
 * @file   :Account.java
 * @story  :
 */
@Component
public class AccountVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int accountNo,money; // 인스턴스 변수는 초기화를 하지 않는다. private 암호화 되어 있다. 보안
	private String name,id,pw,chagePw;
	public AccountVO() {
		// default constructor 기본 생성자
		// 생성자 오버로딩 
	}
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo() {
		this.accountNo = (int) (Math.random() * 999999)+100000;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getChagePw() {
		return chagePw;
	}
	public void setChagePw(String chagePw) {
		this.chagePw = chagePw;
	}
	public String toString() {// 메소드 오버라이딩
		return " ["+com.hanbit.web.util.Constants.BANK_NAME+" 계좌번호 : " + accountNo + " 성명 : " + name + 
				  " 잔액 : " + String.format("%,d", money) + " 아이디 : " + id + "]\n";
	}
}
