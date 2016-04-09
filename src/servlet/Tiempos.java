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
import entidades.Inscripcion;
import entidades.Nadador;
import entidades.Serie;
import negocio.ControladorNatacion;

@WebServlet("/Tiempos")

public class Tiempos extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Tiempos() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(ControladorNatacion.getInstance().getTorneoActual() != null)
		{
			HttpSession session = request.getSession(false);
			int nroPrograma=ControladorNatacion.getInstance().getTorneoActual().getNroPrograma();
			int nroTorneo=ControladorNatacion.getInstance().getTorneoActual().getNroTorneo();
			ArrayList<Carrera> carreras = ControladorNatacion.getInstance().buscarCarrerasPrograma(nroPrograma);
			session.setAttribute("carrerasTiempos", carreras);
			if(request.getParameter("selCarrera")!=null)
			{
				int nroCar = Integer.parseInt(request.getParameter("cbCarrera"));
				request.setAttribute("nroCarSel", nroCar);
				Carrera car = ControladorNatacion.getInstance().buscarCarrera(nroCar, nroPrograma);
				session.setAttribute("carreraSeleccionadaTiempo", car);
				ArrayList<Serie> seriesPorCarrera = ControladorNatacion.getInstance().buscarSeriesPorCarrera(nroCar,nroPrograma , nroTorneo);
				session.setAttribute("seriesCarrera", seriesPorCarrera);
			}
			else if(request.getParameter("selSerie")!=null)
			{
				int nroSerie =Integer.parseInt(request.getParameter("cbSeries"));
				Carrera car = (Carrera)session.getAttribute("carreraSeleccionadaTiempo");
				ArrayList<Inscripcion> insc = ControladorNatacion.getInstance().buscarInscripcionSerie(nroSerie, car.getNroCarrera(), nroTorneo, nroPrograma);	
				session.setAttribute("nroSerieSel", nroSerie);
				session.setAttribute("nadadoresPorSerie", insc);
			}
			else if(request.getParameter("regTiempos")!=null)
			{
				Carrera car=(Carrera) session.getAttribute("carreraSeleccionadaTiempo");
				int nroSerie=(int) session.getAttribute("nroSerieSel");
				String[] tiempo = new  String[6];
				String txt ="txtTiempo";
				for(int i=0;i<5;i++)
				{
					txt="txtTiempo"+i;
					if(request.getAttribute(txt) != null)
					{
						tiempo[i]=(String) request.getAttribute(txt);
					}
				}
				ControladorNatacion.getInstance().cargarTiempo(nroTorneo, nroPrograma, car.getNroCarrera(), nroSerie, tiempo);
				
				session.removeAttribute("carreraSeleccionadaTiempo");
				session.removeAttribute("seriesCarrera");
				session.removeAttribute("nroSerieSel");
				session.removeAttribute("nadadoresPorSerie");
				session.removeAttribute("nadadoresPorSerieNad");
				
				
			}
			else if(request.getParameter("menuTiempos")!=null){
				
				
			}
			response.sendRedirect("RegistrarTiempos.jsp");
		}
		else
		{
			request.setAttribute("mensajeError", "Primero debe definir un torneo!");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}
}
