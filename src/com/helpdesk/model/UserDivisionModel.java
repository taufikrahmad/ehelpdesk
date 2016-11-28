package com.helpdesk.model;


import javax.persistence.*;
import java.util.Date;

public class UserDivisionModel {

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name="division_id")
	private int divisionId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name="user_id")
	private int userId;

	public UserDivisionModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getDivisionId() {
		return this.divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}