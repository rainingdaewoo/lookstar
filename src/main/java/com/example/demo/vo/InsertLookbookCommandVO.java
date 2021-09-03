package com.example.demo.vo;

import java.util.List;

public class InsertLookbookCommandVO {
	private LookbookVO lookbook;
	private List<LookInfoVO> list_info;
	// list_info["+id+"].category
	private List<Integer> style_no;
	public InsertLookbookCommandVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsertLookbookCommandVO(LookbookVO lookbook, List<LookInfoVO> list_info, List<Integer> style_no) {
		super();
		this.lookbook = lookbook;
		this.list_info = list_info;
		this.style_no = style_no;
	}
	
	@Override
	public String toString() {
		return "InsertLookbookCommandVO [lookbook=" + lookbook + ", list_info=" + list_info + ", style_no=" + style_no
				+ "]";
	}
	public LookbookVO getLookbook() {
		return lookbook;
	}
	public void setLookbook(LookbookVO lookbook) {
		this.lookbook = lookbook;
	}
	public List<LookInfoVO> getList_info() {
		return list_info;
	}
	public void setList_info(List<LookInfoVO> list_info) {
		this.list_info = list_info;
	}
	public List<Integer> getStyle_no() {
		return style_no;
	}
	public void setStyle_no(List<Integer> style_no) {
		this.style_no = style_no;
	}
	
	
}
