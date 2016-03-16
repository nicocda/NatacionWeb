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

public class FrameReporteSeriesEnCarrera extends JInternalFrame implements InternalFrameListener 
{
	private static final long serialVersionUID = 1L;
	private static FrameReporteSeriesEnCarrera instancia = null;
	private JTextField txtTorneo;
	private JButton btnCambiarTorneo;

	public FrameReporteSeriesEnCarrera() 
	{
	    initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameReporteSeriesEnCarrera obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameReporteSeriesEnCarrera();
		}
		return instancia;
	}
	
	public static FrameReporteSeriesEnCarrera devolverInstancia()
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
		txtTorneo.setColumns(10);
		txtTorneo.setBounds(99, 5, 437, 25);
		getContentPane().add(txtTorneo);
		
		btnCambiarTorneo = new JButton("Cambiar Torneo");
		btnCambiarTorneo.setBounds(546, 5, 126, 24);
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
			Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\ReporteSeriesPorCarrera.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			Reportes.showViewer();
			}
			else
			{
			Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\tiemposPosta.jasper", carreraSeleccionado.getNroCarrera(), carreraSeleccionado.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getFecha(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			Reportes.showViewer();
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
	
	public JButton getBtnCambiarTorneo()
	{
		return this.btnCambiarTorneo;
	}
}
