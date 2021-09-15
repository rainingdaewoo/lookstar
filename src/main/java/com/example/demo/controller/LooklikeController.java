package com.example.demo.controller;
     
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.LooklikeDao;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.LooklikeVO;

@Controller
public class LooklikeController {

	@Autowired
	private LooklikeDao dao;

	@Autowired
	private LookbookDao lookbookdao;
	
	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
	}

	public void setDao(LooklikeDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/mypage/likeList.do")
	public ModelAndView listLikes(@RequestParam(value="pageNUM",defaultValue = "1") int pageNUM ,int users_no,Model	model){
		System.out.println("좋아요 페이지 넘버:"+pageNUM);
		LooklikeDao.totalRecord = dao.getTotalRecord(users_no);
		LooklikeDao.totalPage = (int)Math.ceil((double)LooklikeDao.totalRecord/LooklikeDao.pageSIZE);
		
		int start = (pageNUM-1)*LooklikeDao.pageSIZE+1;
		int end = start+LooklikeDao.pageSIZE-1;
		if(end > LooklikeDao.totalRecord) {
			end = LooklikeDao.totalRecord;
		}
		
		System.out.println("like start:"+start);
		System.out.println("like end:"+ end);
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("users_no", users_no);
		
		System.out.println("좋아요controller users_no:"+users_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.listLikes(map));
		model.addAttribute("totalPage",LooklikeDao.totalPage);
		return mav;
	}
}
