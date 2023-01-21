package com.session;

import java.util.List;

import com.users.Administration;
import com.users.Etudiant;
import com.users.Reclamation;
import com.users.Utilisateur;

import jakarta.ejb.Stateless;
import jakarta.jws.WebParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "AUTH") // partie EJB
public class AuthentificationServiceImpl implements AuthentificationServiceLocal {
	@PersistenceContext(unitName = "Projet_J2ee") // la connexion avec la base a l'aide des persistences
	private EntityManager em;

	@Override
	public Utilisateur authentifier(String login, String pwd) {

		Query req = em.createQuery("SELECT u FROM Utilisateur u WHERE  u.email=:login AND u.password=:pwd")
				.setParameter("login", login).setParameter("pwd", pwd);
		
		return (Utilisateur) req.getSingleResult();

	}
	
	
	@Override
	public boolean existeEmail(String login) {
		Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:login ").setParameter("login", login);
		try{Utilisateur utl = (Utilisateur) query.getSingleResult();
		if (utl != null) {
			return true;
		}}catch(NoResultException e) {
		return false;
	}return true;}

	@Override
	public void sauvegarderUtilisateur(Utilisateur utilisateur) {

		em.persist(utilisateur);

	}
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {

		em.merge(utilisateur);

	}

	@Override
	public List<Etudiant> listerEtudiants() {
		Query req = em.createQuery("SELECT e FROM Etudiant e");
		return req.getResultList();
	}


	

	@Override
	public void ActiverCompte(Etudiant et) {

		int req = em.createQuery("UPDATE Etudiant e SET e.active =:etat WHERE e.ID=:id").setParameter("etat", true)
				.setParameter("id", et.getIdUtilisateur()).executeUpdate();

	}

	@Override
	public void DesactiverCompte(Etudiant et) {

		int req = em.createQuery("UPDATE Etudiant e SET e.active =:etat WHERE e.ID=:id").setParameter("etat", false)
				.setParameter("id", et.getIdUtilisateur()).executeUpdate();

	}






}
