<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/miestilo.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ocurrió un error!</title>
</head>
<body>

<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
		                <h3>Error: </h3>
		              </div>    	  
	              	  <!-- Abajo de este tag va el contenido -->
	              	  <p>Ocurrió el siguiente error: <%= request.getAttribute("mensajeError")%></p>
	              	  </div>
	        </div>

</div>
	              	  

</body>
</html>