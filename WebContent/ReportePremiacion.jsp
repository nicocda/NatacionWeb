<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="entidades.Carrera"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte Premiacion por Carrera</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/miestilo.css">

</head>
<body>
<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
		             
		                <h3>Reporte Premiacion por Carrera</h3>
		              </div>
	              	 <form name="form" action="reports" method="post">
	              	  <!-- Abajo de este tag va el contenido -->
	              	  <%ArrayList<Carrera> carreras = (ArrayList<Carrera>)session.getAttribute("carreras");  
	              	  if(carreras != null)
	              	  {
	              	  %>
	              	 <select name = "cbCarrera" class = "comboBox" <%if(session.getAttribute("carrera") != null) {%> value="<%=session.getAttribute("carrera")%>"<% } %>>
					<option selected disabled><<--Seleccione una carrera de la lista -->></option>
	              	  <%for(Carrera c : carreras)
	              		  {
	              		 	%>
	              		 	<option value="<%=c.getNroCarrera()%>"><%=c %></option>
              		 	<%} %>
	              	  </select>
	              	  <%} %>
	              	  <input type="submit" class="botones" name="reportePremiacion" value="Seleccionar Carrera y Generar Reporte"/>
	              	  </form>
              	 </div>
   	</div>
</div>
</body>
</html>