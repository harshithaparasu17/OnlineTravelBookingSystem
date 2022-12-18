package com.travel.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllExceptionDTO {
	private String msg;
	private String userInput;
	private String dateAndTime;	
}
