package com.users;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD) // pour pouvoir acceder au graouppment many to one
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String titre;
	String description;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	@XmlTransient
	private TypeReclamation typereclamation;

	public Reclamation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Reclamation(String titre, String description, Etudiant etudiant, TypeReclamation typereclamation) {
		super();

		this.titre = titre;
		this.description = description;
		this.etudiant = etudiant;// pour la relation entre reclamation et leur etudiant
		this.typereclamation = typereclamation;// pour la relation entre reclamation et leur type
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public TypeReclamation getTypereclamation() {
		return typereclamation;
	}

	public void setTypereclamation(TypeReclamation typereclamation) {
		this.typereclamation = typereclamation;
	}

}
