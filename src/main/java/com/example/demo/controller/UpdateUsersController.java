package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UpdateUsersCommandVO;
import com.example.demo.vo.UsersVO;
import com.example.demo.vo.Users_outVO;

@Controller
public class UpdateUsersController {

	@Autowired
	private UsersDao dao;

	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/updateMyInfo.do", method = RequestMethod.GET)
	public void form(Model model,int users_no) {
		model.addAttribute("u",dao.getUser(users_no));
	}
	
	@RequestMapping(value = "/updateMyInfo.do", method = RequestMethod.POST)
	public ModelAndView submit(UpdateUsersCommandVO updateUsers, HttpServletRequest request) {
		UsersVO u = updateUsers.getUsers();
		ModelAndView mav = new ModelAndView("redirect:/mypage/mypage.do");
		int re = dao.updateUsers(updateUsers);
		if(re != 1) {
			mav.addObject("msg","개인 정보 수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/updateProfile.do", method = RequestMethod.GET)
	public void profileForm(Model model, int users_no) {
		System.out.println("컨트롤러 겟");
		System.out.println("users_no:"+users_no);
		model.addAttribute("u",dao.getUser(users_no));
	}
	
	@RequestMapping(value = "/updateProfile.do", method = RequestMethod.POST)
	public ModelAndView profileSubmit(UsersVO u,HttpServletRequest request) {
		System.out.println("컨트롤러 포스트 동작");
		ModelAndView mav = new ModelAndView("redirect:/mypage/mypage.do");
		
		
		String path = request.getRealPath("../resources/profile");
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
	
	@RequestMapping(value = "/deleteUsers.do",method = RequestMethod.GET)
	public void deleteForm(Model model,int users_no	) {
		model.addAttribute("users_no",users_no);
	}
	
	@RequestMapping(value = "/deleteUsers.do",method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int users_no,String users_pw,HttpServletRequest request,Users_outVO uo,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/login.do");
		
		int re = dao.insertUsers_out(uo);
		int re2 = dao.updateUsersDel(users_no);
		
		if(re != 1) {
			mav.addObject("msg","회원 탈퇴에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		if(re2 == 1) {

		}else {
			mav.addObject("msg","회원탈퇴에 실패하였습니다. ");
			mav.setViewName("error");
		}
		session.invalidate();
		return mav;
	}
	
}
