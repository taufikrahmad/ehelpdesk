package com.helpdesk.model;

import javax.persistence.*;



public class ApplicationUserLevelModel {

	@Id
	@Column(name="id_level")
	private int idLevel;

	@Column(name="user_level")
	private String userLevel;

	public ApplicationUserLevelModel() {
	}

	public int getIdLevel() {
		return this.idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}

	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

}