package com.hanbit.web.account;

import org.springframework.stereotype.Component;

/**
 * @date   :2016. 7. 8.
 * @author :ckan
 * @file   :AccountMemberBean.java 
 * @story  :
 */
@Component
public class AccountMemberVO {
	private int accountNo,money,year,curyear; // 인스턴스 변수는 초기화를 하지 않는다. private 암호화 되어 있다. 보안
	private String name,id,pw,chagePw,ssn,regDate,gender,birth;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCuryear() {
		return curyear;
	}
	public void setCuryear(int curyear) {
		this.curyear = curyear;
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "계좌번호 : " + accountNo + " 잔액 : " + String.format("%,d", money) + "원 이름 : " + name + " ID : " + id
				+ " 생년월일 : " + birth;
	}
}