package com.example.demo.vo;

public class Users_outVO {
	private int users_out_no;
	private String users_out_reason;
	
	
	public int getUsers_out_no() {
		return users_out_no;
	}
	public void setUsers_out_no(int users_out_no) {
		this.users_out_no = users_out_no;
	}
	public String getUsers_out_reason() {
		return users_out_reason;
	}
	public void setUsers_out_reason(String users_out_reason) {
		this.users_out_reason = users_out_reason;
	}
	public Users_outVO(int users_out_no, String users_out_reason) {
		super();
		this.users_out_no = users_out_no;
		this.users_out_reason = users_out_reason;
	}
	public Users_outVO() {
		super();
	}
}
