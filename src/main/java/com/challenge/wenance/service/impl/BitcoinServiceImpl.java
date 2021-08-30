package com.challenge.wenance.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.challenge.wenance.dto.BitcoinDTO;
import com.challenge.wenance.dto.PromedioDTO;
import com.challenge.wenance.service.BitcoinService;

import reactor.core.publisher.Mono;

@Service
public class BitcoinServiceImpl implements BitcoinService {

	public static final String URL = "https://cex.io/api/last_price/BTC/USD";
	public String value = "";
	List<BitcoinDTO> listBitCointDTO = new ArrayList<>();
	String maxPrice = null;

	@Autowired
	WebClient client;

	@Override
	public void getBitcoin() {
		// Consulta la api para obtener el valor del bitcoint a traves de webclient
		Mono<String> bitcoinDTO = client.get().uri(URL).retrieve().bodyToMono(String.class);
		bitcoinDTO.subscribe(dto -> value = dto.toString());
		// Formatea y setea el valor actual del precio
		String price = formatPrice();
		// Obtiene el timestamp actual
		Timestamp times = new Timestamp(System.currentTimeMillis());
		// Arma una lista en memoria con todas las consultas
		listBitCointDTO.add(BitcoinDTO.builder().price(price).time(times).build());
		// Actualiza el valor mínimo y máximo obtenido hasta el momento
		updateMaxPrice(price);
		// Muestra en consola el valor y tiempo de la consulta actual
		System.out.println("En el tiempo: " + times + ", se obtuvo un precio de: " + price);
	}

	private String formatPrice() {
		String priceUpdate = value.substring(11, 18);
		if (priceUpdate.contains(",")) {
			String[] parts = priceUpdate.split(",");
			String part1 = parts[0];
			return part1.substring(0, part1.length() - 1);
		} else {
			return priceUpdate;
		}
	}

	private void updateMaxPrice(String price) {
		if (maxPrice == null || Double.parseDouble(price) > Double.parseDouble(maxPrice)) {
			maxPrice = price;
		}
	}

	@Override
	public PromedioDTO getPromedio(Timestamp desde, Timestamp hasta) {
		BitcoinDTO desdeDTO = null;
		BitcoinDTO hastaDTO = null;
		for (BitcoinDTO dto : listBitCointDTO) {
			if (dto.getTime().equals(desde)) {
				desdeDTO = dto;
			}
			if (dto.getTime().equals(hasta)) {
				hastaDTO = dto;
			}
		}
		Double promedio = (Double.parseDouble(desdeDTO.getPrice()) + Double.parseDouble(hastaDTO.getPrice())) / 2;
//		System.out.println("EL PROMEDIO DE TIMESTAMP ES: " + promedio);
		Double diferenciaPorcentual = (Double.parseDouble(maxPrice) - promedio) - 1;
//		System.out.println("LA DIFERENCIA PORCENTUAL ES: " + diferenciaPorcentual);
		return PromedioDTO.builder().promedio(promedio).diferenciaPorcentual(diferenciaPorcentual).build();
	}

}
