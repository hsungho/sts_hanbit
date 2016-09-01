package com.hanbit.web.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@RequestMapping("/open")
	public String moveOpen() {
		logger.info("GO TO {}","open");
		return "user:account/open.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO {}","detail");
		return "user:account/detail.tiles";
	}
	@RequestMapping("/transaction")
	public String moveTransaction() {
		logger.info("GO TO {}","transaction");
		return "user:account/transaction.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}","delete");
		return "user:account/delete.tiles";
	}
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");
		return "user:account/content.tiles";
	}
	@RequestMapping("/count")
	public String count() {
		logger.info("AccoountController ! count()");
		return "admin:account/count.tiles";
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
