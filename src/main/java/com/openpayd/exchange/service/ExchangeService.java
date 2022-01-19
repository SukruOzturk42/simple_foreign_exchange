/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange */

package com.openpayd.exchange.service;

import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.port.ExchangeExternalApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService {

	private final ExchangeExternalApiPort exchangeExternalApiPort;

	public CurrencyExchange getExchangeRate(String baseCurrency,String targetCurrency){

		var currencyExchange=CurrencyExchange.builder()
											 .sourceCurrency(baseCurrency)
											 .targetCurrency(targetCurrency)
											 .amount(1.0)
				                             .build();
        return exchangeExternalApiPort.currencyExchangeResult(currencyExchange);

	}

	private CurrencyExchange getExchangeRate(String source,String targetCurrency,double amount){

		var currencyExchange=CurrencyExchange.builder()
				.sourceCurrency(source)
				.targetCurrency(targetCurrency)
				.amount(amount)
				.build();
		return exchangeExternalApiPort.currencyExchangeResult(currencyExchange);

	}


}
