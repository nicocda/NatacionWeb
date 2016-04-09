<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="entidades.Carrera"
    import="entidades.Usuario"
    import="util.TipoUsuarios"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte Nadador</title>

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
		                <h3>Reporte de Nadadores Inscriptos en el torneo</h3>
		              </div>
	              	  
	              	  <!-- Abajo de este tag va el contenido -->
	              	  <%if (usuarioActual.getTipoUsuario() == TipoUsuarios.ADMIN.ordinal()+1 || usuarioActual.getTipoUsuario() == TipoUsuarios.MANAGER.ordinal()+1) 
	              	  { %>
	              		  <form action="reports" method="post">
		              	  <input type="submit" class="botones" name="reporteNadadores" value="Generar Reporte de Nadadores"/>
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