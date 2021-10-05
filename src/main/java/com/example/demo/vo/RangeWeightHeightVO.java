package com.example.demo.vo;

public class RangeWeightHeightVO {
	private String weight_low;
	private String weight_high;
	private String height_low;
	private String height_high;
	public RangeWeightHeightVO(String weight_low, String weight_high, String height_low, String height_high) {
		super();
		this.weight_low = weight_low;
		this.weight_high = weight_high;
		this.height_low = height_low;
		this.height_high = height_high;
	}
	public RangeWeightHeightVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getWeight_low() {
		return weight_low;
	}
	public void setWeight_low(String weight_low) {
		this.weight_low = weight_low;
	}
	public String getWeight_high() {
		return weight_high;
	}
	public void setWeight_high(String weight_high) {
		this.weight_high = weight_high;
	}
	public String getHeight_low() {
		return height_low;
	}
	public void setHeight_low(String height_low) {
		this.height_low = height_low;
	}
	public String getHeight_high() {
		return height_high;
	}
	public void setHeight_high(String height_high) {
		this.height_high = height_high;
	}
	@Override
	public String toString() {
		return "RangeWeightHeightVO [weight_low=" + weight_low + ", weight_high=" + weight_high + ", height_low="
				+ height_low + ", height_high=" + height_high + "]";
	}
	
	
	
}
