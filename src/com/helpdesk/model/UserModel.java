package com.helpdesk.model;

public class UserModel {
	private int id_user;
	private String email;
	private String username;
	private String password;
	private String id_division;
	private String pc_sn;
	private String pc_barcode;
	private String sender_id;
	
	public DivisionModel division;
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId_division() {
		return id_division;
	}
	public void setId_division(String id_division) {
		this.id_division = id_division;
	}
	public String getPc_sn() {
		return pc_sn;
	}
	public void setPc_sn(String pc_sn) {
		this.pc_sn = pc_sn;
	}
	public String getPc_barcode() {
		return pc_barcode;
	}
	public void setPc_barcode(String pc_barcode) {
		this.pc_barcode = pc_barcode;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	
	
	
}
