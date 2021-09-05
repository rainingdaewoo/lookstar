package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.CommentsVO;

@Repository
public class CommentsDao {
	
	public List<CommentsVO> findAll(){
		return DBManager.listComments();
	}
	
	public int insertComments(CommentsVO c) {
		return DBManager.insertComments(c);
	}
}
