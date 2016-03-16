package servlet;

import java.io.IOException;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getAttribute("torneo");
		HttpSession session = request.getSession(false);
		String torneoString = request.getParameter("torneo");
		int nroTorneo=-1;
		if(torneoString.charAt(6) == ' ')
		{
			 nroTorneo = Character.getNumericValue(torneoString.charAt(5));
		}
			else if(torneoString.charAt(7) == ' ')
			{
				 nroTorneo = Character.getNumericValue(torneoString.charAt(5)+torneoString.charAt(6));
			}else if(torneoString.charAt(8) == ' ')
					{
						 nroTorneo = Character.getNumericValue(torneoString.charAt(5)+torneoString.charAt(6)+torneoString.charAt(7));
					}
		Torneo t = ControladorNatacion.getInstance().buscarTorneo(nroTorneo);
		session.setAttribute("torneo", t);
		response.sendRedirect("PaginaPpal.html");
		
	}

}
