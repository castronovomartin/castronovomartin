package com.challenge.wenance.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.wenance.dto.PromedioDTO;
import com.challenge.wenance.service.BitcoinService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bitcoin")
@Slf4j
public class BitcoinController {

	@Autowired
	private BitcoinService bitcoinService;

	@GetMapping
	public void getBitcoin() {
		log.info("Se procede a consultar el valor del bitcoin");
		bitcoinService.getBitcoin();
	}

	@GetMapping("/promedio")
	public PromedioDTO getPromedio(Timestamp desde, Timestamp hasta) {
		log.info("Se procede a calcular el promedio y variación porcentual");
		return bitcoinService.getPromedio(desde, hasta);
	}

}
