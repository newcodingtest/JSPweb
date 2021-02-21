package com.model;

public class DTO_keyboard {

	
	private String model;
	private String company;
	private String conn;
	private String select_s;
	private String s_company;
	private String k_switch;
	private String array;
	private String color;
	private int price;
	private int cnt;
	
	
	
	public DTO_keyboard(String model, String company, String conn, String select_s, String s_company, String k_switch, String array,
			String color, int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.conn = conn;
		this.select_s = select_s;
		this.s_company = s_company;
		this.k_switch = k_switch;
		this.array = array;
		this.color = color;
		this.price = price;
		this.cnt = cnt;
	}

	
	
	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	public String getConn() {
		return conn;
	}

	public String getSelect_s() {
		return select_s;
	}

	public String getS_company() {
		return s_company;
	}
	public String getK_switch() {
		return k_switch;
	}

	public String getArray() {
		return array;
	}

	public String getColor() {
		return color;
	}

	public int getPrice() {
		return price;
	}

	public int getCnt() {
		return cnt;
	}
	
	
	
	
}
