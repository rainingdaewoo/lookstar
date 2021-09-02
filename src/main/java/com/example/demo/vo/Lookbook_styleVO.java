package com.example.demo.vo;

public class Lookbook_styleVO {
	private int lookbook_no;
	private int style_no;
	
	
	public Lookbook_styleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lookbook_styleVO(int lookbook_no, int style_no) {
		super();
		this.lookbook_no = lookbook_no;
		this.style_no = style_no;
	}
	public int getLookbook_no() {
		return lookbook_no;
	}
	public void setLookbook_no(int lookbook_no) {
		this.lookbook_no = lookbook_no;
	}
	public int getStyle_no() {
		return style_no;
	}
	public void setStyle_no(int style_no) {
		this.style_no = style_no;
	}
	@Override
	public String toString() {
		return "Lookbook_styleVO [lookbook_no=" + lookbook_no + ", style_no=" + style_no + "]";
	}
	
	
}
