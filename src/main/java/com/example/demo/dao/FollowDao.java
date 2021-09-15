package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.UsersVO;

@Repository
public class FollowDao {

	public static int pageSIZE = 3;
	public static int totalRecord;
	public static int totalPage;
	
	public int getTotalRecord(String users_id) {
		return DBManager.getTotalMyFollow(users_id);
	}
	
	public List<UsersVO> listFollow(HashMap map){
		return DBManager.listFollw(map);
	}
}
     