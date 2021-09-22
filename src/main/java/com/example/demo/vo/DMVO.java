package com.example.demo.vo;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class DMVO {

	private String dm_no;
	private String room_no;
	private String from_id;
	private String to_id;
	private String dm_content;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime read_date;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime send_date;
	private int read_chk;
	
	
	private String to_profile;
	private String to_nickname;
	private String other_id;
	
	
	
	public String getOther_id() {
		return other_id;
	}
	public void setOther_id(String other_id) {
		this.other_id = other_id;
	}
	public String getDm_no() {
		return dm_no;
	}
	public void setDm_no(String dm_no) {
		this.dm_no = dm_no;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
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
	public LocalDateTime getRead_date() {
		return read_date;
	}
	public void setRead_date(LocalDateTime read_date) {
		this.read_date = read_date;
	}
	public LocalDateTime getSend_date() {
		return send_date;
	}
	public void setSend_date(LocalDateTime send_date) {
		this.send_date = send_date;
	}
	public int getRead_chk() {
		return read_chk;
	}
	public void setRead_chk(int read_chk) {
		this.read_chk = read_chk;
	}
	public String getTo_profile() {
		return to_profile;
	}
	public void setTo_profile(String to_profile) {
		this.to_profile = to_profile;
	}
	public String getTo_nickname() {
		return to_nickname;
	}
	public void setTo_nickname(String to_nickname) {
		this.to_nickname = to_nickname;
	}
	public DMVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DMVO(String dm_no, String room_no, String from_id, String to_id, String dm_content, LocalDateTime read_date,
			LocalDateTime send_date, int read_chk, String to_profile, String to_nickname, String other_id) {
		super();
		this.dm_no = dm_no;
		this.room_no = room_no;
		this.from_id = from_id;
		this.to_id = to_id;
		this.dm_content = dm_content;
		this.read_date = read_date;
		this.send_date = send_date;
		this.read_chk = read_chk;
		this.to_profile = to_profile;
		this.to_nickname = to_nickname;
		this.other_id = other_id;
	}
	@Override
	public String toString() {
		return "DMVO [dm_no=" + dm_no + ", room_no=" + room_no + ", from_id=" + from_id + ", to_id=" + to_id
				+ ", dm_content=" + dm_content + ", read_date=" + read_date + ", send_date=" + send_date + ", read_chk="
				+ read_chk + ", to_profile=" + to_profile + ", to_nickname=" + to_nickname + ", other_id=" + other_id
				+ "]";
	}
	
	
}