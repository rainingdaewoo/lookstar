package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DMDao;
import com.example.demo.vo.DMVO;

@Controller
@RequestMapping("/insertDM.do")
public class InsertDMController {
	
	@Autowired
	private DMDao dao;
	
	public void setDao(DMDao dao) {
		this.dao = dao;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(DMVO d, Model model) {
		ModelAndView mav = new ModelAndView("redirect:/listDM.do");
		
		
		int re = dao.insertDM(d);
		if(re != 1) {
			mav.addObject("msg", "채팅 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}
