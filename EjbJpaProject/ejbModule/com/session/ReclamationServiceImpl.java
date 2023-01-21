package com.session;

import java.util.List;

import com.users.Etudiant;
import com.users.Reclamation;
import com.users.TypeReclamation;

import jakarta.ejb.Stateless;
import jakarta.jws.WebParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "RE") //
public class ReclamationServiceImpl implements ReclamationServiceLocal {
	@PersistenceContext(unitName = "Projet_J2ee") // la connexion avec la base a l'aide des persistences
	private EntityManager em;

	@Override
	public void ajouterReclamation(Reclamation reclamation) {
		em.persist(reclamation);
	}

	@Override
	public void ajouterTypeReclamation(TypeReclamation typeReclamation) {

		em.persist(typeReclamation);

	}
	@Override
	public void supprimerReclamation(Reclamation Reclamation) {
		Query query = em.createQuery("DELETE FROM Reclamation t WHERE t.id = :id");
		query.setParameter("id", Reclamation.getId());
		int deletedCount = query.executeUpdate();
	}
	@Override
	public void ModifierReclamation(Reclamation Reclamation,String titre,String desc) {
		Query query1 = em.createQuery("UPDATE Reclamation t SET t.titre =:titre,t.description = :description WHERE t.id = :id");
		query1.setParameter("titre", titre);
		query1.setParameter("description", desc);
		query1.setParameter("id", Reclamation.getId());
		int updatedCount = query1.executeUpdate();
		
		

	}
	@Override
	public void ModifierTypeReclamation(TypeReclamation typeReclamation,String type) {
		Query query = em.createQuery("UPDATE TypeReclamation t SET t.type =:Type WHERE t.id = :id");
		query.setParameter("Type", type);
		query.setParameter("id", typeReclamation.getId());
		int updatedCount = query.executeUpdate();
		

	}
	@Override
	public Reclamation ChercherReclamation(int id) {
		
		return em.find(Reclamation.class, id);
	}
	
	@Override
	public List<Reclamation> listerReclamations() {
		Query req = em.createQuery("SELECT r FROM Reclamation r");
		return req.getResultList();
	}

	@Override
	public List<TypeReclamation> listerTypeReclamations() {
		Query req = em.createQuery("SELECT t FROM TypeReclamation t");
		return req.getResultList();
	}

	@Override
	public boolean existeTypeReclalamtion(String type) {
		Query query = em.createQuery("SELECT t FROM TypeReclamation t WHERE t.type = :type").setParameter("type", type);

		try {
			TypeReclamation tr = (TypeReclamation) query.getSingleResult();
			if (tr != null) {
				return true;
			}
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant) {

		return etudiant.getReclamations();
	}

	@Override
	public TypeReclamation chercherTypeReclamationParType(String type) {

		Query query = em.createQuery("SELECT t FROM TypeReclamation t WHERE t.type = :type").setParameter("type", type);
		TypeReclamation tr = (TypeReclamation) query.getSingleResult();
		return tr;
	}
}
