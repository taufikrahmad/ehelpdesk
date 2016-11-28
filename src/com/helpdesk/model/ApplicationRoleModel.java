package com.helpdesk.model;


import javax.persistence.*;



public class ApplicationRoleModel {


	@Id
	@Column(name="id_rolde")
	private int idRolde;

	@Column(name="app_superior")
	private int appSuperior;

	@Column(name="id_division")
	private int idDivision;

	public ApplicationRoleModel() {
	}

	public int getIdRolde() {
		return this.idRolde;
	}

	public void setIdRolde(int idRolde) {
		this.idRolde = idRolde;
	}

	public int getAppSuperior() {
		return this.appSuperior;
	}

	public void setAppSuperior(int appSuperior) {
		this.appSuperior = appSuperior;
	}

	public int getIdDivision() {
		return this.idDivision;
	}

	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
	}

}