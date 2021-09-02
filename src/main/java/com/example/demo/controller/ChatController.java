package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
	
	@RequestMapping("/chat2.do")
	public ModelAndView chat2() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
