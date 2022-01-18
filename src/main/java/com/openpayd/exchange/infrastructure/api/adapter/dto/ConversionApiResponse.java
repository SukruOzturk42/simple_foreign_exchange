/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.infrastructure.api.adapter.dto */

package com.openpayd.exchange.infrastructure.api.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionApiResponse {

	private String result;
}
