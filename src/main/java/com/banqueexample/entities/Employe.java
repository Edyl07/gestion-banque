package com.banqueexample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codeEmploye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn(name = "CODE_EMP_SUP")
	private Employe employeSup;
	@ManyToMany
	@JoinTable(name = "EMP_GRP")
	private Collection<Groupe> groupes;
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	
	
	public long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	@JsonIgnore
	public Employe getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupe() {
		return groupes;
	}
	public void setGroupe(Collection<Groupe> groupe) {
		this.groupes = groupes;
	}
	
	
}
