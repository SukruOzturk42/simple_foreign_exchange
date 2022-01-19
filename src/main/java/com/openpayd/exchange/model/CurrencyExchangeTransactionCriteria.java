/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.model */

package com.openpayd.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeTransactionCriteria {
	private String transactionId;
	private LocalDate transactionDate;
}
