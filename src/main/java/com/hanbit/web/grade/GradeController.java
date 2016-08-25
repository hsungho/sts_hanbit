package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	@RequestMapping("/main")
	public String moveMain(){
		logger.info("GradeController ! moveMain()");
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/count")
	public String count(){
		logger.info("GradeController ! count()");
		return "admin:grade/count.tiles";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("GradeController ! delete()");
		return "admin:grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String list(){
		logger.info("GradeController ! list()");
		return "admin:grade/list.tiles";
	}
	@RequestMapping("/regist")
	public String regist(){
		logger.info("GradeController ! regist()");
		return "admin:grade/regist.tiles";
	}
	@RequestMapping("/search")
	public String search(){
		logger.info("GradeController ! search()");
		return "admin:grade/search.tiles";
	}
	@RequestMapping("/update")
	public String update(){
		logger.info("GradeController ! update()");
		return "admin:grade/update.tiles";
	}
}
