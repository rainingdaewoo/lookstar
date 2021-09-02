package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.UsersDao;

@Controller
public class LookbookController {
	@Autowired
	private UsersDao userdao;
	@Autowired
	private LookbookDao lookbookdao;
	
	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}


	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
	}


	@RequestMapping("/lookbook.do")
	public void lookbook(Model model, String sortField) {
		model.addAttribute("list", lookbookdao.listLookbook(sortField));
	}
	@RequestMapping("/lookbook_write.do")
	public void lookbook_write(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("u", userdao.getUsers(id));
	}
}
