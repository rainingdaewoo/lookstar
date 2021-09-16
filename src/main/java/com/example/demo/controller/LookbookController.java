package com.example.demo.controller;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.LookbookDao;
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

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}

	public void setLookbookdao(LookbookDao lookbookdao) {
		this.lookbookdao = lookbookdao;
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
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("인증정보: " + authentication);
			User user = (User) authentication.getPrincipal();
			String id = user.getUsername();
			System.out.println("ooooooooooooooooooooo");
			System.out.println("id값: " + id);
			// 현재 로그인 되어 있는 유저의 정보
			model.addAttribute("u", userdao.getUsers(id));
		}
		SelectLookbookCommandVO look = lookbookdao.selectLookbook(lookbook_no);
		lookbookdao.updateLookbookViews(lookbook_no);
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
}
