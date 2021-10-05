package com.example.demo.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

@Controller
@RequestMapping("/users/findPW.do")
public class FindPWController {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UsersDao dao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView mail(String users_id,String users_email,HttpSession session) {
		System.out.println("findPW.do 동작함");
		UsersVO u = new UsersVO();
		ModelAndView mav = new ModelAndView("redirect:/users/findOK.do");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		String code = "abcdef"+a+""+b+""+c+""+d;
		System.out.println(code);
		u.setUsers_pw("");
		String encode_code= passwordEncoder.encode(code);
		u.setUsers_pw(encode_code);
		int re = dao.updatePW(encode_code,users_id, users_email);
		System.out.println("인코드 전 비밀번호 코드:" + code);
		System.out.println("인코드 후 비밀번호 코드:" + encode_code);
		mailMessage.setSubject("룩스타그램 비밀번호");
		mailMessage.setFrom("rladudtjrwkd@gmail.com");
		mailMessage.setText("회원님의 비밀번호는 : " + code);
		mailMessage.setTo(users_email);
		if(re == 1) {
			try {
				javaMailSender.send(mailMessage);
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
			session.setAttribute("msg","이메일 발송이 완료되었습니다. 보낸 임시 비밀번호로 로그인하여 마이페이지에서 비밀번호 변경 바랍니다." );
		}else {			
			session.setAttribute("msg", "이메일 또는 아이디를 다시 확인해 주시기 바랍니다.");
		}
		
		return mav;
	}
}
