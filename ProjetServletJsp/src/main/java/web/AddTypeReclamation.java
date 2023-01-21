package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.session.ReclamationServiceLocal;
import com.users.Etudiant;
import com.users.TypeReclamation;

import jakarta.ejb.EJB;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddTypeReclamation")
public class AddTypeReclamation extends HttpServlet {
	@EJB
	private ReclamationServiceLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("AddTypeReclamation.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String type = (request.getParameter("type"));
		TypeReclamation tr = new TypeReclamation(type);
		if (action.equals("Ajout Type")) {
			if (metier.existeTypeReclalamtion(type) == false) {
				metier.ajouterTypeReclamation(tr);
				response.sendRedirect("/ProjetServletJsp/TableauxEtd");
			} else {
				request.getRequestDispatcher("AddTypeReclamation.jsp").forward(request, response);
			}
		}

	}
}