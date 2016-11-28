package com.helpdesk.model;

import javax.persistence.*;


public class StatusTicketModel {

	@Id
	@Column(name="id_status")
	private int idStatus;

	private String status;

	public StatusTicketModel() {
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}