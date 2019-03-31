package com.servicecontrol.dev.financial.model;

import java.math.BigDecimal;

public class FinancialCount {

	private BigDecimal moneyToReceive;
	
	private BigDecimal moneyReceived;
	
	public FinancialCount (){
		
	}

	public BigDecimal getMoneyToReceive() {
		return moneyToReceive;
	}



	public void setMoneyToReceive(BigDecimal moneyToReceive) {
		this.moneyToReceive = moneyToReceive;
	}



	public BigDecimal getMoneyReceived() {
		return moneyReceived;
	}


	public void setMoneyReceived(BigDecimal moneyReceived) {
		this.moneyReceived = moneyReceived;
	}

	@Override
	public String toString() {
		return "FinancialCount [moneyToReceive=" + moneyToReceive + ", moneyReceived=" + moneyReceived + "]";
	}
	
}
