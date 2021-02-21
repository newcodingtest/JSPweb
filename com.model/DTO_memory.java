package com.model;

public class DTO_memory {

	private String model;
	private String company;
	private String type;
	private String mem;
	private String clock;
	private int price;
	private int cnt;
	private String c_company;
	
	
	
	public DTO_memory(String model, String company, String type, String mem, String clock, int price, int cnt,
			String c_company) {
		super();
		this.model = model;
		this.company = company;
		this.type = type;
		this.mem = mem;
		this.clock = clock;
		this.price = price;
		this.cnt = cnt;
		this.c_company = c_company;
	}



	public String getModel() {
		return model;
	}
	public String getCompany() {
		return company;
	}
	public String getType() {
		return type;
	}
	public String getMem() {
		return mem;
	}
	public String getClock() {
		return clock;
	}
	public int getPrice() {
		return price;
	}
	public int getCnt() {
		return cnt;
	}
	public String getC_company() {
		return c_company;
	}
	
	
	
	
	
	
}
