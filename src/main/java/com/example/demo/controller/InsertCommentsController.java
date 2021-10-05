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

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentsVO;

@Controller
@RequestMapping("/board/insertComments.do")
public class InsertCommentsController {
	
	@Autowired
	private UsersDao userdao;
	@Autowired
	private CommentsDao dao;
	@Autowired
	private BoardDao boarddao;
	
	public void setDao(CommentsDao dao) {
		this.dao = dao;
	}
	
	public UsersDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}
	
	public BoardDao getBoarddao() {
		return boarddao;
	}

	public void setBoarddao(BoardDao boarddao) {
		this.boarddao = boarddao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(CommentsVO vo, HttpServletRequest request, Model model, int board_no) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("u", userdao.getUsers(id));
		
		System.out.println("CommentsInsert POST방식 작동함");
		System.out.println("users_no"+vo.getUsers_no());
		ModelAndView mav = new ModelAndView("redirect:/board/detailBoard.do?board_no="+ board_no);
		String path = request.getRealPath("/resources/comments_img");
		System.out.println("path:"+path);
		String fname = null;
		MultipartFile uploadFile = vo.getComments_uploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				vo.setComments_fname(fname);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		int re = dao.insertComments(vo);
		if(re != 1) {
			mav.addObject("msg", "댓글 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		boarddao.plusCommentsCount(board_no);
		return mav;
	}
}