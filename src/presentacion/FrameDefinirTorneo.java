package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import entidades.Club;
import entidades.Torneo;
import negocio.ControladorNatacion;
import util.UtilidadesEscritorio;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameDefinirTorneo extends JInternalFrame implements InternalFrameListener {

	private static FrameDefinirTorneo instancia= null;
	private JButton btnElegirTorneo;
	private JComboBox<Torneo> cbTorneos;

	public JButton getBtnElegirTorneo()
	{
		return btnElegirTorneo;
	}

	public FrameDefinirTorneo() 
	{
        initComponents();
        addInternalFrameListener(this);
    }
	
	public static FrameDefinirTorneo obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameDefinirTorneo();
		}
		return instancia;
	}
	
	public static FrameDefinirTorneo devolverInstancia()
	{
		return instancia;
	}

	public void initComponents() 
	{
		//--Definición del...
		setTitle("Definir Torneo Actual");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(27, 11, 531, 280);
	//...frame--
		
		getContentPane().setLayout(null);
        
        
        cbTorneos = new JComboBox<Torneo>(UtilidadesEscritorio.generarModeloComboBox(ControladorNatacion.getInstance().buscarTorneos()));
        cbTorneos.setBounds(10, 36, 495, 29);
        getContentPane().add(cbTorneos);
        cbTorneos.setRenderer(new PromptComboBoxRenderer("<-Seleccione un Torneo->"));    
        cbTorneos.setSelectedIndex(-1);
        getContentPane().add(cbTorneos);

        btnElegirTorneo = new JButton("Elegir Torneo");
        btnElegirTorneo.setBounds(309, 201, 196, 38);
        getContentPane().add(btnElegirTorneo);
        
        JLabel lblSeleccioneUnTorneo = new JLabel("Seleccione un torneo con el cual trabajar:");
        lblSeleccioneUnTorneo.setBounds(10, 11, 442, 14);
        getContentPane().add(lblSeleccioneUnTorneo);
        
        JLabel lblAdvertencia = new JLabel("El torneo que elija ser\u00E1 utilizado por defecto en el programa para el resto de los m\u00F3dulos");
        lblAdvertencia.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdvertencia.setForeground(Color.RED);
        lblAdvertencia.setBounds(10, 88, 495, 14);
        getContentPane().add(lblAdvertencia);
        
        JButton btnNoElegirTorneo = new JButton("No elegir torneo");
        btnNoElegirTorneo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		dispose();
        	}
        });
        btnNoElegirTorneo.setBounds(10, 201, 196, 38);
        getContentPane().add(btnNoElegirTorneo);
        
        JLabel lblAdvertencia_1 = new JLabel("Puede optar por no elegir un torneo, y se deshabilitaran algunas de los m\u00F3dulos");
        lblAdvertencia_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdvertencia_1.setForeground(Color.RED);
        lblAdvertencia_1.setBounds(10, 113, 495, 14);
        getContentPane().add(lblAdvertencia_1);
        
        
	}
	
	public String elegirTorneoActual()
	{
		if(cbTorneos.getSelectedIndex()!=-1)
		{
			Torneo torneoActual = (Torneo)cbTorneos.getSelectedItem();
			ControladorNatacion.getInstance().setTorneoActual(torneoActual);
			JOptionPane.showMessageDialog(getContentPane(), "Torneo definido.");
			Club clubActual = ControladorNatacion.getInstance().buscarClubPorNumeroClub(torneoActual.getNroClub());
			this.dispose();
			return "Programa: " + torneoActual.getNroPrograma() + ", Fecha: " + torneoActual.getFecha() + ", Club Anfitrión: " + clubActual.getNombre() + ", Localidad:" + clubActual.getLocalidad();
		}else
		{
			JOptionPane.showMessageDialog(getContentPane(), "Debe Seleccionar un Torneo");
			return " ";
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
