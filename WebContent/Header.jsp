<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="entidades.Usuario"
	import="negocio.ControladorNatacion"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/miestilo.css">
<title>Gestiónn de Torneos</title>


</head>
<body>

<div id="header" class="navbar navbar-default navbar-fixed-top" style="background: #252932">
    <div class="navbar-header">
        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <i class="icon-reorder"></i>
        </button>
    </div>
    <nav class="collapse navbar-collapse" style="padding-left:110px;">
        <ul class="nav navbar-nav">
            <li>
                <a href="PaginaPpal.jsp" id="fondo">Página Principal</a>
            </li>
            <li>
                <a href="Contacto.jsp" id="fondo">Contacto</a>
            </li>
        </ul>	
        <ul class="nav navbar-nav" style="padding-top: 12px; padding-left: 40px;">
       			<%if (ControladorNatacion.getInstance().getTorneoActual() != null)
            	{%>
            		<a id="fondo" href=MenuDefinirTorneo>Torneo:<%= ControladorNatacion.getInstance().getTorneoActual().toString() %></a>
            	<%}%>
        </ul>
        <ul class="nav navbar-nav pull-right">
			<li class="dropdown">
	              <a href="#" onclick="myFunction()" id="fondo" class="dropdown-toggle" data-toggle="dropdown">
	              <%= ((Usuario) session.getAttribute("usuarioActual")).getUsuario() %><b class="caret"></b></a>
		                <div id="myDropdown" class="dropdown-content">
		                <a href="#" style="font-weight: bold;">Opcion1</a>
					    <a href="#" style="font-weight: bold;">Opcion2</a>
					    <a href="Logout" name="cerrar" style="font-weight: bold;">Cerrar Sesión</a> 	
					    </div>
	        </li>
	     </ul>
        
       
       	
</div>
    </nav>





</body>
<script type="text/javascript" lang="JavaScript">
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropdown-toggle')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</html>