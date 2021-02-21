package com.model;

public class DTO_monitor {


	private String model;
	private String company;
	private int inchi;
	private String hae;
	private String rate;
	private String hz;
	private String form;
	private String weight;
	private boolean blue;
	private String panel;
	private String color;
	private int price;
	private int cnt;
	
	public DTO_monitor(String model, String company, int inchi, String hae, String rate, String hz, String form,
			String weight, boolean blue, String panel, String color, int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.inchi = inchi;
		this.hae = hae;
		this.rate = rate;
		this.hz = hz;
		this.form = form;
		this.weight = weight;
		this.blue = blue;
		this.panel = panel;
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

	public int getInchi() {
		return inchi;
	}

	public String getHae() {
		return hae;
	}

	public String getRate() {
		return rate;
	}

	public String getHz() {
		return hz;
	}

	public String getForm() {
		return form;
	}

	public String getWeight() {
		return weight;
	}

	public boolean isBlue() {
		return blue;
	}

	public String getPanel() {
		return panel;
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
