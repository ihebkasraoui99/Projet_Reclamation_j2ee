package com.session;

import java.util.List;

import com.users.Etudiant;
import com.users.Reclamation;
import com.users.TypeReclamation;

import jakarta.ejb.Local;

@Local
public interface ReclamationServiceLocal {
	void ajouterReclamation(Reclamation reclamation);

	void ajouterTypeReclamation(TypeReclamation typeReclamation);

	List<Reclamation> listerReclamations();

	List<TypeReclamation> listerTypeReclamations();

	boolean existeTypeReclalamtion(String type);

	TypeReclamation chercherTypeReclamationParType(String type);

	List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);

	Reclamation ChercherReclamation(int id);// ajouter par moi pour un besoin alterieur

	void supprimerReclamation(Reclamation Reclamation);// ajouter par moi pour un besoin alterieur

	void ModifierReclamation(Reclamation Reclamation, String titre, String desc);// ajouter par moi pour un besoin alterieur
	
	void ModifierTypeReclamation(TypeReclamation typeReclamation, String type);
}
