/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange */

package com.openpayd.exchange.service;

import com.openpayd.exchange.aspect.ExchangeTransactionRecordCreator;
import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.model.PageContent;
import com.openpayd.exchange.model.CurrencyExchangeTransactionCriteria;
import com.openpayd.exchange.port.CurrencyExchangeTransactionPort;
import com.openpayd.exchange.port.ExchangeExternalApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService {

	private final ExchangeExternalApiPort exchangeExternalApiPort;

	private final CurrencyExchangeTransactionPort currencyExchangeTransactionPort;


	public CurrencyExchange getCurrencyExchangeAmountAsOne(String sourceCurrency,String targetCurrency){

		var currencyExchange=CurrencyExchange.builder()
											 .sourceCurrency(sourceCurrency)
											 .targetCurrency(targetCurrency)
											 .amount(1.0)
				                             .build();
        return exchangeExternalApiPort.currencyExchangeResult(currencyExchange);

	}

	@ExchangeTransactionRecordCreator
	public CurrencyExchange getCurrencyExchange(String source,String targetCurrency,double amount){

		var currencyExchange=CurrencyExchange.builder()
				.sourceCurrency(source)
				.targetCurrency(targetCurrency)
				.amount(amount)
				.build();
		return exchangeExternalApiPort.currencyExchangeResult(currencyExchange);

	}

	public PageContent<CurrencyExchange> getCurrencyTransactionHistory(
			CurrencyExchangeTransactionCriteria currencyExchangeTransactionCriteria, Pageable pageable){
		
		return currencyExchangeTransactionPort.getCurrencyExchangeTransactions(currencyExchangeTransactionCriteria,pageable);
	}


}
