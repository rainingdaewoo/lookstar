package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.FollowDao;
import com.example.demo.dao.LookbookDao;
import com.example.demo.dao.LooklikeDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.RangeWeightHeightVO;
import com.example.demo.vo.SelectLookbookCommandVO;
import com.example.demo.vo.Style_searchVO;

@Controller
public class LookbookController {
	@Autowired
	private UsersDao userdao;
	@Autowired
	private LookbookDao lookbookdao;
	@Autowired
	private FollowDao followdao;
	@Autowired
	private LooklikeDao looklikedao;

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}

	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
	}

	public void setFollowdao(FollowDao followdao) {
		this.followdao = followdao;
	}

	public void setLooklikedao(LooklikeDao looklikedao) {
		this.looklikedao = looklikedao;
	}

	@RequestMapping("/lookbook/ListLookbook.do")
	@ResponseBody
	public List<LookbookVO> listlookbook(@RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM, Model model,
			String sortField, RangeWeightHeightVO rw, Style_searchVO sv) {
		lookbookdao.totalRecord = lookbookdao.getTotalRecordLookbook();
		lookbookdao.totalPage = (int) Math.ceil((double) lookbookdao.totalRecord / lookbookdao.pageSIZE);

		int start = (pageNUM - 1) * lookbookdao.pageSIZE + 1;
		int end = start + lookbookdao.pageSIZE - 1;
		if (end > lookbookdao.totalRecord) {
			end = lookbookdao.totalRecord;
		}

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int) (Math.ceil((double) pageNUM / (double) lookbookdao.pageSIZE) * lookbookdao.pageSIZE);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (lookbookdao.pageSIZE - 1);

		// 마지막 번호 재계산
		int endPageNum_tmp = (int) (Math.ceil((double) lookbookdao.totalRecord / (double) lookbookdao.pageSIZE));

		if (endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		// 다음 페이징 숫자 뜨게하기
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * lookbookdao.pageSIZE >= lookbookdao.totalRecord ? false : true;

		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		String arr_Style[] = sv.getArr();
		map.put("sortField", sortField);
		map.put("arr_Style", arr_Style);
		map.put("rw", rw);

		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", pageNUM);
		//
		model.addAttribute("totalPage", lookbookdao.totalPage);

		model.addAttribute("list", lookbookdao.listLookbookFilter(map));
		System.out.println("listlookbook 작동");
		List<LookbookVO> list = lookbookdao.listLookbookFilter(map);
		return list;
	}

	@GetMapping("/lookbook/lookbook.do")
	public List<LookbookVO> lookbook(@RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM, Model model,
			String sortField, RangeWeightHeightVO rw, Style_searchVO sv) {
		lookbookdao.totalRecord = lookbookdao.getTotalRecordLookbook();
		lookbookdao.totalPage = (int) Math.ceil((double) lookbookdao.totalRecord / lookbookdao.pageSIZE);

		int start = (pageNUM - 1) * lookbookdao.pageSIZE + 1;
		int end = start + lookbookdao.pageSIZE - 1;
		if (end > lookbookdao.totalRecord) {
			end = lookbookdao.totalRecord;
		}

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int) (Math.ceil((double) pageNUM / (double) lookbookdao.pageSIZE) * lookbookdao.pageSIZE);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (lookbookdao.pageSIZE - 1);

		// 마지막 번호 재계산
		int endPageNum_tmp = (int) (Math.ceil((double) lookbookdao.totalRecord / (double) lookbookdao.pageSIZE));

		if (endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		// 다음 페이징 숫자 뜨게하기
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * lookbookdao.pageSIZE >= lookbookdao.totalRecord ? false : true;

		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		String arr_Style[] = sv.getArr();
		map.put("sortField", sortField);
		map.put("arr_Style", arr_Style);
		map.put("rw", rw);

		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		// 현재 페이지
		model.addAttribute("select", pageNUM);
		//
		model.addAttribute("totalPage", lookbookdao.totalPage);

		model.addAttribute("list", lookbookdao.listLookbookFilter(map));
		System.out.println("listlookbook 작동");
		List<LookbookVO> list = lookbookdao.listLookbookFilter(map);
		return list;
	}

	@RequestMapping("/lookbook/lookbook_write.do")
	public void lookbook_write(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("u", userdao.getUsers(id));
	}

	@RequestMapping("/lookbook/lookbook_detail.do")
	public void detailLookbook(HttpServletRequest request, Model model, int lookbook_no) {
		SelectLookbookCommandVO look = lookbookdao.selectLookbook(lookbook_no);
		lookbookdao.updateLookbookViews(lookbook_no);

		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("인증정보: " + authentication);
			User user = (User) authentication.getPrincipal();
			
			
			
			// id는 뭔지 안다! id안에 있는 fname 등등은 모름 아직
			String id = user.getUsername();
			System.out.println("ooooooooooooooooooooo");
			System.out.println("id값: " + id);
			model.addAttribute("u", userdao.getUsers(id));
			
			
		
			String follower_id = id;
			String following_id = look.getUsers().getUsers_id();
			System.out.println("로그인한 아이디: " + follower_id);
			System.out.println("글쓴 아이디: " + following_id);

			// 팔로우 여부 조회
			int followBtn = followdao.isFollow(follower_id, following_id);
			System.out.print("팔로우여부: " + followBtn);
			model.addAttribute("followBtn", followBtn);

			// 좋아요 여부 조회
			int isLooklike = looklikedao.isLooklike(userdao.getUsers(id).getUsers_no(),
					look.getLookbook().getLookbook_no());
			model.addAttribute("isLooklike", isLooklike);

		} else {
			// 비로그인시 팔로우버튼/ 빈하트버튼 보여줌
			model.addAttribute("followBtn", 0);
			model.addAttribute("isLooklike", 0);
		}

		// 룩북 좋아요 개수 정보
		int likelookCount = looklikedao.countLooklike(look.getLookbook().getLookbook_no());
		model.addAttribute("likelookCount", likelookCount);
		// 룩북 쓴 유저의 정보
		model.addAttribute("write_u", look.getUsers());
		// lookbook에 대한 정보
		model.addAttribute("look", look.getLookbook());
		// lookinfo에 대한 정보
		model.addAttribute("info", look.getList_info());
		// lookbook_style에 대한 정보
		model.addAttribute("style", look.getList_style());

	}

	@RequestMapping("/lookbook/deletelookbook.do")
	public ModelAndView deleteBoard(int lookbook_no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/lookbook/lookbook.do");
		String path = request.getRealPath("/resources/look_img");
		String oldFname = lookbookdao.getDelLookbook(lookbook_no).getLookbook_fname();

		int re = lookbookdao.deleteLookbook(lookbook_no);
		System.out.println(lookbook_no);
		if (re == 1) {
			File file = new File(path + "/" + oldFname);
			file.delete();
		}
		return mav;
	}

	// 보민 마이페이지 내 룩북 관리
	@RequestMapping("/mypage/manageMylook.do")
	public ModelAndView listMyLook(@RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM, int users_no,
			Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("users", userdao.getUsers(id));
		
		LookbookDao.totalMyLook = lookbookdao.getTotalMyLook(users_no);
		LookbookDao.my_totalPage = (int)Math.ceil((double)LookbookDao.totalMyLook/LookbookDao.my_pageSIZE);
		System.out.println("my_totalPage:" + LookbookDao.my_totalPage);	
		System.out.println("LookbookDao.my_pageSIZE:" + LookbookDao.my_pageSIZE);	
		int start = (pageNUM-1)*LookbookDao.my_pageSIZE + 1;
		int end = start+LookbookDao.my_pageSIZE-1;
		if (end > LookbookDao.totalMyLook) {
			end = LookbookDao.totalMyLook;
		}

		System.out.println("start:" + start);
		System.out.println("end:" + end);
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("users_no", users_no);
		System.out.println("controller users_no:" + users_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", lookbookdao.listMyLook(map));

		model.addAttribute("totalPage", LookbookDao.my_totalPage);
		return mav;
	}
}
