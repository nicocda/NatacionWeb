<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PreInscripcion a Carrera Individual</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Custom CSS -->

<link rel="stylesheet" href="css/miestilo.css">


</head>

<body>
	<%@ include file = "PaginaPpal.jsp" %>



	<form>
		<div class='col-lg-9'>
			<label>Torneo: &nbsp;&nbsp;</label> <select><option>torneo1</option></select>
			<br> <label>Carrera: &nbsp;&nbsp;</label><select><option>Carrera1</option></select>

		</div>
		<div class='col-lg-3'>
			<button class="boton-pers">Cambiar Torneo</button>
		</div>
		<br> <br>
		<div class="col-md-4">
			<h3>
				Nadadores no Inscriptos
				</h1>
				<br> <select multiple size="12">
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>Juan Perez</option>
					<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				</select>
		</div>
		<div class="col-md-4">
			<br> <br> <br> <br> <br> <br>
			<button class="boton-pers"
				onClick=" window.location.href='pagina_siguiente.html' ">Agregar
				>></button>
			<br>
			<button class="boton-pers"><< Quitar</button>
			<br> <br> <br> <br> <input type="submit"
				name="genSerie" id="genSerie" value="Generar Series">
			<button class="boton-pers">Generar Series</button>
		</div>
		<div class="col-md-4">
			<h3>
				Nadadores Inscriptos
				</h1>
				<br> <select multiple size="12">
					<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				</select>
		</div>

	</form>

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
