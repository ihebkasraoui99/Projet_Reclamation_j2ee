package com.service;

import java.util.List;

import com.session.AuthentificationServiceLocal;
import com.session.ReclamationServiceLocal;
import com.users.Etudiant;
import com.users.Reclamation;
import com.users.TypeReclamation;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@Stateless
@WebService// cette classe c'est pour les tests dans soap
public class ReclamationServ {
	@EJB
	private ReclamationServiceLocal metier;
	@EJB
	private AuthentificationServiceLocal metier1;

/*	@WebMethod
	public void addReclamation(@WebParam String titre, @WebParam String descr) {
		/*Etudiant et = metier1.recherherEtudiant("iheb", "iheb") ;
		TypeReclamation tr =metier.chercherTypeReclamationParType("grave");
 		Reclamation rec = new Reclamation(titre, descr,et,tr);
		metier.ajouterReclamation(rec);
	}*/

	@WebMethod
	public void addtypeReclamation(@WebParam String type) {
		TypeReclamation tyrec = new TypeReclamation(type);

		metier.ajouterTypeReclamation(tyrec);
	}

	@WebMethod
	public List<Reclamation> listerReclamations() {

		return metier.listerReclamations();
	}

	@WebMethod
	public List<TypeReclamation> listerTypeReclamations() {

		return metier.listerTypeReclamations();
	}

	@WebMethod
	public boolean existeTypeReclalamtion(@WebParam String type) {
		return metier.existeTypeReclalamtion(type);
	}

	@WebMethod
	public TypeReclamation chercherTypeReclamationParType(@WebParam String type) {
		

		return metier.chercherTypeReclamationParType(type);
	}


	/*public List<Reclamation> listerReclamationParEtudiant() {
		Etudiant rec = metier1.recherherEtudiant("iheb", "iheb") ;
		return metier.listerReclamationParEtudiant(rec);
	}*/
}
