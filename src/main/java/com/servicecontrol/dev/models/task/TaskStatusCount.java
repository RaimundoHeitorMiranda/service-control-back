package com.servicecontrol.dev.models.task;

public class TaskStatusCount {

	private Integer waiting;
	
	private Integer inProgress;
	
	private Integer paused;
	
	private Integer stopped;
	
	private Integer canceled;
	
	private Integer waitingPayment;
	
	private Integer finalized;
	
	public TaskStatusCount() {
		
	}

	public Integer getWaiting() {
		return waiting;
	}

	public void setWaiting(Integer waiting) {
		this.waiting = waiting;
	}

	public Integer getInProgress() {
		return inProgress;
	}

	public void setInProgress(Integer inProgress) {
		this.inProgress = inProgress;
	}

	public Integer getPaused() {
		return paused;
	}

	public void setPaused(Integer paused) {
		this.paused = paused;
	}

	public Integer getStopped() {
		return stopped;
	}

	public void setStopped(Integer stopped) {
		this.stopped = stopped;
	}

	public Integer getCanceled() {
		return canceled;
	}

	public void setCanceled(Integer canceled) {
		this.canceled = canceled;
	}

	public Integer getWaitingPayment() {
		return waitingPayment;
	}

	public void setWaitingPayment(Integer waiting_payment) {
		this.waitingPayment = waiting_payment;
	}
	
	public Integer getFinalized() {
		return finalized;
	}

	public void setFinalized(Integer finalized) {
		this.finalized = finalized;
	}

	@Override
	public String toString() {
		return "TaskStatusCount [waiting=" + waiting + ", inProgress=" + inProgress + ", paused=" + paused
				+ ", stopped=" + stopped + ", canceled=" + canceled + ", waitingPayment=" + waitingPayment
				+ ", finalized=" + finalized + "]";
	}
	
}
