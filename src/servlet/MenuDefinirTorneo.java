package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Torneo;
import negocio.ControladorNatacion;

/**
 * Servlet implementation class MenuDefinirTorneo
 */
@WebServlet("/MenuDefinirTorneo")
public class MenuDefinirTorneo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDefinirTorneo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Torneo> torneos = ControladorNatacion.getInstance().buscarTorneos();
		if(torneos.isEmpty())
		{
			response.sendRedirect("PaginaPpal.html");
		}
		else
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("listaTorneos", torneos);
			request.getRequestDispatcher("DefinirTorneo.jsp").forward(request, response);	
		}
		
		
		
	}

}
