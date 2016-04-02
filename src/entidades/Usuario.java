package entidades;

public class Usuario 
{
	private String usuario, contraseña;
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

	public String getContraseña() 
	{
		return contraseña;
	}

	public void setContraseña(String contraseña) 
	{
		this.contraseña = contraseña;
	}
}
