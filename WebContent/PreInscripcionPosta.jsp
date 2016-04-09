<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="entidades.Carrera"
    import="entidades.Nadador"
    import="entidades.Usuario"
    import="util.TipoUsuarios"
    import="entidades.NadadorCarreraPosta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pre Inscripcion por Postas</title>
</head>
<body>
	<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
<div id="main-wrapper" class="col-md-11 pull-right">
		<div id="main">
	   	  	<%if (usuarioActual.getTipoUsuario() == TipoUsuarios.ADMIN.ordinal()+1 || usuarioActual.getTipoUsuario() == TipoUsuarios.MANAGER.ordinal()+1) 
	   	  	{ %>
				<div class = "row">
	
				<form name="form" action="PreInscripcionPosta" method="post">
					<div class='col-lg-12'>
						
						<br> <label>Carrera: &nbsp;&nbsp;</label>
						<select name = "cbCarrera" class = "comboBox" <%if(session.getAttribute("carrera") != null) {%> value="<%=session.getAttribute("carrera")%>"<% } %>>
						<option selected disabled><<--Seleccione una carrera de la lista -->></option>
						<% ArrayList<Carrera> carreras = (ArrayList<Carrera>) session.getAttribute("carreras");
						for(Carrera car : carreras)
						{ %>
							<option value="<%=car.getNroCarrera()%>"><%=car %></option>
						<%}
						%>
						</select>
						<button class="boton-pers" type="submit" name="selCarrera">Seleccionar Carrera</button>
					</div>
				
					<div class='col-md-6'>
							<h3>Nadadores no Inscriptos</h3>
								<select multiple name="nadadores" size="8">
										<%
										Nadador equipo[];
										equipo = (Nadador[])session.getAttribute("equipo");
										ArrayList<Nadador> nadadores = (ArrayList<Nadador>) session.getAttribute("nadadores");
										if(session.getAttribute("nadadores")!=null)
										{
											for(Nadador n : nadadores)
											{ 
												if(equipo!=null)
												{	
													boolean bandera=false;
													for(int i=0;i<4;i++)
													{	
														if(equipo[i] != null)
														{
															if(equipo[i].getDni()==n.getDni())
															{
																 bandera= true;
															}
														}
													}
													if(bandera==false)
													{
														 %><option value="<%=n.getDni() %>"><%=n %></option> <%
													}
												}else {
													 %><option value="<%=n.getDni() %>"><%=n %></option><%
												}
											}
										} %>
								</select>
								<button class="boton-pers" type="submit" name="selNadador">Seleccionar Nadador</button>
					</div>
					<div class='col-md-6'>
					<h3>Equipo</h3>
						<%	if(session.getAttribute("equipo")!= null)
								{
									for(int i=0;i<equipo.length;i++)
									{
										%>
										<label>Nadador <%=i+1 %>: </label>
									<% if(equipo[i]==null) {%>
									<label>Seleccione un Nadador</label>
									<%} else { %>
									<label><%=equipo[i] %></label><% 
											 }
											 if(equipo[i]!= null)
											 {%>
									<button class="boton-pers" type="submit" name="<%=i%>">Quitar</button>
									
								<% 			 }%>
								<br>
								<%}
										if(equipo[0]!=null && equipo[1]!=null && equipo[2]!=null && equipo[3]!=null)
										{%>
											<button class="boton-pers" type="submit" name="addEquipo">AgregarEquipo</button>
								<%	}
								}%>
					</div>
			
				<div class='col-lg-12'>
				<%ArrayList<NadadorCarreraPosta> equipoInsc = (ArrayList<NadadorCarreraPosta>)session.getAttribute("InscEquipo");
			if(equipoInsc != null) 
			{
				if(!equipoInsc.isEmpty())
				{%>
							<h3>Equipos Inscriptos</h3>
							<table border="1">
								<tr>
									<th>Nadador 1</th>
									<th>Nadador 2</th>
									<th>Nadador 3</th>
									<th>Nadador 4</th>
								</tr>
										<%
											for(NadadorCarreraPosta team : equipoInsc)
											{%>
										<tr>
											<td><%= team.getDniNadador1() %></td>
											<td><%= team.getDniNadador2() %></td>
											<td><%= team.getDniNadador3() %></td>
											<td><%= team.getDniNadador4() %></td>
										</tr>
									<%		}	%>
										
			 	 <%}else
			 	 {%>
			 		<tr>
					<td>&nbsp</td><td>&nbsp</td><td>&nbsp</td><td>&nbsp</td>
				</tr>
				
			 	<% }%>
			 	<div><button class="boton-pers" name="quitarEquipo">Quitar Equipo</button>
				<button class="boton-pers" name="genSerie">Generar Serie</button></div>
			 	</table>
			 <%}%>
					</div>
				</form>
</div>

	<%} 
	else
	{%>
		<p>El usuario no dispone de suficientes permisos para ingresar en esta página</p>
	<%}%>

</div>
</div>
</div>
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