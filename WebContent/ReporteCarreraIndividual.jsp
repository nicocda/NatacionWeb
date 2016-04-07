<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="entidades.Carrera"
    import="entidades.Serie"
    import="entidades.Inscripcion"
    import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte Carrera </title>
</head>
<body>
<%ArrayList<Serie> series = (ArrayList<Serie>)request.getAttribute("series");  
		              		Carrera car = (Carrera) request.getAttribute("carrera");
							ArrayList<Inscripcion> inscriptos = (ArrayList<Inscripcion>) request.getAttribute("inscriptos");
							if(inscriptos != null)
							{%>
							 <h3>Lista de Inscriptos</h3>
							<label><%=car.toString() %></label> <br>
									<%for(Serie ser : series)
									{ %>
										<label><%=ser.toString() %></label><br>
										 <% for(Inscripcion i : inscriptos)
											{
												if(i.getNroSerie()==ser.getNroSerie())
												{ %>
													<label><%=i %></label><br>
											<%	}
											}
									}
							}%>
</body>
</html>