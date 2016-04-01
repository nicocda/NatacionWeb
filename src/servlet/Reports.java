package servlet;

import java.io.IOException;
import java.sql.Connection;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexion.DataConnection;
import entidades.Carrera;
import negocio.ControladorNatacion;
import reporte.Reportes;


@WebServlet("/reports")
public class Reports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Reports() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(request.getParameter("reportePreInscripcion") != null)
		{
			int nroCar =  Integer.parseInt(request.getParameter("cbCarrera"));
			Carrera carreraSeleccionado = ControladorNatacion.getInstance().buscarCarrera(nroCar, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma());
			session.setAttribute("carrera",carreraSeleccionado);

			   try
			   {
				   if(carreraSeleccionado.getNroCarrera()<=40)
					{
					Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\PreInscripcionIndividual.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
					Reportes.showViewer();
					}
					else
					{
					Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\PreInscripcionPosta.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
					Reportes.showViewer();
					}
			   }
			   catch (Exception e)
			   {
			      e.printStackTrace();
			   }
		}
		else if(request.getParameter("reportePremiacion") != null)
		{
			int nroCar =  Integer.parseInt(request.getParameter("cbCarrera"));
			Carrera carreraSeleccionado = ControladorNatacion.getInstance().buscarCarrera(nroCar, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma());
			session.setAttribute("carrera",carreraSeleccionado);

			   try
			   {
				   if(carreraSeleccionado.getNroCarrera()<=40)
					{
					Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\PremiacionIndividual.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
					Reportes.showViewer();
					}
					else
					{
					Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\PremiacionPosta.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
					Reportes.showViewer();
					}
			   }
			   catch (Exception e)
			   {
			      e.printStackTrace();
			   }
		} else if (request.getParameter("reporteNadadores") != null)
		{
			try
			{
				Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\ReporteNadadores.jasper");
			}
			catch (Exception e)
		   {
		      e.printStackTrace();
		   }
		}
	}
}
