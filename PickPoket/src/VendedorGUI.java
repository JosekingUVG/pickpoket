import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VendedorGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton btnRegistrarUsuario;
    private JButton btnEditarUsuario;
    private JButton btnRegistrarProducto;
    private JButton btnEditarProducto;
    private JButton btnInventario;
    private JButton btnVolver;
    private JLabel label_2;
    private JLabel label_5;
    private JLabel label_8;
    private JLabel label_11;
    private JLabel label_14;
    private JLabel label_17;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VendedorGUI frame = new VendedorGUI();
                    frame.setVisible(true);  // Ahora usas el JFrame de la clase VendedorGUI
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VendedorGUI() {
        inicializador();
    }

    private void inicializador() {
        // Crear un objeto que escuche los botones
        Escucha MP_microfono = new Escucha();
        
        // Configurar el JFrame
        setTitle("VENDEDOR MENU");
        setBounds(100, 100, 523, 346);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 230, 255));

        // Crea el borde con efecto grabado
        Border etched = new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192));

        // Añadir el borde con título
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 12, true), "Selecciona una opción", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 192)));

        // Añadir el panel al JFrame
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(176, 230, 255));
        panel.add(panel_1, BorderLayout.WEST);

        JLabel lblNewLabel = new JLabel("                                    ");
        panel_1.add(lblNewLabel);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(176, 230, 255));
        panel.add(panel_3, BorderLayout.EAST);

        JLabel lblNewLabel3 = new JLabel("                                    ");
        panel_3.add(lblNewLabel3);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(176, 230, 255));
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(12, 1, 0, 0));

        btnRegistrarUsuario = new JButton("USUARIOS");
        panel_2.add(btnRegistrarUsuario);

        label_2 = new JLabel("");
        panel_2.add(label_2);

        btnEditarUsuario = new JButton("PRODUCTOS");
        panel_2.add(btnEditarUsuario);

        label_5 = new JLabel("");
        panel_2.add(label_5);

        btnRegistrarProducto = new JButton("INVENTARIO");
        panel_2.add(btnRegistrarProducto);

        label_8 = new JLabel("");
        panel_2.add(label_8);

        btnEditarProducto = new JButton("INFORMES");
        panel_2.add(btnEditarProducto);

        label_11 = new JLabel("");
        panel_2.add(label_11);

        btnInventario = new JButton("DESCUENTOS");
        panel_2.add(btnInventario);

        label_14 = new JLabel("");
        panel_2.add(label_14);

        btnVolver = new JButton("VOLVER");
        panel_2.add(btnVolver);

        label_17 = new JLabel("");
        panel_2.add(label_17);

        // Añadir el ActionListener a los botones
        btnRegistrarUsuario.addActionListener(MP_microfono);
        btnEditarUsuario.addActionListener(MP_microfono);
        btnRegistrarProducto.addActionListener(MP_microfono);
        btnEditarProducto.addActionListener(MP_microfono);
        btnInventario.addActionListener(MP_microfono);
        btnVolver.addActionListener(MP_microfono);
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnRegistrarUsuario) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Usuarios");
            } else if (e.getSource() == btnEditarUsuario) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Productos");
            } else if (e.getSource() == btnRegistrarProducto) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Inventario");
            } else if (e.getSource() == btnEditarProducto) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Informe");
            } else if (e.getSource() == btnInventario) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Descuentos");
            } else if (e.getSource() == btnVolver) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Volver");

                // Abrir la ventana de login
                LoginGUI loginGUI = new LoginGUI();
                loginGUI.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        }
    }
}
