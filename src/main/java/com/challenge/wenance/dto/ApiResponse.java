package com.challenge.wenance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse {

	private String lprice;
	private String curr1;
	private String curr2;

}
