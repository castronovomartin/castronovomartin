package com.challenge.wenance.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.wenance.dto.PromedioDTO;
import com.challenge.wenance.service.BitcoinService;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinController {

	@Autowired
	private BitcoinService bitcoinService;

	@GetMapping
	public void getBitcoin() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10000);
						bitcoinService.getBitcoin();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hilo = new Thread(runnable);
		hilo.start();
		System.out.println("Comienzan los llamados recurrentes cada 10 segundos");
	}

	@GetMapping("/promedio")
	public PromedioDTO getPromedio(Timestamp desde, Timestamp hasta) {
		return bitcoinService.getPromedio(desde, hasta);
	}

}
