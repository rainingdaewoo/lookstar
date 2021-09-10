package com.example.demo.vo;

import java.sql.Timestamp;

public class DMVO {

	private int dm_no;
	private String from_nickname;
	private String to_nickname;
	private String dm_content;
	private String dm_date;

	
	public int getDm_no() {
		return dm_no;
	}
	public void setDm_no(int dm_no) {
		this.dm_no = dm_no;
	}
	public String getFrom_nickname() {
		return from_nickname;
	}
	public void setFrom_nickname(String from_nickname) {
		this.from_nickname = from_nickname;
	}
	public String getTo_nickname() {
		return to_nickname;
	}
	public void setTo_nickname(String to_nickname) {
		this.to_nickname = to_nickname;
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

	
	public DMVO(int dm_no, String from_nickname, String to_nickname, String dm_content, String dm_date) {
		super();
		this.dm_no = dm_no;
		this.from_nickname = from_nickname;
		this.to_nickname = to_nickname;
		this.dm_content = dm_content;
		this.dm_date = dm_date;
	}
	
	
	public DMVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "DMVO [dm_no=" + dm_no + ", from_nickname=" + from_nickname + ", to_nickname=" + to_nickname
				+ ", dm_content=" + dm_content + ", dm_date=" + dm_date + "]";
	}

}