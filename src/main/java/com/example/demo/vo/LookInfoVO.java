package com.example.demo.vo;

public class LookInfoVO {
	private int lookinfo_no;
	private int lookbook_no;
	private String lookinfo_name;
	private String lookinfo_url;
	private int lookinfo_category;
	public LookInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LookInfoVO(int lookinfo_no, int lookbook_no, String lookinfo_name, String lookinfo_url,
			int lookinfo_category) {
		super();
		this.lookinfo_no = lookinfo_no;
		this.lookbook_no = lookbook_no;
		this.lookinfo_name = lookinfo_name;
		this.lookinfo_url = lookinfo_url;
		this.lookinfo_category = lookinfo_category;
	}
	public int getLookinfo_no() {
		return lookinfo_no;
	}
	public void setLookinfo_no(int lookinfo_no) {
		this.lookinfo_no = lookinfo_no;
	}
	public int getLookbook_no() {
		return lookbook_no;
	}
	public void setLookbook_no(int lookbook_no) {
		this.lookbook_no = lookbook_no;
	}
	public String getLookinfo_name() {
		return lookinfo_name;
	}
	public void setLookinfo_name(String lookinfo_name) {
		this.lookinfo_name = lookinfo_name;
	}
	public String getLookinfo_url() {
		return lookinfo_url;
	}
	public void setLookinfo_url(String lookinfo_url) {
		this.lookinfo_url = lookinfo_url;
	}
	public int getLookinfo_category() {
		return lookinfo_category;
	}
	public void setLookinfo_category(int lookinfo_category) {
		this.lookinfo_category = lookinfo_category;
	}
	@Override
	public String toString() {
		return "LookInfoVO [lookinfo_no=" + lookinfo_no + ", lookbook_no=" + lookbook_no + ", lookinfo_name="
				+ lookinfo_name + ", lookinfo_url=" + lookinfo_url + ", lookinfo_category=" + lookinfo_category + "]";
	}
	
	
}
