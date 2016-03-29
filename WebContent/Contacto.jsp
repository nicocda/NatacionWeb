<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->

<!-- Custom CSS -->
<link rel="stylesheet" href="css/miestilo.css">

<title>Insert title here</title>
</head>
<body>
<!-- Header -->
<!-- Content -->
<%@ include file = "Header.jsp"%>
<div id = "wrapper">

	<%@ include file = "SideBarMenu.jsp"%>
	<div id="main-wrapper" class="col-md-11 pull-right">
	            <div id="main">
		              <!-- Abajo de este tag Título -->
		              <div class="page-header">
		                <h3>Escribinos:</h3>
		              </div>
		       
		        <form action="EnviarEmail" id="contact-form" method="post" name="formEmail">
                    <label class="name">
                        <span>Su nombre:</span>
                        <input type="text" name="txtNombreEnvia">
                    </label>
                    <label class="email">
                      <span>Email:</span>
                      <input type="email" name="txtEmail">
                    </label>
                    <label class="message">
                      <span>Mensaje:</span>	
                      <textarea name="txtMensaje"></textarea>
                    </label>
                  <div style="padding-top: 40px;">
                        <button class="botones" name="borrarTexto">Borrar</button>
                        <button class="botones" name="enviarMail">Enviar</button> 
                  </div>
                </form>
                
		              
</body>
</html>