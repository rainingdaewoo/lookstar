package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.LooklikeVO;

@Repository
public class LooklikeDao {
	public static int pageSIZE = 4;
	public static int totalRecord;
	public static int totalPage;
	
	public int getTotalRecord(int users_no) {
		return DBManager.getTotalMyLikes(users_no);
	}
	
	public List<LookbookVO> listLikes(HashMap map){
		return DBManager.listLikes(map);
	}
}
      