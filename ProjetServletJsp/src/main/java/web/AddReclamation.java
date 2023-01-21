package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.session.AuthentificationServiceLocal;
import com.session.ReclamationServiceLocal;
import com.users.Etudiant;
import com.users.Reclamation;
import com.users.TypeReclamation;

import jakarta.ejb.EJB;

@WebServlet("/AddReclamation")
public class AddReclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ReclamationServiceLocal metier;
	@EJB
	private AuthentificationServiceLocal metier1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username1");
		String userpass = (String) session.getAttribute("userpass1");
		request.setAttribute("name", username);
		request.setAttribute("pass", userpass);
		Etudiant et = (Etudiant) metier1.authentifier(username, userpass);
		request.setAttribute("nom", et.getNom());
		request.setAttribute("prenom", et.getPrenom());
		request.setAttribute("typereclamation", metier.listerTypeReclamations());
		request.getRequestDispatcher("AddReclamation.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username1");
		String userpass = (String) session.getAttribute("userpass1");
		request.setAttribute("name", username);
		request.setAttribute("pass", userpass);
		String titre = request.getParameter("titre");
		String desc = request.getParameter("desc");
		String type = request.getParameter("x");

		if (action.equals("Ajout Reclamation")) {
			Etudiant etud = (Etudiant) metier1.authentifier(username, userpass);
			TypeReclamation typere = metier.chercherTypeReclamationParType(type);
			Reclamation recl = new Reclamation(titre, desc, etud, typere);
			metier.ajouterReclamation(recl);

			response.sendRedirect("/ProjetServletJsp/TableauFinale");
		}
		if (action.equals("Voir Reclamation")) {
			response.sendRedirect("/ProjetServletJsp/TableauFinale");
		}
		request.setAttribute("typereclamation", metier.listerTypeReclamations());

		request.getRequestDispatcher("AddReclamation.jsp").forward(request, response);
	}

}
