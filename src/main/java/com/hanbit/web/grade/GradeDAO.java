package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date   :2016. 7. 1.
 * @author :ckan
 * @file   :GradeDAO.java 
 * @story  :
 */
public class GradeDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	private static GradeDAO instance = new GradeDAO();
	private GradeDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE,Constants.USER_ID,Constants.USER_PW).getConnection();
	}
	public static GradeDAO getInstance() {
		return instance;
	}
	public int insert(GradeVO grade){
		int result = 0;
		String sql = "insert into grade (seq,grade,java,sql,html,javascript,id,exam_date) "
				      + " values(seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade.getGrade());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getHtml());
			pstmt.setInt(5, grade.getJavascript());
			pstmt.setString(6, grade.getId());
			pstmt.setString(7, grade.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int update(GradeVO grade){
		int result = 0;
		String sql = "update grade "
				+ " set grade = ?, "
				+ grade.getClassName()+" = ? "
				+ " where seq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade.getGrade());
			pstmt.setInt(2, grade.getUpdatescore());
			pstmt.setInt(3, grade.getSeq());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int delete(GradeVO grade) {
		int result = 0;
		String sql = "delete grade "
				+ " where seq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade.getSeq());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// list
	public List<?> list() {
		String sql = "select * from grade_view order by name,id,exam_date";
		List<GradeVO> tempList = new ArrayList<GradeVO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeVO mem = new GradeVO();
				mem.setSeq(rs.getInt("SEQ"));
				mem.setGrade(rs.getString("GRADE"));
				mem.setJava(rs.getInt("JAVA"));
				mem.setSql(rs.getInt("SQL"));
				mem.setHtml(rs.getInt("HTML"));
				mem.setJavascript(rs.getInt("JAVASCRIPT"));
				mem.setId(rs.getString("ID"));
				mem.setExamDate(rs.getString("EXAM_DATE"));
				mem.setName(rs.getString("NAME"));
				tempList.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	// findByPK
	public GradeVO findBySeq(int seq) {
		String sql = "select * from grade_view where seq = ? order by name,id,exam_date";
		GradeVO tempBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tempBean = new GradeVO();
				tempBean.setSeq(rs.getInt("SEQ"));
				tempBean.setGrade(rs.getString("GRADE"));
				tempBean.setJava(rs.getInt("JAVA"));
				tempBean.setSql(rs.getInt("SQL"));
				tempBean.setHtml(rs.getInt("HTML"));
				tempBean.setJavascript(rs.getInt("JAVASCRIPT"));
				tempBean.setId(rs.getString("ID"));
				tempBean.setExamDate(rs.getString("EXAM_DATE"));
				tempBean.setName(rs.getString("NAME"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempBean;
	}
	// findByName
	public List<?> findById(String id) {
		String sql = "select * from grade where id = ? order by name,id,exam_date";
		List<GradeVO> tempList = new ArrayList<GradeVO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeVO mem = new GradeVO();
				mem.setSeq(rs.getInt("SEQ"));
				mem.setGrade(rs.getString("GRADE"));
				mem.setJava(rs.getInt("JAVA"));
				mem.setSql(rs.getInt("SQL"));
				mem.setHtml(rs.getInt("HTML"));
				mem.setJavascript(rs.getInt("JAVASCRIPT"));
				mem.setId(rs.getString("ID"));
				mem.setExamDate(rs.getString("EXAM_DATE"));
				mem.setName(rs.getString("NAME"));
				tempList.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	public int count(String examDate) {
		int result = 0;
		String sql = "select count(*) count from grade where exam_date = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,examDate);
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
}
