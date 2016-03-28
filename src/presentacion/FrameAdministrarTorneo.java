package presentacion;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import entidades.Club;
import entidades.Programa;
import negocio.ControladorNatacion;
import util.UtilidadesEscritorio;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class FrameAdministrarTorneo extends JInternalFrame implements InternalFrameListener
{
	private static FrameAdministrarTorneo instancia = null;
	private ControladorNatacion cc = new ControladorNatacion();
	private JPanel pnlModificarTorneo;
	private JTextField txtNuevoTorneo;
	private JTextField txtFecha;
	private JTextField txtNroTorneoModifica;
	private JTextField txtFechaModifica;
	private JComboBox<Club> cbClubes;
	private JComboBox<Programa> cbPrograma;
	private JComboBox<Club> cbClubModifica;
	private JComboBox<Programa> cbProgramaModifica;
	
	
	public FrameAdministrarTorneo() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameAdministrarTorneo obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameAdministrarTorneo();
		}
		return instancia;
	}
	
	public static FrameAdministrarTorneo devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("Administrar Torneos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 648, 281);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_373674735936708");
		
		JPanel pnlAgregarTorneo = new JPanel();
		tabbedPane.addTab("Nuevo Torneo", null, pnlAgregarTorneo, null);
		pnlAgregarTorneo.setLayout(null);
		
		JLabel lblNroTorneo = new JLabel("N\u00FAmero de Torneo:");
		lblNroTorneo.setBounds(10, 13, 122, 14);
		pnlAgregarTorneo.add(lblNroTorneo);
		
		txtNuevoTorneo = new JTextField();
		txtNuevoTorneo.setEnabled(false);
		txtNuevoTorneo.setText(Integer.toString(ControladorNatacion.getInstance().nroTorneo()));
		txtNuevoTorneo.setBounds(142, 8, 464, 25);
		pnlAgregarTorneo.add(txtNuevoTorneo);
		txtNuevoTorneo.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Club Anfitri\u00F3n:");
		lblDescripcin.setBounds(10, 49, 122, 14);
		pnlAgregarTorneo.add(lblDescripcin);
		
		JButton btnAgregarTorneo = new JButton("Agregar Torneo");
		btnAgregarTorneo.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				agregarNuevoTorneo();
			}
		});
		btnAgregarTorneo.setBounds(455, 173, 151, 39);
		pnlAgregarTorneo.add(btnAgregarTorneo);
		
		cbClubes = new JComboBox<Club>(UtilidadesEscritorio.generarModeloComboBox(cc.buscarClubes()));
		cbClubes.setBounds(142, 44, 464, 25);
		pnlAgregarTorneo.add(cbClubes);
		
		JLabel lblTorneo = new JLabel("Torneo:");
		lblTorneo.setBounds(10, 85, 122, 14);
		pnlAgregarTorneo.add(lblTorneo);
		
		cbPrograma = new JComboBox<Programa>(UtilidadesEscritorio.generarModeloComboBox(cc.buscarTodosProgramas()));
		cbPrograma.setBounds(142, 80, 464, 25);
		pnlAgregarTorneo.add(cbPrograma);
		
		txtFecha = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##/##/####"));
		txtFecha.setBounds(142, 116, 464, 25);
		pnlAgregarTorneo.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 121, 46, 14);
		pnlAgregarTorneo.add(lblFecha);
		
		JPanel pnlModificarEliminarTorneo = new JPanel();
		tabbedPane.addTab("Modificar/Eliminar Torneo", null, pnlModificarEliminarTorneo, null);
		pnlModificarEliminarTorneo.setLayout(null);
		
		JTable tablaTorneos = new JTable();
		tablaTorneos.setBounds(10, 11, 607, 112);
		tablaTorneos.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarTorneos()));
		pnlModificarEliminarTorneo.add(tablaTorneos);
		
		
		JButton btnModificarTorneo = new JButton("Modificar Torneo");
		btnModificarTorneo.setBounds(10, 134, 274, 35);
		pnlModificarEliminarTorneo.add(btnModificarTorneo);
		
		JButton btnEliminarTorneo = new JButton("Eliminar Torneo");
		btnEliminarTorneo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				cc.eliminarTorneo((int)tablaTorneos.getValueAt(tablaTorneos.getSelectedRow(), 0));
				JOptionPane.showMessageDialog(pnlAgregarTorneo, "Torneo eliminado con Exito");
			}
		});
		btnEliminarTorneo.setBounds(343, 134, 274, 35);
		pnlModificarEliminarTorneo.add(btnEliminarTorneo);
		
		pnlModificarTorneo = new JPanel();
		getContentPane().add(pnlModificarTorneo, "name_373678566874195");
		pnlModificarTorneo.setLayout(null);
		
		JButton btnGuardarDatos = new JButton("Guardar Datos");
		btnGuardarDatos.setBounds(471, 201, 151, 39);
		pnlModificarTorneo.add(btnGuardarDatos);
		
		JLabel lblNroTorneoModifica = new JLabel("N\u00FAmero de Torneo:");
		lblNroTorneoModifica.setBounds(10, 16, 122, 14);
		pnlModificarTorneo.add(lblNroTorneoModifica);
		
		txtNroTorneoModifica = new JTextField();
		txtNroTorneoModifica.setEnabled(false);
		txtNroTorneoModifica.setColumns(10);
		txtNroTorneoModifica.setBounds(142, 11, 480, 25);
		pnlModificarTorneo.add(txtNroTorneoModifica);
		
		JLabel lblClubModifica = new JLabel("Club Anfitri\u00F3n:");
		lblClubModifica.setBounds(10, 52, 122, 14);
		pnlModificarTorneo.add(lblClubModifica);
		
		cbClubModifica = new JComboBox<Club>(UtilidadesEscritorio.generarModeloComboBox(cc.buscarClubes()));
		cbClubModifica.setBounds(142, 47, 480, 25);
		pnlModificarTorneo.add(cbClubModifica);
		
		JLabel lblTorneoModifica = new JLabel("Torneo:");
		lblTorneoModifica.setBounds(10, 88, 122, 14);
		pnlModificarTorneo.add(lblTorneoModifica);
		
		cbProgramaModifica = new JComboBox<Programa>(UtilidadesEscritorio.generarModeloComboBox(cc.buscarTodosProgramas()));
		cbProgramaModifica.setBounds(142, 83, 480, 25);
		pnlModificarTorneo.add(cbProgramaModifica);
		
		JLabel lblFechaModifica = new JLabel("Fecha:");
		lblFechaModifica.setBounds(10, 124, 46, 14);
		pnlModificarTorneo.add(lblFechaModifica);
		
		txtFechaModifica = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##/##/####"));
		txtFechaModifica.setColumns(10);
		txtFechaModifica.setBounds(142, 119, 480, 25);
		pnlModificarTorneo.add(txtFechaModifica);
	//...frame--
		
	}
	
	private void agregarNuevoTorneo()
	{
		ControladorNatacion.getInstance().cargarTorneo(txtFecha.getText(), ((Programa)cbPrograma.getSelectedItem()).getNroPrograma(), ((Club)cbClubes.getSelectedItem()).getNroClub());
		JOptionPane.showMessageDialog(getContentPane(), "Torneo Generado con Exito");
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
