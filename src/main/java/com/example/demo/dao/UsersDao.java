package com.example.demo.dao;


import java.util.HashMap;
import java.util.Map;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.InsertUsersCommandVO;
import com.example.demo.vo.UsersVO;
import com.example.demo.vo.Users_outVO;
import com.example.demo.vo.FollowVO;
import com.example.demo.vo.UpdateUsersCommandVO;

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
	
	
	public UsersVO getUser(int users_no) {
		return DBManager.getUser(users_no);
	}
	
	//users
	
	
	public int updateUsersDel(int users_no) {
		return DBManager.updateUsersDel(users_no);
	}
	
	public int updateProfile(UsersVO u) {
		return DBManager.updateProfile(u);
	}
	
	public int updateUsers(UpdateUsersCommandVO usersc) {
		System.out.println("users: " + usersc.getUsers());
		System.out.println("users_like_style: " + usersc.getStyle_no());
		return DBManager.updateUsersWithStyle(usersc);
	}
	
	public List<UsersVO> listFollow(String users_id){
		return DBManager.listFollw(users_id);
	}
	
	public int insertUsers_out(Users_outVO uo) {
		return DBManager.insertUsers_out(uo);
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
