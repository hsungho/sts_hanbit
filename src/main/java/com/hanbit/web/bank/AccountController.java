package com.hanbit.web.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	 @RequestMapping("/main")
	  public String moveMain(){
			logger.info("AccountController! goMain()");
			return "admin:account/content.tiles";
	  }
	
	 @RequestMapping("/open")
	 public String open(){
		 logger.info("AccountController! open()");
		 return "admin:account/open.tiles";
	 }

	 @RequestMapping("/deposit")
	 public String deposit(){
		 logger.info("AccountController! deposit()");
		 return "admin:account/deposit.tiles";
	 }

	 @RequestMapping("/withdraw")
	 public String withraw(){
		 logger.info("AccountController! withdraw()");
		 return "admin:account/withdraw.tiles";
	 }
	
	 @RequestMapping("/list")
	 public String list(){
		 logger.info("AccountController! list()");
		 return "admin:account/list.tiles";
	 }
	
	 @RequestMapping("/find")
	 public String find(){
		 logger.info("AccountController! find()");
		 return "admin:account/find.tiles";
	 }

	 @RequestMapping("/update")
	 public String update(){
		 logger.info("AccountController! update()");
		 return "admin:account/update.tiles";
	 }
	 @RequestMapping("/delete")
	 public String delete(){
		 logger.info("AccountController! delete()");
		 return "admin:account/delete.tiles";
	 }
	 @RequestMapping("/count")
	 public String count(){
		 logger.info("AccountController! count()");
		 return "admin:account/count.tiles";
	 }
}
