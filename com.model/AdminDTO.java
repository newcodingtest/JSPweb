package com.model;

public class AdminDTO {
	private int seq;
 private String id;
 private String pw;
 
public AdminDTO(String id, String pw) {
	
	this.id = id;
	this.pw = pw;
}

public int getSeq() {
	return seq;
}

public void setSeq(int seq) {
	this.seq = seq;
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

@Override
public String toString() {
	return "AdminDTO [seq=" + seq + ", id=" + id + ", pw=" + pw + "]";
}
 
 
}
