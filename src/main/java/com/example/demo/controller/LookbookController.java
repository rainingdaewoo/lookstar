package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public List<LookbookVO> listlookbook(String sortField,RangeWeightHeightVO rw,Style_searchVO sv, Model model) {
		//System.out.println("listlookbook의 list" + list);
		System.out.println("ListLookbook.do의 likelookbook 동작함:"+ Arrays.toString(sv.getArr()));
		String arr_Style[] = sv.getArr();
		HashMap map = new HashMap();
		/*
		
		if(sortField==null) {
			sortField="NEW";
		}
		if(arr_Style.length==0) {
			arr_Style[0] = "1";
			arr_Style[1] = "2";
			arr_Style[2] = "3";
			arr_Style[3] = "4";
			arr_Style[4] = "5";
			arr_Style[5] = "6";
			arr_Style[6] = "7";
			arr_Style[7] = "8";
			arr_Style[8] = "9";
			arr_Style[9] = "10";
		}
		if(rw.getWeight_low()==null && rw.getHeight_low()==null) {
			rw.setWeight_low("0");
			rw.setWeight_high("150");
			rw.setHeight_low("0");
			rw.setHeight_high("220");
		}
		*/
		map.put("sortField", sortField);
		map.put("arr_Style", arr_Style);
		map.put("rw", rw);
		List<LookbookVO> list = lookbookdao.listLookbookFilter(map);
		return list;
	}


	@RequestMapping("/lookbook/lookbook.do")
	public void lookbook(String sortField,RangeWeightHeightVO rw,Style_searchVO sv, Model model) {
		System.out.println("lookbook.do 작동");
		String arr_Style[] = sv.getArr();		
		HashMap map = new HashMap();

		if(sortField==null) {
			sortField="NEW";
		}
		if(arr_Style==null || arr_Style.length==0) {
			
			arr_Style[0] = "1";
			arr_Style[1] = "2";
			arr_Style[2] = "3";
			arr_Style[3] = "4";
			arr_Style[4] = "5";
			arr_Style[5] = "6";
			arr_Style[6] = "7";
			arr_Style[7] = "8";
			arr_Style[8] = "9";
			arr_Style[9] = "10";
		}
		if(rw.getWeight_low()==null && rw.getHeight_low()==null) {
			rw.setWeight_low("0");
			rw.setWeight_high("150");
			rw.setHeight_low("0");
			rw.setHeight_high("220");
		}
		map.put("sortField", sortField);
		map.put("arr_Style", arr_Style);
		map.put("rw", rw);
		model.addAttribute("list", lookbookdao.listLookbookFilter(map));
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
}
