package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.UsersVO;

@Repository
public class UsersDao {
	public int insert(UsersVO u) {
		System.out.println("Dao 동작함" + u);
		return DBManager.insertUsers(u);
	}
	
	public UsersVO getUsers(String username) {
		return DBManager.getUsers(username);
	}
	public UsersVO getUsers(int users_no) {
		return DBManager.getUsers(users_no);
	}
	//users
	public int update(UsersVO u) {
		return DBManager.updateInfo(u);
	}
	
	public int delete(int users_no,String users_pw) {
		return DBManager.deleteUser(users_no, users_pw);
	}
	
}
