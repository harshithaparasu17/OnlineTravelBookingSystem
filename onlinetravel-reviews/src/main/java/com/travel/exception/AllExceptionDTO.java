package com.travel.exception;

public class AllExceptionDTO {
	private String msg;

	public AllExceptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AllExceptionDTO(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "AllExceptionDTO [msg=" + msg + "]";
	}


}
