package com.helpdesk.model;


import javax.persistence.*;


public class TicketTypeHandlerModel{


	@Id
	@Column(name="id_handler")
	private int idHandler;

	@Column(name="id_divisions")
	private int idDivisions;

	@Column(name="ticket_type")
	private int ticketType;

	public TicketTypeHandlerModel() {
	}

	public int getIdHandler() {
		return this.idHandler;
	}

	public void setIdHandler(int idHandler) {
		this.idHandler = idHandler;
	}

	public int getIdDivisions() {
		return this.idDivisions;
	}

	public void setIdDivisions(int idDivisions) {
		this.idDivisions = idDivisions;
	}

	public int getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

}