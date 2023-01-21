package web;

import java.io.IOException;

import com.session.AuthentificationServiceLocal;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TableauxEtd")
public class TableauxEtd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AuthentificationServiceLocal metier;

	public TableauxEtd() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("comptes", metier.listerEtudiants());
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username1");
		String pass = (String) session.getAttribute("userpass1");
		request.setAttribute("admin", email);
		request.setAttribute("admin1", pass);
		request.getRequestDispatcher("TableauxEtd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
