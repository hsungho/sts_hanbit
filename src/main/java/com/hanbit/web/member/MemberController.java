package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.subject.SubjectMemberVO;

@Controller // has a 관계
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option")String option,
			@RequestParam("context")String context,
			Model model){
		logger.info("MemberController!! find()");
		System.out.println("검색어 : "+keyword);
		System.out.println("옵션 : "+option);
		System.out.println("context : "+context);
		MemberVO member = (MemberVO) service.findById(keyword);
		System.out.println("name : "+member.getName());
		System.out.println("이미지 : "+member.getProfileImg());
		model.addAttribute("member", member);
		model.addAttribute("img", context+"/resources/img");
		return "admin:member/detail.tiles";
	}
	@RequestMapping("/login/execute")
	public String executelogin(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("context")String context,
			Model model) {
		logger.info("MemberController ! loginexecute()");
		System.out.println("로그인시 넘어온 ID : "+id);
		System.out.println("CONTEXT : "+context);
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		System.out.println("=== 서비스 login 가기 직전=====");
		SubjectMemberVO sm = service.login(member);
		model.addAttribute("user", sm);
		model.addAttribute("js", context+"/resources/js");
		model.addAttribute("css", context+"/resources/css");
		model.addAttribute("img", context+"/resources/img");
		return "user:user/content.tiles";
	}
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("MemberController ! moveMain()");
		return "admin:member/content.tiles";
	}
	@RequestMapping("/regist")
	public String regist() {
		logger.info("MemberController ! regist()");
		return "public:member/regist.tiles";
	}
	@RequestMapping("/detail")
	public String detail() {
		logger.info("MemberController ! detail()");
		return "admin:member/detail.tiles";
	}
	@RequestMapping("/update")
	public String update() {
		logger.info("MemberController ! update()");
		return "admin:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String delete() {
		logger.info("MemberController ! delete()");
		return "admin:member/delete.tiles";
	}
	@RequestMapping("/login")
	public String login() {
		logger.info("MemberController ! login()");
		return "public:member/login.tiles";
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("MemberController ! logout()");
		return "admin:member/logout.tiles";
	}
	@RequestMapping("/list")
	public String list() {
		logger.info("MemberController ! list()");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find_by")
	public String find_by() {
		logger.info("MemberController ! find_by()");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String count() {
		logger.info("MemberController ! count()");
		return "admin:member/count.tiles";
	}
}
