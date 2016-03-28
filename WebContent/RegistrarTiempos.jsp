<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="java.util.ArrayList"
import="entidades.Carrera"
import="entidades.Serie"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
		                <h3>¿Qué desea hacer?</h3>
		              </div>
		              <form action="Tiempos" method="post" name="form">
		              
		              <% ArrayList<Carrera> carreras = (ArrayList<Carrera>) session.getAttribute("carrerasTiempos");
		              if(carreras != null) {%>
		              <select name="cbCarreras">
		              <% for(Carrera car: carreras){ %>
		              <option value="<%= car.getNroCarrera()%>"> <%=car %></option>
		              
		              <%} %>
		              </select>
		              <%} %>
		            
		              <input type="submit" class="botones" value="Elegir Carrea" name="selCarrera">
		              
		             <% ArrayList<Serie> series = (ArrayList<Serie>) session.getAttribute("seriesCarrera");
		             if(series != null){%>
		              <select name="cbSeries">
		              <% for(Serie ser: series){ %>
		              <option value="<%= ser.getNroSerie()%>"> <%=ser %></option>
		              
		              <%} %>
		              </select>
		              <%} %>
		              
		              
		              <%for (int i = 0; i<3; i++){%>
		             
		              <div class="row" style="padding:10px;">
		              <label class="col-md-2">Andarivel 1:</label>
		              <label class="col-md-4"><--Nadador--></label>
		              <input class="col-md-5" name="txtTiempo1"></input>
		              </div>
						<%} %>
		              
		              
		              
		              </form>
		        </div>
	</div>
</div>
</body>
</html>