package com.example.demo.vo;

public class StyleVO {
	private int style_no;
	private String style_name;
	public StyleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StyleVO(int style_no, String style_name) {
		super();
		this.style_no = style_no;
		this.style_name = style_name;
	}
	public int getStyle_no() {
		return style_no;
	}
	public void setStyle_no(int style_no) {
		this.style_no = style_no;
	}
	public String getStyle_name() {
		return style_name;
	}
	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}
	
}
