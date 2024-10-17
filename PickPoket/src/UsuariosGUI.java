import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

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
import javax.swing.JOptionPane;
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
	private JButton btnEliminar;
	private JButton btnVolver;
	loginCSV usuarioLoader = new loginCSV();
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

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
			
			cargarUsuario = new JComboBox();
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
			
			lblNewLabel_4 = new JLabel("");
			panel.add(lblNewLabel_4);
			
			btnAceptar1= new JButton("Aceptar");
			panel.add(btnAceptar1);
			btnAceptar1.addActionListener(MP_microfono);
			
			
			JLabel lblNewLabel_11 = new JLabel("Nombre");
			panel_1.add(lblNewLabel_11);
			
			tfNombre2 = new JTextField();
			tfNombre2.setEnabled(false);
			panel_1.add(tfNombre2);
			tfNombre2.setColumns(10);
			
			JLabel lblNewLabel2 = new JLabel("Contraseña");
			panel_1.add(lblNewLabel2);
			
			tfPassword2 = new JTextField();
			tfPassword2.setEnabled(false);
			panel_1.add(tfPassword2);
			tfPassword2.setColumns(10);
			
			JLabel lblNewLabel_22 = new JLabel("Tipo");
			panel_1.add(lblNewLabel_22);
			
			cbTipo2 = new JComboBox(tipo);
			cbTipo2.setEnabled(false);
			panel_1.add(cbTipo2);
			
			btnAceptar3= new JButton("Aceptar");
			btnAceptar3.setEnabled(false);
			panel_1.add(btnAceptar3);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setEnabled(false);
			panel_1.add(btnEliminar);
			
			lblNewLabel_3 = new JLabel("");
			panel_1.add(lblNewLabel_3);
			
			btnVolver = new JButton("Volver");
			panel_1.add(btnVolver);
			
			
			//Añadir acciones a los botones:
			btnVolver.addActionListener(MP_microfono);
			
			//CARGAR LOS USUARIOS EN EL COMBOBOX
			 try {
		            // Llenar el JComboBox con los usuarios del archivo
		            cargarUsuariosEnComboBox();
		        } catch (IOException e) {
		            e.printStackTrace();
		            System.out.println("Error al cargar usuarios: " + e.getMessage());
		        }
			 btnAceptar2.addActionListener(MP_microfono);
			 btnAceptar3.addActionListener(MP_microfono);
			 btnEliminar.addActionListener(MP_microfono);

			
	 }
	 
	 private class Escucha implements ActionListener {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				//Volver a la interfaz admin
				if (e.getSource() == btnVolver) {
	                JOptionPane.showMessageDialog(null, "Has presionado el botón: Volver");
	                AdminGUI adminFrame = new AdminGUI();
	       	     	adminFrame.setVisible(true);

	       	     	// Cerrar el frame actual
	       	     	dispose();
	            } else if (e.getSource() == btnAceptar1){
					//Guardar los datos del usuario
					Usuario user = new Usuario();

					user.setNombre(tfNombre1.getText());
					user.setContraseña(tfPassword1.getText());
					int tipoUser;
					//Comparar si el item es Admin o Vendedor para cbTipo1
					if (cbTipo1.getSelectedItem().equals("Admin")) {
                        tipoUser = 1;
                    } else {
                        tipoUser = 2;
                    }
					user.setTipo(tipoUser);
					try {
						usuarioLoader.guardarUsuario(user);
						JOptionPane.showMessageDialog(null, "Usuario guardado correctamente");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error al guardar el usuario: " + e1.getMessage());
					}
					

				} else if (e.getSource() == btnAceptar2) {
					//Habilitar la edición y bloquear el btnAceptar1 y el cbCargarUsuario
					btnAceptar1.setEnabled(false);
					cargarUsuario.setEnabled(false);
					cbTipo2.setEnabled(true);
					btnAceptar3.setEnabled(true);
					btnEliminar.setEnabled(true);
					tfNombre2.setEnabled(true);
					tfPassword2.setEnabled(true);
					
				} else if (e.getSource() == btnAceptar3){
					//Editar el usuario que se haya elegido:
					Usuario user = new Usuario();
					user.setNombre(tfNombre2.getText());
					user.setContraseña(tfPassword2.getText());
					int tipoUser;
					//Comparar si el item es Admin o Vendedor para cbTipo2
					if (cbTipo2.getSelectedItem().equals("Admin")) {
                        tipoUser = 1;
                    } else {
                        tipoUser = 2;
                    }
                    user.setTipo(tipoUser);
                    try {
                        usuarioLoader.modificarUsuario(tfNombre2.getText(), tfPassword2.getText(), tipoUser);
                        JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al modificar el usuario: " + e1.getMessage());
                    }
                  //Habilitar la edición y bloquear el btnAceptar1 y el cbCargarUsuario
					btnAceptar1.setEnabled(true);
					cargarUsuario.setEnabled(true);
					cbTipo2.setEnabled(false);
					btnAceptar3.setEnabled(false);
					btnEliminar.setEnabled(false);
					tfNombre2.setEnabled(false);
					tfPassword2.setEnabled(false);
				} else if (e.getSource() == btnEliminar){
					Usuario user = new Usuario();
					String eliminado = (String) cargarUsuario.getSelectedItem();
					user.setNombre(eliminado); 
					try {
						usuarioLoader.eliminarUsuario(user);
						JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
						
						
					}catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al modificar el usuario: " + e1.getMessage());
                    }
					//Habilitar la edición y bloquear el btnAceptar1 y el cbCargarUsuario
					btnAceptar1.setEnabled(true);
					cargarUsuario.setEnabled(true);
					cbTipo2.setEnabled(false);
					btnAceptar3.setEnabled(false);
					btnEliminar.setEnabled(false);
					tfNombre2.setEnabled(false);
					tfPassword2.setEnabled(false);

				}
				
				
			}
	 }
	 
	 private void cargarUsuariosEnComboBox() throws IOException {
	        
	        List<Usuario> usuarios = usuarioLoader.obtenerUsuarios();

	        // Agregar nombres al JComboBox
	        for (Usuario usuario : usuarios) {
	            cargarUsuario.addItem(usuario.getNombre());
	        }
	    }
	 
	

}
