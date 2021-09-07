package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.UsersDao;

@Controller
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

	@RequestMapping("/board/deleteComments.do")
	public ModelAndView deleteBoard(int comments_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/board/listBoard.do");
		String path = request.getRealPath("resources/comments_img");
		String oldFname = dao.getComments(comments_no).getComments_fname();
		
		int re = dao.deleteComments(comments_no);
		System.out.println(comments_no);
		if(re == 1) {
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		return mav;
	}
}
