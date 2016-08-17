package com.hanbit.web.grade;

import java.util.List;
import java.util.Map;

public class GradeServiceImpl implements GradeService{
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	private GradeServiceImpl() {
	}
	public String insert(GradeBean grade) {
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
		result = (dao.insert(grade) == 1)?"점수 입력 완료":"점수 입력 실패";
		return result;
	}
	@Override
	public String update(GradeBean grade) {
		int total = 0,avg = 0;
		String grade1 = "",result = "";
		GradeBean tempBean = findBySeq(grade.getSeq());		
		if (grade.getClassName().equals("java")) {
			total = grade.getUpdatescore()+tempBean.getSql()+tempBean.getHtml()+tempBean.getJavascript();
		} else if(grade.getClassName().equals("sql")){
			total = grade.getUpdatescore()+tempBean.getJava()+tempBean.getHtml()+tempBean.getJavascript();
		} else if(grade.getClassName().equals("html")){
			total = grade.getUpdatescore()+tempBean.getJava()+tempBean.getSql()+tempBean.getJavascript();
		}else if(grade.getClassName().equals("javascript")){
			total = grade.getUpdatescore()+tempBean.getJava()+tempBean.getHtml()+tempBean.getSql();
		}
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
		result = (dao.update(grade) == 0)?"점수 수정 실패":"점수 수정 성공";
		return result;
	}
	@Override
	public String delete(GradeBean grade) {
		return (dao.delete(grade) == 0)?"삭제 실패":"삭제 성공";
	}
	@Override
	public List<?> findBy(String id) {
		return dao.findById(id);
	}
	@Override
	public GradeBean findBySeq(int seq) {
		return dao.findBySeq(seq);
	}
	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}
	@Override
	public String score(String[] a) {
		GradeBean g = new GradeBean();
		g.setId(a[0]);
		g.setJava(Integer.parseInt(a[1]));
		g.setSql(Integer.parseInt(a[2]));
		g.setHtml(Integer.parseInt(a[3]));
		g.setJavascript(Integer.parseInt(a[4]));
		g.setExamDate(a[5]);
		return this.insert(g);
	}
	@Override
	public List<?> list() {
		return dao.list();
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
	
}
