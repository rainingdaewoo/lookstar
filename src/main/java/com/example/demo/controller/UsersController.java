package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		UsersVO u = dao.getUsers(id);
		session.setAttribute("users", u);
		
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
	
	@RequestMapping("/mypage/manageMylook.do")
	public void manageMylook() {
		
	}
	
	@RequestMapping("/mypage/followList.do")
	public void followList(Model model,HttpSession session) {
		String users_id = ((UsersVO)session.getAttribute("users")).getUsers_id();
		System.out.println("users_id:"+users_id);
		List<UsersVO> list = dao.listFollow(users_id);
		System.out.println("팔로우목록:"+list);
		model.addAttribute("flist",list);
	}
	
	@RequestMapping("/mypage/likeList.do")
	public void likeList() {
		
	}
}

