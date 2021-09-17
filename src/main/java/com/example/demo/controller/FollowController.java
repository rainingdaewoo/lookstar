package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.FollowDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.FollowVO;
import com.example.demo.vo.UsersVO;

import ch.qos.logback.classic.Logger;

@Controller
public class FollowController {

	@Autowired
	private UsersDao usersdao;
	
	@Autowired
	private FollowDao fdao;
	
	public void setFdao(FollowDao fdao) {
		this.fdao = fdao;
	}

	public void setUsersdao(UsersDao usersdao) {
		this.usersdao = usersdao;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertFollow.do")
	public String insertFollow(HttpServletRequest request, Model model, FollowVO follow) {
		System.out.println("insertFollow 작동함"+follow);
		
		int re = fdao.insertFollow(follow);
		System.out.println("follow 값:" + follow);
		System.out.println("insertFollow.do의 re값: " + re);
		
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteFollow.do")
	public String deleteFollow(HttpServletRequest request, Model model,String follower_id, String following_id) {
		System.out.println("deleteFollow 작동함");
		
		/*
		HashMap map = new HashMap();
		map.put("follower_id", follower_id);
		map.put("following_id", following_id);
		*/
		int re = fdao.deleteFollow(follower_id, following_id);
		return "ok";
	}
	
	
	
	
	
	
	
	
}