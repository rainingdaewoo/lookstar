package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CommentsVO {
	private int comments_no;
	private int board_no;
	private int users_no;
	private String users_nickname;
	private String comments_content;
	private Date comments_date;
	private int comments_show;
	private String comments_fname;
	private int comments_fsize;
	private MultipartFile comments_uploadFile;
	
	public int getComments_no() {
		return comments_no;
	}
	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getUsers_no() {
		return users_no;
	}
	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}
	public String getUsers_nickname() {
		return users_nickname;
	}
	public void setUsers_nickname(String users_nickname) {
		this.users_nickname = users_nickname;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public Date getComments_date() {
		return comments_date;
	}
	public void setComments_date(Date comments_date) {
		this.comments_date = comments_date;
	}
	public int getComments_show() {
		return comments_show;
	}
	public void setComments_show(int comments_show) {
		this.comments_show = comments_show;
	}
	public String getComments_fname() {
		return comments_fname;
	}
	public void setComments_fname(String comments_fname) {
		this.comments_fname = comments_fname;
	}
	public int getComments_fsize() {
		return comments_fsize;
	}
	public void setComments_fsize(int comments_fsize) {
		this.comments_fsize = comments_fsize;
	}
	public MultipartFile getComments_uploadFile() {
		return comments_uploadFile;
	}
	public void setComments_uploadFile(MultipartFile comments_uploadFile) {
		this.comments_uploadFile = comments_uploadFile;
	}
	public CommentsVO(int comments_no, int board_no, int users_no, String users_nickname, String comments_content,
			Date comments_date, int comments_show, String comments_fname, int comments_fsize,
			MultipartFile comments_uploadFile) {
		super();
		this.comments_no = comments_no;
		this.board_no = board_no;
		this.users_no = users_no;
		this.users_nickname = users_nickname;
		this.comments_content = comments_content;
		this.comments_date = comments_date;
		this.comments_show = comments_show;
		this.comments_fname = comments_fname;
		this.comments_fsize = comments_fsize;
		this.comments_uploadFile = comments_uploadFile;
	}
	public CommentsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
