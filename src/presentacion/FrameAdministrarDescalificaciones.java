package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.ControladorNatacion;
import util.UtilidadesEscritorio;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class FrameAdministrarDescalificaciones extends JInternalFrame {
	private JTextField txtMotivo;
	private JTable tablaDescalificaciones;
	private static FrameAdministrarDescalificaciones instancia;
	private JTextField txtMotivoNuevo;
	
	
	
	public static FrameAdministrarDescalificaciones obtenerInstancia()
	{
		if (instancia == null)
		{
			instancia = new FrameAdministrarDescalificaciones();
		}
		return instancia;
	}
	
	public static FrameAdministrarDescalificaciones devolverInstancia()
	{
		return instancia;
	}

	
	public FrameAdministrarDescalificaciones() {
		setBounds(100, 100, 451, 289);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 435, 259);
		getContentPane().add(tabbedPane);
		
		JPanel pnlAgregarDescalificacion = new JPanel();
		tabbedPane.addTab("Agregar Motivo Descalific.", null, pnlAgregarDescalificacion, null);
		pnlAgregarDescalificacion.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Motivo Descalificaci\u00F3n:");
		lblNewLabel.setBounds(10, 32, 112, 24);
		pnlAgregarDescalificacion.add(lblNewLabel);
		
		txtMotivo = new JTextField();
		txtMotivo.setBounds(132, 34, 288, 25);
		pnlAgregarDescalificacion.add(txtMotivo);
		txtMotivo.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar Motivo");
		btnNewButton.setBounds(299, 197, 121, 23);
		pnlAgregarDescalificacion.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(10, 197, 89, 23);
		pnlAgregarDescalificacion.add(btnNewButton_1);
		
		JPanel pnlModificarDescalificacion = new JPanel();
		tabbedPane.addTab("Modificar Motivo Descalific.", null, pnlModificarDescalificacion, null);
		pnlModificarDescalificacion.setLayout(null);
		
		tablaDescalificaciones = new JTable(UtilidadesEscritorio.crearModeloTabla(ControladorNatacion.getInstance().getDescalificaciones()));
		
		JScrollPane spDescalificaciones = new JScrollPane(tablaDescalificaciones);
		spDescalificaciones.setBounds(10, 11, 410, 138);
		pnlModificarDescalificacion.add(spDescalificaciones);
		
		JButton btnNewButton_2 = new JButton("Eliminar Descalificacion");
		btnNewButton_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				String motivoViejo = (String) tablaDescalificaciones.getValueAt(tablaDescalificaciones.getSelectedRow(),0);
				int nro= ControladorNatacion.getInstance().getNroConDesc(motivoViejo);
				ControladorNatacion.getInstance().eliminarDescalificacion(nro);
				JOptionPane.showMessageDialog(pnlModificarDescalificacion, "Descalificacion eliminadad");
			}
		});
			
		btnNewButton_2.setBounds(230, 181, 190, 39);
		pnlModificarDescalificacion.add(btnNewButton_2);
		
		JButton btnModificarDescalificacin = new JButton("Modificar Descalificaci\u00F3n");
		btnModificarDescalificacin.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				String motivoViejo = (String) tablaDescalificaciones.getValueAt(tablaDescalificaciones.getSelectedRow(),0);
				int nro= ControladorNatacion.getInstance().getNroConDesc(motivoViejo);
				String motivoNuevo = txtMotivoNuevo.getText();
				ControladorNatacion.getInstance().modificarDescalificacion(nro, motivoNuevo);
				JOptionPane.showMessageDialog(pnlModificarDescalificacion, "Descalificacion modificada");
				txtMotivoNuevo.setText("");
			}
		});
		btnModificarDescalificacin.setBounds(10, 181, 190, 39);
		pnlModificarDescalificacion.add(btnModificarDescalificacin);
		
		txtMotivoNuevo = new JTextField();
		txtMotivoNuevo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMotivoNuevo.setText("Ingrese aqui el nuevo Motivo de descalificacion");
		txtMotivoNuevo.setBounds(10, 154, 410, 25);
		pnlModificarDescalificacion.add(txtMotivoNuevo);
		txtMotivoNuevo.setColumns(10);

	}
}
