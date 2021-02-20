package com.model;

public class BoardDTO {
	
	private int comid;
	private String category;
	private String title;
	private String content;
	private String id;
	private String pw;
	private String comdate;
	private int visit;
	

	
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public String getComdate() {
		return comdate;
	}
	public void setComdate(String comdate) {
		this.comdate = comdate;
	}
	@Override
	public String toString() {
		return "BoardDTO [comid=" + comid + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", id=" + id + ", pw=" + pw + ", comdate=" + comdate + ", visit=" + visit + "]";
	}

	
	
}
