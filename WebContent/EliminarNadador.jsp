<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" import="entidades.Nadador"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/miestilo.css">
<title>Gestion de Torneos</title>
</head>
<body>
	<!-- Menú Herencia Visual -->
	<%@ include file = "PaginaPpal.jsp" %>


	<div id="contenedor">
		<center>
			<H2>Editar nadador</H2>
		</center>
		<form id="form" action="ABMNadador" method="post">
			<label>Seleccione un nadador de la lista:</label>
			<% ArrayList<Nadador> nadadores = (ArrayList<Nadador>) session.getAttribute("listaNadadores");
			%>
			<select name="cbNadadores" class="comboBox">
				<% 
            	for(Nadador n : nadadores)
            	{           	
            	%>
				<option value="<%= n.getDni()%>"><%= n.getDni() + " " + n.getNombre() + " " + n.getApellido()%>
				</option>
				<%
            	}
            	%>
			</select> <input type="submit" name="btnEliminar" class="botones"
				value="Eliminar"> <input type="submit" name="btnCancelar"
				class="botones" value="Cancelar">
		</form>
	</div>
</body>
</html>