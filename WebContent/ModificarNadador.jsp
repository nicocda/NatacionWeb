<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import = "java.util.ArrayList"
	import = "entidades.Club"
	import = "entidades.Nadador"
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
	<%@ include file = "Header.jsp"%>
	
<div id="wrapper">
	<%@ include file = "SideBarMenu.jsp"%>
		<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
						<H3>Editar nadador</H3>
					</div>
						
						<!-- Abajo de este tag va el contenido -->
						<form id= "form" action ="ABMNadador" method ="post">
							<% ArrayList<Club> clubes = (ArrayList<Club>) session.getAttribute("listaClubes");
							%>
							<% ArrayList<Nadador> nadadores = (ArrayList<Nadador>) session.getAttribute("listaNadadores");
							%>
							<label>Seleccione un nadador de la lista:</label>
							<select name = "cbNadadores" class = "comboBox">
								<% 
				            	for(Nadador n : nadadores)
				            	{           	
				            	%>
				            		<option value="<%= n.getDni()%>"><%= n.getDni() + " " + n.getNombre() + " " + n.getApellido()%> </option>           		
				            	<%
				            	}
				            	%>			
							</select>
							<!-- Hay que llenar todos estos txtBox con los datos de quien elije editar -->
							<input type = "text" name = "txtDNI" class = "txtBox" value = "" placeholder = "Ingrese DNI del nadador">
							<input type = "text" name = "txtNombre" class = "txtBox" value = "" placeholder = "Ingrese nombre del nadador">
							<input type = "text" name = "txtApellido" class = "txtBox" value = "" placeholder = "Ingrese apellido del nadador">
							<input type = "text" name = "txtNacimiento" class = "txtBox" value = "" placeholder = "Ingrese nacimiento del nadador">
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
							<input type = "submit" name = "btnModificar" class = "botones" value = "Guardar">
							<input type = "submit" name = "btnCancelar" class = "botones" value = "Cancelar">
						</form>
					 </div>
						
						 	<div class="col-md-12 footer">
				              <!-- Abajo de este tag va el footer -->
				              <ul class="nav navbar-nav"><li><a href="">Link</a></li><li><a href="">Link</a></li><li><a href="">Link</a></li></ul>
				            </div>
			</div>
	</div>
</body>
</html>