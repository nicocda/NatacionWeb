package reporte;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

public class Reportes {

	private static JasperReport reporte;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;
	
	public static void crearReporte(Connection conn, String path, Integer nroCarrera, Integer nroPrograma, String fechaTorneo, Integer nroTorneo)
	{
		
		try
		{
			Map<String, Object> parametersMap = new HashMap<String, Object>();  
			parametersMap.put("nroCarrera", nroCarrera);
			parametersMap.put("nroPrograma", nroPrograma);
			parametersMap.put("fechaTorneo", fechaTorneo);
			parametersMap.put("nroTorneo", nroTorneo);
			reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
			reportFilled = JasperFillManager.fillReport(reporte, parametersMap, conn);
		}
		catch(JRException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void crearReporte(Connection conn, String path)
	{
		
		try
		{
			reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
			reportFilled = JasperFillManager.fillReport(reporte, null, conn);
		}
		catch(JRException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void showViewer(){
		
		viewer = new JasperViewer(reportFilled, false);
		viewer.setVisible(true); 
			
	}
	
	public static void exportarPDF(String destino)
	{
		try {
			JasperExportManager.exportReportToPdfFile(reportFilled, destino);
			
		} catch (Exception e) {
			System.out.println("Error al exportar en pdf");
		}
	}
}