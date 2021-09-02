package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ChatVO;
import com.example.demo.vo.UsersVO;

@Repository
public class ChatDao {
	public int insertDM(ChatVO c) {
		return DBManager.insertDM(c);
	}
	
	public List<ChatVO> listDM(String from_id) {
		return DBManager.listDM(from_id);
	}
}
