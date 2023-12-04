package com.jht.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jht.model.MemberDTO;
import com.jht.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService ms;	// MemberService ms = new MemberService();

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	// member.jsp를 실행하기 위한 abcdefg메소드
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public void abcdefg(Model model) {}
	
	// 회원가입 화면에서 회원가입 버튼을 클릭시 실행하기 위한 fawfawefaweawg메소드
	@RequestMapping(value = "member", method = RequestMethod.POST)
	public void fawfawefaweawg(MemberDTO member) {
		ms.write(member);
	}
	//@RequestMapping(value = "memberlist", method = RequestMethod.GET)
	@GetMapping("memberlist")
	// memberlist.jsp를 실행하기 위한 meberlist메소드
	public void memberlist(Model model) {
		model.addAttribute("list", ms.list());
		
	}
	
	@GetMapping("memberdetail")
	public void memberdetail(MemberDTO member,Model model) {
		model.addAttribute("detail", ms.detail(member));
	}
	@PostMapping("modify")
	public String membermodify(MemberDTO member,RedirectAttributes rttr) {
		ms.modify(member);
		rttr.addAttribute("id", member.getId());
		return "redirect:/memberdetail";
	}
	@PostMapping("remove")
	public String memberremove(MemberDTO member) {
		ms.remove(member);
		return "redirect:/memberlist";
	}
	@GetMapping("logForm")
	public void loginForm() {}
	
	@PostMapping("login")
	public String login(MemberDTO member, HttpSession session) {
		// 만약에 ms.login(member)값이 null아니면.
		if(ms.login(member) != null) {
			// 로그인 해라.(session에 select값 저장)
			session.setAttribute("login", ms.login(member));
			// 리스트화면으로 이동
			return "redirect:/memberlist";
		}else {// 그렇지 않으면
			// 로그인 하지 마라.
			// 로그인 화면으로 이동
			return "login";
		}
	}
	@PostMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logForm";
	}
	
	
	
	/*
	@RequestMapping(value = "board/board", method = RequestMethod.GET)
	public void zzzzzzzz() {}
	*/
	/*@RequestMapping(value = "board", method = RequestMethod.GET)
	public String aaaaaaaaaaaa() {
		return "board/board";
	}*/
	
}














