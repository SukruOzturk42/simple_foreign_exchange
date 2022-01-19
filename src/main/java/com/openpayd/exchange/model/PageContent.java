/* dks20165 created on 19.01.2022 inside the package - com.openpayd.exchange.model */

package com.openpayd.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageContent <T> {

	private int page;

	private int size;

	private int totalPages;

	private Long totalItems;

	private List<T> content;

	public PageContent() {
		this.content = new LinkedList<>();
	}

}