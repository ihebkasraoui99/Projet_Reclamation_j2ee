
package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.users.Administration;
import com.users.Etudiant;
import com.users.Utilisateur;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class login extends HttpServlet {
	@EJB
	private AuthentificationServiceLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("username");
		String pass = request.getParameter("userpass");
		HttpSession session = request.getSession();
		session.setAttribute("username1", email);
		session.setAttribute("userpass1", pass);
		String action = request.getParameter("action");
		if (action.equals("login")) {
			if (metier.existeEmail(email)) {
				Utilisateur u = metier.authentifier(email, pass);
				if (u instanceof Etudiant) {
					Etudiant etd = (Etudiant) metier.authentifier(email, pass);
					if (etd.isActive()) {
						response.sendRedirect("/ProjetServletJsp/AddReclamation");
					} else if (etd.isActive() == false) {
						response.sendRedirect("/ProjetServletJsp/Login");
					}
				} else if (u instanceof Administration) {
					response.sendRedirect("/ProjetServletJsp/TableauxEtd");
				}
			} else {
				response.sendRedirect("/ProjetServletJsp/Login");
			}

		}
	}
}
