package com.servicecontrol.dev.financial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicecontrol.dev.financial.model.FinancialCount;
import com.servicecontrol.dev.financial.service.FinancialService;

@RestController
@RequestMapping("/user/{userId}/financial")
@CrossOrigin("*")
public class FinancialController {

	
	@Autowired
	private FinancialService financialService;
	
	@GetMapping
	public ResponseEntity<FinancialCount> getFinancialStatistic(@PathVariable Long userId){
		
		return ResponseEntity.ok(this.financialService.countMoney(userId));
	}
	
	
}
