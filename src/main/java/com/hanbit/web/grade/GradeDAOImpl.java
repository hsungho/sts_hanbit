package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

public class GradeDAOImpl {
	
	private static GradeDAOImpl instance = new GradeDAOImpl();
		public static GradeDAOImpl getInstance() {
		return instance;
	}

	private GradeDAOImpl() {
	
	}

	public int insert(GradeVO g){
		int result = 0;
		String sql="insert into grade(seq,grade,java,sql,html,javascript,id,exam_date)"
				+ "values(seq.nextval,?,?,?,?,?,?,?)";
	
		return result;
	}

	public List<?> list() {
		List<GradeVO> list = new ArrayList<GradeVO>();
		String sql = "select * from grade ";
		return list;
	}
	public int count() {
		return 0;
	}

	public int count(String examDate) {
		int result = 0;
		String sql = "select count(*) as count from grade "
				+ "where exam_date = ?";
		
	
		return result;
	}

	public GradeVO findBySeq(String seq) {
		GradeVO bean = new GradeVO();
		String sql = "select * from grade where seq = ?";
		
		return bean;
	}

	public List<?> findById(String id) {
		List<GradeVO> list = new ArrayList<GradeVO>();
		String sql= "select * from grade where id = ?";
		
		return list;
	}

	public int update(GradeVO grade) {
		//"과목,점수,seq"
		int result = 0;
		String sql = "update grade set"+ grade.getSubject()+"="+grade.getScore()+ "where seq =?";
		
	
		return result;
	}

	public int delete(String del) {
		int result =0;
		String sql = "delete from grade where seq = ?";
	
		return result;
	}
	
}
	
