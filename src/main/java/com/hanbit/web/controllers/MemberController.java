package com.hanbit.web.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.service.impl.MemberServiceImpl;

@Controller // has a 관계
@SessionAttributes({"user","context","js","css","img"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	@Autowired MemberDTO member;
	@Autowired Command command;
	@Autowired Retval retval;
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
		@PathVariable("keyword")String keyword){
		logger.info("TO SERCH OPTION IS {}",option);
		logger.info("TO SERCH KEYWORD IS {}",keyword);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	@RequestMapping(value="/count/{option}",consumes="application/json")
	public Model count(@PathVariable("option") String option,
			Model model){
		logger.info("TO COUNT OPTION IS {}",option);
		model.addAttribute("count", service.count());
		return model;
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("TO COUNT CONDITION IS : {}","LOGINED_HEADER");
		return "user/header.jsp";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody MemberDTO Login(
			@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			HttpSession session
			) {
		logger.info("로그인시 넘어온 id {}",id);
		logger.info("로그인시 넘어온 pw {}",pw);
		member.setId(id);
		member.setPw(pw);
		//member = service.login(member);
		MemberDTO user = service.login(member);
		if (member.getId().equals("NONE")) {
			logger.info("COntroller LOGIN","FAIL");
			return user;
		}else{
			logger.info("COntroller LOGIN","SUCCESS");
			session.setAttribute("user", user);
			return user;
		}
	}
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");
		return "admin:member/content.tiles";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST,
			consumes="application/json")
	public @ResponseBody Retval signup(@RequestBody MemberDTO param) {
		logger.info("SIGN UP {}","EXEUTE");
		logger.info("SIGN UP ID = {}",param.getId());
		logger.info("SIGN UP PW = {}",param.getPw());
		logger.info("SIGN UP NAME = {}",param.getName());
		logger.info("SIGN UP SSN = {}",param.getSsn());
		logger.info("SIGN UP EMAIL = {}",param.getEmail());
		logger.info("SIGN UP PHONE = {}",param.getPhone());
		// retval.setMessage(service.regist(param));
		retval.setMessage("success");
		logger.info("SIGN UP REVAL = {}",retval.getMessage());
		return retval;
	}
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval CheckDup(@PathVariable String id) {
		logger.info("CHECK DUP {}","EXECUTE");
		if (service.existId(id)==1) {
			retval.setFlag("TRUE");
			retval.setMessage("입력하신 ID는 이미 존재합니다");
		}else{
			retval.setFlag("FALSE");
			retval.setMessage("입력하신 ID는 사용 가능한 ID입니다");
			retval.setTemp(id);
		}
		logger.info("RETVAL IS {}",retval.getFlag());
		logger.info("RETVAL IS {}",retval.getMessage());
		return retval;
	}
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key")String key) {
		logger.info("GO TO {}","a_detail");
		logger.info("KEY IS {}",key);
		return "admin:member/a_detail.tiles";
	}
	
	@RequestMapping("/detail")
	   public @ResponseBody MemberDTO moveDetail(HttpSession session) {
	      logger.info("GO TO {}","detail");
	      return (MemberDTO) session.getAttribute("user");
	}
	
	@RequestMapping("/update")
	public String update() {
		logger.info("GO TO {}","update");
		return "user:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String delete() {
		logger.info("GO TO {}","delete");
		return "user:member/delete.tiles";
	}
	@RequestMapping("/login")
	public String login() {
		logger.info("GO TO {}","login");
		return "public:member/login.tiles";
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		logger.info("GO TO {}","logout");
		status.setComplete();
		logger.info("SESSION IS {}","CLEAR");
		return "redirect:/";
	}
	@RequestMapping("/list")
	public String list() {
		logger.info("GO TO {}","list");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find_by")
	public String find_by() {
		logger.info("GO TO {}","find_by");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String count() {
		logger.info("GO TO {}","count");
		return "admin:member/count.tiles";
	}
	@RequestMapping("/content")
	public String moveUserContent() {
		logger.info("GO TO {}","content");
		return "user:user/content.tiles";
	}
	@RequestMapping("/kaup")
	public String moveKaup() {
		logger.info("GO TO {}","kaup");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/rock_sissor_paper")
	public String moveRockSissorPaper() {
		logger.info("GO TO {}","rock_sissor_paper");
		return "user:user/rock_sissor_paper.tiles";
	}
	@RequestMapping("/lotto")
	public String moveLotto() {
		logger.info("GO TO {}","lotto");
		return "user:user/lotto.tiles";
	}
}