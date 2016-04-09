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

import entidades.Club;
import entidades.Nadador;
import entidades.Programa;
import entidades.Torneo;
import negocio.ControladorNatacion;

@WebServlet("/CargarGrillaTorneos")
public class CargarGrillaTorneos extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public CargarGrillaTorneos() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		Gson gson = new Gson();										
		if(action.equals("list"))
		{		
			try
			{
				ArrayList<Torneo> ln = new ArrayList<Torneo>();
				//Paginado
				int paginaInicio = Integer.parseInt(request.getParameter("jtStartIndex"));
				int nroPorPagina = Integer.parseInt(request.getParameter("jtPageSize"));
				//Datos
				ln = ControladorNatacion.getInstance().buscarTorneos(paginaInicio, nroPorPagina);					
				int nroNadadores = ControladorNatacion.getInstance().buscarTorneos().size();
				//Gson-Json
				JsonElement element = gson.toJsonTree(ln, new TypeToken<ArrayList<Nadador>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();			
				listData="{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+nroNadadores+"}";					
				response.setContentType("application/json");
				response.setHeader("Cache-control", "no-cache, no-store");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Expires", "-1");
				response.getWriter().print(listData);
				System.out.println(listData); //por ahora esto está para ver las salidas del JSON
			}
			catch(Exception ex)
			{
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace()+"}";
				response.getWriter().print(error);
				System.out.println(error);//por ahora esto está para ver las salidas del JSON
			}
		}
		else if(action.equals("create") || action.equals("modify"))
		{
			//Traigo datos de la grilla
			//Esto sirve para el create y para el modify
			Torneo torneo = new Torneo();
			String fecha = request.getParameter("fechaCreate"), 
					nroPrograma = request.getParameter("programa"),
					nroClub = request.getParameter("club"),
					nroTorneo = request.getParameter("nroTorneo");
			if(nroTorneo != null)
				torneo.setNroTorneo(Integer.parseInt(nroTorneo));
			torneo.setFecha(fecha);
			torneo.setNroPrograma(Integer.parseInt(nroPrograma));
			torneo.setNroClub(Integer.parseInt(nroClub));
			
			if(action.equals("create"))
			{
				//Los guardo en la DB
				ControladorNatacion.getInstance().cargarTorneo(torneo.getFecha(), torneo.getNroPrograma(), torneo.getNroClub());
				//Devuelvo el OK, para que muestre el cartel
				String json=gson.toJson(torneo);
				String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";
				response.getWriter().print(listData);
			}
			else if(action.equals("modify"))
			{
				//Los guardo en la DB
				ControladorNatacion.getInstance().modificarTorneo(torneo.getNroTorneo(), torneo.getFecha(), torneo.getNroPrograma(), torneo.getNroClub());
				//Devuelvo el OK, para que muestre el cartel
				String json=gson.toJson(torneo);
				String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";
				response.getWriter().print(listData);
			}
		}
		else if(action.equals("delete"))
		{
			String nroTorneo = request.getParameter("nroTorneo");
			ControladorNatacion.getInstance().eliminarTorneo(Integer.parseInt(nroTorneo));
			String listData="{\"Result\":\"OK\"}";
			response.getWriter().print(listData);
		}
		else if(action.equals("buscarClubes"))
		{
			ArrayList<Club> lc = ControladorNatacion.getInstance().buscarClubes();
			
			String listData = "";
			
			for(int i = 0; i<lc.size(); i++)
			{
				Club c = lc.get(i);
				if (lc.size() == 1)
					listData = "{\"DisplayText\":" +"\"" +c.getNombre() + " " + c.getLocalidad()+"\","+"\"Value\":"+"\""+c.getNroClub()+"\"}";
				else
				{
					if (i != lc.size()-1)
						listData = listData + "{\"DisplayText\":" +"\"" +c.getNombre()+ " " + c.getLocalidad() +"\","+"\"Value\":"+"\""+c.getNroClub()+"\"},";
					else
						listData = listData + "{\"DisplayText\":" +"\"" +c.getNombre()+ " " + c.getLocalidad() +"\","+"\"Value\":"+"\""+c.getNroClub()+"\"}";
				}
			}


			listData="{\"Result\":\"OK\",\"Options\":"+ "[" +listData+ "]" +"}";
			response.setContentType("application/json");
			response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
			response.getWriter().print(listData);
			System.out.println(listData);//por ahora esto está para ver las salidas del JSON
		}
		else if(action.equals("buscarProgramas"))
		{
			ArrayList<Programa> lp = ControladorNatacion.getInstance().buscarTodosProgramas();
			
			String listData = "";
			
			for(int i = 0; i<lp.size(); i++)
			{
				Programa p = lp.get(i);
				if (lp.size() == 1)
					listData = "{\"DisplayText\":" +"\"" +p.getNroPrograma() + " " + p.getDescripcion()+"\","+"\"Value\":"+"\""+p.getNroPrograma()+"\"}";
				else
				{
					if (i != lp.size()-1)
						listData = listData + "{\"DisplayText\":" +"\"" +p.getNroPrograma() + " " + p.getDescripcion() +"\","+"\"Value\":"+"\""+p.getNroPrograma()+"\"},";
					else
						listData = listData + "{\"DisplayText\":" +"\"" +p.getNroPrograma() + " " + p.getDescripcion() +"\","+"\"Value\":"+"\""+p.getNroPrograma()+"\"}";
				}
			}


			listData="{\"Result\":\"OK\",\"Options\":"+ "[" +listData+ "]" +"}";
			response.setContentType("application/json");
			response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
			response.getWriter().print(listData);
			System.out.println(listData);//por ahora esto está para ver las salidas del JSON
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
