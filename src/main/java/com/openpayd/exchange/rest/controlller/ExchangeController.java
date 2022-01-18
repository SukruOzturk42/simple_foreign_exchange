/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.rest.controlller */

package com.openpayd.exchange.rest.controlller;

import com.openpayd.exchange.model.ExchangeConversion;
import com.openpayd.exchange.port.ExchangeExternalApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

	private final ExchangeExternalApiPort exchangeExternalApiPort;
	@GetMapping("campaign-approval-history")
	public String getRate(){
        return exchangeExternalApiPort.getCurrencyPairRate(ExchangeConversion.builder()
				.build());
	}

}
