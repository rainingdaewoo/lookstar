package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVO;

@Controller
@RequestMapping("/insertBoard.do")
public class insertBoardController {
	
	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(BoardVO vo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		String path = request.getRealPath("resources/board_img");
		System.out.println("path:"+path);
		String fname = null;
		MultipartFile uploadfile = vo.getBoard_uploadFile();
		fname = uploadfile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte[] data = uploadfile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				vo.setBoard_fname(fname);
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
			
		}
		
		
		
		int re = dao.insert(vo);
		if(re != 1) {
			mav.addObject("msg", "게시글 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav; 
	}
}
