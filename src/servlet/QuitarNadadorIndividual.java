package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ControladorNatacion;

/**
 * Servlet implementation class QuitarNadadorIndividual
 */
@WebServlet("/QuitarNadadorIndividual")
public class QuitarNadadorIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QuitarNadadorIndividual() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dniNadador = Integer.parseInt(request.getParameter("dniNadador"));
		int nroCarrera = Integer.parseInt(request.getParameter("nroCarrera"));
		ControladorNatacion.getInstance().eliminarDePreInscripcionIndividual(dniNadador, nroCarrera, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
