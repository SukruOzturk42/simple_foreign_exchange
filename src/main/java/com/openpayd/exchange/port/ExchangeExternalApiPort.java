/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.port */

package com.openpayd.exchange.port;

import com.openpayd.exchange.model.ExchangeConversion;

public interface ExchangeExternalApiPort {

	String getCurrencyPairRate(ExchangeConversion exchangeConversion);
}
