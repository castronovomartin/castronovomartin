package com.challenge.wenance.service;

import java.sql.Timestamp;

import com.challenge.wenance.dto.PromedioDTO;

public interface BitcoinService {
	
	public void getBitcoin();
	
	public PromedioDTO getPromedio(Timestamp desde, Timestamp hasta);

}
