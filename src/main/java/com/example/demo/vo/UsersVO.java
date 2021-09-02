package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UsersVO {
	private int users_no;
	private String users_id;
	private String users_pw;
	private String users_email;
	private String users_nickname;
	private String users_birth;
	private int users_gender;
	private int users_height;
	private int users_weight;
	private int users_jointype;
	private String users_grant;
	private String users_fname;
	private int users_fsize;
	private MultipartFile uploadFile;
	public UsersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersVO(int users_no, String users_id, String users_pw, String users_email, String users_nickname,
			String users_birth, int users_gender, int users_height, int users_weight, int users_jointype,
			String users_grant, String users_fname, int users_fsize) {
		super();
		this.users_no = users_no;
		this.users_id = users_id;
		this.users_pw = users_pw;
		this.users_email = users_email;
		this.users_nickname = users_nickname;
		this.users_birth = users_birth;
		this.users_gender = users_gender;
		this.users_height = users_height;
		this.users_weight = users_weight;
		this.users_jointype = users_jointype;
		this.users_grant = users_grant;
		this.users_fname = users_fname;
		this.users_fsize = users_fsize;
	}
	public int getUsers_no() {
		return users_no;
	}
	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public String getUsers_pw() {
		return users_pw;
	}
	public void setUsers_pw(String users_pw) {
		this.users_pw = users_pw;
	}
	public String getUsers_email() {
		return users_email;
	}
	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}
	public String getUsers_nickname() {
		return users_nickname;
	}
	public void setUsers_nickname(String users_nickname) {
		this.users_nickname = users_nickname;
	}
	public String getUsers_birth() {
		return users_birth;
	}
	public void setUsers_birth(String users_birth) {
		this.users_birth = users_birth;
	}
	public int getUsers_gender() {
		return users_gender;
	}
	public void setUsers_gender(int users_gender) {
		this.users_gender = users_gender;
	}
	public int getUsers_height() {
		return users_height;
	}
	public void setUsers_height(int users_height) {
		this.users_height = users_height;
	}
	public int getUsers_weight() {
		return users_weight;
	}
	public void setUsers_weight(int users_weight) {
		this.users_weight = users_weight;
	}
	public int getUsers_jointype() {
		return users_jointype;
	}
	public void setUsers_jointype(int users_jointype) {
		this.users_jointype = users_jointype;
	}
	public String getUsers_grant() {
		return users_grant;
	}
	public void setUsers_grant(String users_grant) {
		this.users_grant = users_grant;
	}
	public String getUsers_fname() {
		return users_fname;
	}
	public void setUsers_fname(String users_fname) {
		this.users_fname = users_fname;
	}
	public int getUsers_fsize() {
		return users_fsize;
	}
	public void setUsers_fsize(int users_fsize) {
		this.users_fsize = users_fsize;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "UsersVO [users_no=" + users_no + ", users_id=" + users_id + ", users_pw=" + users_pw + ", users_email="
				+ users_email + ", users_nickname=" + users_nickname + ", users_birth=" + users_birth
				+ ", users_gender=" + users_gender + ", users_height=" + users_height + ", users_weight=" + users_weight
				+ ", users_jointype=" + users_jointype + ", users_grant=" + users_grant + ", users_fname=" + users_fname
				+ ", users_fsize=" + users_fsize + ", uploadFile=" + uploadFile + "]";
	}
	
}
