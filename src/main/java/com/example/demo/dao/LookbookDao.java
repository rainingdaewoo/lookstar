package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.InsertLookbookCommandVO;
import com.example.demo.vo.LookInfoVO;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.Lookbook_styleVO;
import com.example.demo.vo.UsersVO;

@Repository
public class LookbookDao {
	
	public List<LookbookVO> listLookbook(String sortField) {
		// TODO Auto-generated method stub
		return DBManager.listLookbook(sortField);
	}

	public int insert(InsertLookbookCommandVO insertlook) {
		return DBManager.insertLookbook(insertlook);
	}
	
	
}
