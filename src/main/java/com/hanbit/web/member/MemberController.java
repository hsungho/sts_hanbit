package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.web.home.HomeController;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/main")
	public String moveMain() {
		logger.info("MemberController! goMain()");
		return "admin:member/content.tiles";

	}
	
	@RequestMapping("/regist")
	public String regist() {
		logger.info("MemberController! regist()");
		return "public:member/regist.tiles";
		
	}

	@RequestMapping("/detail")
	public String detail() {
		logger.info("MemberController! detail()");
		return "admin:member/detail.tiles";
	}

	@RequestMapping("/update")
	public String update() {
		logger.info("MemberController! update()");
		return "admin:member/update.tiles";
	}

	@RequestMapping("/delete")
	public String delete() {
		logger.info("MemberController! delete()");
		return "admin:member/delete.tiles";
	}

	@RequestMapping("/login")
	public String login() {
		logger.info("MemberController! login()");
		return "public:member/login.tiles";
	}

	@RequestMapping("/logout")
	public String logout() {
		logger.info("MemberController! logout()");
		return "admin:member/logout.tiles";
	}

	@RequestMapping("/list")
	public String list() {
		logger.info("MemberController! list()");
		return "admin:member/list.tiles";
	}

	@RequestMapping("/find_by")
	public String find_by() {
		logger.info("MemberController! find_by()");
		return "admin:member/find_by.tiles";
	}

	@RequestMapping("/count")
	public String count() {
		logger.info("MemberController! count()");
		return "admin:member/count.tiles";
	}

}
