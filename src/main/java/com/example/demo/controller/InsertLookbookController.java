package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LookbookDao;
import com.example.demo.vo.LookbookVO;

@Controller
@RequestMapping("/insertLookbook.do")
public class InsertLookbookController {
	@Autowired
	private LookbookDao dao;
	
	public void setDao(LookbookDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(LookbookVO l, HttpServletRequest request) {
		System.out.println("Lookbookinsert POST방식 작동함");
		System.out.println("userno"+l.getUsers_no());
		ModelAndView mav = new ModelAndView("redirect:/lookbook.do");
		String path = request.getRealPath("/resources/look_img");
		System.out.println("path:"+path);
		String fname = null;
		MultipartFile uploadFile = l.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				l.setLookbook_fname(fname);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		
		int re = dao.insert(l);
		if(re != 1) {
			mav.addObject("msg", "상품등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
}