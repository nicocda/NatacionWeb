package entidades;

import java.sql.Time;

public class Inscripcion 
{
	private int nroNadador, nroNadador2, nroNadador3, nroNadador4, nroAndarivel, nroSerie, nroCarrera, nroPrograma, nroTorneo;
	private String nombreApellidoNadador, nombreApellidoNadador2,nombreApellidoNadador3,nombreApellidoNadador4;
	private String motivoDescalificacion, tiempoCompeticion;
	
	
	public String toString()
	{
		if(tiempoCompeticion != "00:null")
		{
			if(nroCarrera<=40){
				return this.nroAndarivel+"  "+this.nombreApellidoNadador;
			}else
			{
				return this.nroAndarivel+"  "+this.nombreApellidoNadador+"  "+this.nombreApellidoNadador2+"  "+this.nombreApellidoNadador3+"  "+this.nombreApellidoNadador4;
			}
		}
		else
		{
			if(nroCarrera<=40){
				return this.nombreApellidoNadador+" "+this.tiempoCompeticion;
			}else
			{
				return this.nombreApellidoNadador+"  "+this.nombreApellidoNadador2+"  "+this.nombreApellidoNadador3+"  "+this.nombreApellidoNadador4+" "+this.tiempoCompeticion;
			}
		}
		
	}
	
	public int getNroNadador2() {
		return nroNadador2;
	}
	public void setNroNadador2(int nroNadador2) {
		this.nroNadador2 = nroNadador2;
	}
	public int getNroNadador3() {
		return nroNadador3;
	}
	public void setNroNadador3(int nroNadador3) {
		this.nroNadador3 = nroNadador3;
	}
	public int getNroNadador4() {
		return nroNadador4;
	}
	public void setNroNadador4(int nroNadador4) {
		this.nroNadador4 = nroNadador4;
	}
	public int getNroCarrera() {
		return nroCarrera;
	}
	public void setNroCarrera(int nroCarrera) {
		this.nroCarrera = nroCarrera;
	}
	public int getNroPrograma() {
		return nroPrograma;
	}
	public void setNroPrograma(int nroPrograma) {
		this.nroPrograma = nroPrograma;
	}
	public int getNroTorneo() {
		return nroTorneo;
	}
	public void setNroTorneo(int nroTorneo) {
		this.nroTorneo = nroTorneo;
	}
	public String getMotivoDescalificacion() {
		return motivoDescalificacion;
	}
	public void setMotivoDescalificacion(String motivoDescalificacion) {
		this.motivoDescalificacion = motivoDescalificacion;
	}
	public String getTiempoCompeticion() {
		return tiempoCompeticion;
	}
	public void setTiempoCompeticion(String tiempoCompeticion) {
		this.tiempoCompeticion = tiempoCompeticion;
	}

	
	public int getNroNadador() {
		return nroNadador;
	}
	public void setNroNadador(int nroNadador) {
		this.nroNadador = nroNadador;
	}
	public int getNroAndarivel() {
		return nroAndarivel;
	}
	public void setNroAndarivel(int nroAndarivel) {
		this.nroAndarivel = nroAndarivel;
	}
	public int getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}
	public String getNombreApellidoNadador() {
		return nombreApellidoNadador;
	}
	public void setNombreApellidoNadador(String nombreApellidoNadador) {
		this.nombreApellidoNadador = nombreApellidoNadador;
	}

	public String getNombreApellidoNadador2() {
		return nombreApellidoNadador2;
	}

	public void setNombreApellidoNadador2(String nombreApellidoNadador2) {
		this.nombreApellidoNadador2 = nombreApellidoNadador2;
	}

	public String getNombreApellidoNadador3() {
		return nombreApellidoNadador3;
	}

	public void setNombreApellidoNadador3(String nombreApellidoNadador3) {
		this.nombreApellidoNadador3 = nombreApellidoNadador3;
	}

	public String getNombreApellidoNadador4() {
		return nombreApellidoNadador4;
	}

	public void setNombreApellidoNadador4(String nombreApellidoNadador4) {
		this.nombreApellidoNadador4 = nombreApellidoNadador4;
	}
}
