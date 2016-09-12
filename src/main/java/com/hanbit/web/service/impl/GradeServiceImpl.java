package com.hanbit.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.services.GradeService;
@Service
public class GradeServiceImpl implements GradeService{
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	private GradeServiceImpl() {
	}
	public String insert(GradeDTO grade) {
		int total = 0,avg = 0;
		String grade1 = "",result = "";
		total = grade.getJava()+grade.getSeq()+grade.getSql()+grade.getHtml()+grade.getJavascript();
		avg = total/4;
		switch (avg/10) {
		case 10:case 9:
			grade1 = "A";
			break;
		case 8:	
			grade1 = "B";
			break;
		case 7:
			grade1 = "C";
			break;
		case 6:	
			grade1 = "D";
			break;
		case 5:	
			grade1 = "E";
			break;
		case 4: case 3: case 2: case 1:	
			grade1 = "F";
			break;

		default:
			result = "점수는 0~100 까지 가능 합니다. ";
			return result;
		}
		grade.setGrade(grade1);
		return result;
	}
	@Override
	public String update(GradeDTO grade) {
		int total = 0,avg = 0;
		String grade1 = "",result = "";
		avg = total/4;
		switch (avg/10) {
		case 10:case 9:
			grade1 = "A";
			break;
		case 8:	
			grade1 = "B";
			break;
		case 7:
			grade1 = "C";
			break;
		case 6:	
			grade1 = "D";
			break;
		case 5:	
			grade1 = "E";
			break;
		case 4: case 3: case 2: case 1:	
			grade1 = "F";
			break;

		default:
			result = "점수는 0~100 까지 가능 합니다. ";
			return result;
		}
		grade.setGrade(grade1);
		return result;
	}
	@Override
	public String delete(GradeDTO grade) {
		return "";
	}
	@Override
	public List<?> findBy(String id) {
		return null;
	}
	@Override
	public int count(String examDate) {
		return 0;
	}
	@Override
	public String score(String[] a) {
		GradeDTO g = new GradeDTO();
		g.setId(a[0]);
		g.setJava(Integer.parseInt(a[1]));
		g.setSql(Integer.parseInt(a[2]));
		g.setHtml(Integer.parseInt(a[3]));
		g.setJavascript(Integer.parseInt(a[4]));
		g.setExamDate(a[5]);
		return this.insert(g);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<?> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
