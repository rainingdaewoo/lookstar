package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import java.util.Random;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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
	
	// 보민
	@RequestMapping("/mypage.do")
	public void mypage() {
		
	}
	
	@RequestMapping("/changePWD.do")
	public void updatePWD() {
		
	}
	
	@RequestMapping("/myInform.do")
	public void updateInfo() {
		
	}
	
	@RequestMapping("/kakao.do")
	public void kakao() {
		
	}
}

