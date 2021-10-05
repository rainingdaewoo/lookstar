package com.example.demo.vo;

import java.util.List;

public class SelectLookbookCommandVO {
	private LookbookVO lookbook;
	private UsersVO users;
	private List<LookInfoVO> list_info;
	private List<Lookbook_styleVO> list_style;
	public LookbookVO getLookbook() {
		return lookbook;
	}
	public void setLookbook(LookbookVO lookbook) {
		this.lookbook = lookbook;
	}
	public UsersVO getUsers() {
		return users;
	}
	public void setUsers(UsersVO users) {
		this.users = users;
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
	public SelectLookbookCommandVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectLookbookCommandVO(LookbookVO lookbook, UsersVO users, List<LookInfoVO> list_info,
			List<Lookbook_styleVO> list_style) {
		super();
		this.lookbook = lookbook;
		this.users = users;
		this.list_info = list_info;
		this.list_style = list_style;
	}
	@Override
	public String toString() {
		return "SelectLookbookCommandVO [lookbook=" + lookbook + ", users=" + users + ", list_info=" + list_info
				+ ", list_style=" + list_style + "]";
	}
	
}
