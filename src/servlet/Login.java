package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Usuario;
import negocio.ControladorNatacion;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String usuario = request.getParameter("login");
		String password = request.getParameter("password");
		
		
			Usuario usuarioActual = ControladorNatacion.getInstance().buscarUsuario(usuario, password);
			if(usuarioActual != null)
			{
				//inicializo la sesion
				HttpSession session = request.getSession(true);
				session.setAttribute("usuarioActual", usuarioActual);
				request.getRequestDispatcher("PaginaPpal.jsp").forward(request, response);
			}
			else
			{
				response.sendRedirect("Ingresar.html");
			}
		
	}

}

