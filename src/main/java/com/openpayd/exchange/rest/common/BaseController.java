package com.openpayd.exchange.rest.common;


import com.openpayd.exchange.model.PageContent;

import java.util.List;

public class BaseController {

	public <T> Response<DataResponse<T>> respond(List<T> items) {
		return ResponseBuilder.build(items);
	}

	public <T> PageableResponse<DataResponse<T>> respond(PageContent<T> pageContent) {
		return ResponseBuilder.build(pageContent);
	}

	protected <T> Response<T> respond(T item) {
		return ResponseBuilder.build(item);
	}

	protected Response<?> respond(ErrorResponse errorResponse) {
		return ResponseBuilder.build(errorResponse);
	}

}
