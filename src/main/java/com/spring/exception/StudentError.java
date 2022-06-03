package com.spring.exception;

public class StudentError {
	
	private int statuscode;
	
	private String message;
	
	private long timestamp;

	public StudentError() {
		super();
	}

	public StudentError(int statuscode, String message, long timestamp) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	

}
