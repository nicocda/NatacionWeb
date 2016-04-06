package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Torneo;
import negocio.ControladorNatacion;

/**
 * Servlet implementation class ElegirTorneo
 */
@WebServlet("/btnDefinirTorneo")
public class BtnDefinirTorneo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BtnDefinirTorneo() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*
		request.getAttribute("torneo");
		HttpSession session = request.getSession(false);
		int nroTorneo = Integer.parseInt(request.getParameter("torneo"));
		Torneo t = ControladorNatacion.getInstance().buscarTorneo(nroTorneo);
		session.setAttribute("torneo", t);
		Date date;
		String stringCorto="";
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t.getFecha());
			 stringCorto = new SimpleDateFormat("dd/MM/yyyy").format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.setFecha(stringCorto);
		ControladorNatacion.getInstance().setTorneoActual(t);
		response.sendRedirect("PaginaPpal.jsp");
		*/
		HttpSession session = request.getSession(false);
		int nroTorneo = Integer.parseInt(request.getParameter("torneo"));
		Torneo torneoActual = ControladorNatacion.getInstance().buscarTorneo(nroTorneo);
		ControladorNatacion.getInstance().setTorneoActual(torneoActual);
		session.removeAttribute("listaTorneos");
		response.sendRedirect("PaginaPpal.jsp");
	}

}
