package com.helpdesk.model;


import javax.persistence.*;

public class TicketsNumberModel {

	@Id
	private int id;

	@Column(name="id_tickets")
	private int idTickets;

	@Column(name="ticket_number")
	private String ticketNumber;

	public TicketsNumberModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTickets() {
		return this.idTickets;
	}

	public void setIdTickets(int idTickets) {
		this.idTickets = idTickets;
	}

	public String getTicketNumber() {
		return this.ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

}