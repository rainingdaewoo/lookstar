package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.CommentsVO;

@Repository
public class CommentsDao {
	
	public List<CommentsVO> findAll(int board_no){
		return DBManager.listComments(board_no);
	}
	
	public int insertComments(CommentsVO c) {
		return DBManager.insertComments(c);
	}
	
	public int deleteComments(int comments_no) {
		return DBManager.deleteComments(comments_no);
	}
	
	public CommentsVO getComments(int comments_no) {
		return DBManager.getComments(comments_no);
	}
	
	public int updateComments(CommentsVO c) {
		System.out.println("BoardDao 작동함");
		return DBManager.updateComments(c);
	}
}
