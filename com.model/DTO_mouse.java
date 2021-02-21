package com.model;

public class DTO_mouse {


	private String model;
	private String company;
	private String conn;
	private int feel;
	private String sensor;
	private String color;
	private int price;
	private int cnt;
	
	
	public DTO_mouse(String model, String company, String conn, int feel, String sensor, String color, int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.conn = conn;
		this.feel = feel;
		this.sensor = sensor;
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

	public int getFeel() {
		return feel;
	}

	public String getSensor() {
		return sensor;
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
