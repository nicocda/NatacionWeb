package presentacion;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import entidades.Programa;
import negocio.ControladorNatacion;
import util.UtilidadesEscritorio;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ComboBoxModel;

public class FrameAdministrarCarrera extends JInternalFrame implements InternalFrameListener
{
	private static FrameAdministrarCarrera instancia = null;
	private JTextField txtNroCarrera;
	private JTextField txtMetros;
	public FrameAdministrarCarrera() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameAdministrarCarrera obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameAdministrarCarrera();
		}
		return instancia;
	}
	
	public static FrameAdministrarCarrera devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("Administrar Carreras");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 648, 380);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_404119858051884");
		
		JPanel pnlAgregarCarrera = new JPanel();
		tabbedPane.addTab("Nueva Carrera", null, pnlAgregarCarrera, null);
		pnlAgregarCarrera.setLayout(null);
		
		JComboBox<Programa> cbProgramas = new JComboBox<Programa>(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarTodosProgramas()));
		cbProgramas.setBounds(140, 11, 477, 25);
		pnlAgregarCarrera.add(cbProgramas);
		
		txtNroCarrera = new JTextField();
		txtNroCarrera.setBounds(140, 47, 477, 25);
		pnlAgregarCarrera.add(txtNroCarrera);
		txtNroCarrera.setColumns(10);
		
		Integer[] edades = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		JComboBox<Integer> cbEdades = new JComboBox<Integer>(edades);
		cbEdades.setBounds(140, 83, 477, 25);
		pnlAgregarCarrera.add(cbEdades);
		
		String[] estilos = {"Mariposa", "Croll", "Espalda", "Pecho","4 Estilos"};
		JComboBox<String> cbEstilos = new JComboBox<String>(estilos);
		cbEstilos.setBounds(140, 119, 477, 25);
		pnlAgregarCarrera.add(cbEstilos);
		
		String[] sexo = {"Masculino", "Femenino", "Mixto"};
		JComboBox<String> cbSexo = new JComboBox<String>(sexo);
		cbSexo.setBounds(140, 191, 477, 25);
		pnlAgregarCarrera.add(cbSexo);
		
		txtMetros = new JTextField();
		txtMetros.setBounds(140, 155, 477, 25);
		pnlAgregarCarrera.add(txtMetros);
		txtMetros.setColumns(10);
		
		JLabel lblPrograma = new JLabel("Programa:");
		lblPrograma.setBounds(10, 16, 120, 14);
		pnlAgregarCarrera.add(lblPrograma);
		
		JLabel lblNmeroCarrera = new JLabel("N\u00FAmero Carrera:");
		lblNmeroCarrera.setBounds(10, 52, 120, 14);
		pnlAgregarCarrera.add(lblNmeroCarrera);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 88, 120, 14);
		pnlAgregarCarrera.add(lblEdad);
		
		JLabel lblEstilo = new JLabel("Estilo:");
		lblEstilo.setBounds(10, 124, 120, 14);
		pnlAgregarCarrera.add(lblEstilo);
		
		JLabel lblMetros = new JLabel("Metros:");
		lblMetros.setBounds(10, 160, 120, 14);
		pnlAgregarCarrera.add(lblMetros);
		
		JButton btnAgregarCarrera = new JButton("Agregar Carrera");
		btnAgregarCarrera.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				cargarNuevaCarrera(cbEdades, cbEstilos, cbProgramas, cbSexo);
				JOptionPane.showMessageDialog(pnlAgregarCarrera, "Carrera Agregada");
			}
		});
		btnAgregarCarrera.setBounds(402, 269, 215, 42);
		pnlAgregarCarrera.add(btnAgregarCarrera);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 196, 120, 14);
		pnlAgregarCarrera.add(lblSexo);
		
		JPanel pnlEliminarModificarCarrera = new JPanel();
		tabbedPane.addTab("Modificar/Eliminar Carrera", null, pnlEliminarModificarCarrera, null);
		pnlEliminarModificarCarrera.setLayout(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_404124521568158");
		panel.setLayout(null);
	}
	
	private void cargarNuevaCarrera(JComboBox<Integer> cbEdades, JComboBox<String> cbEstilos, JComboBox<Programa> cbProgramas, JComboBox<String> cbSexo)
	{
		int edad = (Integer)cbEdades.getSelectedItem();
		String estilo = (String)cbEstilos.getSelectedItem();
		String sexo =  "m";
		if(cbSexo.getSelectedIndex()==0) sexo="m"; else if(cbSexo.getSelectedIndex()==1) sexo="f"; else sexo="t";
		Programa programaSelecciondo = (Programa)cbProgramas.getSelectedItem();
		int nroCarrera = Integer.parseInt(txtNroCarrera.getText());
		int metros = Integer.parseInt(txtMetros.getText());
		ControladorNatacion.getInstance().registrarCarrera(nroCarrera, edad, metros, programaSelecciondo.getNroPrograma(), sexo, estilo);
		
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
