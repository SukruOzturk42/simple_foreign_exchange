/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.port */

package com.openpayd.exchange.port;

import com.openpayd.exchange.model.CurrencyExchange;

public interface ExchangeExternalApiPort {


	CurrencyExchange currencyExchangeResult(CurrencyExchange currencyExchange);
}
