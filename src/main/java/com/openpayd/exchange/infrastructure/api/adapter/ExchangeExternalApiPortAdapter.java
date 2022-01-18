/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.infrastructure.api.adapter */

package com.openpayd.exchange.infrastructure.api.adapter;

import com.openpayd.exchange.infrastructure.api.adapter.dto.ConversionApiResponse;
import com.openpayd.exchange.infrastructure.api.config.ExchangeRatesApiRestTemplateConfig;
import com.openpayd.exchange.model.ExchangeConversion;
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

	private final String latestApi="/convert";

	@Value("${api.exchangerate.host.url}")
	private String apiHost;
	@Value("${api.exchangerate.access_key}")
	private String accessKey;

	@Override
	public String getCurrencyPairRate(ExchangeConversion exchangeConversion) {
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(apiHost+latestApi)
				.queryParam("access_key", "{access_key}")
				.queryParam("from", "{from}")
				.queryParam("to", "{to}")
				.queryParam("amount", "{amount}")
				.encode()
				.toUriString();
		Map<String, String> params = new HashMap<>();
		params.put("access_key", accessKey);
		params.put("from", "GBP");
		params.put("to", "JPY");
		params.put("amount", "1");
		return restTemplate.getForObject(urlTemplate, ConversionApiResponse.class,params).getResult();

	}
}
