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
import entidades.Serie;
import negocio.ControladorNatacion;

/**
 * Servlet implementation class Tiempos
 */
@WebServlet("/Tiempos")
public class Tiempos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tiempos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if(request.getParameter("selCarrera")!=null){
			int nroCar = Integer.parseInt(request.getParameter("cbCarreras"));
			int nroPrograma=ControladorNatacion.getInstance().getTorneoActual().getNroPrograma();
			int nroTorneo=ControladorNatacion.getInstance().getTorneoActual().getNroTorneo();
			ArrayList<Serie> seriesPorCarrera = ControladorNatacion.getInstance().buscarSeriesPorCarrera(nroCar,nroPrograma , nroTorneo);
			session.setAttribute("seriesCarrera", seriesPorCarrera);
		}
		else if(request.getParameter("selSeries")!=null){}
		else if(request.getParameter("selRegistrar")!=null){}
		else if(request.getParameter("menuTiempos")!=null){
		ArrayList <Carrera>  carreras = ControladorNatacion.getInstance().buscarCarrerasPrograma(ControladorNatacion.getInstance().getTorneoActual().getNroPrograma());
		session.setAttribute("carrerasTiempos", carreras);		
		response.sendRedirect("RegistrarTiempos.jsp");
		}
	}

}
