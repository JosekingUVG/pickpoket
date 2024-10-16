import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class UsuariosGUI extends JFrame {
	
	//Usa esta interfaz como plantilla de como hacer una interfaz gáfica
	
	
	//Primero debemos declarar nuestras variables
	
	
	private JTextField tfNombre1;
	private JTextField tfNombre2;
	
	private JTextField tfPassword1;
	private JTextField tfPassword2;

	private String[] tipo = {"Admin","Vendedor"};
	
	private JComboBox cbTipo1;
	private JComboBox cbTipo2;
	private JComboBox cargarUsuario;

	
	private JButton btnAceptar1;
	
	private JButton btnAceptar2;
	
	private JButton btnAceptar3;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuariosGUI frame = new UsuariosGUI();
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
	public UsuariosGUI() {
		inicializador();
	}
	 public void inicializador() {
		//Se debe crear un objeto que escuche los botnes, se crea en la parte de abajo
			Escucha MP_microfono = new Escucha();
			
			//Primero se crea la ventana, sus dimensiones, etc. 
			 
			setTitle("Registro de usuarios");
			setBounds(100, 100, 523, 346);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 3), "Registro de Usuarios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 192)));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setBackground(new Color(176, 230, 255));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 3, true), "Edici\u00F3n de Usuarios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 192)));
			getContentPane().add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			panel_1.setBackground(new Color(176, 230, 255));
			
			cargarUsuario = new JComboBox(tipo);
			panel_1.add(cargarUsuario);
			
			btnAceptar2 = new JButton("Aceptar");
			panel_1.add(btnAceptar2);
			panel.setLayout(new GridLayout(4, 2, 0, 0));

			
			JLabel lblNewLabel_1 = new JLabel("Nombre");
			panel.add(lblNewLabel_1);
			
			tfNombre1 = new JTextField();
			panel.add(tfNombre1);
			tfNombre1.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Contraseña");
			panel.add(lblNewLabel);
			
			tfPassword1 = new JTextField();
			panel.add(tfPassword1);
			tfPassword1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Tipo");
			panel.add(lblNewLabel_2);
			
			cbTipo1 = new JComboBox(tipo);
			panel.add(cbTipo1);
			
			btnAceptar1= new JButton("Aceptar");
			panel.add(btnAceptar1);
			
			
			JLabel lblNewLabel_11 = new JLabel("Nombre");
			lblNewLabel_11.setEnabled(false);
			panel_1.add(lblNewLabel_11);
			
			tfNombre2 = new JTextField();
			tfNombre2.setEnabled(false);
			panel_1.add(tfNombre2);
			tfNombre2.setColumns(10);
			
			JLabel lblNewLabel2 = new JLabel("Contraseña");
			lblNewLabel2.setEnabled(false);
			panel_1.add(lblNewLabel2);
			
			tfPassword2 = new JTextField();
			tfPassword2.setEnabled(false);
			panel_1.add(tfPassword2);
			tfPassword2.setColumns(10);
			
			JLabel lblNewLabel_22 = new JLabel("Tipo");
			lblNewLabel_22.setEnabled(false);
			panel_1.add(lblNewLabel_22);
			
			cbTipo2 = new JComboBox(tipo);
			cbTipo2.setEnabled(false);
			panel_1.add(cbTipo2);
			
			btnAceptar3= new JButton("Aceptar");
			btnAceptar3.setEnabled(false);
			panel_1.add(btnAceptar3);
			
	 }
	 
	 private class Escucha implements ActionListener {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
	 }

}
