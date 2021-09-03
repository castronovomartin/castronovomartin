package com.challenge.wenance.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.challenge.wenance.service.BitcoinService;

import lombok.extern.slf4j.Slf4j;

@Component("taskComponent")
@Slf4j
public class TaksComponent {

	@Autowired
	@Qualifier("bitcoinServiceImpl")
	private BitcoinService bitcoinService;

	@Scheduled(fixedDelay = 10000)
	public void doTask() {
		log.info("Se procede a obtener el precio del bitcoin");
		bitcoinService.getBitcoin();
	}

}
