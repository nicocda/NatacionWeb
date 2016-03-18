package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Carrera;
import entidades.Nadador;
import entidades.Torneo;
import negocio.ControladorNatacion;

/**
 * Servlet implementation class cargarTablasPreInd
 */
@WebServlet("/selCarrera")
public class CargarTablasPreInd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarTablasPreInd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Carrera carSel = (Carrera)request.getAttribute("cbCarrera");
		HttpSession session = request.getSession(false);
		int nroTorneo =  ((Torneo)session.getAttribute("torneo")).getNroTorneo();
		ArrayList<Nadador> nadadoresNoInsc = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carSel, nroTorneo);
		ArrayList<Nadador> nadadoresInsc = ControladorNatacion.getInstance().buscarNadadoresInscriptosACarreraIndividual(carSel, nroTorneo);
		session.setAttribute("nadNoInsc", nadadoresNoInsc);
		session.setAttribute("nadInsc", nadadoresInsc);
		//response.sendRedirect("PreInscripcionCarreraIndividual.jsp");
		request.getRequestDispatcher("PreInscripcionCarreraIndividual.jsp").forward(request, response);	
	}

}