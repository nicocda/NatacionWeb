package entidades;

public class Usuario 
{
	private String usuario, contrase�a;
	private int tipoUsuario;

	public int getTipoUsuario() 
	{
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) 
	{
		this.tipoUsuario = tipoUsuario;
	}

	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public String getContrase�a() 
	{
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) 
	{
		this.contrase�a = contrase�a;
	}
}
