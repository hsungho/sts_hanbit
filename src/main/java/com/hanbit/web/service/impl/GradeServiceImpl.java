package com.hanbit.web.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.mappers.GradeMapper;
import com.hanbit.web.services.GradeService;
@Service
public class GradeServiceImpl implements GradeService{
	@Autowired SqlSession sqlSession;
	@Override
	public String insert(GradeDTO grade) {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		int total = 0,avg = 0;
		String grade1 = "",result = "";
		total = grade.getScore();
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
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
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
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return "";
	}
	@Override
	public List<?> findBy(String id) {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return null;
	}
	@Override
	public int count(String examDate) {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		mapper.count(examDate);
		return 0;
	}
	@Override
	public String score(String[] a) {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		GradeDTO g = new GradeDTO();
		g.setId(a[0]);
		return this.insert(g);
	}
	@Override
	public int count() {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return 0;
	}
	@Override
	public Map<?, ?> map() {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return null;
	}
	@Override
	public List<?> list() {
		GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
		return null;
	}
	
}
