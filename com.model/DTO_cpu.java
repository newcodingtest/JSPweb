package com.model;

public class DTO_cpu {

	private String model;
	private String company;
	private String socket;
	private String ac;
	private int core;
	private int thread;
	private String clock;
	private String clock_b;
	private String tdp;
	private String mp;
	private String vga;
	private String lineup;
	private int price;
	private int cnt;
	

	public DTO_cpu(String model, String company, String socket, String ac, int core, int thread, String clock,
			String clock_b, String tdp, String mp, String vga, String lineup, int price, int cnt) {
		super();
		this.model = model;
		this.company = company;
		this.socket = socket;
		this.ac = ac;
		this.core = core;
		this.thread = thread;
		this.clock = clock;
		this.clock_b = clock_b;
		this.tdp = tdp;
		this.mp = mp;
		this.vga = vga;
		this.lineup = lineup;
		this.price = price;
		this.cnt = cnt;
	}



	public DTO_cpu(String model) {
		
	}
	
	
	
	public DTO_cpu() {
		
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
	public String getAc() {
		return ac;
	}
	public int getCore() {
		return core;
	}
	public int getThread() {
		return thread;
	}
	public String getClock() {
		return clock;
	}
	public String getClock_b() {
		return clock_b;
	}
	public String getTdp() {
		return tdp;
	}
	public String getMp() {
		return mp;
	}
	public String getVga() {
		return vga;
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
	
	
	
	
}
