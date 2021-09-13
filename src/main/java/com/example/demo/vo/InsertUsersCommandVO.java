package com.example.demo.vo;

import java.util.List;

public class InsertUsersCommandVO {
	private UsersVO users;
	private List<Integer> style_no;
	public InsertUsersCommandVO(UsersVO users, List<Integer> style_no) {
		super();
		this.users = users;
		this.style_no = style_no;
	}
	public InsertUsersCommandVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersVO getUsers() {
		return users;
	}
	public void setUsers(UsersVO users) {
		this.users = users;
	}
	public List<Integer> getStyle_no() {
		return style_no;
	}
	public void setStyle_no(List<Integer> style_no) {
		this.style_no = style_no;
	}
	@Override
	public String toString() {
		return "InsertUsersCommandVO [users=" + users + ", style_no=" + style_no + "]";
	}
	
	
}
