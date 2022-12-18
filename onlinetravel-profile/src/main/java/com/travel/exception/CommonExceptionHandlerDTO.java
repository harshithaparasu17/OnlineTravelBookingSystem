package com.travel.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandlerDTO {
	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> vvhjfhj(javax.persistence.EntityNotFoundException e) {

		System.out.println(" ------------- inside --- @Controller Advice Not Found Exception ----");

		AllExceptionDTO dto = new AllExceptionDTO();

		dto.setMsg(e.getLocalizedMessage());
		dto.setUserInput(e.getLocalizedMessage().toString());
		dto.setDateAndTime(LocalDateTime.now().toString());

		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> dfksdd(javax.persistence.NoResultException d) {
		System.out.println(" ------------- inside --- @Controller Advice Not Result Exception ----");

		AllExceptionDTO dto = new AllExceptionDTO();

		dto.setMsg(d.getLocalizedMessage());
		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.SERVICE_UNAVAILABLE);
	}


}
