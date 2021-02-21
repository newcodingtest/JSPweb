package com.model;

public class DTO_cooler {

	private String model;
	private String company;
	private String ice;
	private String fan_size;
	private String hitcnt;
	private String tdp;
	private String radi_length;
	private String form;
	private String socket;
	private int noise;
	private int price;
	private int cnt;
	
	public DTO_cooler(String model, String company, String ice, String fan_size, String hitcnt, String tdp,
			String radi_length, String form, String socket, int noise, int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.ice = ice;
		this.fan_size = fan_size;
		this.hitcnt = hitcnt;
		this.tdp = tdp;
		this.radi_length = radi_length;
		this.form = form;
		this.socket = socket;
		this.noise = noise;
		this.price = price;
		this.cnt = cnt;
	}

	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	public String getIce() {
		return ice;
	}

	public String getFan_size() {
		return fan_size;
	}

	public String getHitcnt() {
		return hitcnt;
	}

	public String getTdp() {
		return tdp;
	}

	public String getRadi_length() {
		return radi_length;
	}

	public String getForm() {
		return form;
	}

	public String getSocket() {
		return socket;
	}

	public int getNoise() {
		return noise;
	}

	public int getPrice() {
		return price;
	}

	public int getCnt() {
		return cnt;
	}

	
	
	
	
}
