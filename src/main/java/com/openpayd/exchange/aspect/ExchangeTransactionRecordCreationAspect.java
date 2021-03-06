/* dks20165 created on 5.01.2022 inside the package - com.anadolusigorta.campaignmanagement.domain.campaign.aspect */

package com.openpayd.exchange.aspect;

import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.port.CurrencyExchangeTransactionPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class ExchangeTransactionRecordCreationAspect {

	private final CurrencyExchangeTransactionPort currencyExchangeTransactionPort;

	@AfterReturning(
			value = "@annotation(ExchangeTransactionRecordCreator)",
			returning = "currencyExchange")
	public void createCampaignEvents(CurrencyExchange currencyExchange){

		try{
			currencyExchangeTransactionPort.save(currencyExchange);
			log.info("exchange transaction saved using aspect successfully ");

		}catch (Exception e){
			log.error(e.getMessage());
			log.info(String.format("Error occurred at exchange event creation phase, transactionId: %s",
					currencyExchange.getTransactionId()));
		}

	}
}
