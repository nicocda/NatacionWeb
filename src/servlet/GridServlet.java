package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Nadador;
import negocio.ControladorNatacion;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class GridServlet
 */
@WebServlet("/GridServlet")
public class GridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GridServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			ArrayList<Nadador> ln = new ArrayList<Nadador>();
			
			int paginaInicio = Integer.parseInt(request.getParameter("jtStartIndex"));
			int nroPorPagina = Integer.parseInt(request.getParameter("jtPageSize"));
			ln = ControladorNatacion.getInstance().buscarTodosNadadores(paginaInicio, nroPorPagina);
			
			int nroNadadores = ControladorNatacion.getInstance().buscarTodosNadadores().size();
			
			Gson gson = new Gson();
			
			
			JsonElement element = gson.toJsonTree(ln, new TypeToken<ArrayList<Nadador>>() {}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			String listData=jsonArray.toString();
	
			listData="{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+nroNadadores+"}";					
			response.setContentType("application/json");
			response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
			response.getWriter().print(listData);
			System.out.println(listData);
		}
		catch(Exception ex){
			String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace()+"}";
			response.getWriter().print(error);
			System.out.println(error);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

