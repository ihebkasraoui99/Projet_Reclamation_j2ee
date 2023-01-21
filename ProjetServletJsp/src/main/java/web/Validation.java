
package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.users.Administration;
import com.users.Etudiant;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Validation") // not yet !!
public class Validation extends HttpServlet {
	@EJB
	private AuthentificationServiceLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Validation.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("username1");
		String pass = request.getParameter("userpass1");
		String active = request.getParameter("active");
		String action = request.getParameter("action");
		if (action.equals("Oui")) {	
			Etudiant et = (Etudiant) metier.authentifier(email, pass);
			if (active.equals("true")) {
				metier.DesactiverCompte(et);
			} else {
				metier.ActiverCompte(et);
			}
			response.sendRedirect("/ProjetServletJsp/TableauxEtd");
		}

	}
}
