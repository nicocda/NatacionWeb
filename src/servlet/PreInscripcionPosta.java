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
import entidades.NadadorCarreraPosta;
import negocio.ControladorNatacion;

/**
 * Servlet implementation class PreInscripcionPosta
 */
@WebServlet("/PreInscripcionPosta")
public class PreInscripcionPosta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreInscripcionPosta() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Nadador equipo[];
		equipo = new Nadador[4];
		if(request.getParameter("selCarrera")!=null)
		{
			 int nroCar = Integer.parseInt(request.getParameter("cbCarrera"));
			Carrera car = ControladorNatacion.getInstance().buscarCarrera(nroCar, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma());
			ArrayList<Nadador> nadadores = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraPosta(car, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			ArrayList<NadadorCarreraPosta> nadPreInscr = ControladorNatacion.getInstance().buscarTodosEquipoPosta(car, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			session.setAttribute("carrera", car);
			session.setAttribute("nadadores", nadadores);
			session.setAttribute("InscEquipo", nadPreInscr);
			session.setAttribute("equipo", equipo);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("selNadador")!=null){
			int nroNad = Integer.parseInt(request.getParameter("nadadores"));
			Nadador nad = ControladorNatacion.getInstance().buscarNadadorPorDni(nroNad);
			equipo = (Nadador[])session.getAttribute("equipo");
			for( int i=0;i<equipo.length;i++)
			{
				if(equipo[i] == null){
					equipo[i]=nad;
					break;
				}
			}
			session.setAttribute("equipo", equipo);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("0")!=null)
		{
			equipo= (Nadador[])session.getAttribute("equipo");
			equipo[0] = null;
			session.setAttribute("equipo", equipo);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("1")!=null)
		{
			equipo= (Nadador[])session.getAttribute("equipo");
			equipo[1] = null;
			session.setAttribute("equipo", equipo);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("2")!=null)
		{
			equipo= (Nadador[])session.getAttribute("equipo");
			equipo[2] = null;
			session.setAttribute("equipo", equipo);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("3")!=null)
		{
			equipo= (Nadador[])session.getAttribute("equipo");
			equipo[3] = null;
			session.setAttribute("equipo", equipo);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("addEquipo")!=null)
		{
			int nroCar = Integer.parseInt(request.getParameter("cbCarrera"));
			equipo=(Nadador[])session.getAttribute("equipo");
			ControladorNatacion.getInstance().preInscribirAPosta(nroCar, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(), equipo[0].getDni(), equipo[1].getDni(), equipo[2].getDni(), equipo[3].getDni());
			Carrera car = (Carrera)session.getAttribute("carrera");
			ArrayList<NadadorCarreraPosta> nadPreInscr = ControladorNatacion.getInstance().buscarTodosEquipoPosta(car, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			equipo = new Nadador[4];
			session.setAttribute("equipo", equipo);
			session.setAttribute("InscEquipo", nadPreInscr);
			response.sendRedirect("PreInscripcionPosta.jsp");
		}else if(request.getParameter("genSerie")!= null)
		{
			int nroCar = Integer.parseInt(request.getParameter("cbCarrera"));
			Carrera car = (Carrera)session.getAttribute("carrera");
			ArrayList<NadadorCarreraPosta> nadPreInscr = ControladorNatacion.getInstance().buscarTodosEquipoPosta(car, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			ControladorNatacion.getInstance().generarSeriesPosta(nadPreInscr, nroCar, ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			response.sendRedirect("PreInscripciones.jsp");
		}
		
	}

}
