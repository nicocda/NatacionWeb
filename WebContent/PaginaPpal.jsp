

<!DOCTYPE html>
<html lang="en">

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
   

</head>

<body>

<header>
    <div id="subheader">
        <div id="logotipo"><p><a href="PaginaPpal.jsp">Natacion</a></p></div>
            <nav>
                <ul>
                    <li><a href="PaginaPpal.html">Inicio</a></li>
                    <li><a href="Ingresar.html">Ingresar</a></li>
                    <li><a href="">Contacto</a></li>
                </ul>    
            </nav>
    </div>
    <div id="menu">
        <script type="text/javascript"> $("#menu").load("Menu.html"); </script>
    </div>
</header>
<%@ include file="Menu.html"%>



    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>

</html>
