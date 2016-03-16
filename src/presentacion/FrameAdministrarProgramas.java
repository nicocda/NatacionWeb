package presentacion;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import negocio.ControladorNatacion;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameAdministrarProgramas extends JInternalFrame implements InternalFrameListener
{
	private static FrameAdministrarProgramas instancia = null;
	private ControladorNatacion cc = new ControladorNatacion();
	private JPanel pnlModificarPrograma;
	private JTextField txtNuevoPrograma;
	private JTextField txtNuevoDescripcion;
	private JTextField txtModificaNroPrograma;
	private JTextField txtModificaDescripcion;
	
	public FrameAdministrarProgramas() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameAdministrarProgramas obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameAdministrarProgramas();
		}
		return instancia;
	}
	
	public static FrameAdministrarProgramas devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("Administrar Programas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 648, 238);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_373674735936708");
		
		JPanel pnlAgregarPrograma = new JPanel();
		tabbedPane.addTab("Nuevo Programa", null, pnlAgregarPrograma, null);
		pnlAgregarPrograma.setLayout(null);
		
		JLabel lblNmeroDePrograma = new JLabel("N\u00FAmero de programa:");
		lblNmeroDePrograma.setBounds(10, 13, 122, 14);
		pnlAgregarPrograma.add(lblNmeroDePrograma);
		
		txtNuevoPrograma = new JTextField();
		txtNuevoPrograma.setBounds(142, 8, 464, 25);
		pnlAgregarPrograma.add(txtNuevoPrograma);
		txtNuevoPrograma.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 49, 122, 14);
		pnlAgregarPrograma.add(lblDescripcin);
		
		txtNuevoDescripcion = new JTextField();
		txtNuevoDescripcion.setColumns(10);
		txtNuevoDescripcion.setBounds(142, 44, 464, 25);
		pnlAgregarPrograma.add(txtNuevoDescripcion);
		
		JButton btnAgregarPrograma = new JButton("Agregar Programa");
		btnAgregarPrograma.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				agregarNuevoPrograma();
			}
		});
		btnAgregarPrograma.setBounds(455, 130, 151, 39);
		pnlAgregarPrograma.add(btnAgregarPrograma);
		
		JPanel pnlModificarEliminarPrograma = new JPanel();
		tabbedPane.addTab("Modificar/Eliminar Programa", null, pnlModificarEliminarPrograma, null);
		pnlModificarEliminarPrograma.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 607, 112);
		pnlModificarEliminarPrograma.add(scrollPane);
		
		JButton btnModificarPrograma = new JButton("Modificar Programa");
		btnModificarPrograma.setBounds(10, 134, 274, 35);
		pnlModificarEliminarPrograma.add(btnModificarPrograma);
		
		JButton btnEliminarPrograma = new JButton("Eliminar Programa");
		btnEliminarPrograma.setBounds(343, 134, 274, 35);
		pnlModificarEliminarPrograma.add(btnEliminarPrograma);
		
		pnlModificarPrograma = new JPanel();
		getContentPane().add(pnlModificarPrograma, "name_373678566874195");
		pnlModificarPrograma.setLayout(null);
		
		JLabel lblModificaNroPrograma = new JLabel("N\u00FAmero de programa:");
		lblModificaNroPrograma.setBounds(10, 16, 122, 14);
		pnlModificarPrograma.add(lblModificaNroPrograma);
		
		JLabel lblModificaDescripcion = new JLabel("Descripci\u00F3n:");
		lblModificaDescripcion.setBounds(10, 52, 122, 14);
		pnlModificarPrograma.add(lblModificaDescripcion);
		
		txtModificaNroPrograma = new JTextField();
		txtModificaNroPrograma.setColumns(10);
		txtModificaNroPrograma.setBounds(142, 11, 480, 25);
		pnlModificarPrograma.add(txtModificaNroPrograma);
		
		txtModificaDescripcion = new JTextField();
		txtModificaDescripcion.setColumns(10);
		txtModificaDescripcion.setBounds(142, 47, 480, 25);
		pnlModificarPrograma.add(txtModificaDescripcion);
		
		JButton btnGuardarDatos = new JButton("Guardar Datos");
		btnGuardarDatos.setBounds(471, 158, 151, 39);
		pnlModificarPrograma.add(btnGuardarDatos);
	//...frame--
		
	}
	
	private void agregarNuevoPrograma()
	{
		cc.cargarPrograma(Integer.parseInt(txtNuevoPrograma.getText()), txtNuevoDescripcion.getText());
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
