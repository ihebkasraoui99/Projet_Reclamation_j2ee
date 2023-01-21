package com.users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@Entity
@Table(name = "UTILISATEUR")
@Inheritance(strategy = InheritanceType.JOINED) // j'ai choisi le type joined pour annuler les cases null qui apparait												// dans single table
@DiscriminatorColumn(name = "Utilisateur_type") // tableau relationnelle
@XmlAccessorType(XmlAccessType.FIELD) // pour pouvoir acceder au grouppment many to one
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE) // generation auto des ID
	@Column(name = "ID")
	
	private int idUtilisateur;
	private String email;
	private String password;
	@Column(nullable = false, columnDefinition = "TINYINT(1)") // valeur boolean
	private boolean active;

	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String email, String password, boolean active) {
		super();
		this.email = email;
		this.password = password;
		this.active = active;
	}

}
