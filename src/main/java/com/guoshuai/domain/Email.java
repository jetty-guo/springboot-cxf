package com.guoshuai.domain;

public class Email implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3200182538592207431L;
	private String to;
	private String body;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public Email() {
	}
	
	
	public Email(String to, String body) {
		this.to = to;
		this.body = body;
	}
	@Override
	public String toString() {
		return "Email [to=" + to + ", body=" + body + "]";
	}

	
	
}
