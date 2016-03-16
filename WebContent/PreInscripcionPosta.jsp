<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PreInscripcion a Carrera por Posta</title>

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

	<section id="wrap">
		<section id="wrapper">

			
			<!-- /#sidebar-wrapper -->

			<!-- Page Content -->


			<form>
				<div class='col-lg-9'>
					<label>Torneo: &nbsp;&nbsp;</label> <select><option>torneo1</option></select>
					<br> <label>Carrera: &nbsp;&nbsp;</label><select><option>Carrera1</option></select>

				</div>
				<div class='col-lg-3'>
					<button class="boton-pers">Cambiar Torneo</button>
				</div>
				<br>
				<div class='col-md-6'>
					<table>
						<tr>
							<td><button class="boton-pers">Seleccionar Nadador</button></td>
							<td><h3>Nadadores no Inscriptos</h3></td>
						</tr>
						<tr>
							<td colspain="2"><select multiple>
									<option>Soy un Nadador HOLA</option>
							</select></td>
						</tr>
					</table>
				</div>
				<div class='col-md-6'>
					<table>
						<tr>
							<td colspain="3"><h3>Equipo</h3></td>
						</tr>
						<tr>
							<td><label>Nadador 1: </label></td>
							<td><label>Seleccione un Nadador</label></td>
							<td><button class="boton-pers">Quitar</button></td>
						</tr>
						<tr>
							<td><label>Nadador 2: </label></td>
							<td><label>Seleccione un Nadador</label></td>
							<td><button class="boton-pers">Quitar</button></td>
						</tr>
						<tr>
							<td><label>Nadador 3: </label></td>
							<td><label>Seleccione un Nadador</label></td>
							<td><button class="boton-pers">Quitar</button></td>
						</tr>
						<tr>
							<td><label>Nadador 4: </label></td>
							<td><label>Seleccione un Nadador</label></td>
							<td><button class="boton-pers">Quitar</button></td>
						</tr>
						<tr>
							<td colspain="3"><button class="boton-pers">Agregar
									Equipo</button></td>
						</tr>
					</table>
				</div>
				<div class='col-sm-12'>
					<table>
						<tr>
							<td><h3>Equipos Inscriptos</h3></td>
						</tr>
						<tr>
							<table border="1">
								<tr>
									<th>Nadador 1</th>
									<th>Nadador 2</th>
									<th>Nadador 3</th>
									<th>Nadador 4</th>
									<th>Club</th>
								</tr>
								<tr>
									<td>asd</td>
									<td>asd</td>
									<td>asd</td>
									<td>asd</td>
									<td>asd</td>
								</tr>
							</table>
						</tr>
						<tr colspain="5">
							<button class="boton-pers">Quitar Equipo</button>
						</tr>
						<tr colspain="4">&nbsp;
						</tr>
						<tr>
							<button class="boton-pers">Generar Serie</button>
						</tr>

					</table>
				</div>
			</form>






			<!-- /#page-content-wrapper -->


		</section>



	</section>


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
