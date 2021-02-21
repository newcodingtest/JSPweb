package com.model;

public class DTO_power {

	
	private String model;
	private String company;
	private String form;
	private String output;
	private String authen;
	private String gurantee;
	private int price;
	private int cnt;
	
	
	public DTO_power(String model, String company, String form, String output, String authen, String gurantee,
			int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.form = form;
		this.output = output;
		this.authen = authen;
		this.gurantee= gurantee;
		this.price = price;
		this.cnt = cnt;
	}


	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	public String getForm() {
		return form;
	}

	public String getOutput() {
		return output;
	}

	public String getAuthen() {
		return authen;
	}

	public String getGurantee() {
		return gurantee;
	}

	public int getPrice() {
		return price;
	}

	public int getCnt() {
		return cnt;
	}
	
	
	
	
	
}
