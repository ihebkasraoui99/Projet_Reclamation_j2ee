package com.session;

import java.util.List;

import com.users.Administration;
import com.users.Etudiant;
import com.users.Utilisateur;

import jakarta.ejb.Local;

@Local
public interface AuthentificationServiceLocal {
	Utilisateur authentifier(String login, String pwd);

	boolean existeEmail(String login);

	void sauvegarderUtilisateur(Utilisateur utilisateur);

	List<Etudiant> listerEtudiants();

	void DesactiverCompte(Etudiant et);

	void ActiverCompte(Etudiant et);

	void updateUtilisateur(Utilisateur utilisateur);

	

	

}
