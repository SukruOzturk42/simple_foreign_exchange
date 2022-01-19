/* dks20165 created on 19.01.2022 inside the package - com.openpayd.exchange.infrastructure.jpa.repository */

package com.openpayd.exchange.infrastructure.jpa.repository;

import com.openpayd.exchange.infrastructure.jpa.entity.ExchangeTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExchangeTransactionJPARepository extends JpaRepository<ExchangeTransactionEntity, Long>,
		JpaSpecificationExecutor<ExchangeTransactionEntity> {

}
