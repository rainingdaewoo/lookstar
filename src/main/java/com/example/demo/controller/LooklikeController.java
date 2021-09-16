package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.LooklikeDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.LooklikeVO;

@Controller
public class LooklikeController {

	@Autowired
	private UsersDao usersdao;
	@Autowired
	private LooklikeDao likedao;
	public void setUsersdao(UsersDao usersdao) {
		this.usersdao = usersdao;
	}
	public void setLikedao(LooklikeDao likedao) {
		this.likedao = likedao;
	}
	
	@ResponseBody
	@RequestMapping(value="/insertLooklike.do")
	public String insertLooklike(HttpServletRequest request, Model model, LooklikeVO looklike) {
		System.out.println("insertLooklike.do 작동함" + looklike);
		int re = likedao.insertLooklike(looklike);
		System.out.println("looklike값: "+looklike);
		
		return "looklikeOK";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteLooklike.do")
	public String deleteLooklike(HttpServletRequest request, Model model, int users_no, int lookbook_no) {
		System.out.println("deleteLooklike.do 작동함");
		int re = likedao.deleteLooklike(users_no,lookbook_no);
		return "ok";
	}
	
	
	
}
