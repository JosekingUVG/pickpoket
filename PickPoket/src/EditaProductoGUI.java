import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class EditaProductoGUI {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditaProductoGUI window = new EditaProductoGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor
    public EditaProductoGUI() {
        initialize();  // Llamada para inicializar la GUI
    }

    // Método para inicializar el contenido del frame
    private void initialize() {
        // Crear frame
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(208, 255, 255));
        frame.getContentPane().setForeground(new Color(177, 230, 255));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);  

        // Crear panel
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(255, 255, 255)));
        panel.setBackground(new Color(177, 230, 255));
        panel.setBounds(6, 6, 438, 260);  
        frame.getContentPane().add(panel);
        panel.setLayout(null);  

        // Botón Editar
        JButton BEditar = new JButton("Editar Producto");
        BEditar.setBounds(6, 213, 150, 30);  
        panel.add(BEditar);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(19, 6, 207, 30);
        panel.add(comboBox);
        
        JLabel lblNewLabel = new JLabel("Codigo Nuevo");
        lblNewLabel.setForeground(new Color(131, 129, 255));
        lblNewLabel.setBounds(19, 56, 96, 16);
        panel.add(lblNewLabel);
        
        JLabel lblNombreNuevo = new JLabel("Nombre Nuevo");
        lblNombreNuevo.setForeground(new Color(131, 129, 255));
        lblNombreNuevo.setBounds(19, 86, 96, 16);
        panel.add(lblNombreNuevo);
        
        JLabel lblPrecioNuevo = new JLabel("Precio Nuevo");
        lblPrecioNuevo.setForeground(new Color(131, 129, 255));
        lblPrecioNuevo.setBounds(19, 114, 96, 16);
        panel.add(lblPrecioNuevo);
        
        JLabel lblCantidadNueva = new JLabel("Cantidad Nueva");
        lblCantidadNueva.setForeground(new Color(131, 129, 255));
        lblCantidadNueva.setBounds(19, 142, 111, 16);
        panel.add(lblCantidadNueva);
        
        JLabel lblCategoriaNueva = new JLabel("Categoria Nueva");
        lblCategoriaNueva.setForeground(new Color(131, 129, 255));
        lblCategoriaNueva.setBounds(19, 170, 111, 16);
        panel.add(lblCategoriaNueva);
        
        textField = new JTextField();
        textField.setBounds(167, 56, 130, 26);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(167, 86, 130, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(167, 114, 130, 26);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(167, 142, 130, 26);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(167, 170, 130, 26);
        panel.add(textField_4);
        textField_4.setColumns(10);

        // Asignar acción al botón
        BEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón Editar presionado.");
            }
        });
    }
}
