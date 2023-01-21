package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.users.Administration;
import com.users.Etudiant;

import jakarta.ejb.EJB;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddAdm")
public class AddAdm extends HttpServlet {
	@EJB
	private AuthentificationServiceLocal metier;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher("AddAdm.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String email = (request.getParameter("email"));
		String pass = (request.getParameter("pass"));

		if (action.equals("Ajout")) {
				if (metier.existeEmail(email)==false)
						
				{Administration et =new Administration( email, pass, true);
				metier.sauvegarderUtilisateur(et);
			
				request.getRequestDispatcher("AddAdm.jsp").forward(request, response);}
				else {
				System.out.println("<html><head></head><body onload=\"alert('hello')\"></body></html>");}
			}
		
		
		request.getRequestDispatcher("AddAdm.jsp").forward(request, response);

	}
}