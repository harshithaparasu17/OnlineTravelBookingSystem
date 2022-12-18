package com.travel.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> abcdf(javax.persistence.EntityNotFoundException e) {
		System.out.println(" ------------- inside --- @Controller Advice Not Found Exception ----");
		AllExceptionDTO dto = new AllExceptionDTO();
		dto.setMessage(e.getLocalizedMessage());
		dto.setDateAndTime(LocalDateTime.now().toString());

		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> abcd(javax.persistence.NoResultException d) {
		System.out.println(" ------------- inside --- @Controller Advice Not Result Exception ----");

		AllExceptionDTO dto = new AllExceptionDTO();

		dto.setMessage(d.getLocalizedMessage());
		dto.setDateAndTime(LocalDateTime.now().toString());

		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.SERVICE_UNAVAILABLE);
	}
	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> abc(javax.persistence.QueryTimeoutException q) {
		System.out.println("--------------inside @Controller Advice Query time out exception");
		AllExceptionDTO dto = new AllExceptionDTO();
		dto.setMessage(q.getLocalizedMessage());
		dto.setDateAndTime(LocalDateTime.now().toString());

		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.TOO_MANY_REQUESTS);
	}

}
