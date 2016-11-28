package com.helpdesk.model;

import javax.persistence.*;


public class TicketsHistoryModel  {

	@Id
	private int id;

	private String comments;

	private int etf;

	@Column(name="id_ticket")
	private int idTicket;

	private String pic;

	private int status;

	public TicketsHistoryModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getEtf() {
		return this.etf;
	}

	public void setEtf(int etf) {
		this.etf = etf;
	}

	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}