function validarDatos(){
	var usuario = document.getElementById("login");
	var pass = document.getElementById("password");
	if((usuario.value == "" || usuario.value == '' || usuario.value == null || usuario.value == "Usuario") && (pass.value == "" || pass.value == '' || pass.value == null || pass.value == "Password"))
	{
		alert("Ingrese su usuario y password");
		usuario.focus();
		return false;
	} 
	else if(usuario.value == "" || usuario.value == '' || usuario.value == null || usuario.value == "Usuario")
	{
		alert("Ingrese su usuario");
		usuario.focus();
		return false;
	}
	else if(pass.value == "" || pass.value == '' || pass.value == null || pass.value == "Password")
	{
		alert("Ingrese su password");
		pass.focus();
		return false;
	}
	else 
	{
		return true;
	}
	
					}
function carga(){
	document.getElementById("login").focus();
				}
				