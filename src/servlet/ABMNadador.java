package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Club;
import entidades.Nadador;
import negocio.ControladorNatacion;

/**
 * Servlet implementation class ABMNadador
 */
@WebServlet("/ABMNadador")
public class ABMNadador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMNadador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Club> listaClubes = new ArrayList<Club>();
		ArrayList<Nadador> listaNadadores = new ArrayList<Nadador>();
		
		if (request.getParameter("nuevo") != null) 
		{
			listaClubes = ControladorNatacion.getInstance().buscarClubes();	
			session.setAttribute("listaClubes", listaClubes);
			response.sendRedirect("AltaNadador.jsp");
		} 
		else if (request.getParameter("editar") != null)
		{
			listaNadadores = ControladorNatacion.getInstance().buscarTodosNadadores();
			session.setAttribute("listaNadadores", listaNadadores);
			listaClubes = ControladorNatacion.getInstance().buscarClubes();	
			session.setAttribute("listaClubes", listaClubes);
			response.sendRedirect("ModificarNadador.jsp");
		}
		else if (request.getParameter("eliminar") != null)
		{
			listaNadadores = ControladorNatacion.getInstance().buscarTodosNadadores();
			session.setAttribute("listaNadadores", listaNadadores);
			response.sendRedirect("EliminarNadador.jsp");
		}
		else if (request.getParameter("btnCancelar") != null)
		{
			response.sendRedirect("ABMNadador.jsp");
		}
		else if (request.getParameter("btnGuardar") != null)
		{
			//VALIDAR CAMPOS VACIOS? O LO HACEMOS CON JS a eso?
			char sexo;
			if (Integer.parseInt(request.getParameter("cbSexo")) == 1)
				sexo = 'm';
			else
				sexo = 'f';
			ControladorNatacion.getInstance().cargarNadador(sexo, request.getParameter("txtNombre"), request.getParameter("txtApellido"), request.getParameter("txtNacimiento"), Integer.parseInt(request.getParameter("txtDNI")), Integer.parseInt(request.getParameter("cbClubes")));
			session.setAttribute("mensaje", "Se agregó un nuevo nadador");
			response.sendRedirect("ABMNadador.jsp");	
		}
		else if (request.getParameter("btnEliminar") != null)
		{
			ControladorNatacion.getInstance().eliminarNadador(Integer.parseInt(request.getParameter("cbNadadores")));
			session.setAttribute("mensaje", "Se eliminó un nadador");
			response.sendRedirect("ABMNadador.jsp");
		}
		else if (request.getParameter("btnModificar") != null)
		{
			char sexo;
			if (Integer.parseInt(request.getParameter("cbSexo")) == 1)
				sexo = 'm';
			else
				sexo = 'f';
			ControladorNatacion.getInstance().modificarNadador(Integer.parseInt(request.getParameter("cbNadadores")), request.getParameter("txtApellido"), request.getParameter("txtNombre"), Integer.parseInt(request.getParameter("cbClubes")), sexo, request.getParameter("txtNacimiento"));
			session.setAttribute("mensaje", "Se modificó un nadador");
			response.sendRedirect("ABMNadador.jsp");	
		} else
		{
			session.setAttribute("mensaje", "Seleccione una opción");
			response.sendRedirect("ABMNadador.jsp");	
		}
	}

}
