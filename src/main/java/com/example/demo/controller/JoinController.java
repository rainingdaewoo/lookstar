	package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.InsertUsersCommandVO;
import com.example.demo.vo.UsersVO;

@Controller
@RequestMapping("/users/join.do")
public class JoinController {
	@Autowired
	private UsersDao dao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form(Model model, String kakaoprofile, String kakaoemail, String kakaogender) {
		System.out.println("join.do get동작");
		System.out.println("카카오프로필" +kakaoprofile);
		System.out.println("카카오이메일" +kakaoemail);
		System.out.println("카카오성별" +kakaogender);
		
		String type = "1";
		String correct = "1";
		if(kakaoemail != null) {
			System.out.println("카카오 로그인 do");
			System.out.println("카카오프로필" +kakaoprofile);
			int idx = kakaoemail.indexOf("@");
			String mail1 = kakaoemail.substring(0,idx);
			String mail2 = kakaoemail.substring(idx+1);
			type = "2";
			correct = "2";
			model.addAttribute("kakaoprofile",kakaoprofile);
			model.addAttribute("mail1",mail1);
			model.addAttribute("mail2",mail2);
			model.addAttribute("kakaogender",kakaogender);
		}
		System.out.println("유저타입" +type);
		model.addAttribute("users_jointype",type);
		model.addAttribute("correct",correct);
  		//<input type="hidden" name="kakaoprofile" id="kakaoprofile"/>
  		//<input type="hidden" name="kakaoemail" id="kakaoemail"/>
  		//<input type="hidden" name="kakaogender" id="kakaogender"/>
  		//<input type="hidden" name="users_jointype" value="1">
  		
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView submit(UsersVO u, HttpServletRequest request) {
		System.out.println("join.do post동작");
		ModelAndView mav = new ModelAndView("redirect:/main.do");
		String path = request.getRealPath("/resources/profile");
		System.out.println("path:" +path);
		String fname = null;
		int fsize = 0;
		MultipartFile uploadFile = u.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				fsize = data.length;
				u.setUsers_fname(fname);
				u.setUsers_fsize(fsize);
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
		}
		u.setUsers_pw(passwordEncoder.encode(u.getUsers_pw()));
		int re = dao.insert(u);
		if(re != 1) {
			mav.addObject("msg","회원가입에 실패하였습니다.");
			mav.setViewName("error");
			
		}
		return mav;
	}
	*/
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView submit(InsertUsersCommandVO insertUsers, HttpServletRequest request) {
		System.out.println("JoinPost방식 작동함");
		System.out.println("----------------");
		System.out.println("UsersVO 정보: "+insertUsers.getUsers());
		System.out.println("Users_Like_Style 정보: "+insertUsers.getStyle_no());
		
		UsersVO u = insertUsers.getUsers();
		

		ModelAndView mav = new ModelAndView("redirect:/users/login.do");
		
		String path = request.getRealPath("/resources/profile");
		System.out.println("path:" +path);
		String fname = null;
		int fsize = 0;
		MultipartFile uploadFile = u.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				fsize = data.length;
				u.setUsers_fname(fname);
				u.setUsers_fsize(fsize);
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
		}
		u.setUsers_pw(passwordEncoder.encode(u.getUsers_pw()));
		
		int re = dao.insert(insertUsers);
		System.out.println("insert re의 값: "+re);
		if(re!=1) {
			mav.addObject("msg","회원가입에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		
		return mav;
	}
}
