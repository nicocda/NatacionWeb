<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="java.util.ArrayList"
import="entidades.Carrera"
import="entidades.Serie"
import="entidades.Inscripcion"
import="entidades.Nadador"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cargar Tiempos Post Carrera</title>
</head>
<body>

<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
		                <h3>Menu Carga de Tiempo</h3>
		              </div>
		              <form action="Tiempos" method="post" name="form">
		              
		              <% ArrayList<Carrera> carreras = (ArrayList<Carrera>) session.getAttribute("carrerasTiempos");
		              if(carreras != null) {%>
		             <select name = "cbCarrera" class = "comboBox" <%if(session.getAttribute("nroCarSel") != null) {%> value= "<%=session.getAttribute("nroCarSel") %>"<% } %>>
						
					 <% 
					 for(Carrera car: carreras)
					 	{ 
					 	%>
		            	  <option value="<%= car.getNroCarrera()%>"> <%=car %></option>        
		              	<%
		              	} 
		              	%>
		              </select>
		               <input type="submit" class="botones" value="Elegir Carrea" name="selCarrera">
		              <%} %>

		             <% ArrayList<Serie> series = (ArrayList<Serie>) session.getAttribute("seriesCarrera");
		             Carrera carSeleccionada = (Carrera) session.getAttribute("carreraSeleccionadaTiempo");
		             if(carSeleccionada != null)
		             {
		             	if(!series.isEmpty())
		             		{%>
			               <select name = "cbSeries" class = "comboBox" >
						<option selected disabled><<--Seleccione una serie de la lista -->></option>
					 <% for(Serie ser: series)
			              { %>
			              	<option value="<%= ser.getNroSerie()%>"> <%=ser %></option>
			            <%} %>
			            <input type="submit" class="botones" value="Elegir Serie" name="selSerie">
			            <%
			         		 }
			         		 else
			         		 {%>
			         		 <h4>No hay Series cargadas para esta Carrera</h4>
			         	<%	 } %>
		              </select>
		              
		              <%} %>
		              
		              
		              <%
		              ArrayList<Inscripcion> insc = (ArrayList<Inscripcion>)session.getAttribute("nadadoresPorSerie");
		              ArrayList<Nadador> nadinsc = (ArrayList<Nadador>)session.getAttribute("nadadoresPorSerieNad");
		            
		              if(insc != null)  
		              { int j=0;
		              String time;
		            	  for(Inscripcion i : insc)
		            	  {
		            	   time ="txtTiempo"+j;
		            	  %>
		            		  <div class="row" style="padding:10px;">
		              <label class="col-md-2">Andarivel <%= i.getNroAndarivel() %>:</label>
		              <label class="col-md-4"><%=nadinsc.get(j).getNombre()+" "+nadinsc.get(j).getApellido() %></label>
		              <input class="col-md-5" name="<%=time %>" placeholder="  :  :  "></input>
		              </div>
		            	  <%
		            	  j++;
		            	  } 
		            	  %>
		            	<input type="submit" class="botones" value="Registrar Tiempos" name="regTiempos">
		              <%} %>
		              
		              </form>
		        </div>
	</div>
</div>
</body>
</html>