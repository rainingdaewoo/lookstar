package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DMVO;
import com.example.demo.vo.InsertLookbookCommandVO;
import com.example.demo.vo.LookInfoVO;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.Lookbook_styleVO;
import com.example.demo.vo.RangeWeightHeightVO;
import com.example.demo.vo.SelectLookbookCommandVO;
import com.example.demo.vo.UsersVO;

@Repository
public class LookbookDao {
	
	public static int pageSIZE = 4;
	public static int totalMyLook;
	public static int totalPage;
	
	// lookbook 사진 조회시
	public List<LookbookVO> listLookbook(HashMap arr_style) {
		// TODO Auto-generated method stub
		return DBManager.listLookbook(arr_style);
	}
	public List<LookbookVO> listLookbook(RangeWeightHeightVO rw) {
		// TODO Auto-generated method stub
		return DBManager.listLookbook(rw);
	}
	// 룩북 넣을 시
	public int insert(InsertLookbookCommandVO insertlook) {
		System.out.println("=====Dao의 결과==================");
		System.out.println("lookbook: "+ insertlook.getLookbook());
		System.out.println("list_info: "+ insertlook.getList_info());
		System.out.println("style_no: "+ insertlook.getStyle_no());
		System.out.println("===============================");
		return DBManager.insertLookbook(insertlook);
	}
	// 룩북 클릭시
	public SelectLookbookCommandVO selectLookbook(int lookbook_no) {
		return DBManager.getLookbook(lookbook_no);
	}
	
	//보민 - 마이페이지 내 룩북 관리
	
	public int getTotalMyLook(int users_no) {
		return DBManager.getTotalMyLook(users_no);
	}
	
	public List<LookbookVO> listMyLook(HashMap map){
		//System.out.println("lookbookdao users_no:"+map.users_no);
		return DBManager.listMyLook(map);
	}
	
}