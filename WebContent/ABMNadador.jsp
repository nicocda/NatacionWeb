<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

<!-- Esto es para que no colapsen el menú y el contenido!!!!!! -->
	
<div id="wrapper">	
	<%String mensaje = (String)session.getAttribute("mensaje"); %>
	
	<div id="page-content-wrapper">
		<div class="container-fluid">
			<div class = "row">
				<div class = "col-lg-12">
					<center>
						<h2>¿Qué desea hacer?</h2>
						<h5 style="color:#FF0000"><%=mensaje %></h5>
					</center>
					<form id= "form" action ="ABMNadador" method ="post">
						<input class = "botones" type = "submit" name = "nuevo" value="Nuevo Nadador"> 
						<input class = "botones" type = "submit" name = "editar" value="Editar Nadador"> 
						<input class = "botones" type = "submit" name = "eliminar" value="Eliminar Nadador"> 
					</form>
				</div>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>