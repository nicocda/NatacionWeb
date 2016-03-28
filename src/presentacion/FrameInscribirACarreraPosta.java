package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import entidades.Carrera;
import entidades.Club;
import entidades.Nadador;
import entidades.NadadorCarreraPosta;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class FrameInscribirACarreraPosta extends JInternalFrame implements InternalFrameListener 
{
	private static final long serialVersionUID = 1L;
	private static FrameInscribirACarreraPosta instancia = null;
	private JTable tablaNadadoresNoInscriptos;
	private JTable tablaNadadoresInscriptos;
	private JTextField txtTorneo;
	private Nadador[] equipo = new Nadador[4];
	private JTextField txtBuscar;

	public FrameInscribirACarreraPosta() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameInscribirACarreraPosta obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameInscribirACarreraPosta();
		}
		return instancia;
	}
	
	public static FrameInscribirACarreraPosta devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("Inscripcion a carrera por Posta");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 923, 616);
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
        scrollPane.setBounds(10, 106, 420, 304);
        getContentPane().add(scrollPane);
        
        tablaNadadoresInscriptos = new JTable();
        JScrollPane scrollPane_1 = new JScrollPane(tablaNadadoresInscriptos);
        scrollPane_1.setBounds(10, 442, 841, 97);
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
        lblNadadoresNoInscriptos.setBounds(20, 77, 213, 18);
        getContentPane().add(lblNadadoresNoInscriptos);
        
        JLabel lblNadadoresInscriptos = new JLabel("Equipos Inscriptos");
        lblNadadoresInscriptos.setHorizontalAlignment(SwingConstants.CENTER);
        lblNadadoresInscriptos.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblNadadoresInscriptos.setBounds(149, 417, 841, 14);
        getContentPane().add(lblNadadoresInscriptos);
        
        JLabel lblSeleccioneUnNadador1 = new JLabel("<-Seleccione un nadador->");
        lblSeleccioneUnNadador1.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccioneUnNadador1.setBounds(523, 163, 216, 16);
        getContentPane().add(lblSeleccioneUnNadador1);
        
        JLabel lblSeleccioneUnNadador2 = new JLabel("<-Seleccione un nadador->");
        lblSeleccioneUnNadador2.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccioneUnNadador2.setBounds(523, 190, 216, 16);
        getContentPane().add(lblSeleccioneUnNadador2);
        
        JLabel lblSeleccioneUnNadador3 = new JLabel("<-Seleccione un nadador->");
        lblSeleccioneUnNadador3.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccioneUnNadador3.setBounds(523, 217, 216, 16);
        getContentPane().add(lblSeleccioneUnNadador3);
        
        JLabel lblSeleccioneUnNadador4 = new JLabel("<-Seleccione un nadador->");
        lblSeleccioneUnNadador4.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccioneUnNadador4.setBounds(523, 244, 216, 16);
        getContentPane().add(lblSeleccioneUnNadador4);
        //LABELS
        
        //BOTONES
        JButton btnAgregar = new JButton("Agregar Equipo");
        btnAgregar.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseClicked(MouseEvent arg0) 
        	{
        		agregarNadadorACarrera(cbCarreras);
        		limpiarLabels(lblSeleccioneUnNadador1,
		        				lblSeleccioneUnNadador2,
		        				lblSeleccioneUnNadador3,
		        				lblSeleccioneUnNadador4);
        	}
        });
        btnAgregar.setBounds(450, 308, 389, 25);
        getContentPane().add(btnAgregar);
        
        JButton btnQuitar = new JButton("Quitar Equipo");
        btnQuitar.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0) 
        	{
        		quitarNadadorDeCarreraPosta(cbCarreras);
        		//TODO ESTE METODO(CARGARTABLAS) ANDA MAL... LO PROBE PONER EN EL BOTON Y TMPC ANDA
        		cargarTablas(cbCarreras);
        	}
        });
        btnQuitar.setBounds(10, 550, 154, 25);
        getContentPane().add(btnQuitar);
        
      
        
        JButton btnGenerarSerie = new JButton("Generar Serie");
        btnGenerarSerie.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0) 
        	{
        		generarSeries(cbCarreras);
        		limpiarLabels(lblSeleccioneUnNadador1,
        					  lblSeleccioneUnNadador2, 
        					  lblSeleccioneUnNadador3,
        					  lblSeleccioneUnNadador4);
        		
        		
        	}
        });
        btnGenerarSerie.setBounds(722, 550, 141, 25);
        getContentPane().add(btnGenerarSerie);
        
        txtTorneo = new JTextField();
        txtTorneo.setEnabled(false);
        txtTorneo.setBounds(128, 11, 599, 25);
        getContentPane().add(txtTorneo);
        txtTorneo.setColumns(10);
        
        JButton btnCambiarTorneo = new JButton("Cambiar Torneo");
        btnCambiarTorneo.setBounds(737, 11, 114, 25);
        getContentPane().add(btnCambiarTorneo);
        
        JLabel lblNadador1 = new JLabel("Nadador 1 -");
        lblNadador1.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNadador1.setBounds(440, 163, 73, 16);
        getContentPane().add(lblNadador1);
        
        JLabel lblNadador2 = new JLabel("Nadador 2 -");
        lblNadador2.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNadador2.setBounds(440, 190, 73, 16);
        getContentPane().add(lblNadador2);
        
        JLabel lblNadador3 = new JLabel("Nadador 3 -");
        lblNadador3.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNadador3.setBounds(440, 217, 73, 16);
        getContentPane().add(lblNadador3);
        
        JLabel lblNadador = new JLabel("Nadador 4 -");
        lblNadador.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNadador.setBounds(440, 244, 73, 16);
        getContentPane().add(lblNadador);
        
        JButton btnQuitar1 = new JButton("Quitar");
        btnQuitar1.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0) 
        	{
        		quitarNadador1(lblSeleccioneUnNadador1, cbCarreras);
        	}
        });
        btnQuitar1.setBounds(749, 157, 90, 28);
        getContentPane().add(btnQuitar1);
        
        JButton btnQuitar2 = new JButton("Quitar");
        btnQuitar2.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
        		quitarNadador2(lblSeleccioneUnNadador2, cbCarreras);
        	}
        });
        btnQuitar2.setBounds(749, 184, 90, 28);
        getContentPane().add(btnQuitar2);
        
        JButton btnQuitar3 = new JButton("Quitar");
        btnQuitar3.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
        		quitarNadador3(lblSeleccioneUnNadador3, cbCarreras);
        	}
        });
        btnQuitar3.setBounds(749, 211, 90, 28);
        getContentPane().add(btnQuitar3);
        
        JButton btnQuitar4 = new JButton("Quitar");
        btnQuitar4.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseReleased(MouseEvent e) 
        	{
        		quitarNadador4(lblSeleccioneUnNadador4, cbCarreras);
        	}
        });
        btnQuitar4.setBounds(749, 238, 90, 28);
        getContentPane().add(btnQuitar4);
        
        //ACCIONES DOBLE CLICK
        tablaNadadoresNoInscriptos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
			JTable table =(JTable) Mouse_evt.getSource();
			Point point = Mouse_evt.getPoint();
			int row = table.rowAtPoint(point);
			if (Mouse_evt.getClickCount() == 2) {
				agregarNadadorAlEquipo(lblSeleccioneUnNadador1, lblSeleccioneUnNadador2, lblSeleccioneUnNadador3, lblSeleccioneUnNadador4, cbCarreras);			
												}
															}	
        });
         
        JButton btnSeleccionarNadador = new JButton("Seleccionar Nadador");
        btnSeleccionarNadador.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0) 
        	{
        		agregarNadadorAlEquipo(lblSeleccioneUnNadador1, lblSeleccioneUnNadador2, lblSeleccioneUnNadador3, lblSeleccioneUnNadador4, cbCarreras);
        	}
        });
        btnSeleccionarNadador.setBounds(128, 414, 154, 25);
        getContentPane().add(btnSeleccionarNadador);
        
        JLabel lblEquipo = new JLabel("Equipo");
        lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblEquipo.setBounds(440, 83, 399, 14);
        getContentPane().add(lblEquipo);
        //TODO
        txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				filtrarTabla(cbCarreras);
			}	
		});
        txtBuscar.setBounds(297, 76, 187, 25);
        getContentPane().add(txtBuscar);
        txtBuscar.setColumns(10);
        
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(253, 77, 46, 24);
        getContentPane().add(lblBuscar);
        //TxtBoxes
        
        if (ControladorNatacion.getInstance().getTorneoActual() != null)
        {
        	txtTorneo.setText("Programa: " + ControladorNatacion.getInstance().getTorneoActual().getNroPrograma() + " Fecha: " + ControladorNatacion.getInstance().getTorneoActual().getFecha());
        	cargarComboCarreras(cbCarreras, alCarrera);
        }
        else
        	txtTorneo.setText("No hay torneo seleccionado");
	}
	
	private void quitarNadador1(JLabel seleccionar1, JComboBox<Carrera> cbCarreras) 
	{
		equipo[0] = null;
		seleccionar1.setText("<-Seleccione un nadador->");
		cargarTablas(cbCarreras);
	}
	private void quitarNadador2(JLabel seleccionar1, JComboBox<Carrera> cbCarreras) 
	{
		equipo[1] = null;
		seleccionar1.setText("<-Seleccione un nadador->");
		cargarTablas(cbCarreras);
	}
	private void quitarNadador3(JLabel seleccionar1, JComboBox<Carrera> cbCarreras) 
	{
		equipo[2] = null;
		seleccionar1.setText("<-Seleccione un nadador->");
		cargarTablas(cbCarreras);
	}
	private void quitarNadador4(JLabel seleccionar1, JComboBox<Carrera> cbCarreras) 
	{
		equipo[3] = null;
		seleccionar1.setText("<-Seleccione un nadador->");
		cargarTablas(cbCarreras);
	}
	
	private void filtrarTabla(JComboBox<Carrera> cbCarreras)
	{
		Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
		ArrayList<Nadador> lista = new ArrayList<Nadador>();
		if (!txtBuscar.getText().isEmpty())
		{
			if (UtilidadesEscritorio.esNumerico(txtBuscar.getText()))
			{	
				//FALTA HACER LOS METODOS EN EL CATALOGO DE NATACION
				lista=ControladorNatacion.getInstance().buscarMuchosNadadoresPorDniPosta(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(), Integer.parseInt(txtBuscar.getText()));
				quitarRepetidosEnEquipo(lista);
				tablaNadadoresNoInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(lista));
			}
			else if (Pattern.matches("[a-zA-Z]+", txtBuscar.getText()))
			{
				lista = ControladorNatacion.getInstance().buscarMuchosNadadoresPorNombreYApellidoPosta(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(), txtBuscar.getText());
				quitarRepetidosEnEquipo(lista);
				tablaNadadoresNoInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(lista));
			}
			else if (txtBuscar.getText().charAt(0) == ' ')
			{
				txtBuscar.setText("");
			}
		}
		else
		{
			lista = ControladorNatacion.getInstance().buscarNadadoresNoInscriptosACarreraPosta(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			quitarRepetidosEnEquipo(lista);
			tablaNadadoresNoInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(lista));
		}
	}

	private void agregarNadadorAlEquipo(JLabel seleccionar1, JLabel seleccionar2, JLabel seleccionar3, JLabel seleccionar4, JComboBox<Carrera> cbCarreras) 
	{
		if (tablaNadadoresNoInscriptos.getSelectedRow() != -1)
		{
			int i = buscarIndiceNoOcupado();
			if (i != -1)
			{
				equipo[i] = ControladorNatacion.getInstance().buscarNadadorPorDni((int)tablaNadadoresNoInscriptos.getValueAt(tablaNadadoresNoInscriptos.getSelectedRow(), 0));
				switch (i)
				{
					case 0:
						seleccionar1.setText(equipo[0].getNombre() + " " + equipo[0].getApellido());
						break;
					case 1:
						seleccionar2.setText(equipo[1].getNombre() + " " + equipo[1].getApellido());
						break;
					case 2:
						seleccionar3.setText(equipo[2].getNombre() + " " + equipo[2].getApellido());
						break;
					case 3:
						seleccionar4.setText(equipo[3].getNombre() + " " + equipo[3].getApellido());
						break;
				}
			}
			cargarTablas(cbCarreras);
		}
	}

	private int buscarIndiceNoOcupado() 
	{
		for(int i = 0; i < 4; i++)
		{
			if (equipo[i] == null)
				return i;
		}
		return -1;
	}

	private void cargarComboCarreras(JComboBox<Carrera> cbCarreras, ActionListener alCarrera) 
	{
		cbCarreras.removeActionListener(alCarrera);
		cbCarreras.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarPostasProgramaNoCargadas(ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));
        cbCarreras.setRenderer(new PromptComboBoxRendererPosta("<-Seleccione una carrera->"));     
		cbCarreras.setSelectedIndex(-1);
        cbCarreras.addActionListener(alCarrera);
	}

	
	private void cargarTablas(JComboBox<Carrera> cbCarreras)
	{
		Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
		filtrarTabla(cbCarreras);
		tablaNadadoresInscriptos.setModel(UtilidadesEscritorio.crearModeloTabla(ControladorNatacion.getInstance().buscarTodosEquipoPosta(carreraSeleccionada, ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));
	}
	
	private void quitarRepetidosEnEquipo(ArrayList<Nadador> listaNadadores)
	{
		ArrayList<Nadador> nadadoresBuffer = new ArrayList<Nadador>();
		for(Nadador n1 : listaNadadores)
		{
			for (Nadador n2 : equipo)
			{
				if (n2 != null)
				{
					if (n1.getDni() == n2.getDni())
					{
						nadadoresBuffer.add(n1);
					}
				}
			}
		}
		for (Nadador n1: nadadoresBuffer)
		{
			listaNadadores.remove(n1);
		}

	}

	private void agregarNadadorACarrera(JComboBox<Carrera> cbCarreras)
	{
		boolean equipoLleno = true;
		for(int i = 0; i < 4; i++)
		{
			if (equipo[i] == null)
				equipoLleno = false;
		}
		if (equipoLleno)
		{
			Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
			ControladorNatacion.getInstance().preInscribirAPosta(carreraSeleccionada.getNroCarrera(), carreraSeleccionada.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(), equipo[0].getDni(), equipo[1].getDni(), equipo[2].getDni(), equipo[3].getDni());
			cargarTablas(cbCarreras);
		}
		else
			JOptionPane.showMessageDialog(getContentPane(), "El equipo no esta completo");
			
	}
	
	private void quitarNadadorDeCarreraPosta(JComboBox<Carrera> cbCarreras)
	{
		Carrera carreraActual = (Carrera)cbCarreras.getSelectedItem();
		Nadador nad = (Nadador)tablaNadadoresInscriptos.getValueAt(tablaNadadoresInscriptos.getSelectedRow(), 0);
		ControladorNatacion.getInstance().eliminarDePreInscripcionPosta(carreraActual.getNroCarrera(),
																		ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(), 
																		ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(),
																		nad.getDni());
		cargarTablas(cbCarreras);																
	}
	
	private void generarSeries(JComboBox<Carrera> cbCarreras)
	{
		Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
		NadadorCarreraPosta nadPosta = new NadadorCarreraPosta();
		ArrayList<NadadorCarreraPosta> nadadores = new ArrayList<NadadorCarreraPosta>();
		for(int i=0;i<tablaNadadoresInscriptos.getRowCount();i++)
		{
			nadPosta = new NadadorCarreraPosta();
			Nadador nad = (Nadador)tablaNadadoresInscriptos.getValueAt(i, 0);
			Nadador nad2 = (Nadador)tablaNadadoresInscriptos.getValueAt(i, 1);
			Nadador nad3 = (Nadador)tablaNadadoresInscriptos.getValueAt(i, 2);
			Nadador nad4 = (Nadador)tablaNadadoresInscriptos.getValueAt(i, 3);
			nadPosta.setDniNadador1(nad.getDni());
			nadPosta.setDniNadador2(nad2.getDni());
			nadPosta.setDniNadador3(nad3.getDni());
			nadPosta.setDniNadador4(nad4.getDni());
			nadPosta.setNroCarrera(carreraSeleccionada.getNroCarrera());
			nadPosta.setNroPrograma(carreraSeleccionada.getNroPrograma());
			nadPosta.setNroTorneo(ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
			nadadores.add(nadPosta);
		}
		int opt=JOptionPane.showConfirmDialog(getContentPane(), "¿Seguro que desea generar la serie?");
		if(opt==0)
		{
		ControladorNatacion.getInstance().generarSeriesPosta(nadadores, carreraSeleccionada.getNroCarrera(), carreraSeleccionada.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo());
		JOptionPane.showMessageDialog(getContentPane(), "Serie Generada con Exito");
		}
		//Elimino la carrera en la que se genero la serie...
		int indiceSeleccionado = cbCarreras.getSelectedIndex();
		//cbCarreras.remove(indiceSeleccionado);
		//tablaNadadoresInscriptos.removeAll();
		//TODO LOS DOS METODOS ESOS SON LOS Q TIRAN EL ERROR DE INDICE CUANDO GENERAS SERIES, REVISAR..
		cargarTablas(cbCarreras);
		
	}
	
	private void limpiarLabels(JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4)
	{
		equipo[0] = null;
		equipo[1] = null;
		equipo[2] = null;
		equipo[3] = null;
		lbl1.setText("<-Seleccione un nadador->");
		lbl2.setText("<-Seleccione un nadador->");
		lbl3.setText("<-Seleccione un nadador->");
		lbl4.setText("<-Seleccione un nadador->");
		
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
class PromptComboBoxRendererPosta extends BasicComboBoxRenderer
{
	private static final long serialVersionUID = 1L;
	private String prompt;

	public PromptComboBoxRendererPosta(String prompt)
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
	
	//TODO JUAN CHUPAME LA CHOTA :)
	
	
}
