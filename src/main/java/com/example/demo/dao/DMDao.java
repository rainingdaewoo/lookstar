package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DMVO;


@Repository
public class DMDao {
	
	public List<DMVO> findAll2(HashMap map){
		return DBManager.listDM(map);
	}
	
	
	public int insertDM(DMVO d) {
		return DBManager.insertDM(d);
	}
	
	
	public List<DMVO> iconListPeople(String users_id) {
		return DBManager.iconListPeople(users_id);
	}
	
	
	public List<DMVO> findAll3(String room_no){
		return DBManager.iconListDM(room_no);
	}

	/*
	//안씀
	public List<DMVO> findAll(String users_nickname){
		return DBManager.listPeople(users_nickname);
	}
	
	public DMVO getDM(int dm_no) {
		return DBManager.getDM(dm_no);
	}
	*/
}