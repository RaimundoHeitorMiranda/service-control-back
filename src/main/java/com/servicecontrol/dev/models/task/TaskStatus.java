package com.servicecontrol.dev.models.task;


public enum TaskStatus {

	WAITING("WAITING"),
	IN_PROGRESS("IN_PROGRESS"),
	PAUSED("PAUSED"),
	STOPPED("STOPPED"),
	CANCELED("CANCELED"),
	WAITING_PAYMENT("WAITING_PAYMENT"),
	FINALIZED("FINALIZED");
	
	private String status;
	
	TaskStatus(String status) {
		this.status = status;
	}
	
	String getStatus(){
		return this.status;
	}
	
}
