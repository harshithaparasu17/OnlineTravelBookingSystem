package com.travel.dto;


import org.springframework.stereotype.Component;


import lombok.Data;


@Data
@Component
public class ErrorDTO implements ProfileDTO {
	private String errorMsg;
	
	

	public ErrorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ErrorDTO [errorMsg=" + errorMsg + "]";
	}
	
	
}
