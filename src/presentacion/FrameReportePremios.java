package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import conexion.DataConnection;
import entidades.Carrera;
import entidades.Torneo;
import negocio.ControladorNatacion;
import reporte.Reportes;
import util.UtilidadesEscritorio;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameReportePremios extends JInternalFrame implements InternalFrameListener 
{
	private static final long serialVersionUID = 1L;
	private static FrameReportePremios instancia = null;
	private JTextField txtTorneo;
	private JButton btnCambiarTorneo;

	public JButton getBtnCambiarTorneo()
	{
		return btnCambiarTorneo;
	}
	
	public FrameReportePremios() 
	{
	    initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameReportePremios obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameReportePremios();
		}
		return instancia;
	}
	
	public static FrameReportePremios devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("Generar reporte de series");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 694, 186);
		getContentPane().setLayout(null);
		
		JLabel lblTorneos = new JLabel("Torneos:");
		lblTorneos.setBounds(10, 11, 79, 14);
		getContentPane().add(lblTorneos);
		
		JLabel lblCarreras = new JLabel("Carrera:");
		lblCarreras.setBounds(10, 46, 79, 14);
		getContentPane().add(lblCarreras);
		
		JComboBox<Carrera> cbCarreras = new JComboBox<Carrera>();
		cbCarreras.setBounds(99, 41, 573, 25);
		getContentPane().add(cbCarreras);
			
		JButton btnGenerarReporte = new JButton("Generar reporte");
		btnGenerarReporte.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				mostrarReporte(cbCarreras);
			}
		});
		btnGenerarReporte.setBounds(526, 110, 146, 34);
		getContentPane().add(btnGenerarReporte);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(370, 110, 146, 34);
		getContentPane().add(btnCancelar);
		
		txtTorneo = new JTextField();
		txtTorneo.setEnabled(false);
		txtTorneo.setBounds(99, 6, 437, 25);
		getContentPane().add(txtTorneo);
		txtTorneo.setColumns(10);
		
		btnCambiarTorneo = new JButton("Cambiar Torneo");
		btnCambiarTorneo.setBounds(546, 6, 126, 24);
		getContentPane().add(btnCambiarTorneo);
		
		if (ControladorNatacion.getInstance().getTorneoActual() != null)
		{
			txtTorneo.setText("Programa: " + ControladorNatacion.getInstance().getTorneoActual().getNroPrograma() + " Fecha: " + ControladorNatacion.getInstance().getTorneoActual().getFecha());
			cargarComboCarreras(cbCarreras);
		}
		else
			txtTorneo.setText("No hay torneo seleccionado");

	}
	
	
	
	private void cargarComboCarreras(JComboBox<Carrera> cbCarreras) 
	{
		cbCarreras.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarCarrerasPrograma(ControladorNatacion.getInstance().getTorneoActual().getNroPrograma())));
        cbCarreras.setRenderer(new PromptComboBoxRenderer("<-Seleccione una carrera->"));     
		cbCarreras.setSelectedIndex(-1);
	}
	
	private void mostrarReporte(JComboBox<Carrera> cbCarreras)
	{
		if(cbCarreras.getSelectedIndex()==-1)
			JOptionPane.showMessageDialog(getContentPane(), "Debe elegir una carrera.");
		else
		{
			Carrera carreraSeleccionado = (Carrera)cbCarreras.getSelectedItem();
			if(carreraSeleccionado.getNroCarrera()<=40)
			{
				
				Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\PremiacionSeriesInd.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
				Reportes.showViewer();
				if(carreraSeleccionado.getNroCarrera()==8)
				Reportes.exportarPDF("C:\\PDFCarreras\\Carrera8.pdf");
				if(carreraSeleccionado.getNroCarrera()==9)
				Reportes.exportarPDF("C:\\PDFCarreras\\Carrera9.pdf");	
				if(carreraSeleccionado.getNroCarrera()==10)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera10.pdf");	
				if(carreraSeleccionado.getNroCarrera()==11)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera11.pdf");	
				if(carreraSeleccionado.getNroCarrera()==12)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera12.pdf");	
				if(carreraSeleccionado.getNroCarrera()==13)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera13.pdf");	
				if(carreraSeleccionado.getNroCarrera()==14)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera14.pdf");	
				if(carreraSeleccionado.getNroCarrera()==15)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera15.pdf");	
				if(carreraSeleccionado.getNroCarrera()==16)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera16.pdf");	
				if(carreraSeleccionado.getNroCarrera()==19)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera19.pdf");	
				if(carreraSeleccionado.getNroCarrera()==20)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera20.pdf");	
				if(carreraSeleccionado.getNroCarrera()==27)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera27.pdf");	
				if(carreraSeleccionado.getNroCarrera()==28)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera28.pdf");	
				if(carreraSeleccionado.getNroCarrera()==29)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera29.pdf");	
				if(carreraSeleccionado.getNroCarrera()==30)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera30.pdf");	
				if(carreraSeleccionado.getNroCarrera()==31)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera31.pdf");	
				if(carreraSeleccionado.getNroCarrera()==32)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera32.pdf");	
				if(carreraSeleccionado.getNroCarrera()==33)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera33.pdf");	
				if(carreraSeleccionado.getNroCarrera()==34)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera34.pdf");	
				if(carreraSeleccionado.getNroCarrera()==35)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera35.pdf");	
				if(carreraSeleccionado.getNroCarrera()==36)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera36.pdf");	
				if(carreraSeleccionado.getNroCarrera()==39)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera39.pdf");	
				if(carreraSeleccionado.getNroCarrera()==40)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera40.pdf");	
			}
			else
			{
				Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\reportePremioPosta.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
				Reportes.showViewer();
				
				if(carreraSeleccionado.getNroCarrera()==41)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera41.pdf");	
				if(carreraSeleccionado.getNroCarrera()==42)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera42.pdf");	
				if(carreraSeleccionado.getNroCarrera()==43)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera43.pdf");	
				if(carreraSeleccionado.getNroCarrera()==44)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera44.pdf");	
				if(carreraSeleccionado.getNroCarrera()==45)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera45.pdf");	
				if(carreraSeleccionado.getNroCarrera()==46)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera46.pdf");	
				if(carreraSeleccionado.getNroCarrera()==47)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera47.pdf");	
				if(carreraSeleccionado.getNroCarrera()==48)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera48.pdf");	
				if(carreraSeleccionado.getNroCarrera()==49)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera49.pdf");	
				if(carreraSeleccionado.getNroCarrera()==50)
					Reportes.exportarPDF("C:\\PDFCarreras\\Carrera50.pdf");	
			}
		}
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		
	}


	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) 
	{
		instancia = null;

	}


	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) 
	{
		this.dispose();
	}


	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		
	}


	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		
	}


	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		
	}
	
	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
	}
}
