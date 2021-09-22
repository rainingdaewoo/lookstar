package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DMDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.DMVO;

@Controller
@RequestMapping("/insertDM.do")
public class InsertDMController {
	
	@Autowired
	private DMDao dao;
	@Autowired
	private UsersDao userdao;
	
	public void setDao(DMDao dao) {
		this.dao = dao;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(DMVO d, Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//아래것이 오류나서 바꿈
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		//String id = authentication.getName();
		session.setAttribute("u", userdao.getUsers(id));
		ModelAndView mav = new ModelAndView();
		
		
		int re = dao.insertDM(d);
		/*if(re != 1) {
			mav.addObject("msg", "채팅 등록에 실패하였습니다.");
			mav.setViewName("error");
		}*/
		return mav;
	}
}