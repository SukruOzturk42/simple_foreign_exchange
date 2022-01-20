/* dks20165 created on 20.01.2022 inside the package - com.openpayd.exchange.rest.dto.response */

package com.openpayd.exchange.rest.dto.response;

import com.openpayd.exchange.model.CurrencyExchange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionResponse {


	private double exchangeAmountResult;
	private String transactionId;

	public static CurrencyConversionResponse fromModel(CurrencyExchange currencyExchange){
		return CurrencyConversionResponse.builder()
				.exchangeAmountResult(currencyExchange.getExchangeAmountResult())
				.transactionId(currencyExchange.getTransactionId())
				.build();
	}
}
