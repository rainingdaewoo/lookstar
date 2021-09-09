package com.example.demo.vo;

import java.util.List;

public class UpdateUsersCommandVO {
	private UsersVO users;
	private List<Integer> style_no;
	
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
	public UpdateUsersCommandVO(UsersVO users, List<Integer> style_no) {
		super();
		this.users = users;
		this.style_no = style_no;
	}
	public UpdateUsersCommandVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UpdateUsersCommandVO [users=" + users + ", style_no=" + style_no + "]";
	}
	
	
}
