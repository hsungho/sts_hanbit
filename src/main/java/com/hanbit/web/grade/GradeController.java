package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.home.HomeController;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
  @RequestMapping("/main")
  public String moveMain(){
		logger.info("MemberController! goMain()");
		return "admin:grade/content.tiles";
  }
  @RequestMapping("/count")
	private String count() {
		logger.info("MemberController! count()");
		return"admin:grade/count.tiles";
		
	}
	@RequestMapping("/delete")
	private String delete() {
		logger.info("MemberController! delete()");
		return"admin:grade/delete.tiles";
		
	}
	@RequestMapping("/list")
	private String list() {
		logger.info("MemberController! list()");
		return"admin:grade/list.tiles";
		
	}
	@RequestMapping("/regist")
	private String regist() {
		logger.info("MemberController! regist()");
		return"admin:grade/regist.tiles";
		
	}
	@RequestMapping("/search")
	private String search() {
		logger.info("MemberController! search()");
		return"admin:grade/search.tiles";
		
	}
	@RequestMapping("/update")
	private String update() {
		logger.info("MemberController! update()");
		return"admin:grade/update.tiles";
		
	}
}
