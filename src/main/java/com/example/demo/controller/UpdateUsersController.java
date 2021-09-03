package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

@Controller
public class UpdateUsersController {

	@Autowired
	private UsersDao dao;

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/updateMyInfo.do", method = RequestMethod.GET)
	public void form(Model model,int users_no) {
		model.addAttribute("u",dao.getUsers(users_no));
	}
	
	@RequestMapping(value = "/updateMyInfo.do", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/updateProfile.do", method = RequestMethod.GET)
	public void profileForm(Model model, int users_no) {
		model.addAttribute("u",dao.getUsers(users_no));
	}
	
	@RequestMapping(value = "/updateProfile.do", method = RequestMethod.POST)
	public ModelAndView profileSubmit(UsersVO u,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/mypage.do");
		String path = request.getRealPath("resources/profile");
		String oldFname = u.getUsers_fname();
		int oldFsize = u.getUsers_fsize();
		String fname = null;
		int fsize = 0;
		MultipartFile uploadFile = u.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				fsize = data.length;
				u.setUsers_fname(fname);
				u.setUsers_fsize(fsize);
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			int re = dao.updateProfile(u);
			if(re != 1) {
				mav.addObject("msg", "프로필 변경에 실패하였습니다.");
				mav.setViewName("error");
			}else {
				if(fsize != 0) {
					File file = new File(path+"/"+oldFname);
					file.delete();
				}
			}
		}
		return mav;
	}
}
