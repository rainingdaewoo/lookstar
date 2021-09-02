package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int board_no;
	private int board_category_no;
	private int users_no;
	private String users_nickname;
	private String board_title;
	private String  board_content;
	private Date board_date;
	private int board_show;
	private int board_views;
	private String board_fname;
	private int board_fsize;
	private MultipartFile board_uploadFile;
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getBoard_category_no() {
		return board_category_no;
	}
	public void setBoard_category_no(int board_category_no) {
		this.board_category_no = board_category_no;
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
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_show() {
		return board_show;
	}
	public void setBoard_show(int board_show) {
		this.board_show = board_show;
	}
	public int getBoard_views() {
		return board_views;
	}
	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}
	public String getBoard_fname() {
		return board_fname;
	}
	public void setBoard_fname(String board_fname) {
		this.board_fname = board_fname;
	}
	public int getBoard_fsize() {
		return board_fsize;
	}
	public void setBoard_fsize(int board_fsize) {
		this.board_fsize = board_fsize;
	}
	public MultipartFile getBoard_uploadFile() {
		return board_uploadFile;
	}
	public void setBoard_uploadFile(MultipartFile board_uploadFile) {
		this.board_uploadFile = board_uploadFile;
	}
	public BoardVO(int board_no, int board_category_no, int users_no, String users_nickname, String board_title,
			String board_content, Date board_date, int board_show, int board_views, String board_fname, int board_fsize,
			MultipartFile board_uploadFile) {
		super();
		this.board_no = board_no;
		this.board_category_no = board_category_no;
		this.users_no = users_no;
		this.users_nickname = users_nickname;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_show = board_show;
		this.board_views = board_views;
		this.board_fname = board_fname;
		this.board_fsize = board_fsize;
		this.board_uploadFile = board_uploadFile;
	}
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
