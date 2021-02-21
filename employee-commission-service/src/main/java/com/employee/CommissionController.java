package com.employee;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommissionController {
	Logger logger = LoggerFactory.getLogger(CommissionController.class);
	
	@Autowired
	Environment environment;
	
	@RequestMapping(path="/commission/{salary}/{commissionPct}", method=RequestMethod.GET)
	public BigDecimal calculateCommission(@PathVariable("salary") BigDecimal salary, 
										  @PathVariable("commissionPct") Double commissionPct) {
		logger.info("server port:" + environment.getProperty("local.server.port"));
		return salary.multiply(BigDecimal.valueOf(commissionPct));
	}
	
}
