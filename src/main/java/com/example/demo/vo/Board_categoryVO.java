package com.example.demo.vo;

public class Board_categoryVO {
	private int board_category_no;
	private String board_category_name;
	public int getBoard_category_no() {
		return board_category_no;
	}
	public void setBoard_category_no(int board_category_no) {
		this.board_category_no = board_category_no;
	}
	public String getBoard_category_name() {
		return board_category_name;
	}
	public void setBoard_category_name(String board_category_name) {
		this.board_category_name = board_category_name;
	}
	public Board_categoryVO(int board_category_no, String board_category_name) {
		super();
		this.board_category_no = board_category_no;
		this.board_category_name = board_category_name;
	}
	public Board_categoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
