package com.example.demo.controller;

import java.util.List;

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
	public List<DMVO> listDM(){
		return dao.findAll();
	}
	
	

	@RequestMapping("/listDM.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.findAll());
		
		return mav;
	}
	
	@RequestMapping("/dmTest.do")
	@ResponseBody
	public ModelAndView test(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("u", userdao.getUsers(id));
		ModelAndView mav = new ModelAndView();
		mav.addObject("dmList",dao.findAll2());
		return mav;
	}

}
