<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="negocio.ControladorNatacion"
	import="entidades.Usuario"
	import="util.TipoUsuarios"
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
  <!-- Acá tiene que ir el wrapper, pero del lado de afuera -->
  <div id="sidebar-wrapper" class="col-md-1" style="background: #252932">
            <div id="sidebar" >
                <ul class="nav list-group">
                    <%Usuario usuarioActual = (Usuario)session.getAttribute("usuarioActual");%>            
                	<li>
                		
                		
                	
                		<a id="fondo" href=MenuDefinirTorneo>Seleccionar un Torneo</a>
                		
                	</li>
	              	<%if (usuarioActual.getTipoUsuario() == TipoUsuarios.ADMIN.ordinal()+1 || usuarioActual.getTipoUsuario() == TipoUsuarios.MANAGER.ordinal()+1) 
	              	{ %>
	                    <li>
	                        <a id="fondo" href="PreInscripciones.jsp">Pre-inscripciones</a>
	                    </li>
	                    <li>
	                        <a name="menuTiempos" id="fondo" href="Tiempos">Tiempos</a>
	                    </li>
	                <%}%>
	                <%if (usuarioActual.getTipoUsuario() == TipoUsuarios.ADMIN.ordinal()+1) 
	              	{ %>
                    <li>
                        <a id="fondo" href="ABMNadador.jsp"></i>Nadadores</a>
                    </li>
                    <li>
                        <a id="fondo" href="ABMTorneo.jsp">Torneos</a>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>


</body>
</html>