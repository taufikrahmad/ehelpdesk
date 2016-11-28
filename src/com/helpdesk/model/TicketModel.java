package com.helpdesk.model;

import javax.persistence.*;
import java.util.Date;


public class TicketModel{

	@Id
	@Column(name="id_tickets")
	private int idTickets;

	private String autoCreatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date autoUpdatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	private String description;

	private int etf;

	@Column(name="it_verification_code")
	private String itVerificationCode;

	@Column(name="no_ticket")
	private String noTicket;

	@Column(name="pc_barcode")
	private String pcBarcode;

	@Column(name="pc_sn")
	private String pcSn;

	@Column(name="request_by")
	private int requestBy;

	@Column(name="request_email")
	private String requestEmail;

	@Column(name="sender_id")
	private String senderId;

	@Column(name="solve_by")
	private int solveBy;

	@Column(name="status_ticket")
	private int statusTicket;

	private String title;

	@Column(name="type_ticket")
	private String typeTicket;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name="user_verificaton_code")
	private String userVerificatonCode;

	public TypeTicketModel ticketType;
	public TicketsNumberModel ticketNumber;
	public UserModel requester;
	public UserModel solve;
	public DivisionModel division;
	public StatusTicketModel ticketStatus;
	
	
	public TicketModel() {
	}

	public int getIdTickets() {
		return this.idTickets;
	}

	public void setIdTickets(int idTickets) {
		this.idTickets = idTickets;
	}

	public String getAutoCreatedAt() {
		return this.autoCreatedAt;
	}

	public void setAutoCreatedAt(String autoCreatedAt) {
		this.autoCreatedAt = autoCreatedAt;
	}

	public Date getAutoUpdatedAt() {
		return this.autoUpdatedAt;
	}

	public void setAutoUpdatedAt(Date autoUpdatedAt) {
		this.autoUpdatedAt = autoUpdatedAt;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEtf() {
		return this.etf;
	}

	public void setEtf(int etf) {
		this.etf = etf;
	}

	public String getItVerificationCode() {
		return this.itVerificationCode;
	}

	public void setItVerificationCode(String itVerificationCode) {
		this.itVerificationCode = itVerificationCode;
	}

	public String getNoTicket() {
		return this.noTicket;
	}

	public void setNoTicket(String noTicket) {
		this.noTicket = noTicket;
	}

	public String getPcBarcode() {
		return this.pcBarcode;
	}

	public void setPcBarcode(String pcBarcode) {
		this.pcBarcode = pcBarcode;
	}

	public String getPcSn() {
		return this.pcSn;
	}

	public void setPcSn(String pcSn) {
		this.pcSn = pcSn;
	}

	public int getRequestBy() {
		return this.requestBy;
	}

	public void setRequestBy(int requestBy) {
		this.requestBy = requestBy;
	}

	public String getRequestEmail() {
		return this.requestEmail;
	}

	public void setRequestEmail(String requestEmail) {
		this.requestEmail = requestEmail;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public int getSolveBy() {
		return this.solveBy;
	}

	public void setSolveBy(int solveBy) {
		this.solveBy = solveBy;
	}

	public int getStatusTicket() {
		return this.statusTicket;
	}

	public void setStatusTicket(int statusTicket) {
		this.statusTicket = statusTicket;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTypeTicket() {
		return this.typeTicket;
	}

	public void setTypeTicket(String typeTicket) {
		this.typeTicket = typeTicket;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserVerificatonCode() {
		return this.userVerificatonCode;
	}

	public void setUserVerificatonCode(String userVerificatonCode) {
		this.userVerificatonCode = userVerificatonCode;
	}

}