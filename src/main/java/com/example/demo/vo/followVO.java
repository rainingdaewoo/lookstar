package com.example.demo.vo;

public class followVO {
	private int follow_no;
	private String follower_id;
	private String following_id;
	public int getFollow_no() {
		return follow_no;
	}
	public void setFollow_no(int follow_no) {
		this.follow_no = follow_no;
	}
	public String getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}
	public String getFollowing_id() {
		return following_id;
	}
	public void setFollowing_id(String following_id) {
		this.following_id = following_id;
	}
	public followVO(int follow_no, String follower_id, String following_id) {
		super();
		this.follow_no = follow_no;
		this.follower_id = follower_id;
		this.following_id = following_id;
	}
	public followVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
