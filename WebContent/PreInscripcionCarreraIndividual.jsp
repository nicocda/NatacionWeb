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


</head>

<body>
<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
		<div id="main">
			<div class = "row">
				<div class = "col-lg-12">

					<form>
						<div class='col-lg-12'>
						<%
						//Torneo torActual =  (Torneo) session.getAttribute("torneo");
						Torneo torActual = new Torneo(); torActual.setNroTorneo(1); torActual.setNroPrograma(2);
						ControladorNatacion cn = new ControladorNatacion();
						int nroPrograma = torActual.getNroPrograma();
						int nroTorneo = torActual.getNroTorneo();
						ArrayList <Carrera>  carreras= cn.buscarCarreraProgramaNoCargadas(nroPrograma, nroTorneo);
						%>
							<label>Carrera: &nbsp;&nbsp;</label>
							<select name="cbCarrera" class = "comboBox">
							<% for (Carrera c : carreras)
								{
								%>
								<option value="<%= c.getNroCarrera()%>"> <%= c%> </option> 
								<% } %>
									</select>
					<button class="boton-pers"
								onClick=" window.location.href='selCarrera' ">Seleccionar Carrera</button>
						</div>
						<div class="col-md-4">
						<%
							ArrayList <Nadador> nadNoInsc = (ArrayList <Nadador>) session.getAttribute("nadNoInsc");
							ArrayList <Nadador> nadInsc = (ArrayList <Nadador>) session.getAttribute("nadInsc");
						%>
						<h3>Nadadores no Inscriptos</h3>
						<select name="nadNoInsc" multiple size="8">
						<% if(session.getAttribute("nadNoInsc") != null) { 
							for (Nadador n : nadNoInsc)
								{
								%>
								<option value="<%= n.getDni()%>"><%= n.getDni()%> </option> 
								<% } %>
									</select>
							<% } %>
							</select>
						</div>
						<div class="col-md-4">
						<br><br><br><br><br><br><br><br>
							<button class="boton-pers"
								onClick=" window.location.href='pagina_siguiente.html' ">Agregar
								>></button><br>
							<button class="boton-pers"><< Quitar</button><br>
							<button class="boton-pers"
								onClick=" window.location.href='pagina_siguiente.html' ">Generar Series</button>
						</div>
						<div class="col-md-4">
							<h3>Nadadores Inscriptos</h3>
							<select name="nadInsc" multiple size="8">
						<% if(session.getAttribute("nadInsc") != null) {
							for (Nadador n : nadInsc)
								{
								%>
								<option value="<%= n.getDni()%>"><%= n%> </option> 
								<% } %>
									</select>
							<% } %>
							</select>
						</div>
					</form>
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