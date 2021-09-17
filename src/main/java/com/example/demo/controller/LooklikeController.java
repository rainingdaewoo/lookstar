package com.example.demo.controller;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.LooklikeDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.LooklikeVO;

@Controller
public class LooklikeController {

	
	@Autowired
	private LookbookDao lookbookdao;
	
	@Autowired
	private UsersDao usersdao;
	
	@Autowired
	private LooklikeDao likedao;
	
	
	
	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
	}

	
	public void setUsersdao(UsersDao usersdao) {
		this.usersdao = usersdao;
	}
	public void setLikedao(LooklikeDao likedao) {
		this.likedao = likedao;
	}
	
	@RequestMapping("/mypage/likeList.do")
	public ModelAndView listLikes(@RequestParam(value="pageNUM",defaultValue = "1") int pageNUM ,int users_no,Model	model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("users", usersdao.getUsers(id));
		
		LooklikeDao.totalRecord = likedao.getTotalRecord(users_no);
		LooklikeDao.totalPage = (int)Math.ceil((double)LooklikeDao.totalRecord/LooklikeDao.pageSIZE);
		
		int start = (pageNUM-1)*LooklikeDao.pageSIZE+1;
		int end = start+LooklikeDao.pageSIZE-1;
		if(end > LooklikeDao.totalRecord) {
			end = LooklikeDao.totalRecord;
		}
		
		//System.out.println("like start:"+start);
		//System.out.println("like end:"+ end);
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("users_no", users_no);
		
		//System.out.println("좋아요controller users_no:"+users_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",likedao.listLikes(map));
		model.addAttribute("totalPage",LooklikeDao.totalPage);
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/insertLooklike.do")
	public String insertLooklike(HttpServletRequest request, Model model, LooklikeVO looklike) {
		System.out.println("insertLooklike.do 작동함" + looklike);
		int re = likedao.insertLooklike(looklike);
		System.out.println("looklike값: "+looklike);
		
		return "looklikeOK";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteLooklike.do")
	public String deleteLooklike(HttpServletRequest request, Model model, int users_no, int lookbook_no) {
		System.out.println("deleteLooklike.do 작동함");
		int re = likedao.deleteLooklike(users_no,lookbook_no);
		return "ok";
	}
}
