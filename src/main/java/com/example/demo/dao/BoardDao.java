package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDao {
	public static int pageSIZE = 10;
	public static int totalRecord;
	public static int totalPage;
	
	
	public List<BoardVO> findAll(HashMap map){
		return DBManager.listBoard(map);
	}
	
	public int getNextNo() {
		return DBManager.getNextNo();
	}
	
	public int insert(BoardVO b) {
		return DBManager.insertBoard(b);
	}
	
	public BoardVO getBoard(int no) {
		return DBManager.getBoard(no);
	}
	
	public void updateViews(int no) {
		DBManager.updateViews(no);
	}

	public void updateStep(int b_ref, int b_step) {
		// TODO Auto-generated method stub
		DBManager.updateStep(b_ref,b_step);
	}
	
	public int update(BoardVO b) {
		return DBManager.updateBoard(b);
	}
	
	public int deleteBoard(int no) {
		return DBManager.deleteBoard(no);
	}
	
	public int getTotalRecord() {
		return DBManager.getTotalRecord();
	}
	
	//보민
	public List<BoardVO> listMyBoard(){
		return DBManager.listMyBoard();
	}
}