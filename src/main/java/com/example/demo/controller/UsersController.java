package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import java.util.Random;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

@Controller
public class UsersController {
	@Autowired
	private UsersDao dao;	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JavaMailSender javaMailSender;

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	@RequestMapping("/login.do")
	public void login() {
		
	}
	
	@RequestMapping("/loginOK.do")
	public ModelAndView loginOK(HttpSession session) {
		System.out.println("로그인 성공!");
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		Authentication authentication
		= SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		UsersVO u = dao.getUsers(id);
		session.setAttribute("users", u);
		
		return mav;
	}


	@RequestMapping("/findOK.do")
	public void findOK() {
		
	}
	@RequestMapping("/main.do")
	public void main() {
		
	}
	
	@RequestMapping("/")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		return mav;
	}

	@RequestMapping("/compareID.do")
	@ResponseBody
	public String compareID(String compare_id) {
		System.out.println("compareID.do동작함" + compare_id);
		String users_id = dao.compareID(compare_id);
		return users_id;
	}
	
	@RequestMapping("/compareNickname.do")
	@ResponseBody
	public String compareNickname(String compare_nickname) {
		System.out.println("compareNickname.do동작함" + compare_nickname);
		String users_nickname = dao.compareNickname(compare_nickname);
		return users_nickname;
	}
	
	@RequestMapping("/sendCode.do")
	@ResponseBody
	public String sendCode(String sendEmail) {
		System.out.println("sendCode.do동작함" + sendEmail);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String code = a+""+b+""+c+""+d;
		System.out.println(code);
		mailMessage.setSubject("룩스타그램 회원가입 인증번호");
		mailMessage.setFrom("rladudtjrwkd@gmail.com");
		mailMessage.setText("회원님의 가입번호는 : " + code+" 입니다.");
		mailMessage.setTo(sendEmail);
		try {
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		return code;

	}
	
	@RequestMapping("/kakao.do")
	public void kakao() {}
	
	// 보민
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/login.do";
	}
	
	@RequestMapping("/mypage/mypage.do")
	public void mypage() {
		
	}
	
	@RequestMapping("/mypage/changePWD.do")
	public void updatePWD() {
		
	}
	
	@RequestMapping("/mypage/myInform.do")
	public void updateInfo() {
		
	}
	
	@RequestMapping("/mypage/withdrawal.do")
	public void withdrawal(Model model,HttpSession session) {
		int users_no = ((UsersVO)session.getAttribute("users")).getUsers_no();
		System.out.println("users_no:"+users_no);
		model.addAttribute("users_no",users_no);
	}
	
	@RequestMapping("/mypage/termsOfService.do")
	public void termsOfService() {
		
	}
	
	@RequestMapping(value = "/updatePwd.do" , method = RequestMethod.POST)
	public ModelAndView updatePwd(int users_no,String new_pw) {
		ModelAndView mav = new ModelAndView("redirect:/logout.do");
		UsersVO u = new UsersVO();
		u.setUsers_pw("");
		String encode_pw = passwordEncoder.encode(new_pw);
		u.setUsers_pw(encode_pw);
		System.out.println("비번변경컨트롤러 users_no:"+users_no);
		System.out.println("변경전 비밀번호"+new_pw);
		System.out.println("암호화된 비밀번호"+encode_pw);
		HashMap map = new HashMap();
		map.put("users_no", users_no);
		map.put("users_pw", encode_pw);
		int re = dao.updatePWD(map);
		if(re != 1) {
			mav.addObject("msg","비밀번호 변경 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
}
