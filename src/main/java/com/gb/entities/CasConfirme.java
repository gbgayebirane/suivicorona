package com.gb.entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("confirme")
public class CasConfirme extends Cas
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	@Column
	private String symptome ;
	
	
	public CasConfirme() {
		super();
	}
	
	public CasConfirme(int id, String nom, String prenom, String adresse, String symptome) {
		super(id, nom, prenom, adresse);
		this.symptome = symptome;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSymptome() {
		return symptome;
	}
	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}
	
	
}
