package com.example.demo.controller;

import java.io.File;
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

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.BoardVO;

@Controller
@RequestMapping("/board/updateBoard.do")
public class UpdateBoardController {
	
	@Autowired
	private BoardDao dao;

	@Autowired
	private UsersDao userdao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	public UsersDao getUserdao() {
		return userdao;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(HttpServletRequest request, Model model, int board_no) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("users", userdao.getUsers(id));
		model.addAttribute("b", dao.getBoard(board_no));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, BoardVO b, Model model) {
		
		Authentication authentication =
		SecurityContextHolder.getContext().getAuthentication(); User user =
		(User)authentication.getPrincipal(); String id = user.getUsername();
		model.addAttribute("users", userdao.getUsers(id));
		
		
		
		System.out.println("updateBoard.do POST 동작함.");
		System.out.println("users_no:" + b.getUsers_no());
		ModelAndView mav = new ModelAndView("redirect:/board/listBoard.do");
		String path = request.getRealPath("/resources/board_img");
		System.out.println("path:"+path);
		String oldFname= b.getBoard_fname();
		int oldFsize= b.getBoard_fsize();
		
		String fname = null;
		int fsize = 0;
		MultipartFile uploadFile = b.getBoard_uploadFile();
		fname= uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				fsize = data.length;
				b.setBoard_fname(fname);
				b.setBoard_fsize(fsize);
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		System.out.println(fname);
		System.out.println(fsize);
		System.out.println("수정할 게시물:"+b);
		int re = dao.updateBoard(b); 

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