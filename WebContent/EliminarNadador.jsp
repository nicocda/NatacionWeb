<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import = "java.util.ArrayList"
	import = "entidades.Nadador"
	import = "entidades.Usuario"
	import = "util.TipoUsuarios"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/miestilo2.css">
<title>Gestion de Torneos</title></head>
<body>
<!-- Menú Herencia Visual -->
	<%@ include file = "Header.jsp"%>
	
<div id="wrapper">
	<%@ include file = "SideBarMenu.jsp"%>
		<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
							<H3>Eliminar nadador</H3>
						</div>
					<!-- Abajo de este tag va el contenido -->	
	              	<%if (usuarioActual.getTipoUsuario() == TipoUsuarios.ADMIN.ordinal()+1) 
	              	{ %>
						<form id= "form" action ="ABMNadador" method ="post">
							<label>Seleccione un nadador de la lista:</label>
							<% ArrayList<Nadador> nadadores = (ArrayList<Nadador>) session.getAttribute("listaNadadores");
							%>
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
							<input type = "submit" name = "btnEliminar" class = "botones" value = "Eliminar">
							<input type = "submit" name = "btnCancelar" class = "botones" value = "Cancelar">
						</form>
					<%} 
					else
					{%>
						<p>El usuario no dispone de suficientes permisos para ingresar en esta página</p>
					<%}%>
				</div>
				
						
	       </div>
       </div>
				      
</body>
</html>