/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.infrastructure.api.adapter */

package com.openpayd.exchange.infrastructure.api.adapter;

import com.openpayd.exchange.infrastructure.api.adapter.dto.LatestApiResponse;
import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.port.ExchangeExternalApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExchangeExternalApiPortAdapter implements ExchangeExternalApiPort {

	@Autowired
	RestTemplate restTemplate;

	private final String LATEST_API_URL ="/latest";

	@Value("${api.exchangerate.host.url}")
	private String apiHost;
	@Value("${api.exchangerate.access_key}")
	private String accessKey;



	@Override
	public CurrencyExchange currencyExchangeResult(CurrencyExchange currencyExchange) {
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(apiHost+ LATEST_API_URL)
				.queryParam("access_key", "{access_key}")
				.queryParam("symbols ", "{symbols}")
				.encode()
				.toUriString();
		Map<String, String> params = new HashMap<>();
		params.put("access_key", accessKey);
		params.put("symbols", currencyExchange.getTargetCurrency()+","+currencyExchange.getSourceCurrency());
		var response=restTemplate.getForObject(urlTemplate, LatestApiResponse.class,params);
		var sourceval=response.getRates().get(currencyExchange.getSourceCurrency());

		var targetVal=response.getRates().get(currencyExchange.getTargetCurrency());
		currencyExchange.setRate(targetVal/sourceval);
		return currencyExchange;
	}
}
