/* dks20165 created on 21.01.2022 inside the package - com.openpayd.exchange */

package com.openpayd.exchange;

import com.openpayd.exchange.infrastructure.api.adapter.ExchangeExternalApiPortAdapter;
import com.openpayd.exchange.model.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RequiredArgsConstructor
public class CurrencyExchangeConversionTest {

    @Autowired
	private  ExchangeExternalApiPortAdapter exchangeExternalApiPortAdapter;


	@Test
	void conversionTest(){
		var currencyExchange= CurrencyExchange.builder()
				.amount(1.0)
				.sourceCurrency("USD")
				.targetCurrency("EUR")
				.rate(6.0)
				.build();
		var result=exchangeExternalApiPortAdapter.currencyExchangeResult(currencyExchange);
		Assertions.assertEquals(result.getExchangeAmountResult(),
				exchangeExternalApiPortAdapter.calculateConversionResult(currencyExchange.getRate(),currencyExchange.getAmount()) ,
				"result of conversion amount result should be equal amount multiply rate ");

	}

	@Test
	void conversionCalculationTest(){
		var currencyExchange= CurrencyExchange.builder()
				.amount(1.0)
				.sourceCurrency("USD")
				.targetCurrency("EUR")
				.rate(6.0)
				.build();
		var calculation=exchangeExternalApiPortAdapter.calculateConversionResult(currencyExchange.getRate(),currencyExchange.getAmount());
		Assertions.assertEquals(calculation, currencyExchange.getRate()*currencyExchange.getAmount(),
				"conversion amount result should be equal amount multiply rate ");

	}


}
