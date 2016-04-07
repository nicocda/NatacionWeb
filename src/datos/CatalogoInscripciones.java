package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.DataConnection;
import entidades.Carrera;
import entidades.Inscripcion;

public class CatalogoInscripciones 
{
	
	private static CatalogoInscripciones instance = null;
	public CatalogoInscripciones() 
	{
	   
	}
	public static CatalogoInscripciones getInstance() 
	{
		if(instance == null)
		{
			instance = new CatalogoInscripciones();
		}
		return instance;
	}
	
	public void cargarTiempo(int nroTorneo, int nroPrograma, int nroCarrera, int nroSerie, String tiempo[])
	{
		PreparedStatement sentencia = null;
		Connection con = DataConnection.getInstancia().getConn();
		String sql ="UPDATE inscripcion set tiempoCompetencia=? "
				+ "where nroTorneo=? and nroPrograma=? and nroCarrera=? and nroAndarivel=? and nroSerie=?";
		try
		{
			for(int i=0; i<6; i++)
			{
				if(tiempo[i] == "  :  :  ")
				{
					tiempo[i] = "59:59:99";
				}else
				{
				tiempo[i]= "00:"+tiempo[i];
				}
					sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					sentencia.setString(1, tiempo[i]);
					sentencia.setInt(2, nroTorneo);
					sentencia.setInt(3, nroPrograma);
					sentencia.setInt(4, nroCarrera);
					sentencia.setInt(5, i+1);
					sentencia.setInt(6, nroSerie);
					sentencia.executeUpdate();
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void cargarDescalificacion(int nroTorneo, int nroPrograma, int nroCarrera, int nroSerie, ArrayList<String> descalificacion, boolean[] checkboxActive)
	{
		PreparedStatement sentencia = null;
		Connection con = DataConnection.getInstancia().getConn();
		String sql ="UPDATE inscripcion set motivoDescalificacion=? "
				+ "where nroTorneo=? and nroPrograma=? and nroCarrera=? and nroAndarivel=? and nroSerie=?";
		try
		{
			for(int i=0; i<6; i++)
			{
					sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					sentencia.setString(1, (String)descalificacion.get(i));
					sentencia.setInt(2, nroTorneo);
					sentencia.setInt(3, nroPrograma);
					sentencia.setInt(4, nroCarrera);
					sentencia.setInt(5, i+1);
					sentencia.setInt(6, nroSerie);
					sentencia.executeUpdate();
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void cargarInscripciones(int dniNadador, int nroSerie, int nroAndarivel, int nroCarrera, int nroPrograma, int nroTorneo) 
	{
		PreparedStatement sentencia = null;
		Connection con = DataConnection.getInstancia().getConn();
		String sql = "INSERT INTO inscripcion (nroNadador, nroSerie, nroAndarivel, nroCarrera, nroPrograma, nroTorneo, tiempoCompetencia, motivoDescalificacion) VALUES(?, ?, ?, ?, ?, ?, '59:59:99',' ')";
		
		try
		{
			sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, dniNadador);
			sentencia.setInt(2, nroSerie);
			sentencia.setInt(3, nroAndarivel);
			sentencia.setInt(4, nroCarrera);
			sentencia.setInt(5, nroPrograma);
			sentencia.setInt(6, nroTorneo);
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
	
	public void cargarInscripcionesPosta(int dniNadador,int dniNadador2,int dniNadador3,int dniNadador4, int nroSerie, int nroAndarivel, int nroCarrera, int nroPrograma, int nroTorneo) 
	{
		PreparedStatement sentencia = null;
		Connection con = DataConnection.getInstancia().getConn();
		String sql = "INSERT INTO inscripcion VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ' : : ',' ')";
		
		try
		{
			sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, dniNadador);
			sentencia.setInt(2, dniNadador2);
			sentencia.setInt(3, dniNadador3);
			sentencia.setInt(4, dniNadador4);
			sentencia.setInt(5, nroSerie);
			sentencia.setInt(6, nroCarrera);
			sentencia.setInt(7, nroPrograma);
			sentencia.setInt(8, nroTorneo);
			sentencia.setInt(9, nroAndarivel);
			
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
	
	public ArrayList<Inscripcion> buscarInscripcionCarrera(int nroCarrera, int nroTorneo, int nroPrograma) {
		String sql="select i.nroNadador as 'nroNadador', i.nroNadador2 as 'nroNadador2', i.nroNadador3 as 'nroNadador3', "
				+ "i.nroNadador4 as 'nroNadador4', i.nroSerie as 'nroSerie', i.nroAndarivel as 'nroAndarivel', i.nroCarrera as 'nroCarrera', "
				+ "i.nroPrograma as 'nroPrograma', i.nroTorneo as 'nroTorneo', i.motivoDescalificacion as 'motivoDescalificacion', "
				+ "i.tiempoCompetencia as 'tiempoCompetencia', n1.nombre as 'nombre1', n1.apellido as 'apellido1', "
				+ "n2.nombre as 'nombre2', n2.apellido as 'apellido2', n3.nombre as 'nombre3', "
				+ "n3.apellido as 'apellido3', n4.nombre as 'nombre4', n4.apellido as 'apellido4' "
				+ "from inscripcion i "
				+ "inner join nadador n1 on i.nroNadador=n1.dni "
				+ "left join nadador n2 on i.nroNadador2=n2.dni "
				+ "left join nadador n3 on i.nroNadador3=n3.dni "
				+ "left join nadador n4 on i.nroNadador4=n4.dni "
				+ "where nroCarrera=? and nroTorneo=? and nroPrograma=? "
				+ "order by nroSerie, nroAndarivel";
				
		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		PreparedStatement sentencia = null;
		ResultSet rs= null;
		Connection con = DataConnection.getInstancia().getConn();
		try
		{
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, nroCarrera);
			sentencia.setInt(2, nroTorneo);
			sentencia.setInt(3, nroPrograma);
			rs=sentencia.executeQuery();
			while(rs.next())
			{
				Inscripcion inscrip = new Inscripcion();
				inscrip.setNroNadador(rs.getInt("nroNadador"));
				inscrip.setNroNadador2(rs.getInt("nroNadador2"));
				inscrip.setNroNadador3(rs.getInt("nroNadador3"));
				inscrip.setNroNadador4(rs.getInt("nroNadador4"));
				inscrip.setNroSerie(rs.getInt("nroSerie"));
				inscrip.setNroAndarivel(rs.getInt("nroAndarivel"));
				inscrip.setNroCarrera(rs.getInt("nroCarrera"));
				inscrip.setNroPrograma(rs.getInt("nroPrograma"));
				inscrip.setNroTorneo(rs.getInt("nroTorneo"));
				inscrip.setMotivoDescalificacion(rs.getString("motivoDescalificacion"));
				inscrip.setTiempoCompeticion(rs.getString("tiempoCompetencia"));
				inscrip.setNombreApellidoNadador(rs.getString("nombre1")+" "+rs.getString("apellido1"));
				if(rs.getString("nombre2") != null)
				{
					inscrip.setNombreApellidoNadador2(rs.getString("nombre2")+" "+rs.getString("apellido2"));
					inscrip.setNombreApellidoNadador3(rs.getString("nombre3")+" "+rs.getString("apellido3"));
					inscrip.setNombreApellidoNadador4(rs.getString("nombre4")+" "+rs.getString("apellido4"));
				}
				inscripciones.add(inscrip);
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
		return inscripciones;
	
		
	}
	
	public ArrayList<Inscripcion> buscarInscripcionSerie(int nroSerie, int nroCarrera, int nroTorneo, int nroPrograma) {
		String sql="select i.nroNadador as 'nroNadador', i.nroNadador2 as 'nroNadador2', i.nroNadador3 as 'nroNadador3', "
				+ "i.nroNadador4 as 'nroNadador4', i.nroAndarivel as 'nroAndarivel', i.nroCarrera as 'nroCarrera', "
				+ "i.nroPrograma as 'nroPrograma', i.nroTorneo as 'nroTorneo', i.motivoDescalificacion as 'motivoDescalificacion', "
				+ "i.tiempoCompetencia as 'tiempoCompetencia', n1.nombre as 'nombre1', n1.apellido as 'apellido1', "
				+ "n2.nombre as 'nombre2', n2.apellido as 'apellido2', n3.nombre as 'nombre3', "
				+ "n3.apellido as 'apellido3', n4.nombre as 'nombre4', n4.apellido as 'apellido4' "
				+ "from inscripcion i "
				+ "inner join nadador n1 on i.nroNadador=n1.dni "
				+ "inner join nadador n2 on i.nroNadador2=n2.dni "
				+ "inner join nadador n3 on i.nroNadador3=n3.dni "
				+ "inner join nadador n4 on i.nroNadador4=n4.dni "
				+ "where nroCarrera=? and nroTorneo=? and nroPrograma=? and nroSerie=? "
				+ "order by tiempoCompetencia desc";
				
		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		PreparedStatement sentencia = null;
		ResultSet rs= null;
		Connection con = DataConnection.getInstancia().getConn();
		try
		{
			sentencia= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, nroCarrera);
			sentencia.setInt(2, nroTorneo);
			sentencia.setInt(3, nroPrograma);
			sentencia.setInt(4, nroSerie);
			
			rs=sentencia.executeQuery();
			while(rs.next())
			{
				Inscripcion inscrip = new Inscripcion();
				inscrip.setNroNadador(rs.getInt("nroNadador"));
				inscrip.setNroNadador2(rs.getInt("nroNadador2"));
				inscrip.setNroNadador3(rs.getInt("nroNadador3"));
				inscrip.setNroNadador4(rs.getInt("nroNadador4"));
				inscrip.setNroSerie(rs.getInt("nroSerie"));
				inscrip.setNroAndarivel(rs.getInt("nroAndarivel"));
				inscrip.setNroCarrera(rs.getInt("nroCarrera"));
				inscrip.setNroPrograma(rs.getInt("nroPrograma"));
				inscrip.setNroTorneo(rs.getInt("nroTorneo"));
				inscrip.setMotivoDescalificacion(rs.getString("motivoDescalificacion"));
				inscrip.setTiempoCompeticion(rs.getString("tiempoCompetencia"));
				inscrip.setNombreApellidoNadador(rs.getString("nombre1")+" "+rs.getString("apellido1"));
				inscrip.setNombreApellidoNadador2(rs.getString("nombre2")+" "+rs.getString("apellido2"));
				inscrip.setNombreApellidoNadador3(rs.getString("nombre3")+" "+rs.getString("apellido3"));
				inscrip.setNombreApellidoNadador4(rs.getString("nombre4")+" "+rs.getString("apellido4"));
				inscripciones.add(inscrip);
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
		return inscripciones;	
	}
	
	
	public boolean existeInscripcion(int nroCarrera, int nroTorneo, int nroPrograma) {
		String sql = "select distinct * from inscripcion where nroCarrera = ? and nroTorneo = ? and nroPrograma = ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = DataConnection.getInstancia().getConn();
		
		try
		{
			sentencia=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, nroCarrera);
			sentencia.setInt(2, nroTorneo);
			sentencia.setInt(3, nroPrograma);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{		
				return true;
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
		return false;
	
		
	}
	
	
	
}
