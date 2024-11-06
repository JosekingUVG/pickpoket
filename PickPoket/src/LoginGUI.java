import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI extends JFrame {
    private JTextField tfUsuario;
    private JButton btnAceptar;
    private JPasswordField tfPass;
    private loginCSV loginSystem;

    public static void main(String[] args) {
        LoginGUI ventana = new LoginGUI();
        ventana.setVisible(true);
    }

    public LoginGUI() {
        initializate();
        loginSystem = new loginCSV();  // Inicializa loginSystem aquí
    }

    private void initializate() {
        Escucha MP_microfono = new Escucha();

        setTitle("Login Pickpoket");
        setBounds(100, 100, 523, 346);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 230, 255));

        // Configuración de borde con título
        Border etched = new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192));
        panel.setBorder(new TitledBorder(etched, "Ingreso de datos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 128, 192)));

        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

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

        btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBackground(new Color(183, 183, 219));
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(btnAceptar);

        btnAceptar.addActionListener(MP_microfono);
    }

    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreUsuario = tfUsuario.getText();
            String contraseña = new String(tfPass.getPassword());

            // Verificar campos vacíos antes de intentar login
            if (nombreUsuario.isEmpty() || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el usuario y la contraseña.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Usuario usuarioLogueado = loginSystem.loginUsuario(nombreUsuario, contraseña);

                if (usuarioLogueado != null) {
                    if (usuarioLogueado.getTipo() == 1) {
                        JOptionPane.showMessageDialog(null, "Login exitoso como Admin", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        AdminGUI adminGUI = new AdminGUI();
                        adminGUI.setVisible(true);
                        dispose(); // Cerrar la ventana actual
                    } else if (usuarioLogueado.getTipo() == 2) {
                        JOptionPane.showMessageDialog(null, "Login exitoso como Vendedor", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        VendedorGUI vendedorGUI = new VendedorGUI();
                        vendedorGUI.setVisible(true);
                        dispose(); // Cerrar la ventana actual
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos(); // Limpiar campos después de intento fallido
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void limpiarCampos() {
            tfUsuario.setText("");
            tfPass.setText("");
        }
    }
}
