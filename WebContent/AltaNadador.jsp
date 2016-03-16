<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList"
	import="entidades.Club"
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
	
<div id="wrapper">
	
	<div id="page-content-wrapper">
		<div class="container-fluid">
			<div class = "row">
				<div class = "col-lg-12">
					<center>
						<H2>Crear nuevo nadador</H2>
					</center>
						<form id= "form" action ="ABMNadador" method ="post">
							<input type = "text" name = "txtDNI" class = "txtBox" value = "" placeholder = "Ingrese DNI del nadador">
							<input type = "text" name = "txtNombre" class = "txtBox" value = "" placeholder = "Ingrese nombre del nadador">
							<input type = "text" name = "txtApellido" class = "txtBox" value = "" placeholder = "Ingrese apellido del nadador">
							<input type = "text" name = "txtNacimiento" class = "txtBox" value = "" placeholder = "Ingrese nacimiento del nadador">
							
							<% ArrayList<Club> clubes = (ArrayList<Club>) session.getAttribute("listaClubes");
							%>
							
							<label>Seleccione un club de la lista:</label>
							<select name = "cbClubes" class = "comboBox">
								<% 
				            	for(Club c : clubes)
				            	{           	
				            	%>
				            		<option value="<%= c.getNroClub()%>"><%= c.getNombre()%> </option>           		
				            	<%
				            	}
				            	%>			
				            </select>
							<label>Seleccione su sexo:</label>
							<select name = "cbSexo" class = "comboBox">
								<option value = "1"> Masculino </option>
								<option value = "2"> Femenino </option>
							</select>
							<input type = "submit" name = "btnGuardar" class = "botones" value = "Guardar">
							<input type = "submit" name = "btnCancelar" class = "botones" value = "Cancelar">
						</form>
					</div>
				</div>
			</div>
	</div>
</div>

</body>
</html>