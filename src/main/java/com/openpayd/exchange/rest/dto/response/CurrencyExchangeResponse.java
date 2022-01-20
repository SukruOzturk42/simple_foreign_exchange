/* dks20165 created on 20.01.2022 inside the package - com.openpayd.exchange.rest.dto.response */

package com.openpayd.exchange.rest.dto.response;

import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.model.PageContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeResponse {


	private String sourceCurrency;
	private String targetCurrency;
	private double rate;
	private double amount=1.0;
	private double exchangeAmountResult;
	private String transactionId;
	private LocalDate transactionDate;

	public static CurrencyExchangeResponse fromModel(CurrencyExchange currencyExchange){
		return CurrencyExchangeResponse.builder()
				.exchangeAmountResult(currencyExchange.getExchangeAmountResult())
				.transactionId(currencyExchange.getTransactionId())
				.amount(currencyExchange.getAmount())
				.exchangeAmountResult(currencyExchange.getExchangeAmountResult())
				.build();
	}

	public static List<CurrencyExchangeResponse> fromModelList(List<CurrencyExchange> currencyExchanges){
		return  currencyExchanges.stream()
				.map(CurrencyExchangeResponse::fromModel)
				.collect(Collectors.toList());
	}

	public static PageContent<CurrencyExchangeResponse> fromModelList(PageContent<CurrencyExchange> pageContent){
		return PageContent.<CurrencyExchangeResponse>builder()
				.content(fromModelList(pageContent.getContent()))
				.page(pageContent.getPage())
				.size(pageContent.getSize())
				.totalItems(pageContent.getTotalItems())
				.totalPages(pageContent.getTotalPages())
				.build();
	}

}
