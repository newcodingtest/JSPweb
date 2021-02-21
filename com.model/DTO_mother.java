package com.model;

public class DTO_mother {

	
	private String model;
	private String company;
	private String socket;
	private String chipset;
	private String form;
	private String type;
	private String lineup;
	private int price;
	private int cnt;
	private String c_company;
	
	
	public DTO_mother(String model, String company, String socket, String chipset, String form, String type,
			String lineup, int price, int cnt, String c_company) {
		super();
		this.model = model;
		this.company = company;
		this.socket = socket;
		this.chipset = chipset;
		this.form = form;
		this.type = type;
		this.lineup = lineup;
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


	public String getSocket() {
		return socket;
	}


	public String getChipset() {
		return chipset;
	}


	public String getForm() {
		return form;
	}


	public String getType() {
		return type;
	}


	public String getLineup() {
		return lineup;
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
