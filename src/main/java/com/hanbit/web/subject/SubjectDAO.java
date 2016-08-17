package com.hanbit.web.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hanbit.web.global.Constants;
import com.hanbit.web.global.DatabaseFactory;
import com.hanbit.web.global.Vendor;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectDAO.java 
 * @story  :
 */
public class SubjectDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	private static SubjectDAO instance = new SubjectDAO();
	private SubjectDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE,Constants.USER_ID,Constants.USER_PW).getConnection();
	}
	public static SubjectDAO getInstance() {
		return instance;
	}
	public void insert(SubjectBean sub){
		int result = 0;
		String sql = "insert into subject (subj_seq,major,subjects,id) "
				      + " values(subj_seq.nextval,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sub.getMajor());
			pstmt.setString(2, sub.getSubjects());
			pstmt.setString(3, sub.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public SubjectBean findById(String id) {
		String sql = "select * from subject_member where id = ?";
		SubjectBean tempBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tempBean = new SubjectBean();
				tempBean.setId(rs.getString("id"));
				tempBean.setMajor(rs.getString("major"));
				tempBean.setSubjects(rs.getString("subjects"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempBean;
	}
	public int findId(String id) {
		int result = 0;
		String sql = "select count(*) count from subject "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
