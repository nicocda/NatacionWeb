<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import = "entidades.Usuario"
	import= "util.TipoUsuarios"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Torneos</title>

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

<script src="js/tablaTorneos.js" type="text/javascript"></script>
</head>
<body>

<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag T�tulo -->
		              <div class="page-header">
		                <h3>Si se les ocurre alg�n t�tulo...:</h3>
		              </div>
		              <%Usuario usuarioActual = (Usuario)session.getAttribute("usuarioActual"); %>
	              	  <%if (usuarioActual.getTipoUsuario() == TipoUsuarios.ADMIN.ordinal()+1) 
	              	  { %>
	              	  <!-- Abajo de este tag va el contenido -->
	             	  <div id = "tablaTorneos"></div>
	             	  <%}
					  else
	             	  {
	             	  	%>
	             	  	<a>Puto</a>
	             	  <% 
	             	  }
	             	  %>
	             </div>
	 </div>
</div>

</body>
</html>