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

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVO;

@Controller
@RequestMapping("/updateBoard.do")
public class UpdateBoardController {
	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(HttpServletRequest request, Model model, int board_no) {
		//System.out.println(4/0);
		model.addAttribute("b", dao.getBoard(board_no));
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, BoardVO b) {
		System.out.println("updateBoard.do POST 동작함.");
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String path = request.getRealPath("/resources/board_img");
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
		int re = dao.getTotalRecord();
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
