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
	
	public int insertBoard(BoardVO b) {
		return DBManager.insertBoard(b);
	}
	
	public BoardVO getBoard(int no) {
		return DBManager.getBoard(no);
	}
	
	public void updateViews(int no) {
		DBManager.updateViews(no);
	}
	
	public void plusCommentsCount(int no) {
		DBManager.plusCommentsCount(no);
	}
	
	public void minusCommentsCount(int no) {
		DBManager.minusCommentsCount(no);
	}

	public void updateStep(int b_ref, int b_step) {
		// TODO Auto-generated method stub
		DBManager.updateStep(b_ref,b_step);
	}
	

	public int updateBoard(BoardVO b) {
		System.out.println("BoardDao 작동함");
		return DBManager.updateBoard(b);
	}
	
	public int deleteBoard(int no) {
		return DBManager.deleteBoard(no);
	}
	
	public int getTotalRecord(String searchType, String keyword) {
		return DBManager.getTotalRecord(searchType, keyword);
	}
	
	//보민
	public List<BoardVO> listMyBoard(){
		return DBManager.listMyBoard();
	}
}