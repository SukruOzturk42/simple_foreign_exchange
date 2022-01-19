/* dks20165 created on 19.01.2022 inside the package - com.openpayd.exchange.infrastructure.jpa.repository */

package com.openpayd.exchange.infrastructure.jpa.repository;

import com.openpayd.exchange.infrastructure.jpa.entity.ExchangeTransactionEntity;
import com.openpayd.exchange.model.CurrencyExchangeTransactionCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

public class ExchangeTransactionSpecification {

	public static Specification<ExchangeTransactionEntity> isTransactionIdEqual(CurrencyExchangeTransactionCriteria criteria) {

		if(criteria.getTransactionId()!=null){
			return (exchangeTransactionEntity, cq, cb) -> cb.equal(
					getPath(Long.class, exchangeTransactionEntity, "transactionId"),
					criteria.getTransactionId());
		}

		return null;
	}

	public static Specification<ExchangeTransactionEntity> isTransactionDateEqual(CurrencyExchangeTransactionCriteria criteria) {
		if(criteria.getTransactionDate()!=null){
			return (exchangeTransactionEntity, cq, cb) -> cb.equal(
					getPath(Long.class, exchangeTransactionEntity, "transactionDate"),
					criteria.getTransactionDate());
		}

		return null;
	}

	private static <T, R> Path<R> getPath(Class<R> resultType, Path<T> root, String path) {
		String[] pathElements = path.split("\\.");
		Path<?> retVal = root;
		for (String pathEl : pathElements) {
			retVal = (Path<R>) retVal.get(pathEl);
		}
		return (Path<R>) retVal;
	}
}
