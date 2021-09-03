package com.example.demo.vo;

import java.util.List;

public class InsertLookbookCommandVO {
	private LookbookVO lookbook;
	private List<LookInfoVO> list_info;
	private List<Lookbook_styleVO> list_style;
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
	public List<Lookbook_styleVO> getList_style() {
		return list_style;
	}
	public void setList_style(List<Lookbook_styleVO> list_style) {
		this.list_style = list_style;
	}
	public InsertLookbookCommandVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsertLookbookCommandVO(LookbookVO lookbook, List<LookInfoVO> list_info, List<Lookbook_styleVO> list_style) {
		super();
		this.lookbook = lookbook;
		this.list_info = list_info;
		this.list_style = list_style;
	}
	
}
