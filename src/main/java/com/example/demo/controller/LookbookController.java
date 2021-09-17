package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<LookbookVO> listlookbook(Style_searchVO sv, Model model) {
		//System.out.println("listlookbook의 list" + list);
		System.out.println("ListLookbook.do의 likelookbook 동작함:"+ Arrays.toString(sv.getArr()));
		String arr_Style[] = sv.getArr();
		HashMap map = new HashMap();
		map.put("arr_Style", arr_Style);
		List<LookbookVO> list = lookbookdao.listLookbook(map);
		return list;
	}
	@RequestMapping("/lookbook/ListWeightHeight.do")
	@ResponseBody
	public List<LookbookVO> rangelookbook(RangeWeightHeightVO rw, Model model){
		System.out.println("ListWeightHeight.do 작동:");
		System.out.println("Height_low: "+ rw.getHeight_low() );
		System.out.println("Height_high: "+ rw.getHeight_high() );
		System.out.println("Weight_low: "+ rw.getWeight_low() );
		System.out.println("Weight_high: "+ rw.getWeight_high() );
		
		List<LookbookVO> list = lookbookdao.listLookbook(rw);
		
		return list;
	}


	@RequestMapping("/lookbook/lookbook.do")
	public void lookbook(Model model, String sortField, Style_searchVO sv) {
		HashMap map = new HashMap();
		String arr_Style[] = sv.getArr();
		map.put("sortField", sortField);
		map.put("arr_Style", arr_Style);
		model.addAttribute("list", lookbookdao.listLookbook(map));
	}
	
	
	
	@RequestMapping("/lookbook/lookbook_write.do")
	public void lookbook_write(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("u", userdao.getUsers(id));
	}
	@RequestMapping("/lookbook/lookbook_detail.do")
	public void detailLookbook(HttpServletRequest request,Model model,int lookbook_no) {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("인증정보: "+authentication);
			User user = (User)authentication.getPrincipal();
			String id = user.getUsername();
			System.out.println("ooooooooooooooooooooo");
			System.out.println("id값: "+id);
			
			model.addAttribute("u", userdao.getUsers(id));
		}

		SelectLookbookCommandVO look = lookbookdao.selectLookbook(lookbook_no);
		
		
		model.addAttribute("write_u", look.getUsers());
		model.addAttribute("look", look.getLookbook());
		model.addAttribute("info", look.getList_info());
		model.addAttribute("style", look.getList_style());
		
	}
	
	//보민 마이페이지 내 룩북 관리
	@RequestMapping("/mypage/manageMylook.do")
	public ModelAndView listMyLook( @RequestParam(value="pageNUM",defaultValue = "1") int pageNUM,int users_no,Model model) {
		System.out.println("pageNUM:"+pageNUM);
		LookbookDao.totalMyLook = lookbookdao.getTotalMyLook(users_no);
		LookbookDao.totalPage = (int)Math.ceil((double)LookbookDao.totalMyLook/LookbookDao.pageSIZE);
		
		int start = (pageNUM-1)*LookbookDao.pageSIZE+1;
		int end = start+LookbookDao.pageSIZE-1;
		if(end>LookbookDao.totalMyLook) {
			end = LookbookDao.totalMyLook;
		}
		
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("users_no", users_no);
		System.out.println("controller users_no:"+users_no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",lookbookdao.listMyLook(map));
		
		model.addAttribute("totalPage",LookbookDao.totalPage);
		return mav;
	}
}
