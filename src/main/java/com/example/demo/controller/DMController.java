package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DMDao;
import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.DMVO;

@Controller
public class DMController {
	
	@Autowired
	private DMDao dao;
	@Autowired
	private UsersDao userdao;
	@Autowired
	private LookbookDao lookbookdao;
	
	
	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}

	//HashMap에 사용
	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
	}

	public void setDao(DMDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/dmTest.do")
	public void test(Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		System.out.println("dmTest.do 동작함");
		System.out.println("login한 회원의 아이디: "+id);
		session.setAttribute("u", userdao.getUsers(id));
	}

	
	@RequestMapping(value="/dmTest02.do")
	@ResponseBody
	public ModelAndView listDM(Model model, HttpSession session, String users_nickname, int lookbook_no, String users_fname, String users_id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//아래것이 오류나서 바꿈
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		//String id = authentication.getName();
	
		
		System.out.println("dmTest.do 동작함");
		System.out.println("login한 회원의 아이디: "+id);
		session.setAttribute("u", userdao.getUsers(id));
		session.setAttribute("dto_users_id", users_id);
		session.setAttribute("dto_users_nickname", users_nickname);
		session.setAttribute("dto_users_fname", users_fname);
		System.out.println("users_id: "+users_id);
		System.out.println("users_nickname: "+users_nickname);
		System.out.println("users_fname: "+users_fname);
		HashMap map = new HashMap();
		map.put("users_id", id);
		map.put("lookbook_no", lookbook_no);
		
		System.out.println("디엠controller users_id"+id);
		ModelAndView mav = new ModelAndView();
		// 목록정보(1:1 채팅내역)
		mav.addObject("list",dao.findAll2(map));
		
		
		List<DMVO> list = dao.findAll2(map);
		
		System.out.println("디엠목록(정보):"+list);
		model.addAttribute("dlist",list);
		

		return mav;
	}
	
	
	
	@RequestMapping("/listlist.do")
	@ResponseBody
	public List<DMVO> iconDMListPeople(Model model, HttpSession session, DMVO d) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		System.out.println("iconDMList 동작함!");
		session.setAttribute("u", userdao.getUsers(id));
		System.out.println("icoDMList id: "+id);
		List<DMVO> list = null;
		//ModelAndView mav = new ModelAndView();
		list = dao.iconListPeople(id);
		return list;
		
	}
	
		
	@RequestMapping("/dmTest03.do")
	@ResponseBody
	public ModelAndView iconListDM(Model model, HttpSession session, String to_id, String room_no, String to_nickname, String to_profile) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();	
		System.out.println("dmTest03.do 동작함");
		System.out.println("login한 회원의 아이디: "+id);
		session.setAttribute("u", userdao.getUsers(id));
		session.setAttribute("icon_to_profile", to_profile);
		session.setAttribute("icon_to_nickname", to_nickname);
		session.setAttribute("icon_to_id", to_id);
		//session.setAttribute("icon_room_no", room_no);
	
		System.out.println("디엠2controller users_id"+id);
		ModelAndView mav = new ModelAndView();
		// 목록정보(1:1 채팅내역)
		mav.addObject("list",dao.findAll3(room_no));
		List<DMVO> list = dao.findAll3(room_no);
		
		
		System.out.println("아이콘 디엠목록(정보):"+list);
		model.addAttribute("dlist",list);
		return mav;
	}
	
	
	/*
	//to_nickname? 수신자를 직접 입력했을 때 썼던 컨트롤러들
	@RequestMapping("/listChat.do")
	@ResponseBody	
	public List<DMVO> listDM(HttpSession session){
		List<DMVO> dmList = null;
		if(session.getAttribute("u")!=null) {
			String users_nickname = ((UsersVO)session.getAttribute("u")).getUsers_nickname();
			dmList = dao.findAll2(users_nickname);
		}				
		return dmList;
	}
	
	
	//채팅목록보여주는곳
	@RequestMapping("/listPeople.do")
	@ResponseBody
	public List<DMVO> listPeople(HttpSession session){
		List<DMVO> list = null;
		if(session.getAttribute("u")!=null) {
			String users_nickname = ((UsersVO)session.getAttribute("u")).getUsers_nickname();
			list = dao.findAll(users_nickname);
		}				
		return list;
	}
	 */
}