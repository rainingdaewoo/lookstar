package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.UsersDao;

public class CommentsController {
	
	@Autowired
	private UsersDao userdao;
	@Autowired
	private CommentsDao dao;
	
	public void setDao(CommentsDao dao) {
		this.dao = dao;
	}
	
	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}
	
	/*
	 * @RequestMapping("/detailBoard.do") public void
	 * listComments(HttpServletRequest request, Model model) {
	 * model.addAttribute("comments", dao.findAll());
	 * 
	 * }
	 */
}
