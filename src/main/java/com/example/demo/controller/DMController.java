package com.example.demo.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DMDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.DMVO;
import com.example.demo.vo.UsersVO;

@Controller
public class DMController {
	
	@Autowired
	private DMDao dao;
	@Autowired
	private UsersDao userdao;

	public void setDao(DMDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listChat.do")
	@ResponseBody	
	public List<DMVO> listDM(HttpSession session){
		List<DMVO> dmList = null;
		if(session.getAttribute("u")!=null) {
			String users_nickname = ((UsersVO)session.getAttribute("u")).getUsers_nickname();
			dmList = dao.findAll2(users_nickname);
		}				
		return dmList;
	}
	
	
	//채팅목록보여주는곳
	@RequestMapping("/listPeople.do")
	@ResponseBody
	public List<DMVO> listPeople(HttpSession session){
		List<DMVO> list = null;
		if(session.getAttribute("u")!=null) {
			String users_nickname = ((UsersVO)session.getAttribute("u")).getUsers_nickname();
			list = dao.findAll(users_nickname);
		}				
		return list;
	}

	
	
	@RequestMapping("/dmTest.do")
	public void test(Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		System.out.println("dmTest.do 동작함");
		System.out.println("login한 회원의 아이디: "+id);
		session.setAttribute("u", userdao.getUsers(id));
		//model.addAttribute("u", userdao.getUsers(id));
		//ModelAndView mav = new ModelAndView();
		//List<DMVO> list = dao.findAll2(id);
		//System.out.println("list: "+list);
		//mav.addObject("dmList",list);

	}

}
