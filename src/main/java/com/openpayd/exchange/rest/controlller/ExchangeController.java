/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.rest.controlller */

package com.openpayd.exchange.rest.controlller;

import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.port.ExchangeExternalApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

	private final ExchangeExternalApiPort exchangeExternalApiPort;
	@GetMapping("currency-pair-rate")
	public CurrencyExchange getCurrenciesRate(@RequestParam String sourceCurrency,@RequestParam String targetCurrency) {
		return exchangeExternalApiPort.currencyExchangeResult(
				CurrencyExchange.builder()
						.sourceCurrency(sourceCurrency)
						.targetCurrency(targetCurrency)
						.amount(1.0).build());
	}
}
