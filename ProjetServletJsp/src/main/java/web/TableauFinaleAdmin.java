package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;
import com.session.ReclamationServiceLocal;
import com.users.Etudiant;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TableauFinaleAdmin")
public class TableauFinaleAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AuthentificationServiceLocal metier;
	@EJB
	private ReclamationServiceLocal metier1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username1");
		String password = request.getParameter("userpass1");
		Etudiant et = (Etudiant) metier.authentifier(username, password);
		request.setAttribute("reclamation", metier1.listerReclamationParEtudiant(et));
		request.getRequestDispatcher("TableauFinaleAdmin.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
