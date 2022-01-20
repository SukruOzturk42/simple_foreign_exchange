/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.infrastructure.api.adapter.dto */

package com.openpayd.exchange.infrastructure.api.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LatestApiResponse {

	private boolean success;
	private String result;
	private Map<String,Double> rates;
	private LocalDate date;
	private Long timestamp;
	private String base;
	private Error error;

	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Error{
		private String code;
		private String info;
	}
}
