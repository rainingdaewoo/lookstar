package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.db.DBManager;


@Controller
public class BoardController {
	
	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	/*
	 * @RequestMapping("/") public ModelAndView main(HttpServletRequest request) {
	 * ModelAndView mav = new ModelAndView("redirect:/listBoard.do"); return mav; }
	 */
	
	@RequestMapping("/listBoard.do")
	public void listBoard(HttpServletRequest request, @RequestParam(value = "pageNUM", 
						defaultValue = "1") int pageNUM, Model model) {
		System.out.println("pageNUM:"+pageNUM);
		BoardDao.totalRecord = dao.getTotalRecord();
		BoardDao.totalPage =
		(int) Math.ceil( (double) BoardDao.totalRecord / BoardDao.pageSIZE);
		
		int start = (pageNUM-1)* BoardDao.pageSIZE +1;
		int end=start+BoardDao.pageSIZE-1;
		if(end > BoardDao.totalRecord) {
			end = BoardDao.totalRecord;
		}
		
		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)pageNUM / (double)BoardDao.pageSIZE) * BoardDao.pageSIZE);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (BoardDao.pageSIZE - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)BoardDao.totalRecord / (double)BoardDao.pageSIZE));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * BoardDao.pageSIZE >= BoardDao.totalRecord ? false : true;
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", pageNUM);
		//
		model.addAttribute("list", dao.findAll(map));
		model.addAttribute("totalPage", BoardDao.totalPage);
	}
	
	@RequestMapping("/detailBoard.do")
	public void detailBoard(HttpServletRequest request, Model model, int board_no) {
		dao.updateViews(board_no);
		model.addAttribute("b",dao.getBoard(board_no));
	}
	
	
	@RequestMapping("/deleteBoard.do")
	public ModelAndView deleteBoard(int board_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String path = request.getRealPath("resources/images");
		String oldFname = dao.getBoard(board_no).getBoard_fname();
		
		int re = dao.deleteBoard(board_no);
		System.out.println(board_no);
		if(re == 1) {
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		return mav;
	}
	
	
	@RequestMapping("/manageMyboard.do")
	public ModelAndView listMyBoard() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.listMyBoard());
		return mav;
	}
}
