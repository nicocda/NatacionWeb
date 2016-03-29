package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import entidades.Carrera;
import entidades.Nadador;
import entidades.Torneo;
import negocio.ControladorNatacion;


@WebServlet("/PreInscripcion")
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public PreInscripcion() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		HttpSession session = request.getSession(false);
		//Torneo torActual =  (Torneo) session.getAttribute("torneo");
		Torneo torActual = ControladorNatacion.getInstance().getTorneoActual();
		
		int nroPrograma = torActual.getNroPrograma();
		int nroTorneo = torActual.getNroTorneo();
		
		if (request.getParameter("individual") != null) 
		{
			ArrayList <Carrera>  carreras= ControladorNatacion.getInstance().buscarCarreraProgramaNoCargadas(nroPrograma, nroTorneo);
			session.setAttribute("carrerasIndividualNoCargadas", carreras);
		response.sendRedirect("PreInscripcionCarreraIndividual2.jsp");
		}
		else if(request.getParameter("Posta") != null)
		{
			ArrayList <Carrera>  carreras= ControladorNatacion.getInstance().buscarPostasProgramaNoCargadas(nroPrograma, nroTorneo);
			session.setAttribute("carreras", carreras);
			response.sendRedirect("PreInscripcionPosta.jsp");
			
		}
		else if(request.getParameter("reporte") != null)
		{
			
		}
		else if(request.getParameter("selCarrera") != null)
		{
			
			int nroCarrera =Integer.parseInt(request.getParameter("cbCarrera"));
			Carrera carSel = ControladorNatacion.getInstance().buscarCarrera(nroCarrera, nroPrograma);
			session.setAttribute("carSel", carSel);
			ArrayList<Nadador> nadadoresNoInsc = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carSel, nroTorneo);
			ArrayList<Nadador> nadadoresInsc = ControladorNatacion.getInstance().buscarNadadoresInscriptosACarreraIndividual(carSel, nroTorneo);
			session.setAttribute("nadNoInsc", nadadoresNoInsc);
			session.setAttribute("nadInsc", nadadoresInsc);
			response.sendRedirect("PreInscripcionCarreraIndividual.jsp");
		}
		else if(request.getParameter("agregar") != null)
		{
			Carrera carSel = (Carrera)session.getAttribute("carSel");
			int dniNadadorSeleccionado = Integer.parseInt(request.getParameter("nadNoInsc"));
			ControladorNatacion.getInstance().preInscribirACarreraIndividual(dniNadadorSeleccionado, carSel.getNroCarrera(), nroPrograma, nroTorneo);
			ArrayList<Nadador> nadadoresNoInsc = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carSel, nroTorneo);
			ArrayList<Nadador> nadadoresInsc = ControladorNatacion.getInstance().buscarNadadoresInscriptosACarreraIndividual(carSel, nroTorneo);
			session.removeAttribute("nadNoInsc");
			session.removeAttribute("nadInsc");
			session.setAttribute("nadNoInsc", nadadoresNoInsc);
			session.setAttribute("nadInsc", nadadoresInsc);
			response.sendRedirect("PreInscripcionCarreraIndividual.jsp");
		}
		else if(request.getParameter("quitar") != null)
		{
			Carrera carSel = (Carrera)session.getAttribute("carSel");
			int dniNadadorSeleccionado = Integer.parseInt(request.getParameter("nadInsc"));
			ControladorNatacion.getInstance().eliminarDePreInscripcionIndividual(dniNadadorSeleccionado, carSel.getNroCarrera(), nroPrograma, nroTorneo);
			ArrayList<Nadador> nadadoresNoInsc = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carSel, nroTorneo);
			ArrayList<Nadador> nadadoresInsc = ControladorNatacion.getInstance().buscarNadadoresInscriptosACarreraIndividual(carSel, nroTorneo);
			session.removeAttribute("nadNoInsc");
			session.removeAttribute("nadInsc");
			session.setAttribute("nadNoInsc", nadadoresNoInsc);
			session.setAttribute("nadInsc", nadadoresInsc);
			response.sendRedirect("PreInscripcionCarreraIndividual.jsp");
		}
		else if(request.getParameter("generar") != null)
		{
			Carrera carSel = (Carrera)session.getAttribute("carSel");
			ControladorNatacion.getInstance().generarSeriesPorCarrera(carSel.getNroCarrera(), nroPrograma, nroTorneo);
			response.sendRedirect("PreInscripciones.jsp");
		}
		
		//request.getRequestDispatcher("PreInscripcionCarreraIndividual.jsp").forward(request, response);	
	}

}