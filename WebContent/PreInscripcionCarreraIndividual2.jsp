<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList"
	import="entidades.Torneo"
	import="entidades.Programa"	
	import="entidades.Carrera"
	import="entidades.Nadador"
	import="negocio.ControladorNatacion"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PreInscripcion a Carrera Individual</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->

<link rel="stylesheet" href="css/miestilo.css">


<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script src="js/cargarTabla.js" type="text/javascript"></script>


</head>

<body>
<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
		<div id="main">
			<div class = "row">
				<div class = "col-lg-12">	
						<div class='col-lg-12'>
						<%
						Torneo torActual =  (Torneo) session.getAttribute("torneo");
						//Torneo torActual = new Torneo(); torActual.setNroTorneo(1); torActual.setNroPrograma(2);
						ArrayList<Carrera> carreras = (ArrayList<Carrera>) session.getAttribute("carreras");
						%>
							<label>Carrera:</label>
							<select id = "cbCarrera" class = "comboBox" <%if(session.getAttribute("carSel") != null) {%> value="<%=session.getAttribute("carSel")%>"<% } %>>
								<option selected disabled><<--Seleccione una carrera de la lista -->></option>
								<% 
				            	for(Carrera c : carreras)
				            	{           	
				            	%>
				            		<option value="<%= c.getNroCarrera()%>"><%= c%> </option>           		
				            	<%
				            	}
				            	%>		
				            </select>				
						</div>
						<div class="col-md-6">
							<div id = "NadadoresNoInscriptos" ></div>
						</div>
						
						<div class="col-md-6">
							<div id = "NadadoresInscriptos" ></div>
						</div>
						
						<div class="col-md-12">
							<br>
							<button class = "botones">Generar Series</button>
						</div>
				</div>
			</div>
		</div>
	</div>
</div>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>