package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;

import com.example.demo.dao.CommentsDao;
import com.example.demo.dao.UsersDao;

import com.example.demo.db.DBManager;


@Controller
public class BoardController {
	
	@Autowired
	private BoardDao dao;
	@Autowired
	private CommentsDao commentsdao;
	@Autowired
	private UsersDao userdao;
	
	public UsersDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}

	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	public CommentsDao getCommentsdao() {
		return commentsdao;
	}

	public void setCommentsdao(CommentsDao commentsdao) {
		this.commentsdao = commentsdao;
	}
	

	

	@GetMapping("/board/listBoard.do")
	public void listBoard(HttpServletRequest request, @RequestParam(value = "pageNUM", 
						defaultValue = "1") int pageNUM, Model model,
			@RequestParam(value = "searchType", required = false, defaultValue = "board_title") String searchType , @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
	
		System.out.println("listBoard.do 동작함");
		System.out.println("검색컬럼:" +searchType);
		System.out.println("검색어:" + keyword);
		System.out.println("pageNUM:"+pageNUM);
		BoardDao.totalRecord = dao.getTotalRecord(searchType, keyword);
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
		// 다음 페이징 숫자 뜨게하기
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * BoardDao.pageSIZE >= BoardDao.totalRecord ? false : true;
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("searchType", searchType); 
		map.put("keyword", keyword);
		 
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
		// 검색 후에도 검색창 유지
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
	}
	
	@RequestMapping("/board/detailBoard.do")
	public void detailBoard(HttpServletRequest request, Model model, int board_no) {
		dao.updateViews(board_no);
		model.addAttribute("b",dao.getBoard(board_no));
		model.addAttribute("comments", commentsdao.findAll(board_no)); 
	}
	
	
	@RequestMapping("/board/deleteBoard.do")
	public ModelAndView deleteBoard(int board_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/board/listBoard.do");
		String path = request.getRealPath("resources/ard_img");
		String oldFname = dao.getBoard(board_no).getBoard_fname();
		
		int re = dao.deleteBoard(board_no);
		System.out.println(board_no);
		if(re == 1) {
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		return mav;
	}



	@RequestMapping(value = {"/board/board_write.do", "/board/updateBoard.do"})
	public void board_write(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("u", userdao.getUsers(id));
	}


	@RequestMapping("/manageMyboard.do")
	public ModelAndView listMyBoard() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.listMyBoard());
		return mav;
	}
}
