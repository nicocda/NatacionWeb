package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import entidades.Carrera;
import entidades.Nadador;
import entidades.Torneo;
import negocio.ControladorNatacion;


@WebServlet("/CargarGrillaNoInscriptosAIndividual")
public class CargarGrillaNoInscriptosAIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CargarGrillaNoInscriptosAIndividual() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			int pushSelCarrera = Integer.parseInt(request.getParameter("push"));
			if (pushSelCarrera == 1)
			{
				ArrayList<Nadador> ln = new ArrayList<Nadador>();
				
				int paginaInicio = Integer.parseInt(request.getParameter("jtStartIndex"));
				int nroPorPagina = Integer.parseInt(request.getParameter("jtPageSize"));
				int nroCarrera = Integer.parseInt(request.getParameter("nroCarrera"));
				int nroPrograma = ControladorNatacion.getInstance().getTorneoActual().getNroPrograma();
				Carrera carSel = ControladorNatacion.getInstance().buscarCarrera(nroCarrera, nroPrograma);
				Torneo torActual =  ControladorNatacion.getInstance().getTorneoActual();
	
				ln = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carSel, torActual.getNroTorneo(), paginaInicio, nroPorPagina);
				
				int nroNadadores = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carSel, torActual.getNroTorneo()).size();
				
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
		}
		catch(Exception ex){
			String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace()+"}";
			response.getWriter().print(error);
			System.out.println(error);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
