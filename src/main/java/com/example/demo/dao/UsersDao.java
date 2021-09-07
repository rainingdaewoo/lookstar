package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.UsersVO;
import com.example.demo.vo.Users_outVO;
import com.example.demo.vo.FollowVO;

@Repository
public class UsersDao {
	public int insert(UsersVO u) {
		System.out.println("Dao 동작함" + u);
		return DBManager.insertUsers(u);
	}
	
	public UsersVO getUsers(String username) {
		return DBManager.getUsers(username);
	}
	public UsersVO getUser(int users_no) {
		return DBManager.getUser(users_no);
	}
	//users
	public int update(UsersVO u) {
		return DBManager.updateInfo(u);
	}
	
	public int updateUsersDel(int users_no) {
		return DBManager.updateUsersDel(users_no);
	}
	
	public int updateProfile(UsersVO u) {
		return DBManager.updateProfile(u);
	}
	
	public List<UsersVO> listFollow(String users_id){
		return DBManager.listFollw(users_id);
	}
	
	public int insertUsers_out(Users_outVO uo) {
		return DBManager.insertUsers_out(uo);
	}
	
}
