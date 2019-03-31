package com.servicecontrol.dev.financial.service;

import com.servicecontrol.dev.financial.model.FinancialCount;

public interface FinancialService {

	FinancialCount countMoney(Long userId);
	
}
