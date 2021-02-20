package com.model;

public class MessageDTO {
	private int seq;
	private String kind;
	private String title;
	private String content;
	private String m_date;
	private String e_mail;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	@Override
	public String toString() {
		return "MessageDTO [seq=" + seq + ", kind=" + kind + ", title=" + title + ", content=" + content + ", m_date="
				+ m_date + ", e_mail=" + e_mail + "]";
	}
	

}
