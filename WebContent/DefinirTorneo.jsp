<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="entidades.Torneo"
	import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestion de Torneos</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->

<link rel="stylesheet" href="css/miestilo.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<%@ include file = "PaginaPpal.jsp" %>

	<section id="wrap"> <section id="wrapper"> <!-- Sidebar -->
	

	<div class="row">

		<div class="col-md-12">

			<form action="btnDefinirTorneo" method="POST" name="formTorneo">
				<% ArrayList<Torneo> listaTorneos =(ArrayList<Torneo>) session.getAttribute("listaTorneos"); %>
				<label>Seleccione un Torneo con el cual trabajar:</label> <select
					id="torneo" name="torneo">
					<% for(int i=0; i < listaTorneos.size(); i++)
                    	{
                    	%>
					<option value="<%= listaTorneos.get(i).toString() %>"><%= listaTorneos.get(i).toString() %></option>
					<%
                    	}
                        %>
				</select> <label>El torneo que elija sera utilizado por defecto en el
					programa para el resto de los modulos, puede optar por no elegir un
					torneo, y se deshabilitaran algunos de los modulos</label> <br>
				<button class="boton-pers">No elegir Torneo</button>
				<input class="boton-pers" type="submit" value="Elegir Torneo">


			</form>

		</div>

	</div>

	</section> </section>

	<!-- /#sidebar-wrapper -->

	<!-- Page Content -->





	<!-- /#page-content-wrapper -->










	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>
</html>