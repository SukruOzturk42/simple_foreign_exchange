/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.model */

package com.openpayd.exchange.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {
	private String sourceCurrency;
	private String targetCurrency;
	private double rate;
	private double amount=1.0;
	private double exchangeAmountResult;
	private String transactionId;
	private LocalDate transactionDate;
}
