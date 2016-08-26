package com.hanbit.web.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("AccoountController ! moveMain()");
		return "user:account/content.tiles";
	}
	@RequestMapping("/count")
	public String count() {
		logger.info("AccoountController ! count()");
		return "admin:account/count.tiles";
	}
	@RequestMapping("/delete")
	public String delete() {
		logger.info("AccoountController ! delete()");
		return "admin:account/delete.tiles";
	}
	@RequestMapping("/deposit")
	public String deposit() {
		logger.info("AccoountController ! deposit()");
		return "user:account/deposit.tiles";
	}
	@RequestMapping("/list")
	public String list() {
		logger.info("AccoountController ! list()");
		return "admin:account/list.tiles";
	}
	@RequestMapping("/regist")
	public String regist() {
		logger.info("AccoountController ! regist()");
		return "admin:account/regist.tiles";
	}
	@RequestMapping("/search")
	public String search() {
		logger.info("AccoountController ! search()");
		return "admin:account/search.tiles";
	}
	@RequestMapping("/update")
	public String update() {
		logger.info("AccoountController ! update()");
		return "user:account/update.tiles";
	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		logger.info("AccoountController ! withdraw()");
		return "user:account/withdraw.tiles";
	}
}
