package com.example.demo.vo;

public class LooklikeVO {
	private int like_no;
	private int users_no;
	private int lookbook_no;
	
	
	public LooklikeVO(int like_no, int users_no, int lookbook_no) {
		super();
		this.like_no = like_no;
		this.users_no = users_no;
		this.lookbook_no = lookbook_no;
	}
	public LooklikeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public int getUsers_no() {
		return users_no;
	}
	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}
	public int getLookbook_no() {
		return lookbook_no;
	}
	public void setLookbook_no(int lookbook_no) {
		this.lookbook_no = lookbook_no;
	}
	
	
	@Override
	public String toString() {
		return "LooklikeVO [like_no=" + like_no + ", users_no=" + users_no + ", lookbook_no=" + lookbook_no + "]";
	}
	
}
