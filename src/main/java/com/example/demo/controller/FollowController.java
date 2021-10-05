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
import com.example.demo.dao.LookbookDao;

@Controller
public class FollowController {

	@Autowired
	private UsersDao usersdao;
	@Autowired
	private LookbookDao lookbookdao;
	@Autowired
	private FollowDao fdao;
	
	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
	}

	public void setFdao(FollowDao fdao) {
		this.fdao = fdao;
	}

	public void setUsersdao(UsersDao usersdao) {
		this.usersdao = usersdao;
	}      
	
	@RequestMapping("/mypage/followList.do")
	public ModelAndView followList(@RequestParam(value="pageNUM",defaultValue = "1") int pageNUM, Model model,HttpSession session,String users_id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("users", usersdao.getUsers(id));
		
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
	}
	
	@RequestMapping("/mypage/followingLookbook.do")
	public ModelAndView followingLook(@RequestParam(value = "pageNUM",defaultValue = "1") int pageNUM,int users_no,Model model,HttpSession session,String users_nickname) {
		//System.out.println("bbb 81 controller:"+users_no);
		//System.out.println("bbb nickname s:"+users_nickname);
		session.setAttribute("fusers_nickname", users_nickname);
		session.setAttribute("fusers_no", users_no);
		
		FollowDao.totalFRecord = fdao.getTotalFRecord(users_no);
		FollowDao.totalFPage = (int)Math.ceil((double)FollowDao.totalFRecord/LookbookDao.pageSIZE);
		int start = (pageNUM-1)*LookbookDao.pageSIZE+1;
		int end = start+LookbookDao.pageSIZE-1;
		if(end>FollowDao.totalFRecord) {
			end = FollowDao.totalFRecord;
		}
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("users_no", users_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",fdao.listFLook(map));
		System.out.println("list:"+fdao.listFLook(map));
		model.addAttribute("totalPage",FollowDao.totalFPage);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertFollow.do")
	public String insertFollow(HttpServletRequest request, Model model, FollowVO follow) {
		System.out.println("insertFollow 작동함"+follow);
		
		int re = fdao.insertFollow(follow);
		System.out.println("follow 값:" + follow);
		System.out.println("insertFollow.do의 re값: " + re);
		
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteFollow.do")
	public String deleteFollow(HttpServletRequest request, Model model,String follower_id, String following_id) {
		System.out.println("deleteFollow 작동함");
		
		/*
		HashMap map = new HashMap();
		map.put("follower_id", follower_id);
		map.put("following_id", following_id);
		*/
		int re = fdao.deleteFollow(follower_id, following_id);
		return "ok";
	}
}
