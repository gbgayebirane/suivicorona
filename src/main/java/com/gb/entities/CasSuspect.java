package com.gb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("suspect")
public class CasSuspect extends Cas
{
	@Id
	private int id;
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateConfirmation;
	
	
	public CasSuspect() {
		super();
	}
	
	public CasSuspect(int id, String nom, String prenom, String adresse, Date dateConfirmation) {
		super(id, nom, prenom, adresse);
		this.dateConfirmation = dateConfirmation;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateConfirmation() {
		return dateConfirmation;
	}
	public void setDateConfirmation(Date dateConfirmation) {
		this.dateConfirmation = dateConfirmation;
	}
	
	

}
