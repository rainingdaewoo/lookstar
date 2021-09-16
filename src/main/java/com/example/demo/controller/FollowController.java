package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.FollowDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.FollowVO;
import com.example.demo.vo.UsersVO;

import ch.qos.logback.classic.Logger;

@Controller
public class FollowController {

	@Autowired
	private UsersDao usersdao;
	
	@Autowired
	private FollowDao fdao;
	
	public void setFdao(FollowDao fdao) {
		this.fdao = fdao;
	}

	public void setUsersdao(UsersDao usersdao) {
		this.usersdao = usersdao;
	}
	/*
	@RequestMapping("/mypage/followList.do")
	public ModelAndView followList(@RequestParam(value="pageNUM",defaultValue = "1") int pageNUM, Model model,HttpSession session,String users_id) {
		System.out.println("users_id:"+users_id);
		
		System.out.println("controller 팔로우 pageNUM:"+pageNUM);
		FollowDao.totalRecord = fdao.getTotalRecord(users_id);
		FollowDao.totalPage = (int)Math.ceil((double)FollowDao.totalRecord/FollowDao.pageSIZE);
		
		int start = (pageNUM-1)*FollowDao.pageSIZE+1;
		int end = start+FollowDao.pageSIZE-1;
		if(end > FollowDao.totalRecord ) {
			end = FollowDao.totalRecord;
		}
		
		System.out.println("f start:"+start);
		System.out.println("f end:"+ end);
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("users_id", users_id);
		System.out.println("팔로우controller users_id"+users_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",fdao.listFollow(map));
		
		List<UsersVO> list = fdao.listFollow(map);
		System.out.println("팔로우목록:"+list);
		model.addAttribute("flist",list);
		model.addAttribute("totalPage",FollowDao.totalPage);
		return mav;
	}*/
	
	
	
	/* 팔로우 실험용
	@RequestMapping("/follow")
	public void follow(HttpServletRequest request, Model model) throws Exception {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("인증정보: " + authentication);
			User user = (User) authentication.getPrincipal();
			String id = user.getUsername();
			System.out.println("ooooooooooooooooooooo");
			System.out.println("id값: " + id);
			// 현재 로그인 되어 있는 유저의 정보
			model.addAttribute("u", usersdao.getUsers(id));
		}
		
		// lookbook에 대한 정보
		model.addAttribute("look", look.getLookbook());
		String following = request.getParameter("user_id");
		String followed = request.getParameter("page_id");

		fdao.follow(following, followed);

	}
	*/
	@ResponseBody
	@RequestMapping(value = "/insertFollow.do")
	public void insertFollow(HttpServletRequest request, Model model, FollowVO follow) {
		System.out.println("insertFollow 작동함");
		
		
		int re = fdao.insertFollow(follow);
		System.out.println("follow 값:" + follow);
		System.out.println("insertFollow.do의 re값: " + re);
		
	}
}