package com.example.demo.vo;

public class ChatVO {
	int dm_no;
	//수신자 아이디
	String from_id;
	//발신자 아이디
	String to_id;
	String dm_content;
	String dm_date;

	public int getDm_no() {
		return dm_no;
	}
	public void setDm_no(int dm_no) {
		this.dm_no = dm_no;
	}
	public String getFrom_id() {
		return from_id;
	}
	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}
	public String getTo_id() {
		return to_id;
	}
	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}
	public String getDm_content() {
		return dm_content;
	}
	public void setDm_content(String dm_content) {
		this.dm_content = dm_content;
	}
	public String getDm_date() {
		return dm_date;
	}
	public void setDm_date(String dm_date) {
		this.dm_date = dm_date;
	}

	public ChatVO(int dm_no, String from_id, String to_id, String dm_content, String dm_date) {
		super();
		this.dm_no = dm_no;
		this.from_id = from_id;
		this.to_id = to_id;
		this.dm_content = dm_content;
		this.dm_date = dm_date;
	}

	public ChatVO() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
