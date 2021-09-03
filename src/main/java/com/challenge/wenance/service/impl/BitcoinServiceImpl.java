package com.challenge.wenance.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.challenge.wenance.dto.ApiResponse;
import com.challenge.wenance.dto.BitcoinDTO;
import com.challenge.wenance.dto.PromedioDTO;
import com.challenge.wenance.service.BitcoinService;
import com.challenge.wenance.utils.Constant;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Service("bitcoinServiceImpl")
@Slf4j
public class BitcoinServiceImpl implements BitcoinService {

	List<BitcoinDTO> listBitcoinDTO = new ArrayList<>();
	String maxPrice = "0";

	@Autowired
	WebClient client;

	final Gson gson = new Gson();

	@Override
	public void getBitcoin() {
		log.info("Procede a obtener el valor del bitcoin");
		String price = gson
				.fromJson(client.get().uri(Constant.URL).retrieve().bodyToMono(String.class).block(), ApiResponse.class)
				.getLprice();
		Timestamp times = new Timestamp(System.currentTimeMillis());
		listBitcoinDTO.add(BitcoinDTO.builder().price(price).time(times).build());
		updateMaxPrice(price);
		log.info("TIMESTAMP: " + times + " - BITCOIN: " + price);
	}

	private void updateMaxPrice(String price) {
		if (Double.parseDouble(price) > Double.parseDouble(maxPrice)) {
			maxPrice = price;
		}
	}

	@Override
	public PromedioDTO getPromedio(Timestamp desde, Timestamp hasta) {
		log.info("Se obtienen los valores del bitcoin en los momentos indicados");
		log.info("Se procede a calcular el promedio y la diferencia porcentual");
		Double promedio = (Double.parseDouble(getBitcoinDTO(desde).getPrice())
				+ Double.parseDouble(getBitcoinDTO(hasta).getPrice())) / 2;
		Double diferenciaPorcentual = (Double.parseDouble(maxPrice) - promedio) - 1;
		return PromedioDTO.builder().promedio(promedio).diferenciaPorcentual(diferenciaPorcentual).build();
	}

	private BitcoinDTO getBitcoinDTO(Timestamp desdeHasta) {
		return listBitcoinDTO.stream().filter(b -> b.getTime().equals(desdeHasta)).collect(Collectors.toList()).get(0);
	}

}
