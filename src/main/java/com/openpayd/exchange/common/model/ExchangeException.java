/* odeon_sukruo created on 26.04.2021 inside the package - com.anadolusigorta.campaignmanagement.domain.common */

package com.openpayd.exchange.common.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeException extends RuntimeException {
	private String key;
	private int errorCode;
	private final String[] args;

	public ExchangeException(String key) {
		super(key);
		this.key = key;
		args = new String[0];
	}

	public ExchangeException(int errorCode,String key) {
		super(key);
		this.key = key;
		args = new String[0];
		this.errorCode=errorCode;
	}

	public ExchangeException(String key, String... args) {
		super(key);
		this.key = key;
		this.args = args;
	}
}
