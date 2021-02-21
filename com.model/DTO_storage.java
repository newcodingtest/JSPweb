package com.model;

public class DTO_storage {

	
	private String model;
	private String company;
	private String form;
	private String interfaced;
	private String mem;
	private String type;
	private int price;
	private int cnt;
	private String kind;
	
	
	public DTO_storage(String model, String company, String form, String interfaced, String mem, String type, int price,
			int cnt, String kind) {
		super();
		this.model = model;
		this.company = company;
		this.form = form;
		this.interfaced = interfaced;
		this.mem = mem;
		this.type = type;
		this.price = price;
		this.cnt = cnt;
		this.kind = kind;
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

	public String getInterfaced() {
		return interfaced;
	}

	public String getMem() {
		return mem;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	public int getCnt() {
		return cnt;
	}

	public String getKind() {
		return kind;
	}
	
	
	
	
	
	
}
