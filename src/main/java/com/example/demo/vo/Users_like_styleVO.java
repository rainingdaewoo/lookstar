package com.example.demo.vo;

public class Users_like_styleVO {
	private int users_like_style_no;
	private int users_no;
	private int style_no;
	public Users_like_styleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users_like_styleVO(int users_like_style_no, int users_no, int style_no) {
		super();
		this.users_like_style_no = users_like_style_no;
		this.users_no = users_no;
		this.style_no = style_no;
	}
	public int getUsers_like_style_no() {
		return users_like_style_no;
	}
	public void setUsers_like_style_no(int users_like_style_no) {
		this.users_like_style_no = users_like_style_no;
	}
	public int getUsers_no() {
		return users_no;
	}
	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}
	public int getStyle_no() {
		return style_no;
	}
	public void setStyle_no(int style_no) {
		this.style_no = style_no;
	}
	
	
}
