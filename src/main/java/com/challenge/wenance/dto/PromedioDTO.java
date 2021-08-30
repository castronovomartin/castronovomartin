package com.challenge.wenance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PromedioDTO {

	private Double promedio;
	private Double diferenciaPorcentual;

}
