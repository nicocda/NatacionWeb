package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.MaskFormatter;

import entidades.Club;
import entidades.Nadador;
import negocio.ControladorNatacion;
import util.UtilidadesEscritorio;
import javax.swing.JTable;

public class FrameAdministrarNadador extends JInternalFrame implements InternalFrameListener 
{

	private static final long serialVersionUID = 1L;
	private static FrameAdministrarNadador instancia = null;
	private JTextField txtNuevoDni;
	private JTextField txtNuevoNombre;
	private JTextField txtNuevoApellido;
	private JFormattedTextField txtNuevoFechaNacimiento;
	private ControladorNatacion cc = new ControladorNatacion();
	private JTextField txtBuscar;
	private JTable tablaNadadores;
	private JTextField txtModificaDni;
	private JTextField txtModificaNombre;
	private JTextField txtModificaApellido;
	private JTextField txtModificaFechaNacimiento;
	private JPanel pnlAgregarNadador;
	
	public FrameAdministrarNadador() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameAdministrarNadador obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameAdministrarNadador();
		}
		return instancia;
	}
	
	public static FrameAdministrarNadador devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
			setTitle("Administrar Nadador");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setIconifiable(true);
			setClosable(true);
			setBounds(27, 11, 648, 426);
			getContentPane().setLayout(new CardLayout(0, 0));
		//...frame--
		
		//--Definición del...
			JTabbedPane tbPnlAdministrarNadadores = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(tbPnlAdministrarNadadores, "tabbedPane");
		//...panel tabulado--
		
		//--Definición de la...
			JPanel pnlAgregarNadador = new JPanel();
			tbPnlAdministrarNadadores.addTab("Nuevo Nadador", null, pnlAgregarNadador, null);
			pnlAgregarNadador.setLayout(null);
		//...primer etiqueta del panel tabulado--
		
		//--Agrego componentes al...
			//--Inicio Labels...
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(6, 50, 77, 14);
				pnlAgregarNadador.add(lblNombre);
				
				JLabel lblApellido = new JLabel("Apellido:");
				lblApellido.setBounds(6, 86, 77, 14);
				pnlAgregarNadador.add(lblApellido);
				
				JLabel lblFechaNacimiento = new JLabel("Nacimiento:");
				lblFechaNacimiento.setBounds(6, 124, 77, 14);
				pnlAgregarNadador.add(lblFechaNacimiento);
				
				JLabel lblClub = new JLabel("Club:");
				lblClub.setBounds(6, 161, 77, 14);
				pnlAgregarNadador.add(lblClub);
				
				JLabel lblDni = new JLabel("DNI:");
				lblDni.setBounds(6, 11, 77, 14);
				pnlAgregarNadador.add(lblDni);
				
				JLabel lblSexo = new JLabel("Sexo:");
				lblSexo.setBounds(6, 197, 77, 14);
				pnlAgregarNadador.add(lblSexo);
			//...fin Labels--
		
			//--Labels de mensajes...
				JLabel lblErrorDniNuevoNadador = new JLabel("");
				lblErrorDniNuevoNadador.setForeground(Color.RED);
				lblErrorDniNuevoNadador.setBounds(431, 11, 186, 14);
				pnlAgregarNadador.add(lblErrorDniNuevoNadador);
				
				JLabel lblErrorEdadNuevoNadador = new JLabel("");
				lblErrorEdadNuevoNadador.setForeground(Color.RED);
				lblErrorEdadNuevoNadador.setBounds(305, 86, 186, 14);
				pnlAgregarNadador.add(lblErrorEdadNuevoNadador);
			//...de error--
				
			//--Inicio TextBoxes...
				txtNuevoDni = new JTextField();
				txtNuevoDni.setBounds(95, 8, 329, 25);
				pnlAgregarNadador.add(txtNuevoDni);
				txtNuevoDni.setColumns(10);
				UtilidadesEscritorio.validarValoresNumericos(txtNuevoDni, lblErrorDniNuevoNadador);
				
				txtNuevoNombre = new JTextField();
				txtNuevoNombre.setColumns(10);
				txtNuevoNombre.setBounds(95, 45, 329, 25);
				pnlAgregarNadador.add(txtNuevoNombre);
				
				txtNuevoApellido = new JTextField();
				txtNuevoApellido.setColumns(10);
				txtNuevoApellido.setBounds(95, 81, 329, 25);
				pnlAgregarNadador.add(txtNuevoApellido);
				
				txtNuevoFechaNacimiento = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##/##/####"));
				txtNuevoFechaNacimiento.setColumns(10);
				txtNuevoFechaNacimiento.setBounds(95, 119, 329, 25);
				pnlAgregarNadador.add(txtNuevoFechaNacimiento);
			//...fin TextBoxes--
				
			//--Inicio ComboBoxes...
				String[] opciones = {"Masculino", "Femenino"};
				JComboBox<String> cbNuevoSexo = new JComboBox<String>(opciones);
				cbNuevoSexo.setBounds(95, 192, 329, 25);
				pnlAgregarNadador.add(cbNuevoSexo);
				
				JComboBox<Club> cbClubes = new JComboBox<Club>(UtilidadesEscritorio.generarModeloComboBox(cc.buscarClubes()));
				cbClubes.setBounds(95, 156, 329, 25);
				pnlAgregarNadador.add(cbClubes);
			//...fin ComboBoxes--
				
			//--Inicio botones...
				JButton btnCargarJugador = new JButton("Cargar Nadador");
				btnCargarJugador.setBounds(408, 328, 209, 31);
				pnlAgregarNadador.add(btnCargarJugador);
				btnCargarJugador.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent arg0) 
					{
						cargarNadador(cbNuevoSexo, cbClubes);
					}
				});	
			//...fin botones--	
	//...primer etiqueta del panel tabulado--	
	
	//--Definición de la...
		JPanel pnlEliminarNadador = new JPanel();
		tbPnlAdministrarNadadores.addTab("Modificar/Eliminar Nadador", null, pnlEliminarNadador, null);
		pnlEliminarNadador.setLayout(null);
	//...segunda etiqueta del panel tabulado--
		
	//--Componentes de...
		//--Inicio labels, txtFields y tabla...
			JLabel lblFiltrar = new JLabel("Buscar:");
			lblFiltrar.setBounds(323, 14, 51, 14);
			pnlEliminarNadador.add(lblFiltrar);
			
			txtBuscar = new JTextField();
			txtBuscar.addKeyListener(new KeyAdapter() 
			{
				@Override
				public void keyReleased(KeyEvent arg0) 
				{
					filtrarTabla();
				}	
			});
			
			txtBuscar.setColumns(10);
			txtBuscar.setBounds(386, 8, 244, 25);
			pnlEliminarNadador.add(txtBuscar);
			
			tablaNadadores = new JTable();
			tablaNadadores.getTableHeader().setReorderingAllowed(false);
			tablaNadadores.getTableHeader().setResizingAllowed(false);
			tablaNadadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablaNadadores.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarTodosNadadores()));
			
			JScrollPane spEliminarNadador = new JScrollPane(tablaNadadores);
			spEliminarNadador.setBounds(6, 40, 624, 276);
			pnlEliminarNadador.add(spEliminarNadador);
			
		//...fin labels, txtFields y tabla--
		
			
		//--Inicio botones...
			JButton btnEliminarNadador = new JButton("Eliminar Nadador");
			btnEliminarNadador.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{	 
					
					int dni= (int) tablaNadadores.getValueAt(tablaNadadores.getSelectedRow(), 0);
					ControladorNatacion.getInstance().eliminarNadador(dni);
					JOptionPane.showMessageDialog(pnlEliminarNadador, "Nadador Eliminado");
				}
			});
			
			btnEliminarNadador.setBounds(408, 328, 222, 31);
			pnlEliminarNadador.add(btnEliminarNadador);
			
			JButton btnModificarNadador = new JButton("Modificar Nadador");
			btnModificarNadador.setBounds(6, 328, 222, 31);
			pnlEliminarNadador.add(btnModificarNadador);
		
		//...fin botones--
	//...la segunda etiqueta del panel tabulado--
			
	//--Definición del otro panel del cardLayout:...
		JPanel pnlModificarNadador = new JPanel();
		getContentPane().add(pnlModificarNadador, "pnlModificarNadador");
		pnlModificarNadador.setLayout(null);
		
		//--Inicio labels...
			JLabel lblModificaDNI = new JLabel("DNI:");
			lblModificaDNI.setBounds(6, 12, 79, 14);
			pnlModificarNadador.add(lblModificaDNI);
			
			JLabel lblModificaNombre = new JLabel("Nombre:");
			lblModificaNombre.setBounds(6, 49, 79, 14);
			pnlModificarNadador.add(lblModificaNombre);
		
			JLabel lblModificaApellid = new JLabel("Apellido:");
			lblModificaApellid.setBounds(6, 86, 79, 14);
			pnlModificarNadador.add(lblModificaApellid);
			
			JLabel lblModificaNacimiento = new JLabel("Nacimiento:");
			lblModificaNacimiento.setBounds(6, 123, 79, 14);
			pnlModificarNadador.add(lblModificaNacimiento);
			
			JLabel lblErrorEdadModificarNadador = new JLabel("");
			lblErrorEdadModificarNadador.setForeground(Color.RED);
			lblErrorEdadModificarNadador.setBounds(305, 86, 186, 14);
			pnlModificarNadador.add(lblErrorEdadModificarNadador);
			
			JLabel lblModificaClub = new JLabel("Club:");
			lblModificaClub.setBounds(6, 159, 79, 14);
			pnlModificarNadador.add(lblModificaClub);
			
			JLabel lblModificaSexo = new JLabel("Sexo:");
			lblModificaSexo.setBounds(6, 196, 79, 14);
			pnlModificarNadador.add(lblModificaSexo);		
		//...fin labels--
		
		//--Inicio ComboBoxes...
			JComboBox<String> cbModificaSexo = new JComboBox<String>(opciones);
			cbModificaSexo.setBounds(97, 191, 329, 25);
			pnlModificarNadador.add(cbModificaSexo);
			
			JComboBox<Club> cbModificarClubAnfitrion = new JComboBox<Club>(UtilidadesEscritorio.generarModeloComboBox(cc.buscarClubes()));
			cbModificarClubAnfitrion.setBounds(97, 154, 329, 25);
			pnlModificarNadador.add(cbModificarClubAnfitrion);
		//...fin ComboBoxes--
			
		//--Inicio TextFields...
			txtModificaDni = new JTextField();
			txtModificaDni.setEditable(false);
			txtModificaDni.setColumns(10);
			txtModificaDni.setBounds(97, 6, 329, 25);
			pnlModificarNadador.add(txtModificaDni);
			
			txtModificaNombre = new JTextField();
			txtModificaNombre.setColumns(10);
			txtModificaNombre.setBounds(97, 43, 329, 25);
			pnlModificarNadador.add(txtModificaNombre);
			
			txtModificaApellido = new JTextField();
			txtModificaApellido.setColumns(10);
			txtModificaApellido.setBounds(97, 80, 329, 25);
			pnlModificarNadador.add(txtModificaApellido);
			
			txtModificaFechaNacimiento = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##/##/####"));
			txtModificaFechaNacimiento.setColumns(10);
			txtModificaFechaNacimiento.setBounds(97, 117, 329, 25);
			pnlModificarNadador.add(txtModificaFechaNacimiento);
		//...finTextFields--
			
		//--Inicio botones...
			btnModificarNadador.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseReleased(MouseEvent arg0) 
				{
					cargarPanelModificar(cbModificaSexo, cbModificarClubAnfitrion);
				}
			});
			
			JButton btnGuardarDatos = new JButton("Guardar Datos");
			btnGuardarDatos.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseReleased(MouseEvent arg0) 
				{
					/*Club club = (Club) cbModificarClubAnfitrion.getSelectedItem();
					char sexo;
					if(cbModificaSexo.getSelectedIndex()== 0) sexo='m'; else sexo='f';
					ControladorNatacion.getInstance().modificarNadador(Integer.parseInt(txtModificaDni.getText()),txtModificaApellido.getText(),txtModificaNombre.getText(),club.getNroClub(), sexo, txtModificaFechaNacimiento.getText());
					*/
					modificarNadador(cbModificaSexo, cbModificarClubAnfitrion);
					JOptionPane.showMessageDialog(pnlModificarNadador, "Nadador Modificado");
					volverAlPanelNadadores();
					tablaNadadores.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarTodosNadadores()));
					
				}
			});
			btnGuardarDatos.setBounds(408, 358, 222, 31);
			pnlModificarNadador.add(btnGuardarDatos);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseReleased(MouseEvent arg0) 
				{
					volverAlPanelNadadores();
				}
			});
			btnVolver.setBounds(6, 359, 222, 31);
			pnlModificarNadador.add(btnVolver);
		//...fin botones--
	//...--
	}
	

	private void cargarPanelModificar(JComboBox<String> cbSexo, JComboBox<Club> cbClubes)
	{
		int i = tablaNadadores.getSelectedRow();
		if (i != -1)
		{
			Nadador nadadorActual = ControladorNatacion.getInstance().buscarNadadorPorDni((int)tablaNadadores.getValueAt(i, 0));			
			txtModificaNombre.setText(nadadorActual.getNombre());
			txtModificaApellido.setText(nadadorActual.getApellido());
			txtModificaDni.setText(Integer.toString(nadadorActual.getDni()));
			txtModificaFechaNacimiento.setText(nadadorActual.getFechaNacimiento());
			CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
			cardLayout.show(getContentPane(), "pnlModificarNadador");
			if(nadadorActual.getSexo() == 'm')
				cbSexo.setSelectedIndex(0);
			else
				cbSexo.setSelectedIndex(1);
			for(Club c : ControladorNatacion.getInstance().buscarClubes())
			{
				if (c.getNroClub() == nadadorActual.getNroClub())
					cbClubes.getModel().setSelectedItem(c);
			}
		}
		else
			JOptionPane.showMessageDialog(getContentPane(), "Seleccione un nadador para modificar.");
	}
		
	private void modificarNadador(JComboBox<String> cbSexo, JComboBox<Club> cbClubes)
	{
		int dni=Integer.parseInt(txtModificaDni.getText());
		int nroClub=((Club) cbClubes.getSelectedItem()).getNroClub();
		String nombre=txtModificaNombre.getText();
		String apellido=txtModificaApellido.getText();
		String fechaNacimiento=txtModificaFechaNacimiento.getText();
		char sexo;
		if(cbSexo.getSelectedIndex() == 0) sexo='m'; else sexo='f';
		ControladorNatacion.getInstance().modificarNadador(dni, apellido, nombre, nroClub, sexo, fechaNacimiento);

	}
	
	private void volverAlPanelNadadores()
	{
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "tabbedPane");
	}

	private void cargarNadador(JComboBox<String> cbSexo, JComboBox<Club> cbClubes)
	{	 
		
		int dni=Integer.parseInt(txtNuevoDni.getText());
		int nroClub=((Club) cbClubes.getSelectedItem()).getNroClub();
		String nombre=txtNuevoNombre.getText();
		String apellido=txtNuevoApellido.getText();
		String fechaNacimiento=txtNuevoFechaNacimiento.getText();
		//Formateador de la fecha--
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fechaMinimaPosible = ("01/01/1990");
		try 
		{
		Date fechaActual = new Date();
		Date fechaNac = formatter.parse(fechaNacimiento);
		Date fechaMinima = formatter.parse(fechaMinimaPosible);
		
			if(fechaNac.before(fechaActual) && fechaNac.after(fechaMinima))
			{
				char sexo;
				if(cbSexo.getSelectedIndex() == 0) sexo='m'; else sexo='f';
			
					if(!ControladorNatacion.getInstance().existeNadador(dni))
					{
					
					ControladorNatacion.getInstance().cargarNadador(sexo, nombre, apellido, fechaNacimiento, dni, nroClub);
					JOptionPane.showMessageDialog(null, "Nadador Cargado Correctamente");
					this.limpiarCampos();
					tablaNadadores.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarTodosNadadores()));
					}
					else
					{
					JOptionPane.showMessageDialog(pnlAgregarNadador, "Ya existe el nadador");
					limpiarCampos();
					}
			} 
			else
			{
			JOptionPane.showMessageDialog(pnlAgregarNadador, "No es posible registrar esa fecha");
			}
		}
		
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		
	
		}
			
		
		
		
		
		
		
		
	
	
	private void filtrarTabla()
	{
		if (!txtBuscar.getText().isEmpty())
		{
			if (UtilidadesEscritorio.esNumerico(txtBuscar.getText()))
			{
				tablaNadadores.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarMuchosNadadoresPorDni(Integer.parseInt(txtBuscar.getText()))));
			}
			else if (Pattern.matches("[a-zA-Z]+", txtBuscar.getText()))
			{
				tablaNadadores.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarMuchosNadadoresPorNombreYApellido(txtBuscar.getText())));
			}
			else if (txtBuscar.getText().charAt(0) == ' ')
			{
				txtBuscar.setText("");
			}
		}
		else
		{
			tablaNadadores.setModel(UtilidadesEscritorio.crearModeloTabla(cc.buscarTodosNadadores()));
		}
	}
	
	private void eliminarNadador()
	{
		int i=tablaNadadores.getSelectedRow();
		if (i != -1)
		{
			int dni=(int) tablaNadadores.getValueAt(i, 2);
			ControladorNatacion.getInstance().eliminarNadador(dni);
			JOptionPane.showMessageDialog(null, "Nadador Eliminado Correctamente");
		}
		else JOptionPane.showMessageDialog(getContentPane(), "Seleccione un nadador para eliminar.");
	}
	
	private void limpiarCampos(){
		
		txtNuevoDni.setText("");
		txtNuevoNombre.setText("");
		txtNuevoApellido.setText("");
		txtNuevoFechaNacimiento.setText("");
		
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
