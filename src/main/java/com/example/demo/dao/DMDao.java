package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DMVO;

@Repository
public class DMDao {
	
	public List<DMVO> findAll(){
		return DBManager.listDM();
	}
	
	public List<DMVO> findAll2(){
		return DBManager.listDM2();
	}
	
	public DMVO getDM(int dm_no) {
		return DBManager.getDM(dm_no);
	}
	
	public int insertDM(DMVO d) {
		return DBManager.insertDM(d);
	}
	
}
