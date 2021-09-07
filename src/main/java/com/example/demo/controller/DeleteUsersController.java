package com.example.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.Users_outVO;

@Controller
@RequestMapping("/deleteUsers.do")
public class DeleteUsersController {

	@Autowired
	private UsersDao dao;

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(Model model, int users_no) {
		model.addAttribute("users_no",users_no);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(int users_no,String users_pw,HttpServletRequest request,Users_outVO uo) {
		ModelAndView mav = new ModelAndView("redirect:/login.do");
		String path = request.getRealPath("resources/profile");
		String oldFname = dao.getUser(users_no).getUsers_fname();
		int fsize = dao.getUser(users_no).getUsers_fsize();
		
		
		int re = dao.delete(users_no, users_pw);
		int re2 = dao.insertUsers_out(uo);
		
		if(re == 1) {
			if(fsize != 0) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}else {
			mav.addObject("msg","회원 탈퇴에 실패하였습니다.");
			mav.setViewName("mypage");
		}
		
		if(re2 != 1) {
			mav.addObject("msg2","회원 탈퇴에 실패하였습니다. 탈퇴 사유를 고르고 다시 시도해주십시오.");
			mav.setViewName("error");
		}
		return mav;
	}
}
