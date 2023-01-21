package com.users;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD) // pour pouvoir acceder au graouppment many to one
public class TypeReclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String type;
	@OneToMany(mappedBy = "typereclamation", fetch = FetchType.EAGER)//le mode EAGER pour posseder toutes les informations sans aucune demande
	@XmlTransient// comme XmlAccessorType
	private List<Reclamation> reclamations = new ArrayList<Reclamation>();

	
	
	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TypeReclamation(String type) {
		super();
		this.type = type;

	}

	public TypeReclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
