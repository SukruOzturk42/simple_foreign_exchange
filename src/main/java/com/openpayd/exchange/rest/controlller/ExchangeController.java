/* dks20165 created on 18.01.2022 inside the package - com.openpayd.exchange.rest.controlller */

package com.openpayd.exchange.rest.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class ExchangeController {

	@GetMapping("campaign-approval-history")
	public String getRate(){
        return null;
	}

}
