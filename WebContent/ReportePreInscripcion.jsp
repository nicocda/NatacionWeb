<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="entidades.Carrera"
    import="entidades.Torneo"
    import="entidades.Club"
    import="entidades.Serie"
    import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->

<link rel="stylesheet" href="css/miestilo.css">

</head>
<body>
	<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	

	
	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
	             <div class="page-header">
		                <h1><label>Reporte de Series por Carrera</label></h1>
		                <%
		                Torneo torActual=(Torneo)session.getAttribute("Torneo");
		                Carrera car = (Carrera)session.getAttribute("carrera");
		                Club club = (Club) session.getAttribute("club");
		                ArrayList<Serie> series= (ArrayList<Serie>) session.getAttribute("series");%>
		                <div>
		                Torneo: <%=torActual.getFecha()%> NroCarrera: <%=car.getNroCarrera()%> Metros: <%=car.getMetros()%>mts Estilo:<%=car.getEstilo() %> Edad:<%=car.getCategoria() %> Sexo: <%=car.getSexo() %>
		                <br>
		               	NroPrograma: <%=car.getNroPrograma() %> Club Anfitrion: (<%=club.getAbreviacion() %>) <%=club.getNombre() %> - <%=club.getLocalidad() %> 
		                </div>
		                <div>
		                <% for(Serie s : series) 
		                {
		               %>
		               <h3>Nro.Serie:</h3> <%=s.getNroSerie() %>
		               <h4>Andarivel Nombre y Apellido Club Edad Tiempo</h4>
		              
		               <%} %></div>
		         </div>
		        </div>
    </div>
</div>
</body>
</html>