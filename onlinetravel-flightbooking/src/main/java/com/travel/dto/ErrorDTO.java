package com.travel.dto;

import org.springframework.stereotype.Component;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ErrorDTO {
	private String errorMsg;
}
