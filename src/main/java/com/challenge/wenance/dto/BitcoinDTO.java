package com.challenge.wenance.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BitcoinDTO {
	
	private String price;
	private Timestamp time;

}
