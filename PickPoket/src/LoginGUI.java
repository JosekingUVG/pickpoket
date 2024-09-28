import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {
	
	//Usa esta interfaz como plantilla de como hacer una interfaz gáfica
	
	
	//Primero debemos declarar nuestras variables
	
	private JFrame fVentanita;
	private JTextField tfUsuario;
	private JButton btnAceptar;
	private JPasswordField tfPass;
	private loginCSV loginSystem;
	
	/**
	 * Necesario para correr la aplicación 
	 */
	public static void main(String[] args) {
		LoginGUI ventana =  new LoginGUI(); 
		ventana.fVentanita.setVisible(true);
	}
	
	//luego debes de inicializarlas en el constructor
	public LoginGUI() {
		initializate();
		loginSystem = new loginCSV();  // Inicializa loginSystem aquí

	}
	//Luego se crea la interfaz en esta función
	private void initializate() {
		
		//Se debe crear un objeto que escuche los botnes, se crea en la parte de abajo
		Escucha MP_microfono = new Escucha();
		
		//Primero se crea la ventana, sus dimensiones, etc. 
		fVentanita = new JFrame();
		fVentanita.setTitle("Login Pickpoket");
		fVentanita.setBounds(100, 100, 523, 346);
		fVentanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 230, 255));

		// Crea primero el borde con efecto grabado (EtchedBorder)
		Border etched = new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192));

		// Luego, añade este borde grabado dentro del borde con título
		panel.setBorder(new TitledBorder(etched, "Ingreso de datos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 128, 192)));

		// Añade el panel al centro de la ventana
		fVentanita.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		//Aquí se crean los labels, textfields y botones. 
		
		JLabel lblNewLabel = new JLabel("LOGIN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		tfUsuario = new JTextField();
		panel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		
		
		
		tfPass = new JPasswordField();
		panel.add(tfPass);
		tfPass.setColumns(10);
		
		btnAceptar = new JButton();
		btnAceptar.setBackground(new Color(183, 183, 219));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAceptar.setText("ACEPTAR");
		panel.add(btnAceptar);
		
		 // Añadir el ActionListener al botón
        btnAceptar.addActionListener(MP_microfono);

		
		
	}
	//Luego se crea las funciones para escuchar a los botones.
	
	
	/*Clase interna Escucha que implementa ActionListener
	*Esta clase es un listener (escuchador) que responde a eventos de acción, 
	*como hacer clic en un botón. Implementa la interfaz ActionListener, 
	*que requiere que implementes el método actionPerformed(). 
	*Este método se ejecuta cuando el usuario interactúa con un botón 
	*(u otro componente que genera eventos de acción).*/
	
	
	private class Escucha implements ActionListener {
    
		@Override
		public void actionPerformed(ActionEvent e) {
			// Obtenemos los datos del usuario desde los campos de texto
			String nombreUsuario = tfUsuario.getText();
			String contraseña = new String(tfPass.getPassword());
	
			try {
				// Intentar hacer login con el nombre de usuario y contraseña
				Usuario usuarioLogueado = loginSystem.loginUsuario(nombreUsuario, contraseña);
	
				if (usuarioLogueado != null) {
					// Si el login fue exitoso, redirigir dependiendo del tipo de usuario
					if (usuarioLogueado.getTipo() == 1) {
						// Si es Admin, abrir la interfaz AdminGUI
						JOptionPane.showMessageDialog(fVentanita, "Login exitoso como Admin", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						AdminGUI adminGUI = new AdminGUI();
						adminGUI.setVisible(true);
						fVentanita.dispose(); // Cerrar la ventana actual
	
					} else if (usuarioLogueado.getTipo() == 2) {
						// Si es Vendedor, abrir la interfaz VendedorGUI
						JOptionPane.showMessageDialog(fVentanita, "Login exitoso como Vendedor", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						VendedorGUI vendedorGUI = new VendedorGUI();
						vendedorGUI.setVisible(true);
						fVentanita.dispose(); // Cerrar la ventana actual
					}
				} else {
					// Si el login falla, mostrar mensaje de error
					JOptionPane.showMessageDialog(fVentanita, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException ex) {
				// Capturamos cualquier error de lectura del archivo CSV
				ex.printStackTrace();
				JOptionPane.showMessageDialog(fVentanita, "Error al leer el archivo de usuarios", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	


}
