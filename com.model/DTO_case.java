package com.model;

public class DTO_case {

	
	private String model;
	private String company;
	private String sized;
	private String max;
	private String pane_cnt;
	private int price;
	private int cnt;
	
	
	
	public DTO_case(String model, String company, String sized, String max, String pane_cnt, int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.sized = sized;
		this.max = max;
		this.pane_cnt = pane_cnt;
		this.price = price;
		this.cnt = cnt;
	}



	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	public String getSized() {
		return sized;
	}

	public String getMax() {
		return max;
	}

	public String getPane_cnt() {
		return pane_cnt;
	}

	public int getPrice() {
		return price;
	}

	public int getCnt() {
		return cnt;
	}
	

	
	
	
}
