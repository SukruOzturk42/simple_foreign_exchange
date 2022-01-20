package com.openpayd.exchange.rest.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class ErrorResponse {

	private String errorCode;
	
	private String errorDescription;

}