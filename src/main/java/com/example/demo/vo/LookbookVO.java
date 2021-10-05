package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class LookbookVO {
	private int lookbook_no;
	private int users_no;
	private String lookbook_write;
	private Date lookbook_date;
	private int lookbook_views;
	private int lookbook_show;
	private int lookbook_height;
	private int lookbook_weight;
	private String lookbook_fname;
	private int lookbook_fsize;
	private MultipartFile uploadFile;
	public LookbookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LookbookVO(int lookbook_no, int users_no, String lookbook_write, Date lookbook_date, int lookbook_views,
			int lookbook_show, int lookbook_height, int lookbook_weight, String lookbook_fname, int lookbook_fsize) {
		super();
		this.lookbook_no = lookbook_no;
		this.users_no = users_no;
		this.lookbook_write = lookbook_write;
		this.lookbook_date = lookbook_date;
		this.lookbook_views = lookbook_views;
		this.lookbook_show = lookbook_show;
		this.lookbook_height = lookbook_height;
		this.lookbook_weight = lookbook_weight;
		this.lookbook_fname = lookbook_fname;
		this.lookbook_fsize = lookbook_fsize;
	}
	public int getLookbook_no() {
		return lookbook_no;
	}
	public void setLookbook_no(int lookbook_no) {
		this.lookbook_no = lookbook_no;
	}
	public int getUsers_no() {
		return users_no;
	}
	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}
	public String getLookbook_write() {
		return lookbook_write;
	}
	public void setLookbook_write(String lookbook_write) {
		this.lookbook_write = lookbook_write;
	}
	public Date getLookbook_date() {
		return lookbook_date;
	}
	public void setLookbook_date(Date lookbook_date) {
		this.lookbook_date = lookbook_date;
	}
	public int getLookbook_views() {
		return lookbook_views;
	}
	public void setLookbook_views(int lookbook_views) {
		this.lookbook_views = lookbook_views;
	}
	public int getLookbook_show() {
		return lookbook_show;
	}
	public void setLookbook_show(int lookbook_show) {
		this.lookbook_show = lookbook_show;
	}
	public int getLookbook_height() {
		return lookbook_height;
	}
	public void setLookbook_height(int lookbook_height) {
		this.lookbook_height = lookbook_height;
	}
	public int getLookbook_weight() {
		return lookbook_weight;
	}
	public void setLookbook_weight(int lookbook_weight) {
		this.lookbook_weight = lookbook_weight;
	}
	public String getLookbook_fname() {
		return lookbook_fname;
	}
	public void setLookbook_fname(String lookbook_fname) {
		this.lookbook_fname = lookbook_fname;
	}
	public int getLookbook_fsize() {
		return lookbook_fsize;
	}
	public void setLookbook_fsize(int lookbook_fsize) {
		this.lookbook_fsize = lookbook_fsize;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "LookbookVO [lookbook_no=" + lookbook_no + ", users_no=" + users_no + ", lookbook_write="
				+ lookbook_write + ", lookbook_date=" + lookbook_date + ", lookbook_views=" + lookbook_views
				+ ", lookbook_show=" + lookbook_show + ", lookbook_height=" + lookbook_height + ", lookbook_weight="
				+ lookbook_weight + ", lookbook_fname=" + lookbook_fname + ", lookbook_fsize=" + lookbook_fsize
				+ ", uploadFile=" + uploadFile + "]";
	}
	
}
