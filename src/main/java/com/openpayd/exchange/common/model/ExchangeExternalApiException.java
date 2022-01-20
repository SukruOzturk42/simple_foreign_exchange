/* odeon_sukruo created on 26.04.2021 inside the package - com.anadolusigorta.campaignmanagement.domain.common */

package com.openpayd.exchange.common.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeExternalApiException extends RuntimeException {

	private String info;
	private String errorCode;

	public ExchangeExternalApiException(String errorCode,String info) {
		super(info);
		this.info = info;
		this.errorCode=errorCode;
	}


}
