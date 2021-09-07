package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentsVO;

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
	
	@RequestMapping(value = "board/updateComments.do", method = RequestMethod.GET)
	public void form(HttpServletRequest request, Model model, int comments_no) {
		model.addAttribute("c", dao.getComments(comments_no));
	
	}
	
	@RequestMapping(value = "board/updateComments.do", method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, CommentsVO c, Model model) {
		
		Authentication authentication =
		SecurityContextHolder.getContext().getAuthentication(); User user =
		(User)authentication.getPrincipal(); String id = user.getUsername();
		model.addAttribute("users", userdao.getUsers(id));
		
		
		
		System.out.println("updateBoard.do POST 동작함.");
		System.out.println("users_no:" + c.getUsers_no());
		ModelAndView mav = new ModelAndView("redirect:/board/listBoard.do");
		String path = request.getRealPath("/resources/board_img");
		System.out.println("path:"+path);
		String oldFname= c.getComments_fname();
		int oldFsize= c.getComments_fsize();
		
		String fname = null;
		int fsize = 0;
		MultipartFile uploadFile = c.getComments_uploadFile();
		fname= uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				fsize = data.length;
				c.setComments_fname(fname);
				c.setComments_fsize(fsize);
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		System.out.println(fname);
		System.out.println(fsize);
		System.out.println("수정할 게시물:"+c);
		int re = dao.updateComments(c);
		if(re != 1) {
			mav.addObject("msg", "게시물 수정에 실패하였습니다.");
			mav.setViewName("error");
		}else {
			if(fsize != 0) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		}
		
		return mav;
	}
}
