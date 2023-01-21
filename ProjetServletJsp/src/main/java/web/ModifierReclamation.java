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

@WebServlet("/ModifierReclamation")
public class ModifierReclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ReclamationServiceLocal metier;
	@EJB
	private AuthentificationServiceLocal metier1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idS = request.getParameter("id");
		request.setAttribute("l", idS);
	
		request.setAttribute("typereclamation", metier.listerTypeReclamations());
		request.getRequestDispatcher("ModifierReclamation.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		request.setAttribute("l", idS);
		String titre = request.getParameter("titre");
		String desc = request.getParameter("desc");
		String type = request.getParameter("x");
		TypeReclamation typer = metier.chercherTypeReclamationParType(type);
		Reclamation rec=metier.ChercherReclamation(id);
		
		if (action.equals("Modifier Reclamation")) {
			
			metier.ModifierReclamation(rec,titre,desc);
			metier.ModifierTypeReclamation( typer,type);
			response.sendRedirect("/ProjetServletJsp/TableauFinale");
		}
		request.setAttribute("typereclamation", metier.listerTypeReclamations());

		request.getRequestDispatcher("ModifierReclamation.jsp").forward(request, response);
	}

}
