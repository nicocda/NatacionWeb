package presentacion;


import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;



import datos.CatalogoNadadores;
import negocio.ControladorNatacion;
import entidades.Carrera;
import entidades.Inscripcion;
import entidades.Nadador;
import entidades.Serie;
import entidades.Torneo;
import util.UtilidadesEscritorio;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class FrameAdministrarTiempoPostCarrera extends JInternalFrame implements InternalFrameListener {
	private JTextField txtTiempo2;
	private JTextField txtTiempo3;
	private JTextField txtTiempo4;
	private JTextField txtTiempo5;
	private JTextField txtTiempo1;
	private JTextField txtTiempo6;
	private JLabel lblNadador1;
	private JLabel lblNadador2;
	private JLabel lblNadador3;
	private JLabel lblNadador4;
	private JLabel lblNadador5;
	private JLabel lblNadador6;
	private JLabel num1;
	private JLabel num2;
	private JLabel num3;
	private JLabel num4;
	private JLabel num5;
	private JLabel num6;
	private JComboBox<String> cbDescalificado1;
	private JComboBox<String> cbDescalificado2;
	private JComboBox<String> cbDescalificado3;
	private JComboBox<String> cbDescalificado4;
	private JComboBox<String> cbDescalificado5;
	private JComboBox<String> cbDescalificado6;
	private JCheckBox chckbxDescalificado1;
	private JCheckBox chckbxDescalificado2;
	private JCheckBox chckbxDescalificado3;
	private JCheckBox chckbxDescalificado4;
	private JCheckBox chckbxDescalificado5;
	private JCheckBox chckbxDescalificado6;
	private JLabel lblMotivoDescalificacion;
	private JLabel lblAndariveles;
	private static FrameAdministrarTiempoPostCarrera instancia = null;
	private JTextField txtTorneo;
	private JPanel pnlIngresarTiempo;
	
	
	public FrameAdministrarTiempoPostCarrera() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameAdministrarTiempoPostCarrera obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameAdministrarTiempoPostCarrera();
		}
		return instancia;
	}
	
	public static FrameAdministrarTiempoPostCarrera devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
			setTitle("Tiempos Post Competencia");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setIconifiable(true);
			setClosable(true);
			getContentPane().setLayout(new CardLayout(0, 0));
	
			
	 
		setBounds(100, 100, 772, 532);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane pnlAdministrarTiempo = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(pnlAdministrarTiempo, "name_341738282498092");
		
		JPanel pnlIngresarTiempo = new JPanel();
		pnlAdministrarTiempo.addTab("Ingresar Tiempos", null, pnlIngresarTiempo, null);
		pnlIngresarTiempo.setLayout(null);
		
		setTitle("Administrar Tiempos PostCompetencia");
		
		JComboBox<Serie> cbSeries = new JComboBox<Serie>();
		ActionListener alSerie = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				rellenarCampos(cbSeries);
			}
		};
		cbSeries.addActionListener(alSerie);
		cbSeries.setBounds(101, 83, 522, 25);
		pnlIngresarTiempo.add(cbSeries);
		
		JComboBox<Carrera> cbCarreras = new JComboBox<Carrera>();
		
		cbCarreras.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiar();
				cargarComboSeries(cbCarreras, cbSeries, alSerie);
			}
		});
		cbCarreras.setBounds(101, 47, 522, 25);
		pnlIngresarTiempo.add(cbCarreras);
		
		
		JLabel lblNewLabel = new JLabel("Carrera:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 51, 77, 14);
		pnlIngresarTiempo.add(lblNewLabel);
		
		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSerie.setBounds(12, 83, 67, 23);
		pnlIngresarTiempo.add(lblSerie);
		

		
		lblAndariveles = new JLabel(" ");
		lblAndariveles.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndariveles.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAndariveles.setBounds(64, 119, 416, 32);
		pnlIngresarTiempo.add(lblAndariveles);
		
		txtTiempo2 = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##:##"));
		txtTiempo2.setVisible(false);
		txtTiempo2.setBounds(364, 198, 116, 25);
		pnlIngresarTiempo.add(txtTiempo2);
		txtTiempo2.setColumns(10);
		
		
		txtTiempo3 = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##:##"));
		txtTiempo3.setVisible(false);
		txtTiempo3.setColumns(10);
		txtTiempo3.setBounds(364, 234, 116, 25);
		pnlIngresarTiempo.add(txtTiempo3);
		
		txtTiempo4 = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##:##"));
		txtTiempo4.setVisible(false);
		txtTiempo4.setColumns(10);
		txtTiempo4.setBounds(364, 270, 116, 25);
		pnlIngresarTiempo.add(txtTiempo4);
		
		txtTiempo5 = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##:##"));
		txtTiempo5.setVisible(false);
		txtTiempo5.setColumns(10);
		txtTiempo5.setBounds(364, 306, 116, 25);
		pnlIngresarTiempo.add(txtTiempo5);
		
		txtTiempo1 = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##:##"));
		txtTiempo1.setVisible(false);
		txtTiempo1.setColumns(10);
		txtTiempo1.setBounds(364, 162, 116, 25);
		pnlIngresarTiempo.add(txtTiempo1);
		
		txtTiempo6 = new JFormattedTextField(UtilidadesEscritorio.generarMascara("##:##"));
		txtTiempo6.setVisible(false);
		txtTiempo6.setColumns(10);
		txtTiempo6.setBounds(364, 342, 116, 25);
		pnlIngresarTiempo.add(txtTiempo6);
		
		
		lblNadador1 = new JLabel(" ");
		lblNadador1.setBounds(115, 162, 225, 25);
		pnlIngresarTiempo.add(lblNadador1);
		
		lblNadador2 = new JLabel(" ");
		lblNadador2.setBounds(115, 198, 225, 25);
		pnlIngresarTiempo.add(lblNadador2);
		
		lblNadador3 = new JLabel(" ");
		lblNadador3.setBounds(115, 234, 225, 25);
		pnlIngresarTiempo.add(lblNadador3);
		
		lblNadador4 = new JLabel(" ");
		lblNadador4.setBounds(115, 270, 225, 25);
		pnlIngresarTiempo.add(lblNadador4);
		
		lblNadador5 = new JLabel(" ");
		lblNadador5.setBounds(115, 306, 225, 20);
		pnlIngresarTiempo.add(lblNadador5);
		
		lblNadador6 = new JLabel(" ");
		lblNadador6.setBounds(115, 342, 225, 20);
		pnlIngresarTiempo.add(lblNadador6);
		
		num1 = new JLabel("1");
		num1.setBounds(64, 164, 24, 23);
		num1.setVisible(false);
		pnlIngresarTiempo.add(num1);
		
		
		num2 = new JLabel("2");
		num2.setBounds(64, 200, 24, 23);
		num2.setVisible(false);
		pnlIngresarTiempo.add(num2);
		
		num3 = new JLabel("3");
		num3.setBounds(64, 236, 24, 23);
		num3.setVisible(false);
		pnlIngresarTiempo.add(num3);
		
		num4 = new JLabel("4");
		num4.setBounds(64, 272, 24, 23);
		num4.setVisible(false);
		pnlIngresarTiempo.add(num4);
		
		num5 = new JLabel("5");
		num5.setBounds(64, 308, 24, 17);
		num5.setVisible(false);
		pnlIngresarTiempo.add(num5);
		
		num6 = new JLabel("6");
		num6.setBounds(64, 344, 24, 17);
		num6.setVisible(false);
		pnlIngresarTiempo.add(num6);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmar(cbSeries, cbCarreras);
				//TENGO QUE INSERTAR LOS TIEMPOS DE POSTCOMPETICION EN LA INSCRIPCION
				//ControladorNatacion.getInstance().cargarTiempo(ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(),
				//											ControladorNatacion.getInstance().getTorneoActual().getNroPrograma(), nroCarrera, nroNadador, tiempo);
				
			}
		});
		btnConfirmar.setBounds(348, 413, 165, 38);
		pnlIngresarTiempo.add(btnConfirmar);
		
		Torneo torneoActual = ControladorNatacion.getInstance().getTorneoActual();
		
		txtTorneo = new JTextField();
		txtTorneo.setEnabled(false);
		txtTorneo.setBounds(101, 11, 363, 25);
		pnlIngresarTiempo.add(txtTorneo);
		txtTorneo.setColumns(10);
		
		if (torneoActual != null)
		{
			txtTorneo.setText("Programa: " + torneoActual.getNroPrograma() + " Fecha: " + torneoActual.getFecha());
			cbCarreras.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarCarrerasPrograma(ControladorNatacion.getInstance().getTorneoActual().getNroPrograma())));
			cargarComboSeries(cbCarreras, cbSeries, alSerie);
		}
		else
			txtTorneo.setText("No se ha seleccionado ningún torneo");
		
		JLabel lblTorneo = new JLabel("Torneo");
		lblTorneo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTorneo.setBounds(12, 16, 77, 14);
		pnlIngresarTiempo.add(lblTorneo);
		
		JButton btnCambiarTorneo = new JButton("Cambiar Torneo");
		btnCambiarTorneo.setBounds(474, 11, 149, 25);
		pnlIngresarTiempo.add(btnCambiarTorneo);
		
		lblMotivoDescalificacion = new JLabel(" ");
		lblMotivoDescalificacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotivoDescalificacion.setBounds(500, 123, 149, 25);
		pnlIngresarTiempo.add(lblMotivoDescalificacion);
		

		chckbxDescalificado1 = new JCheckBox("Descalificado");
		chckbxDescalificado1.setVisible(false);
		chckbxDescalificado1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxDescalificado1.isSelected())
				{
					chckbxDescalificado1.setSelected(true);
					cbDescalificado1.setVisible(true);
				}
				else
				{
					chckbxDescalificado1.setSelected(false);
					cbDescalificado1.setVisible(false);
				}
				
			}
		});
		chckbxDescalificado1.setBounds(486, 164, 97, 23);
		pnlIngresarTiempo.add(chckbxDescalificado1);
		
		chckbxDescalificado2 = new JCheckBox("Descalificado");
		chckbxDescalificado2.setVisible(false);
		chckbxDescalificado2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxDescalificado2.isSelected())
				{
					chckbxDescalificado2.setSelected(true);
					cbDescalificado2.setVisible(true);
				}
				else
				{
					chckbxDescalificado2.setSelected(false);
					cbDescalificado2.setVisible(false);
				}
				
			}
		});
		chckbxDescalificado2.setBounds(486, 200, 97, 23);
		pnlIngresarTiempo.add(chckbxDescalificado2);
		
		chckbxDescalificado3 = new JCheckBox("Descalificado");
		chckbxDescalificado3.setVisible(false);
		chckbxDescalificado3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxDescalificado3.isSelected())
				{
					chckbxDescalificado3.setSelected(true);
					cbDescalificado3.setVisible(true);
				}
				else
				{
					chckbxDescalificado3.setSelected(false);
					cbDescalificado3.setVisible(false);
				}
				
			}
		});
		chckbxDescalificado3.setBounds(486, 236, 97, 23);
		pnlIngresarTiempo.add(chckbxDescalificado3);
		
		chckbxDescalificado4 = new JCheckBox("Descalificado");
		chckbxDescalificado4.setVisible(false);
		chckbxDescalificado4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxDescalificado4.isSelected())
				{
					chckbxDescalificado4.setSelected(true);
					cbDescalificado4.setVisible(true);
				}
				else
				{
					chckbxDescalificado4.setSelected(false);
					cbDescalificado4.setVisible(false);
				}
				
			}
		});
		chckbxDescalificado4.setBounds(486, 272, 97, 23);
		pnlIngresarTiempo.add(chckbxDescalificado4);
		
		chckbxDescalificado5 = new JCheckBox("Descalificado");
		chckbxDescalificado5.setVisible(false);
		chckbxDescalificado5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxDescalificado5.isSelected())
				{
					chckbxDescalificado5.setSelected(true);
					cbDescalificado5.setVisible(true);
				}
				else
				{
					chckbxDescalificado5.setSelected(false);
					cbDescalificado5.setVisible(false);
				}
				
			}
		});
		chckbxDescalificado5.setBounds(486, 308, 97, 23);
		pnlIngresarTiempo.add(chckbxDescalificado5);
		
		chckbxDescalificado6 = new JCheckBox("Descalificado");
		chckbxDescalificado6.setVisible(false);
		chckbxDescalificado6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(chckbxDescalificado6.isSelected())
				{
					chckbxDescalificado6.setSelected(true);
					cbDescalificado6.setVisible(true);
				}
				else
				{
					chckbxDescalificado6.setSelected(false);
					cbDescalificado6.setVisible(false);
				}
				
			}
		});
		chckbxDescalificado6.setBounds(486, 344, 97, 23);
		pnlIngresarTiempo.add(chckbxDescalificado6);
		
		
		cbDescalificado1 = new JComboBox<String>();
		cbDescalificado1.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().getDescalificaciones()));
		cbDescalificado1.setBounds(579, 162, 149, 23);
		cbDescalificado1.setVisible(false);
		pnlIngresarTiempo.add(cbDescalificado1);
		
		cbDescalificado2 = new JComboBox<String>();
		cbDescalificado2.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().getDescalificaciones()));
		cbDescalificado2.setBounds(579, 198, 149, 23);
		cbDescalificado2.setVisible(false);
		pnlIngresarTiempo.add(cbDescalificado2);
		
		cbDescalificado3 = new JComboBox<String>();
		cbDescalificado3.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().getDescalificaciones()));
		cbDescalificado3.setBounds(579, 234, 149, 23);
		cbDescalificado3.setVisible(false);
		pnlIngresarTiempo.add(cbDescalificado3);
		
		cbDescalificado4 = new JComboBox<String>();
		cbDescalificado4.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().getDescalificaciones()));
		cbDescalificado4.setBounds(579, 270, 149, 23);
		cbDescalificado4.setVisible(false);
		pnlIngresarTiempo.add(cbDescalificado4);
		
		cbDescalificado5 = new JComboBox<String>();
		cbDescalificado5.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().getDescalificaciones()));
		cbDescalificado5.setBounds(579, 306, 149, 23);
		cbDescalificado5.setVisible(false);
		pnlIngresarTiempo.add(cbDescalificado5);
		
		cbDescalificado6 = new JComboBox<String>();
		cbDescalificado6.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().getDescalificaciones()));
		cbDescalificado6.setBounds(579, 342, 149, 23);
		cbDescalificado6.setVisible(false);
		pnlIngresarTiempo.add(cbDescalificado6);

		
	}
	
	private void cargarComboSeries(JComboBox<Carrera> cbCarreras, JComboBox<Serie> cbSeries, ActionListener alSerie) 
	{
		cbSeries.removeActionListener(alSerie);
		Carrera carreraSeleccionada = (Carrera)cbCarreras.getSelectedItem();
		cbSeries.setModel(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarSeriesPorCarrera(carreraSeleccionada.getNroCarrera(), carreraSeleccionada.getNroPrograma(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo())));
		cbSeries.setRenderer(new PromptComboBoxRenderer("<-Seleccione una serie->"));     
		cbSeries.setSelectedIndex(-1);
		cbSeries.addActionListener(alSerie);
	}
	
	private void rellenarCampos(JComboBox<Serie> cbSeries)
	{
		limpiar();
		Serie serie = cbSeries.getItemAt(cbSeries.getSelectedIndex());
		ArrayList<Inscripcion> inscrip = ControladorNatacion.getInstance().buscarInscripcion(serie.getNroSerie(), serie.getNroCarrera(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(),
				ControladorNatacion.getInstance().getTorneoActual().getNroPrograma());
		
		ArrayList<Nadador> nadadoresPorSerie = new ArrayList<Nadador>();
		Nadador nadador = new Nadador();
	
		for(Inscripcion i: inscrip)
		{
			nadador = ControladorNatacion.getInstance().buscarNadadorPorDni(i.getNroNadador());
			nadadoresPorSerie.add(nadador);
		}
		lblAndariveles.setText("ANDARIVELES");
		lblMotivoDescalificacion.setText("Motivo Descalificacion");
		for(Inscripcion i : inscrip)
		{
			if(i.getNroAndarivel()==1)
			{
				lblNadador1.setText(CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getNombre()+" "+CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getApellido());
				txtTiempo1.setVisible(true);
				num1.setVisible(true);
				chckbxDescalificado1.setVisible(true);
			}
			if(i.getNroAndarivel()==2)
			{
				lblNadador2.setText(CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getNombre()+" "+CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getApellido());
				txtTiempo2.setVisible(true);
				num2.setVisible(true);
				chckbxDescalificado2.setVisible(true);
			}
			if(i.getNroAndarivel()==3)
			{
				lblNadador3.setText(CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getNombre()+" "+CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getApellido());
				txtTiempo3.setVisible(true);
				num3.setVisible(true);
				chckbxDescalificado3.setVisible(true);
			}
			if(i.getNroAndarivel()==4)
			{
				lblNadador4.setText(CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getNombre()+" "+CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getApellido());
				txtTiempo4.setVisible(true);
				num4.setVisible(true);
				chckbxDescalificado4.setVisible(true);
			}
			if(i.getNroAndarivel()==5)
			{
				lblNadador5.setText(CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getNombre()+" "+CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getApellido());
				txtTiempo5.setVisible(true);
				num5.setVisible(true);
				chckbxDescalificado5.setVisible(true);
			}
			if(i.getNroAndarivel()==6)
			{
				lblNadador6.setText(CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getNombre()+" "+CatalogoNadadores.getInstance().buscarNadadorPorAndarivel(i).getApellido());
				txtTiempo6.setVisible(true);
				num6.setVisible(true);
				chckbxDescalificado6.setVisible(true);
			}
		}
	}
	
	private void limpiar(){
		lblAndariveles.setText(" ");
		lblMotivoDescalificacion.setText(" ");
		lblNadador1.setText(" ");
		lblNadador2.setText(" ");
		lblNadador3.setText(" ");
		lblNadador4.setText(" ");
		lblNadador5.setText(" ");
		lblNadador6.setText(" ");
		txtTiempo1.setVisible(false);
		txtTiempo2.setVisible(false);
		txtTiempo3.setVisible(false);
		txtTiempo4.setVisible(false);
		txtTiempo5.setVisible(false);
		txtTiempo6.setVisible(false);
		num1.setVisible(false);
		num2.setVisible(false);
		num3.setVisible(false);
		num4.setVisible(false);
		num5.setVisible(false);
		num6.setVisible(false);
		chckbxDescalificado1.setVisible(false);
		chckbxDescalificado2.setVisible(false);
		chckbxDescalificado3.setVisible(false);
		chckbxDescalificado4.setVisible(false);
		chckbxDescalificado5.setVisible(false);
		chckbxDescalificado6.setVisible(false);
		chckbxDescalificado1.setSelected(false);
		chckbxDescalificado2.setSelected(false);
		chckbxDescalificado3.setSelected(false);
		chckbxDescalificado4.setSelected(false);
		chckbxDescalificado5.setSelected(false);
		chckbxDescalificado6.setSelected(false);
		cbDescalificado1.setVisible(false);
		cbDescalificado2.setVisible(false);
		cbDescalificado3.setVisible(false);
		cbDescalificado4.setVisible(false);
		cbDescalificado5.setVisible(false);
		cbDescalificado6.setVisible(false);
	}
	
	private void confirmar(JComboBox<Serie> cbSeries, JComboBox<Carrera> cbCarreras)
	{

		Serie serie = (Serie)cbSeries.getSelectedItem();
		Carrera carrera = (Carrera)cbCarreras.getSelectedItem();
		//Traigo la inscripcion
		ArrayList<Inscripcion> inscrip = ControladorNatacion.getInstance().buscarInscripcion(serie.getNroSerie(), carrera.getNroCarrera(), ControladorNatacion.getInstance().getTorneoActual().getNroTorneo(),
				ControladorNatacion.getInstance().getTorneoActual().getNroPrograma());
		String[] tiempo = new  String[6];
		 if(!chckbxDescalificado1.isSelected()) tiempo[0] = txtTiempo1.getText(); else tiempo[0] = "59:59:99";
		 if(!chckbxDescalificado2.isSelected()) tiempo[1] = txtTiempo2.getText(); else tiempo[1] = "59:59:99";
		 if(!chckbxDescalificado3.isSelected()) tiempo[2] = txtTiempo3.getText(); else tiempo[2] = "59:59:99";
		 if(!chckbxDescalificado4.isSelected()) tiempo[3] = txtTiempo4.getText(); else tiempo[3] = "59:59:99";
		 if(!chckbxDescalificado5.isSelected()) tiempo[4] = txtTiempo5.getText(); else tiempo[4] = "59:59:99";
		 if(!chckbxDescalificado6.isSelected()) tiempo[5] = txtTiempo6.getText(); else tiempo[5] = "59:59:99";
		 int[] nroNadadores = new  int[6];
		 for(int i=0;i<inscrip.size();i++)
		 {
			 nroNadadores[i] =  inscrip.get(i).getNroNadador();
			 
		 }
		 
		 ArrayList<String> descalificaciones = new ArrayList<String>();
		 if(chckbxDescalificado1.isSelected()){
			 									descalificaciones.add((String)cbDescalificado1.getSelectedItem());
			 									txtTiempo1.setText("59:59:99");
		 									  }
		 										else descalificaciones.add(" ");
		 if(chckbxDescalificado2.isSelected()){
			 									descalificaciones.add((String)cbDescalificado2.getSelectedItem());
			 									txtTiempo2.setText("59:59:99");
		 									  }
		 										else descalificaciones.add(" ");
		 if(chckbxDescalificado3.isSelected()) {
												descalificaciones.add((String)cbDescalificado3.getSelectedItem());
												txtTiempo3.setText("59:59:99"); 
											   }
		 										else descalificaciones.add(" ");
		 if(chckbxDescalificado4.isSelected()) {
			 									descalificaciones.add((String)cbDescalificado4.getSelectedItem());
			 									txtTiempo4.setText("59:59:99");
		 									   }
			 									else descalificaciones.add(" "); 
		 if(chckbxDescalificado5.isSelected()) {
													 descalificaciones.add((String)cbDescalificado5.getSelectedItem());
													 txtTiempo5.setText("59:59:99");
											   } 
												else descalificaciones.add(" "); 
		 if(chckbxDescalificado6.isSelected()) {
			 										descalificaciones.add((String)cbDescalificado6.getSelectedItem());
			 										txtTiempo6.setText("59:59:99");
		 									   }
												else descalificaciones.add(" ");
		 boolean[] checkboxs = new boolean[6];
		 checkboxs[0] = chckbxDescalificado1.isSelected();
		 checkboxs[1] = chckbxDescalificado2.isSelected();
		 checkboxs[2] = chckbxDescalificado3.isSelected();
		 checkboxs[3] = chckbxDescalificado4.isSelected();
		 checkboxs[4] = chckbxDescalificado5.isSelected();
		 checkboxs[5] = chckbxDescalificado6.isSelected();

		 
		 if((txtTiempo1.isVisible()&&txtTiempo1.getText().equals("  :  :  ")) || (txtTiempo2.isVisible()&&txtTiempo2.getText().equals("  :  :  ")) || (txtTiempo3.isVisible()&&txtTiempo3.getText().equals("  :  :  "))
				 || (txtTiempo4.isVisible()&&txtTiempo4.getText().equals("  :  :  ")) || (txtTiempo5.isVisible()&&txtTiempo5.getText().equals("  :  :  ")) || (txtTiempo6.isVisible()&&txtTiempo6.getText().equals("  :  :  ")))
		 {
		 JOptionPane.showMessageDialog(pnlIngresarTiempo, "Falta cargar tiempo/s");
		 }
		 else
		 {
		 ControladorNatacion.getInstance().cargarDescalificacion(serie.getNroTorneo(),serie.getNroPrograma(),serie.getNroCarrera(), serie.getNroSerie(), descalificaciones, checkboxs);
		 ControladorNatacion.getInstance().cargarTiempo(serie.getNroTorneo(),serie.getNroPrograma(),serie.getNroCarrera(),serie.getNroSerie(),tiempo);
		 JOptionPane.showMessageDialog(pnlIngresarTiempo, "Datos Cargados");
		 limpiarTxtTiempos();
		 }
	}
	
	public void limpiarTxtTiempos()
	{
		if(txtTiempo1.isVisible()==true)
		txtTiempo1.setText(null);
		if(txtTiempo2.isVisible()==true)
		txtTiempo2.setText(null);
		if(txtTiempo3.isVisible()==true)
		txtTiempo3.setText(null);
		if(txtTiempo4.isVisible()==true)
		txtTiempo4.setText(null);
		if(txtTiempo5.isVisible()==true)
		txtTiempo5.setText(null);
		if(txtTiempo6.isVisible()==true)
		txtTiempo6.setText(null);
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
