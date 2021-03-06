package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import conexion.DataConnection;
import entidades.Torneo;

public class CatalogoTorneos {
	
	private static CatalogoTorneos instance = null;
	public CatalogoTorneos() 
	{
	   
	}
	public static CatalogoTorneos getInstance() 
	{
		if(instance == null)
		{
			instance = new CatalogoTorneos();
		}
		return instance;
	}

	public void eliminarTorneo(int nroTorneo)
	{
		String sql="delete from torneo where nroTorneo=?";
		PreparedStatement sentencia= null;
		Connection con= DataConnection.getInstancia().getConn();
		try
		{
			sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, nroTorneo);
			sentencia.executeUpdate();
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
	}
	
	public void registrarTorneo(String fecha, int nroTorneo, int nroPrograma, int nroClub)
	{
		String sql="insert into torneo values (?,?,?,?);";
		PreparedStatement sentencia=null;
		Connection con= DataConnection.getInstancia().getConn();
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			String fechaLarga = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, nroTorneo);
			sentencia.setInt(3, nroPrograma);
			sentencia.setString(2, fechaLarga);
			sentencia.setInt(4, nroClub);
			sentencia.executeUpdate();
		}
		catch(SQLException | ParseException e)
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
	}
	
	public ArrayList<Torneo> buscarTorneos()
	{
		ArrayList<Torneo> lt = new ArrayList<Torneo>();
		String sql="Select * from torneo t inner join club c on c.nroClub=t.nroClub";
		Statement sentencia = null;
		ResultSet rs = null;
		Connection con = DataConnection.getInstancia().getConn();
		try{
			sentencia = con.createStatement();
			rs=sentencia.executeQuery(sql);
			while(rs.next())
			{
				Torneo t = new Torneo();
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("fechaTorneo"));
				String stringCorto = new SimpleDateFormat("dd/MM/yyyy").format(date);
				t.setNroTorneo(rs.getInt("nroTorneo"));
				t.setNroClub(rs.getInt("nroClub"));
				t.setNroPrograma(rs.getInt("nroPrograma"));
				t.setFecha(stringCorto);
				t.setNombreClub(rs.getString("nombre"));
				lt.add(t);
			}
		}
		catch(SQLException | ParseException e)
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
		return lt;
	}
	
	public ArrayList<Torneo> buscarTorneos(int paginaInicio, int nroPorPagina)
	{
		ArrayList<Torneo> lt = new ArrayList<Torneo>();
		String sql="Select * from Torneo t inner join club c on c.nroClub=t.nroClub limit ? , ? ";
		PreparedStatement sentencia=null;
		ResultSet rs = null;
		Connection con = DataConnection.getInstancia().getConn();
		try
		{
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, paginaInicio);
			sentencia.setInt(2, nroPorPagina);
			rs=sentencia.executeQuery();
			while(rs.next())
			{
				Torneo t = new Torneo();
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("fechaTorneo"));
				String stringCorto = new SimpleDateFormat("dd/MM/yyyy").format(date);
				t.setNroTorneo(rs.getInt("nroTorneo"));
				t.setNroClub(rs.getInt("nroClub"));
				t.setNroPrograma(rs.getInt("nroPrograma"));
				t.setFecha(stringCorto);
				t.setNombreClub(rs.getString("nroClub"));
				lt.add(t);
			}
		}
		catch(SQLException | ParseException e)
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
		return lt;
	}
	
	public int ultimoNroTorneo()
	{
		String sql="select max(nroTorneo) from torneo";
		Statement sentencia = null;
		ResultSet rs = null;
		int max=0;
		try
		{
			sentencia= DataConnection.getInstancia().getConn().createStatement();
			rs=sentencia.executeQuery(sql);
			if(rs.next())
			{
				max=rs.getInt("max(nroTorneo)");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return max;
	}
	public Torneo buscarTorneo(int nroTorneo) {
		String sql="select * from torneo t inner join club c on c.nroClub=t.nroClub where nroTorneo=? ";
		PreparedStatement sentencia= null;
		Connection con= DataConnection.getInstancia().getConn();
		ResultSet rs = null;
		Torneo t = new Torneo();
		try
		{
			sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, nroTorneo);
			rs=sentencia.executeQuery();
			if(rs.next())
			{
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("fechaTorneo"));
				String stringCorto = new SimpleDateFormat("dd/MM/yyyy").format(date);
				t.setNroTorneo(rs.getInt("nroTorneo"));
				t.setNroClub(rs.getInt("nroClub"));
				t.setNroPrograma(rs.getInt("nroPrograma"));
				t.setNombreClub(rs.getString("nombre"));
				t.setFecha(stringCorto);
			}
		}
		catch(SQLException | ParseException e)
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
		return t;
	}
	public void modificarTorneo(int nroTorneo, String fecha, int nroPrograma, int nroClub)
	{
		String sql = "UPDATE torneo set fechaTorneo=?, nroClub=?, nroPrograma=? where nroTorneo=? ";
		PreparedStatement sentencia = null;
		Connection con = DataConnection.getInstancia().getConn();
		try
		{
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			String fechaLarga = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
			sentencia.setString(1, fechaLarga);
			sentencia.setInt(2, nroClub);
			sentencia.setInt(3, nroPrograma);
			sentencia.setInt(4, nroTorneo);
			sentencia.executeUpdate();
		}
		catch(SQLException | ParseException e)
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
	}
}
