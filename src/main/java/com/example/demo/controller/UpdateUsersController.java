package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

@Controller
@RequestMapping("/updateMyInfo.do")
public class UpdateUsersController {

	@Autowired
	private UsersDao dao;

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(Model model,int users_no) {
		model.addAttribute("u",dao.getUsers(users_no));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(UsersVO u, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/mypage.do");
		System.out.println("생일:"+u.getUsers_birth());
		int re = dao.update(u);
		if(re != 1) {
			mav.addObject("msg","개인정보 수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
}
