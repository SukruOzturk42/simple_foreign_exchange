/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.model */

package com.openpayd.exchange.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeConversion {
	private String sourceCurrency;
	private String targetCurrency;
	private double amount=1;
}
