/* dks20165 created on 19.01.2022 inside the package - com.openpayd.exchange.infrastructure.jpa.entity */

package com.openpayd.exchange.infrastructure.jpa.entity;

import com.openpayd.exchange.model.CurrencyExchange;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exchange_transaction")
public class ExchangeTransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "transaction_date")
	private LocalDate transactionDate;

	@Column(name = "source_currency")
	private String sourceCurrency;

	@Column(name = "target_currency")
	private String targetCurrency;

	@Column(name = "target")
	private double rate;

	@Column(name = "amount")
	private double amount=1.0;

	@Column(name = "exchange_amount_result")
	private double exchangeAmountResult;


	public CurrencyExchange toModel(){

		return CurrencyExchange.builder()
				.transactionId(transactionId)
				.transactionDate(transactionDate)
				.sourceCurrency(sourceCurrency)
				.amount(amount)
				.rate(rate)
				.exchangeAmountResult(exchangeAmountResult)
				.build();
	}

	public static ExchangeTransactionEntity fromModel(CurrencyExchange currencyExchange){
		var entity=new ExchangeTransactionEntity();
		entity.setTransactionId(currencyExchange.getTransactionId());
		entity.setTransactionDate(currencyExchange.getTransactionDate());
		entity.setRate(currencyExchange.getRate());
		entity.setAmount(currencyExchange.getAmount());
		entity.setSourceCurrency(currencyExchange.getSourceCurrency());
		entity.setTargetCurrency(currencyExchange.getTargetCurrency());
		entity.setExchangeAmountResult(currencyExchange.getExchangeAmountResult());
		return entity;
	}
}
