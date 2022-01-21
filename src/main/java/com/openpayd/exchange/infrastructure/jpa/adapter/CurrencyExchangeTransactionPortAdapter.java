/* dks20165 created on 19.01.2022 inside the package - com.openpayd.exchange.infrastructure.jpa.adapter */

package com.openpayd.exchange.infrastructure.jpa.adapter;

import com.google.common.math.IntMath;
import com.openpayd.exchange.infrastructure.jpa.entity.ExchangeTransactionEntity;
import com.openpayd.exchange.infrastructure.jpa.repository.ExchangeTransactionJPARepository;
import com.openpayd.exchange.infrastructure.jpa.repository.ExchangeTransactionSpecification;
import com.openpayd.exchange.model.CurrencyExchange;
import com.openpayd.exchange.model.CurrencyExchangeTransactionCriteria;
import com.openpayd.exchange.model.PageContent;
import com.openpayd.exchange.port.CurrencyExchangeTransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
@Transactional
public class CurrencyExchangeTransactionPortAdapter implements CurrencyExchangeTransactionPort {

	private final ExchangeTransactionJPARepository jpaRepository;

	@Override
	public CurrencyExchange save(CurrencyExchange currencyExchange) {
	    return jpaRepository.save(ExchangeTransactionEntity.fromModel(currencyExchange)).toModel();
	}

	@Override
	public PageContent<CurrencyExchange> getCurrencyExchangeTransactions(
			CurrencyExchangeTransactionCriteria criteria,Pageable pageable) {
		Page<ExchangeTransactionEntity> page = null;
		if(criteria.getTransactionId()!=null){
			page=jpaRepository
					.findAll(where(ExchangeTransactionSpecification.isTransactionIdEqual(criteria)),pageable);

		}
		if(criteria.getTransactionDate()!=null){
			page=jpaRepository
					.findAll(where(ExchangeTransactionSpecification.isTransactionDateEqual(criteria)),pageable);

		}
		return PageContent.<CurrencyExchange>builder()
				.content(page!=null?page.getContent()
						.stream()
						.map(ExchangeTransactionEntity::toModel)
						.collect(Collectors.toList()):new ArrayList<>())
				.page(page!=null?page.getPageable().getPageNumber():0)
				.size(page!=null?page.getPageable().getPageSize():0)
				.totalItems(page!=null?page.getTotalElements():0)
				.totalPages(page!=null? IntMath.divide((int)page.getTotalElements(),page.getPageable().getPageSize(),
						RoundingMode.FLOOR):0)
				.build();
	}
}
