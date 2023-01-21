package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.users.Etudiant;

import jakarta.ejb.EJB;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddEtudiant")
public class AddEtudiant extends HttpServlet {
	@EJB
	private AuthentificationServiceLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("AddEtudiant.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String nom = (request.getParameter("nom"));
		String prenom = (request.getParameter("prenom"));
		String email = (request.getParameter("email"));
		String pass = (request.getParameter("pass"));
		Etudiant et = new Etudiant(nom, prenom, email, pass, true);
		if (action.equals("Ajout")) {

			if (metier.existeEmail(email) == false)
				{metier.sauvegarderUtilisateur(et);

			request.getRequestDispatcher("AddEtudiant.jsp").forward(request, response);}
			else {Etudiant et1 = (Etudiant) metier.authentifier(email, pass);//modifier s'il existe
				et1.setNom(nom);
				et1.setPrenom(prenom);
				et1.setPassword(pass);
				metier.updateUtilisateur(et1);
			request.getRequestDispatcher("AddEtudiant.jsp").forward(request, response);
			}
		}

		
		request.getRequestDispatcher("AddEtudiant.jsp").forward(request, response);

	}
}