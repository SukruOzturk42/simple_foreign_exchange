/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.port */

package com.openpayd.exchange.port;

import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.model.CurrencyExchangeTransactionCriteria;
import com.openpayd.exchange.model.PageContent;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CurrencyExchangeTransactionPort {


	void save(CurrencyExchange currencyExchange);

	PageContent<CurrencyExchange> getCurrencyExchangeTransactions(
			CurrencyExchangeTransactionCriteria currencyExchangeTransactionCriteria,Pageable pageable);
}
