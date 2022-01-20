/* dks20165 created on 20.01.2022 inside the package - com.openpayd.exchange.rest.dto.request */

package com.openpayd.exchange.rest.dto.request;

import com.openpayd.exchange.common.model.ExchangeException;
import com.openpayd.exchange.model.CurrencyExchangeTransactionCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class CurrencyExchangeTransactionCriteriaRequest {

	private String transactionId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;

	public  CurrencyExchangeTransactionCriteria toModel(){
        if(transactionDate==null  &&  transactionId==null){
        	throw new ExchangeException("transactionId.or.transactionDate.cannot.be.null");
		}
		return CurrencyExchangeTransactionCriteria.builder()
				.transactionDate(transactionDate)
				.transactionId(transactionId)
				.build();
	}
}
