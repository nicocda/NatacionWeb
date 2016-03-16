package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import conexion.DataConnection;
import negocio.ControladorNatacion;
import reporte.Reportes;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class FramePrincipal extends JFrame {

	private JDesktopPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					FramePrincipal frame = new FramePrincipal();
					frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal()
	{
		setTitle("Gestión de Competencias de Natación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JDesktopPane();
		this.setExtendedState(FramePrincipal.MAXIMIZED_BOTH);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel pnlTorneoSeleccionado = new JPanel();
		pnlTorneoSeleccionado.setBounds(0, 0, 2276, 31);
		contentPane.add(pnlTorneoSeleccionado);
		pnlTorneoSeleccionado.setLayout(null);
		
		JLabel lblTorneoSeleccionado = new JLabel("Torneo seleccionado:");
		lblTorneoSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTorneoSeleccionado.setBounds(10, 0, 146, 31);
		pnlTorneoSeleccionado.add(lblTorneoSeleccionado);
		
		JLabel lblCambiarTorneo = new JLabel("");
		lblCambiarTorneo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCambiarTorneo.setBounds(156, 0, 1055, 31);
		pnlTorneoSeleccionado.add(lblCambiarTorneo);
		
				iniciarFrameDefinirTorneo(lblCambiarTorneo);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNadadores = new JMenu("Gestion de Torneo");
		menuBar.add(mnNadadores);
		
		JMenuItem mntmDefinirTorneo = new JMenuItem("Definir Torneo");
		mntmDefinirTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				iniciarFrameDefinirTorneo(lblCambiarTorneo);
			}
		});
		mnNadadores.add(mntmDefinirTorneo);
		
		
		JMenuItem mntmGenerarReporteNadadores = new JMenuItem("Generar Reporte Nadadores");
		mntmGenerarReporteNadadores.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\ReporteNadadpres.jasper");
				Reportes.showViewer();
			}
		});
		mnNadadores.add(mntmGenerarReporteNadadores);
		
		JMenu mnCarreras = new JMenu("PreInscripciones");
		menuBar.add(mnCarreras);
		
		JMenuItem mntmInscribirACarrera = new JMenuItem("Inscribir a carrera individual");
		mntmInscribirACarrera.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (FrameInscribirACarrera.devolverInstancia() == null)
				{
					agregarAlPanel(FrameInscribirACarrera.obtenerInstancia());
					FrameInscribirACarrera.obtenerInstancia().setVisible(true);
					FrameInscribirACarrera.devolverInstancia().getBtnCambiarTorneo().addMouseListener(new MouseAdapter() 
					{
						@Override
						public void mouseReleased(MouseEvent e) 
						{
							FrameInscribirACarrera.devolverInstancia().dispose();
							iniciarFrameDefinirTorneo(lblCambiarTorneo);
						}
					});
				}
				else
					FrameInscribirACarrera.devolverInstancia().moveToFront();
			}
		});
		mnCarreras.add(mntmInscribirACarrera);
		
		JMenuItem mntmInscribirACarrera_1 = new JMenuItem("Inscribir a carrera por Posta");
		mntmInscribirACarrera_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (FrameInscribirACarreraPosta.devolverInstancia() == null)
				{
					agregarAlPanel(FrameInscribirACarreraPosta.obtenerInstancia());
					FrameInscribirACarreraPosta.obtenerInstancia().setVisible(true);
				}
				else
					FrameInscribirACarreraPosta.devolverInstancia().moveToFront();
			}
		});
		mnCarreras.add(mntmInscribirACarrera_1);
		
		JMenuItem mntmGenerarReporteCarreras = new JMenuItem("Generar Reporte Carreras");
		mntmGenerarReporteCarreras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (FrameReporteSeriesEnCarrera.devolverInstancia() == null)
				{
					agregarAlPanel(FrameReporteSeriesEnCarrera.obtenerInstancia());
					FrameReporteSeriesEnCarrera.obtenerInstancia().setVisible(true);
					FrameReporteSeriesEnCarrera.devolverInstancia().getBtnCambiarTorneo().addMouseListener(new MouseAdapter() 
					{
						@Override
						public void mouseReleased(MouseEvent e) 
						{
							FrameReporteSeriesEnCarrera.devolverInstancia().dispose();
							iniciarFrameDefinirTorneo(lblCambiarTorneo);
						}
					});
				}
				else
					FrameReporteSeriesEnCarrera.devolverInstancia().moveToFront();
			}
		});
		mnCarreras.add(mntmGenerarReporteCarreras);
		
		JMenu mnTiempos = new JMenu("Tiempos");
		menuBar.add(mnTiempos);
		
		JMenuItem mntmRegistrarTiemposCompeticion = new JMenuItem("Registrar tiempos Competicion");
		mntmRegistrarTiemposCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (FrameAdministrarTiempoPostCarrera.devolverInstancia() == null)
				{
					agregarAlPanel(FrameAdministrarTiempoPostCarrera.obtenerInstancia());
					FrameAdministrarTiempoPostCarrera.obtenerInstancia().setVisible(true);
				}
				else
					FrameAdministrarTiempoPostCarrera.devolverInstancia().moveToFront();
			}
		});
		mnTiempos.add(mntmRegistrarTiemposCompeticion);
		
		JMenuItem mntmGenerarReporteDe = new JMenuItem("Generar Reporte de Premiacion");
		mntmGenerarReporteDe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{			
				if (FrameReportePremios.devolverInstancia() == null)
				{
					agregarAlPanel(FrameReportePremios.obtenerInstancia());
					FrameReportePremios.obtenerInstancia().setVisible(true);
					FrameReportePremios.devolverInstancia().getBtnCambiarTorneo().addMouseListener(new MouseAdapter() 
					{
						@Override
						public void mouseReleased(MouseEvent e) 
						{
							FrameReportePremios.devolverInstancia().dispose();
							iniciarFrameDefinirTorneo(lblCambiarTorneo);
						}
					});
				}
				else
					FrameReportePremios.devolverInstancia().moveToFront();
			}
		});
		mnTiempos.add(mntmGenerarReporteDe);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmAdministrarNadadores = new JMenuItem("Administrar Nadadores");
		mnEditar.add(mntmAdministrarNadadores);
		mntmAdministrarNadadores.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (FrameAdministrarNadador.devolverInstancia() == null)
				{
					agregarAlPanel(FrameAdministrarNadador.obtenerInstancia());
					FrameAdministrarNadador.obtenerInstancia().setVisible(true);
				}
				else
					FrameAdministrarNadador.devolverInstancia().moveToFront();
			}
		});
		
		JMenuItem mntmRegistrarPrograma = new JMenuItem("Registrar Programa");
		mntmRegistrarPrograma.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (FrameAdministrarProgramas.devolverInstancia() == null)
				{
					agregarAlPanel(FrameAdministrarProgramas.obtenerInstancia());
					FrameAdministrarProgramas.obtenerInstancia().setVisible(true);
				}
				else
					FrameAdministrarProgramas.devolverInstancia().moveToFront();
			}
		});
		mnEditar.add(mntmRegistrarPrograma);
		
		JMenuItem mntmRegistrarTorneo = new JMenuItem("Registrar Torneo");
		mnEditar.add(mntmRegistrarTorneo);
		mntmRegistrarTorneo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (FrameAdministrarTorneo.devolverInstancia() == null)
				{
					agregarAlPanel(FrameAdministrarTorneo.obtenerInstancia());
					FrameAdministrarTorneo.obtenerInstancia().setVisible(true);
				}
				else
					FrameAdministrarTorneo.devolverInstancia().moveToFront();
			}
		});
		
		JMenuItem mntmRegistrarCarreras = new JMenuItem("Registrar Carreras");
		mntmRegistrarCarreras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (FrameAdministrarCarrera.devolverInstancia() == null)
				{
					agregarAlPanel(FrameAdministrarCarrera.obtenerInstancia());
					FrameAdministrarCarrera.obtenerInstancia().setVisible(true);
				}
				else
					FrameAdministrarCarrera.devolverInstancia().moveToFront();
			}
		});
		
		JMenuItem mntmAgregrarDescalificaciones = new JMenuItem("Agregrar Descalificaciones");
		mntmAgregrarDescalificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (FrameAdministrarDescalificaciones.devolverInstancia() == null)
				{
					agregarAlPanel(FrameAdministrarDescalificaciones.obtenerInstancia());
					FrameAdministrarDescalificaciones.obtenerInstancia().setVisible(true);
				}
				else
					FrameAdministrarDescalificaciones.devolverInstancia().moveToFront();
			}
		});
		mnEditar.add(mntmAgregrarDescalificaciones);
		mnEditar.add(mntmRegistrarCarreras);
		
		JMenu mnPlanillas = new JMenu("Cronometristas");
		menuBar.add(mnPlanillas);
		
		JMenuItem mntmCronometristas = new JMenuItem("San Jorge");
		mntmCronometristas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				
				Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\Blank_A4.jasper");
				Reportes.showViewer();
			}
		});
		mnPlanillas.add(mntmCronometristas);
		
		JMenuItem mntmPiamonte = new JMenuItem("Piamonte");
		mntmPiamonte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Reportes.crearReporte(DataConnection.getInstancia().getConn(), "DataBase\\Piamonte.jasper");
				Reportes.showViewer();
			}
		});
		mnPlanillas.add(mntmPiamonte);
		
	}
	
	private void iniciarFrameDefinirTorneo(JLabel lblCambiarTorneo)
	{
		if (FrameDefinirTorneo.devolverInstancia() == null)
		{
			agregarAlPanel(FrameDefinirTorneo.obtenerInstancia());
			FrameDefinirTorneo.obtenerInstancia().setVisible(true);
			FrameDefinirTorneo.devolverInstancia().getBtnElegirTorneo().addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseReleased(MouseEvent e) 
				{
					lblCambiarTorneo.setText(FrameDefinirTorneo.devolverInstancia().elegirTorneoActual());
				}
			});
		}
		else
			FrameDefinirTorneo.devolverInstancia().moveToFront();
	}
	
	
	//Esto pone un panel adelante del otro y con la forma tipo "en cascada"
	private void agregarAlPanel(JInternalFrame frame)
	{
		frame.setBounds(10 * (contentPane.getAllFrames().length + 1), 50 + (10 * (contentPane.getAllFrames().length + 1)), (int)frame.getBounds().getWidth(), (int)frame.getBounds().getHeight());
		contentPane.add(frame);
		frame.moveToFront();
	}
}
