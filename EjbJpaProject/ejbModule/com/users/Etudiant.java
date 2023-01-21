package com.users;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@DiscriminatorValue("Etudiant")//le discriminitateur pour identifier l'etudiant dans la table utilisateur
@XmlAccessorType(XmlAccessType.FIELD)
public class Etudiant extends Utilisateur {
	private String nom;
	private String prenom;

	@OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@XmlTransient
	private List<Reclamation> reclamations = new ArrayList<Reclamation>();

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Etudiant(String nom, String prenom, String email, String password, boolean active) {
		super(email, password, active);
		this.nom = nom;
		this.prenom = prenom;
	}

	public Etudiant() {
		super();

	}

	public Etudiant(String email, String password, boolean active) {
		super(email, password, active);

	}

}
