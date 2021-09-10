package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReplyVO {
	private int reply_no;
	private int board_no;
	private int users_no;
	private int comments_no;
	private String users_nickname;
	private String reply_content;
	private Date reply_date;
	private int reply_show;
	private String reply_fname;
	private int reply_fsize;
	private MultipartFile reply_uploadFile;
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
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
	public int getComments_no() {
		return comments_no;
	}
	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}
	public String getUsers_nickname() {
		return users_nickname;
	}
	public void setUsers_nickname(String users_nickname) {
		this.users_nickname = users_nickname;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public int getReply_show() {
		return reply_show;
	}
	public void setReply_show(int reply_show) {
		this.reply_show = reply_show;
	}
	public String getReply_fname() {
		return reply_fname;
	}
	public void setReply_fname(String reply_fname) {
		this.reply_fname = reply_fname;
	}
	public int getReply_fsize() {
		return reply_fsize;
	}
	public void setReply_fsize(int reply_fsize) {
		this.reply_fsize = reply_fsize;
	}
	public MultipartFile getReply_uploadFile() {
		return reply_uploadFile;
	}
	public void setReply_uploadFile(MultipartFile reply_uploadFile) {
		this.reply_uploadFile = reply_uploadFile;
	}
	public ReplyVO(int reply_no, int board_no, int users_no, int comments_no, String users_nickname,
			String reply_content, Date reply_date, int reply_show, String reply_fname, int reply_fsize,
			MultipartFile reply_uploadFile) {
		super();
		this.reply_no = reply_no;
		this.board_no = board_no;
		this.users_no = users_no;
		this.comments_no = comments_no;
		this.users_nickname = users_nickname;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.reply_show = reply_show;
		this.reply_fname = reply_fname;
		this.reply_fsize = reply_fsize;
		this.reply_uploadFile = reply_uploadFile;
	}
	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
