package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

@Controller
@RequestMapping("/findID.do")
public class FindIDController {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UsersDao dao;
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView mail(String users_email, HttpSession session) {
		System.out.println("findID.do 동작함");
		ModelAndView mav = new ModelAndView("redirect:/findOK.do");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		String id = dao.findID(users_email);
		mailMessage.setSubject("룩스타그램 아이디");
		mailMessage.setFrom("rladudtjrwkd@gmail.com");
		mailMessage.setText("회원님의 아이디는 : " + id);
		mailMessage.setTo(users_email);
		if(!id.equals("")) {
			try {
				javaMailSender.send(mailMessage);
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
			session.setAttribute("msg","이메일 발송이 완료되었습니다 다시 로그인 해주시기 바랍니다." );
		}else{
			session.setAttribute("msg", "이메일을 다시 확인해 주시기 바랍니다.");
		}
		return mav;
		
		
	}
	
}
