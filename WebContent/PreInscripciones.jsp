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

<title>Administraci�n de PreInscripciones</title>
</head>
<body>

<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag T�tulo -->
		              <div class="page-header">
		                <h3>�Qu� desea hacer?</h3>
		              </div>
	              	  
	              	  <!-- Abajo de este tag va el contenido -->
	              	  
	              	  	<form id= "form" action ="PreInscripcion" method ="post">
							<input class = "botones" type = "submit" name = "individual" value="PreInscripci�n a Carrera Individual"> 
							<input class = "botones" type = "submit" name = "Posta" value="PreInscripci�n a Carrera por Posta">
							<input class = "botones" type = "submit" name = "Reporte" value="Generar Reporte de PreInscripciones"> 
						</form>
	           	</div>
	        </div>

</div>

</body>
</html>