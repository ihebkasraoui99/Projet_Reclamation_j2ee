
package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.session.ReclamationServiceLocal;
import com.users.Administration;
import com.users.Etudiant;
import com.users.Reclamation;
import com.users.TypeReclamation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Supprimer") // not yet !!
public class Supprimer extends HttpServlet {
	@EJB
	private ReclamationServiceLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Supprimer.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		String action = request.getParameter("action");
		if (action.equals("Oui")) {
			Reclamation et = metier.ChercherReclamation(id);
			metier.supprimerReclamation(et);
			response.sendRedirect("/ProjetServletJsp/TableauFinale");
		}
		if (action.equals("Non")) {
			response.sendRedirect("/ProjetServletJsp/TableauFinale");
		}
	}
}
