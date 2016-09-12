/**
 * 
 */
package com.hanbit.web.domains;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.hanbit.web.util.Constants;
/**
 * @date   :2016. 6. 17.
 * @author :ckan
 * @file   :Studente1.java
 * @story  :
 */
@Component
public class MemberDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name,id,pw,ssn,regDate,gender,profileImg,changepw,confirmpw,email,phone;
	private int birth,year,curyear;
	public MemberDTO() {
		// default constructor 기본 생성자
		// 생성자 오버로딩 
	}
	public MemberDTO(String name,String id,String pw,String ssn) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn; 
		
		this.curyear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis())));
		String[] gendergubun = ssn.split("-");
		this.year = Integer.parseInt(gendergubun[0].substring(0,2));
		switch (Integer.parseInt(gendergubun[1])) {
		case 1:case 5:
			this.gender = "남";
			this.year += 1900;
			break;
		case 3:case 7:
			this.gender = "남";
			this.year += 2000;
			break;		
		case 2:case 6:
			this.gender = "여";
			this.year += 1900;
			break;
		case 4:case 8:
			this.gender = "여";
			this.year += 2000;
			break;
		default:
			break;
		}
		this.birth = this.curyear - this.year + 1;
	}
	public void setPw(String pw){
		this.pw = pw;
	}
	public String getName(){
		return this.name;
	}
	public String getId(){
		return this.id;
	}
	public String getRegDate(){
		return this.regDate;
	}
	public String getGender(){
		return this.gender;
	}
	public int getBirth(){
		return this.birth;
	}
	public void setBirth() {
		this.curyear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis())));
		String[] gendergubun = ssn.split("-");
		this.year = Integer.parseInt(gendergubun[0].substring(0,2));
		switch (Integer.parseInt(gendergubun[1])) {
		case 1:case 5:
			this.gender = "남";
			this.year += 1900;
			break;
		case 3:case 7:
			this.gender = "남";
			this.year += 2000;
			break;		
		case 2:case 6:
			this.gender = "여";
			this.year += 1900;
			break;
		case 4:case 8:
			this.gender = "여";
			this.year += 2000;
			break;
		default:
			break;
		}
		this.birth = this.curyear - this.year + 1;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPw() {
		return pw;
	}
	public void setRegDate(String regDate){
		this.regDate = regDate;
	}
	public void setRegDate() {
		this.regDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
	}
	public String toString() {
		return Constants.SCHOOL_NAME+" [ 성명=" + name + ", 이메일=" + email + ", 아이디=" + id + ", 비번=****" + ", 주민번호=" + ssn + ", 등록일=" + regDate
				+ ", 성별=" + gender + ", 나이=" + birth + "]\n";
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getChangepw() {
		return changepw;
	}
	public void setChangepw(String changepw) {
		this.changepw = changepw;
	}
	public String getConfirmpw() {
		return confirmpw;
	}
	public void setConfirmpw(String confirmpw) {
		this.confirmpw = confirmpw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
