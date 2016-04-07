<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="entidades.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
	             <div class="page-header">
		                <h3>Bienvenido</h3>
		                <h3>Has sido logueado como: <%= ((Usuario) session.getAttribute("usuarioActual")).getUsuario() %></h3>
		         </div>
		         <div class="page-header">
		         		<h3>[Boton Seleccionar un Torneo]</h3>
		              	<h4 style="font-weight: bold;">El boton seleccionar torneo es el principal boton, si no se selecciona un torneo el sistema informará que se debe seleccionar uno.
		              	Una vez seleccionado aparecerá en la parte superior para saber sobre que torneo estamos, luego se puede realizar cualquier funcion [Pre inscribir nadador - Generar Series - Registrar Tiempos]	</h4>
		         </div>	
		         <div class="page-header">
		              	<h3>[Boton Pre-Inscripciones]: posee tres funciones:</h3>
		              	1 - Pre Inscripcion a Carrera Individual--> Preinscribir nadadores eligiendo una carrera predeterminada, posteriormente cuando se decidio que no correrán mas nadadores, se generan las series de esa carrera haciendo click en Generar Series<br></br>
		              	2 - Pre Inscripcion a Carrera Posta --> Preinscribir nadadores eligiendo una carrera posta, agregando los cuatro nadadores que la correrán, al presionar el boton agregar equipo el sistema muestra los equipos de posta en la parte inferior<br></br> 
		              	3 - Generar Reportes de Series --> Una vez que se generaron las series de una carrera, se generará el reporte de la carrera que usted seleccione. Atencion! Si no se genero ninguna carrera el sistema le informara ya que es necesario previamente generar la carrera.
		              	</p>
		             
		         </div>
		         <div class="page-header">
		         		<h3>[Boton Tiempos]</h3>
		         		<p>
		         		Este boton permite cargar los tiempos de cada nadador una vez que se terminó de correr una carrera.
		         		<p>[Secuencia de pasos]</p>
		         		1- Se selecciona la carrera donde se cargarán los tiempos<br></br>
		         		2- Se selecciona una serie de esa carrera, luego aparecerán los nadadores que corrieron en esa serie.<br></br>
		         		3- Se ingresa el tiempo de cada nadador, una vez cargados se presiona el boton Registrar Tiempos
		         		</p>
		         </div>
		         <div class="page-header">
		         <h3>[Botones Nadadores y Torneos]</h3>
		         <p>Este es el lugar para agregar nuevos nadadores y torneos que no están cargados en el sistema, tambien se puede eliminarlos y modificarlos en caso de haberlos cargado mal.</p>
		         
		         
		         </div>
	            </div>
	            
	         
	 </div>         	  
</div>
</body>
</html>