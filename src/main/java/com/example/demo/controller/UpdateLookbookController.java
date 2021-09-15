package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.InsertLookbookCommandVO;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.SelectLookbookCommandVO;

@Controller
@RequestMapping("/lookbook/lookbook_update.do")
public class UpdateLookbookController {
	@Autowired
	private LookbookDao dao;
	
	@Autowired
	private UsersDao userdao;

	public void setDao(LookbookDao dao) {
		this.dao = dao;
	}

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void from(HttpServletRequest request, Model model, int lookbook_no) {
		SelectLookbookCommandVO look = dao.selectLookbook(lookbook_no);
		Authentication authentication =	SecurityContextHolder.getContext().getAuthentication(); 
		User user =	(User)authentication.getPrincipal(); 
		String id = user.getUsername();
		model.addAttribute("users", userdao.getUsers(id));
		model.addAttribute("write_u", look.getUsers());
		model.addAttribute("look", look.getLookbook());
		model.addAttribute("info", look.getList_info());
		model.addAttribute("style", look.getList_style());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(InsertLookbookCommandVO updatelook,HttpServletRequest request) {
		System.out.println("Lookbookinsert POST방식 작동함");
		System.out.println("==================================");
		System.out.println("lookbookvo:" + updatelook.getLookbook());
		System.out.println("lookbookinfo:" + updatelook.getList_info());
		System.out.println("lookbookStyle:" + updatelook.getStyle_no());
		System.out.println("==================================");
		System.out.println("userno"+updatelook.getLookbook().getUsers_no());
		ModelAndView mav = new ModelAndView("redirect:/lookbook/lookbook.do");
		String path = request.getRealPath("/resources/look_img");
		System.out.println("path:"+path);
		String fname = null;
		MultipartFile uploadFile = updatelook.getLookbook().getUploadFile();
		
		
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				updatelook.getLookbook().setLookbook_fname(fname);
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		int re = dao.update(updatelook);
		
		
		return mav;
	}
	
}
