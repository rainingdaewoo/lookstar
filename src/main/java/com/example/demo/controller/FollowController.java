package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.FollowDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

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
	}
}
