package com.example.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.InsertUsersCommandVO;
import com.example.demo.vo.UsersVO;

@Repository
public class UsersDao {
	/*public int insert(UsersVO u) {
		System.out.println("Dao 동작함" + u);
		return DBManager.insertUsers(u);
	}*/
	public int insert(InsertUsersCommandVO usersc) {
		System.out.println("---- Dao의 결과 ----");
		System.out.println("users: " + usersc.getUsers());
		System.out.println("users_like_style: " + usersc.getStyle_no());
		System.out.println("-----------------");
		return DBManager.insertUsersWithStyle(usersc);
	}
	
	public UsersVO getUsers(String username) {
		return DBManager.getUsers(username);
	}
	public UsersVO getUsers(int users_no) {
		return DBManager.getUsers(users_no);
	}
	
	//가연
	public UsersVO getUsersByNickname(String users_nickname) {
		return DBManager.getUsersByNickname(users_nickname);
	}
	
	//users
	public int update(UsersVO u) {
		return DBManager.updateInfo(u);
	}
	
	public int delete(int users_no,String users_pw) {
		return DBManager.deleteUser(users_no, users_pw);
	}
	
	public String findID(String users_email) {
		return DBManager.findID(users_email);
	}
	
	public String findPW(String users_id,String users_email) {
		return DBManager.findPW(users_id, users_email);
	}
	public int updatePW(String code, String users_id,String users_email) {
		return DBManager.updatePW(code,users_id,users_email);
	}
	public String compareID(String compare_id) {
		return DBManager.compareID(compare_id);
	}
	
	public String compareNickname(String compare_nickname) {
		return DBManager.compareNickname(compare_nickname);
	}
	
	
}
