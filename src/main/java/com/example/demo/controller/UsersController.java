package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
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
		
		String id = 
		((User)authentication.getPrincipal()).getUsername();
		
		session.setAttribute("users", dao.getUsers(id));
		
		return mav;
	}
	@RequestMapping("/findID.do")
	public void findID() {
		
	}
	
	@RequestMapping("/findPW.do")
	public void findPW() {
		
	}
	
	@RequestMapping("/findOK.do")
	public void findOK() {
		
	}
	@RequestMapping("/main.do")
	public void main() {
		
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
}

