package com.helpdesk.model;

import javax.persistence.*;


public class TypeTicketModel {


	@Id
	private int id;

	private String type;

	public TypeTicketModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}