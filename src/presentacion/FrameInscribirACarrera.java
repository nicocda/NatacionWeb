package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import entidades.Carrera;
import entidades.Club;
import entidades.Torneo;
import negocio.ControladorNatacion;
import util.UtilidadesEscritorio;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class FrameInscribirACarrera extends JInternalFrame implements InternalFrameListener 
{
	private static final long serialVersionUID = 1L;
	private static FrameInscribirACarrera instancia = null;
	private JTable tablaNadadoresNoInscriptos;
	private JTable tablaNadadoresInscriptos;
	private JTextField txtTorneo;
	private JButton btnCambiarTorneo;

	public JButton getBtnCambiarTorneo()
	{
		return btnCambiarTorneo;
	}

	public FrameInscribirACarrera() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameInscribirACarrera obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameInscribirACarrera();
		}
		return instancia;
	}
	
	public static FrameInscribirACarrera devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("PreInscripcion Carrera Individual");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 878, 480);
		getContentPane().setLayout(null);
	//...frame--
        
        //BOXES
        JComboBox<Carrera> cbCarreras = new JComboBox<Carrera>();
        cbCarreras.setBounds(128, 47, 723, 25);
        getContentPane().add(cbCarreras);


        ActionListener alCarrera = new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
        	{
        		cargarTablas(cbCarreras);
        	}
        };
        cbCarreras.addActionListener(alCarrera);
       
        	
		//BOXES
        
        //TABLAS
        tablaNadadoresNoInscriptos = new JTable();
        
        JScrollPane scrollPane = new JScrollPane(tablaNadadoresNoInscriptos);
        scrollPane.setBounds(10, 151, 340, 289);
        getContentPane().add(scrollPane);
        
        tablaNadadoresInscriptos = new JTable();
        JScrollPane scrollPane_1 = new JScrollPane(tablaNadadoresInscriptos);
        scrollPane_1.setBounds(511, 151, 340, 289);
        getContentPane().add(scrollPane_1);
        //TABLAS
        
        //LABELS        
        JLabel lblTorneos = new JLabel("Torneos:");
        lblTorneos.setBounds(10, 16, 108, 14);
        getContentPane().add(lblTorneos);
        
        JLabel lblCarreras = new JLabel("Carreras:");
        lblCarreras.setBounds(10, 52, 108, 14);
        getContentPane().add(lblCarreras);
        
        JLabel lblNadadoresNoInscriptos = new JLabel("Nadadores No Inscriptos");
        lblNadadoresNoInscriptos.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblNadadoresNoInscriptos.setHorizontalAlignment(SwingConstants.CENTER);
        lblNadadoresNoInscriptos.setBounds(10, 126, 340, 14);
        getContentPane().add(lblNadadoresNoInscriptos);
        
        JLabel lblNadadoresInscriptos = new JLabel("Nadadores Inscriptos");
        lblNadadoresInscriptos.setHorizontalAlignment(SwingConstants.CENTER);
        lblNadadoresInscriptos.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblNadadoresInscriptos.setBounds(511, 126, 340, 14);
        getContentPane().add(lblNadadoresInscriptos);
        //LABELS
        
        //ACCIONES DOBLE CLICK
        tablaNadadoresNoInscriptos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
			JTable table =(JTable) Mouse_evt.getSource();
			Point point = Mouse_evt.getPoint();
			int row = table.rowAtPoint(point);
			if (Mouse_evt.getClickCount() == 2) {
				agregarNadadorACarrera(cbCarreras);
			}
			}
			});
        //BOTONES
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseClicked(MouseEvent arg0) 
        	{
        		agregarNadadorACarrera(cbCarreras);
        	}
        });
        btnAgregar.setBounds(360, 151, 141, 25);
        getContentPane().add(btnAgregar);
        
        JButton btnQuitar = new JButton("Quitar");
        btnQuitar.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0) 
        	{
        		quitarNadadorDeCarreraIndividual(cbCarreras);
        	}
        });
        btnQuitar.setBounds(360, 187, 141, 25);
        getContentPane().add(btnQuitar);
        
        JButton btnGenerarSerie = new JButton("Generar Serie");
        btnGenerarSerie.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0) 
        	{
          		int opt = JOptionPane.showConfirmDialog(getContentPane(), "Una vez generada la serie no se podra modificar ¿Estas seguro que desas generar la serie?");
          		if (opt==0)generarSeries(cbCarreras);
        	}
        });
        btnGenerarSerie.setBounds(360, 414, 141, 25);
        getContentPane().add(btnGenerarSerie);
        
        JLabel imagen = new JLabel("");
        ImageIcon iconAgregar = new ImageIcon(FrameInscribirACarrera.class.getResource("/resources/natacion-img.png"));
        imagen.setIcon(new ImageIcon(iconAgregar.getImage().getScaledInstance(141, 80, java.awt.Image.SCALE_SMOOTH )));
        imagen.setBounds(360, 316, 141, 80);
        getContentPane().add(imagen);
        
        txtTorneo = new JTextField();
        txtTorneo.setEnabled(false);
        txtTorneo.setBounds(128, 11, 599, 25);
        getContentPane().add(txtTorneo);
        txtTorneo.setColumns(10);
        
        btnCambiarTorneo = new JButton("Cambiar Torneo");
        btnCambiarTorneo.setBounds(737, 11, 114, 25);
        getContentPane().add(btnCambiarTorneo);
        //TxtBoxes
        
        if (ControladorNatacion.getInstance().getTorneoActual() != null)
        {
        	txtTorneo.setText("Programa: " + ControladorNatacion.getInstance().getTorneoActual().getNroPrograma() + " Fecha: " + ControladorNatacion.getInstance().getTorneoActual().getFecha());
        	cargarComboCarreras(cbCarreras, alCarrera);
        }
        else
        	txtTorneo.setText("No hay torneo seleccionado");
	}
	
	private void cargarComboCarreras(JComboBox<Carrera> cbCarreras, ActionListener alCarrera) 
	{
		cbCarreras.removeActionListener(alCarrera);
		cbCarreras.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarCarreraProgramaNoCargadas(ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));
        cbCarreras.setRenderer(new PromptComboBoxRenderer("<-Seleccione una carrera->"));     
		cbCarreras.setSelectedIndex(-1);
        cbCarreras.addActionListener(alCarrera);
	}

	
	private void cargarTablas(JComboBox<Carrera> cbCarreras)
	{
		Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
		tablaNadadoresInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(ControladorNatacion.getInstance().buscarNadadoresInscriptosACarreraIndividual(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));		
		tablaNadadoresNoInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));		
	}
	
	private void agregarNadadorACarrera(JComboBox<Carrera> cbCarreras)
	{
		if(tablaNadadoresNoInscriptos.getSelectedRow()!=-1)
		{
			
		Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
		int dniNadadorSeleccionado = (int)tablaNadadoresNoInscriptos.getValueAt(tablaNadadoresNoInscriptos.getSelectedRow(), 0);
		ControladorNatacion.getInstance().preInscribirACarreraIndividual(dniNadadorSeleccionado, carreraSeleccionada.getNroCarrera(), carreraSeleccionada.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
		cargarTablas(cbCarreras);
		}
		else
		JOptionPane.showMessageDialog(getContentPane(), "Debe seleccionar un nadador de la lista.");
	}
	
	private void quitarNadadorDeCarreraIndividual(JComboBox<Carrera> cbCarreras)
	{
		if(tablaNadadoresInscriptos.getSelectedRow() != -1)
		{
			Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
			int dniNadadorSeleccionado = (int)tablaNadadoresInscriptos.getValueAt(tablaNadadoresInscriptos.getSelectedRow(), 0);
			ControladorNatacion.getInstance().eliminarDePreInscripcionIndividual(dniNadadorSeleccionado, carreraSeleccionada.getNroCarrera(), carreraSeleccionada.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			cargarTablas(cbCarreras);
		}
	}
	
	private void generarSeries(JComboBox<Carrera> cbCarreras)
	{
		Carrera car = (Carrera)cbCarreras.getSelectedItem();
		if(cbCarreras.getSelectedIndex() != -1)
		{
			if (ControladorNatacion.getInstance().generarSeriesPorCarrera(car.getNroCarrera(), car.getNroPrograma(),ControladorNatacion.getInstance().getTorneoActual().getNroTorneo()))
				JOptionPane.showMessageDialog(getContentPane(), "Éxito al generar serie(s)");
			else
				JOptionPane.showMessageDialog(getContentPane(), "La carrera debe tener más de 1 nadador");
			cbCarreras.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarCarreraProgramaNoCargadas(ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(),ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));
			Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
			tablaNadadoresInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(ControladorNatacion.getInstance().buscarNadadoresInscriptosACarreraIndividual(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));		
			tablaNadadoresNoInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraIndividual(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));		
		
		}
		else
			JOptionPane.showMessageDialog(getContentPane(), "Debe elegir una carrera.");
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

//ESTO ES PARA SETEAR UN PRIMER VALOR EN LOS COMBOBOX
class PromptComboBoxRenderer extends BasicComboBoxRenderer
{
	private static final long serialVersionUID = 1L;
	private String prompt;

	public PromptComboBoxRenderer(String prompt)
	{
		this.prompt = prompt;
	}

	public Component getListCellRendererComponent(
		JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if (value == null)
			setText( prompt );

		return this;
	}
}
