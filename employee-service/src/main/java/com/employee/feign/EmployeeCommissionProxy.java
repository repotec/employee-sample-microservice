package com.employee.feign;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author ahmed mamdouh
 * @summary 
 * Fegin client for commission microservice will be through zuul instead of calling directly 
 * 1- register feign client with zuul gateway application name configured
 * 2- prefix commission microservice application name in request mapping along with zuul uri
 * 3- final uri should be:
 * 	  http://localhost:zuul-port/{microservice-application-name}/uri
 *    http://localhost:8762/employee-commission-service/commission/{salary}/{commissionPct}
 */
//@FeignClient(name = "employee-commission-service") //not needed along with gateway server
@FeignClient(name = "zuul-gateway-server", fallback = EmployeeCommissionProxyFallback.class)
@RibbonClient(name = "employee-commission-service")
public interface EmployeeCommissionProxy {
	
	//@RequestMapping(path="/commission/{salary}/{commissionPct}", method=RequestMethod.GET)
	@RequestMapping(path="/employee-commission-service/commission/{salary}/{commissionPct}")
	public BigDecimal calculateCommission(@PathVariable("salary") BigDecimal salary, 
									      @PathVariable("commissionPct") Double commissionPct);
}

@Component
class EmployeeCommissionProxyFallback implements EmployeeCommissionProxy {
	Logger logger = LoggerFactory.getLogger(EmployeeCommissionProxyFallback.class);
	
	@Override
	public BigDecimal calculateCommission(BigDecimal salary, Double commissionPct) {
		logger.info("fallback method for calculate commission");
		return BigDecimal.ZERO;
	}
	
}