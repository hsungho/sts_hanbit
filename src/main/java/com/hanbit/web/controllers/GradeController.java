package com.hanbit.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/list")
	public String moveList(){
		logger.info("GO TO {}","list");
		return "admin:grade/list.tiles";
	}
	@RequestMapping("/find")
	public String moveFind(){
		logger.info("GO TO {}","find");
		return "user:grade/find.tiles";
	}
	@RequestMapping("/detail")
	public String detail(){
		logger.info("GO TO {}","detail");
		return "user:grade/detail.tiles";
	}
	@RequestMapping("/main")
	public String moveMain(){
		logger.info("GO TO {}","main");
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/count")
	public String count(){
		logger.info("GO TO {}","count");
		return "admin:grade/count.tiles";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("GO TO {}","delete");
		return "admin:grade/delete.tiles";
	}
	
	@RequestMapping("/a_regist")
	public String regist(@RequestParam("key")String key){
		logger.info("GO TO {}","a_regist");
		logger.info("KEY IS {}",key);
		return "admin:grade/regist.tiles";
	}
	@RequestMapping("/regist")
	public String regist(){
		logger.info("GO TO {}","regist");
		return "user:grade/regist.tiles";
	}
	@RequestMapping("/a_update")
	public String update(@RequestParam("key")String key){
		logger.info("GO TO {}","a_update");
		logger.info("KEY IS {}",key);
		return "admin:grade/update.tiles";
	}
	@RequestMapping("/update")
	public String update(){
		logger.info("GO TO {}","update");
		return "user:grade/update.tiles";
	}
}
