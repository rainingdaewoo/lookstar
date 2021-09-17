package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.LooklikeVO;

	
import java.util.HashMap;
import java.util.List;


import com.example.demo.vo.LookbookVO;

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
	public int countLooklike(int lookbook_no) {
		// TODO Auto-generated method stub
		return DBManager.countLooklike(lookbook_no);
	}

	public int isLooklike(int users_no, int lookbook_no) {
		// TODO Auto-generated method stub
		return DBManager.isLooklike(users_no,lookbook_no);
	}

	public int insertLooklike(LooklikeVO looklike) {
		// TODO Auto-generated method stub
		return DBManager.insertLooklike(looklike);
	}

	public int deleteLooklike(int users_no, int lookbook_no) {
		// TODO Auto-generated method stub
		return DBManager.deleteLooklike(users_no,lookbook_no);
	}
}
