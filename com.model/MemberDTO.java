package com.model;

public class MemberDTO {
	private String email;
	private String pw;
	private String tel;
	private String address;
	private String name;
	private int seq;


	//회원가입시 사용되는
	public MemberDTO(String email, String pw,String name,String tel, String address) {
		super();
		
		this.email = email;
		this.name=name;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	public MemberDTO(int seq,String email, String pw,String name,String tel, String address) {
		super();
		this.seq=seq;
		this.email = email;
		this.name=name;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	
	//로그인시 사용되는 
	public MemberDTO(String email, String pw) {
		super();
		this.email = email;
		this.pw = pw;
		
	}
	
	public MemberDTO( String pw,String name,String tel, String address) {
		super();
		this.name=name;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", pw=" + pw + ", tel=" + tel + ", address=" + address + "]";
	}
	
	
}
