package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ControladorNatacion;

@WebServlet("/PreInscribirNadadorIndividual")
public class PreInscribirNadadorIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PreInscribirNadadorIndividual() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int dniNadador = Integer.parseInt(request.getParameter("dniNadador"));
		int nroCarrera = Integer.parseInt(request.getParameter("nroCarrera"));
		ControladorNatacion.getInstance().preInscribirACarreraIndividual(dniNadador, nroCarrera, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
