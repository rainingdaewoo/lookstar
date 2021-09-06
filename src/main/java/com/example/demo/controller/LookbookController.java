package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.SelectLookbookCommandVO;

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
	@RequestMapping("/lookbook_detail.do")
	public void detailLookbook(HttpServletRequest request,Model model,int lookbook_no) {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("인증정보: "+authentication);
			User user = (User)authentication.getPrincipal();
			String id = user.getUsername();
			System.out.println("ooooooooooooooooooooo");
			System.out.println("id값: "+id);
			
			model.addAttribute("u", userdao.getUsers(id));
		}
		
		
		
		
		
		SelectLookbookCommandVO look = lookbookdao.selectLookbook(lookbook_no);
		
		
		model.addAttribute("write_u", look.getUsers());
		model.addAttribute("look", look.getLookbook());
		model.addAttribute("info", look.getList_info());
		model.addAttribute("style", look.getList_style());
		
	}
}
