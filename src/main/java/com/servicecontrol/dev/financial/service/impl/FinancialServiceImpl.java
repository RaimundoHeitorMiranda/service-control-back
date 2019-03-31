package com.servicecontrol.dev.financial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecontrol.dev.financial.model.FinancialCount;
import com.servicecontrol.dev.financial.service.FinancialService;
import com.servicecontrol.dev.repositories.TaskRepository;

@Service
public class FinancialServiceImpl implements FinancialService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public FinancialCount countMoney(Long userId) {
		FinancialCount financial = new FinancialCount();
		financial.setMoneyToReceive(this.taskRepository.sumMoneyToReceive(userId));
		financial.setMoneyReceived(this.taskRepository.sumMoneyReceived(userId));
		return financial;
	}

	
	
}
