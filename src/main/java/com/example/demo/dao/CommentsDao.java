package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.CommentsVO;

@Repository
public class CommentsDao {
	
	public List<CommentsVO> findAll(int board_no){
		System.out.println("CommentsDao findAll 작동함");
		return DBManager.listComments(board_no);
	}
	
	public int insertComments(CommentsVO c) {
		System.out.println("CommentsDao insertComments 작동함");
		return DBManager.insertComments(c);
	}
	
	public int deleteComments(int comments_no) {
		System.out.println("CommentsDao deleteComments 작동함/" + comments_no);
		return DBManager.deleteComments(comments_no);
	}
	
	public CommentsVO getComments(int comments_no) {
		System.out.println("CommentsDao getComments 작동함/" + comments_no);
		return DBManager.getComments(comments_no);
	}
	
	public int updateComments(CommentsVO c) {
		System.out.println("CommentsDao updateComments 작동함");
		return DBManager.updateComments(c);
	}
}
