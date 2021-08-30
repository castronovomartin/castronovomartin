package com.challenge.wenance.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({ MockitoExtension.class })
class BitcoinDTOTest {

	@InjectMocks
	private BitcoinDTO bitcoinDTO;

	@BeforeEach
	public void setup() {
		bitcoinDTO = new BitcoinDTO("48765", new Timestamp(System.currentTimeMillis()));
	}

	@Test
	void testBuilder() throws Exception {
		BitcoinDTO dto = BitcoinDTO.builder().price("48765").time(new Timestamp(System.currentTimeMillis())).build();
		assertNotNull(dto);
	}

	@Test
	void testGetPrice() throws Exception {
		String price = bitcoinDTO.getPrice();
		assertEquals("48765", price);
	}

	@Test
	void testGetTime() throws Exception {
		Timestamp time = bitcoinDTO.getTime();
		assertNotNull(time);
	}

	@Test
	void testToString() throws Exception {
		String toString = bitcoinDTO.builder().toString();
		assertNotNull(toString);
	}

}
