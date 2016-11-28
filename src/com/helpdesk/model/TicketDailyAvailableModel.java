package com.helpdesk.model;

import javax.persistence.*;
import java.util.Date;

public class TicketDailyAvailableModel{

	@Id
	@Column(name="id_daily")
	private int idDaily;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="total_tickets")
	private int totalTickets;

	@Column(name="type_ticket")
	private int typeTicket;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public TicketDailyAvailableModel() {
	}

	public int getIdDaily() {
		return this.idDaily;
	}

	public void setIdDaily(int idDaily) {
		this.idDaily = idDaily;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalTickets() {
		return this.totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}

	public int getTypeTicket() {
		return this.typeTicket;
	}

	public void setTypeTicket(int typeTicket) {
		this.typeTicket = typeTicket;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}