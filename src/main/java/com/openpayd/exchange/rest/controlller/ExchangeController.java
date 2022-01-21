/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.rest.controlller */

package com.openpayd.exchange.rest.controlller;


import com.openpayd.exchange.rest.common.ApiController;
import com.openpayd.exchange.rest.common.PageableResponse;
import com.openpayd.exchange.rest.common.Response;
import com.openpayd.exchange.rest.common.BaseController;
import com.openpayd.exchange.rest.dto.request.CurrencyExchangeTransactionCriteriaRequest;
import com.openpayd.exchange.rest.dto.response.CurrencyConversionResponse;
import com.openpayd.exchange.rest.dto.response.CurrencyExchangeResponse;
import com.openpayd.exchange.rest.dto.response.ExchangeRateResponse;
import com.openpayd.exchange.service.ExchangeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@ApiController
public class ExchangeController extends BaseController {

	private final ExchangeService exchangeService;


	@ApiOperation(value = "currency-pair-rate", notes = "Consumer can get source currency rate according to target currency ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "currency-pair-rate", response = ExchangeRateResponse.class) })
	@GetMapping("/currency-pair-rate")
	public Response<?> getCurrenciesRate(@RequestParam String sourceCurrency,@RequestParam String targetCurrency) {

		return respond(ExchangeRateResponse
				.fromModel(exchangeService.getCurrencyExchangeAmountAsOne(sourceCurrency,targetCurrency)));

	}


	@ApiOperation(value = "currency-conversion", notes = "Consumer can convert source currency value  to target currency value ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "currency-conversion", response = CurrencyConversionResponse.class) })
	@GetMapping("/currency-conversion")
	public Response<?> currencyConversion(@RequestParam String sourceCurrency
			,@RequestParam String targetCurrency,@RequestParam double amount) {

		return respond(CurrencyConversionResponse
				.fromModel(exchangeService
						.getCurrencyExchange(sourceCurrency,targetCurrency,amount)));

	}

	@ApiOperation(value = "currency-conversions", notes = "Consumer can show exchange transaction history")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "currency-conversions-history", response = CurrencyExchangeResponse.class) })
	@PostMapping("/currency-conversion-history")
	public PageableResponse<?> currencyConversion(
			@RequestBody  @Valid CurrencyExchangeTransactionCriteriaRequest currencyExchangeTransactionCriteriaRequest
			,@PageableDefault(size =5) Pageable pageable) {

		return respond(CurrencyExchangeResponse
				.fromModelList(exchangeService
						.getCurrencyTransactionHistory(
								currencyExchangeTransactionCriteriaRequest.toModel(),pageable)));

	}
}
