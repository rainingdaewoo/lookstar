package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LookbookDao;
import com.example.demo.vo.InsertLookbookCommandVO;
import com.example.demo.vo.LookInfoVO;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.Lookbook_styleVO;

@Controller
@RequestMapping("/lookbook/insertLookbook.do")
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
	public ModelAndView submit(InsertLookbookCommandVO insertlook, HttpServletRequest request) {
		System.out.println("Lookbookinsert POST방식 작동함");
		System.out.println("==================================");
		System.out.println("lookbookvo:" + insertlook.getLookbook());
		System.out.println("lookbookinfo:" + insertlook.getList_info());
		System.out.println("lookbookStyle:" + insertlook.getStyle_no());
		System.out.println("==================================");
		System.out.println("userno"+insertlook.getLookbook().getUsers_no());
		ModelAndView mav = new ModelAndView("redirect:/lookbook/lookbook.do");
		String path = request.getRealPath("/resources/look_img");
		System.out.println("path:"+path);
		String fname = null;
		MultipartFile uploadFile = insertlook.getLookbook().getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				insertlook.getLookbook().setLookbook_fname(fname);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		
		int re = dao.insert(insertlook);
		System.out.println("INESRT RE의 값: "+ re);
		/*
		if(re != 1) {
			mav.addObject("msg", "상품등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		*/
		return mav;
	}
}