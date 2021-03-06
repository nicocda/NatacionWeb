package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import conexion.DataConnection;
import entidades.Nadador;
import entidades.Usuario;

public class CatalogoUsuario {
	
	private static CatalogoUsuario instance = null;
	public CatalogoUsuario() 
	{
	   
	}
	public static CatalogoUsuario getInstance() 
	{
		if(instance == null)
		{
			instance = new CatalogoUsuario();
		}
		return instance;
	}
	
	
	public Usuario buscarUsuario(String usuario, String password) 
	{
		String sql = "select * from usuario where usuario = ? and password = ? ";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = DataConnection.getInstancia().getConn();
		Usuario usuarioActual = null;
		
		try
		{
			sentencia=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, usuario);
			sentencia.setString(2, password);
			
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{			
				usuarioActual = new Usuario();
				usuarioActual.setUsuario(rs.getString("usuario"));
				usuarioActual.setContraseña(rs.getString("password"));
				usuarioActual.setTipoUsuario(Integer.parseInt(rs.getString("tipoUsuario")));
			}
			
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			try
			{
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnection.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
		return usuarioActual;
	}
	
	
}
