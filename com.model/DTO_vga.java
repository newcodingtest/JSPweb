package com.model;

public class DTO_vga {

	
private String model;
private String company;
private String chipname;
private String mem;
private String clock;
private String clock_b;
private String length;
private String chip_com;
private int price;
private int cnt;

public DTO_vga(String model, String company, String chipname, String mem, String clock, String clock_b, String length,
		String chip_com, int price, int cnt) {
	super();
	this.model = model;
	this.company = company;
	this.chipname = chipname;
	this.mem = mem;
	this.clock = clock;
	this.clock_b = clock_b;
	this.length = length;
	this.chip_com = chip_com;
	this.price = price;
	this.cnt = cnt;
}

public String getModel() {
	return model;
}

public String getCompany() {
	return company;
}

public String getChipname() {
	return chipname;
}

public String getMem() {
	return mem;
}

public String getClock() {
	return clock;
}

public String getClock_b() {
	return clock_b;
}

public String getLength() {
	return length;
}

public String getChip_com() {
	return chip_com;
}

public int getPrice() {
	return price;
}

public int getCnt() {
	return cnt;
}




}
