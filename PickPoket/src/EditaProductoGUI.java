import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private JButton BEvolver;
    private JButton BEditar;
    private JComboBox comboBox;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditaProductoGUI ventana = new EditaProductoGUI();
                    ventana.frame.setVisible(true);
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
    	Escucha escucha= new Escucha();
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
        BEditar = new JButton("Editar Producto");
        BEditar.setBounds(6, 213, 150, 30);  
        panel.add(BEditar);
        
        comboBox = new JComboBox();
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
        
        BEvolver = new JButton("Volver");
        
        BEvolver.setBounds(263, 213, 150, 30);
        panel.add(BEvolver);
        
        BEvolver.addActionListener(escucha);
        BEditar.addActionListener(escucha);
        
        
        //CARGAR LOS PRODUCTOS EN EL COMBOBOX
      
		 try {
            // Llenar el JComboBox con los productos del archivo
            cargarUsuariosEnComboBox();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar productos: " + e.getMessage());
        }

        
    }
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// Aquí se pueden definir las acciones de los botones
        	if (e.getSource() == BEvolver) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Volver");
                ProductosGUI fr = new ProductosGUI();
                fr.setVisible(true);
                frame.dispose();
            } else if(e.getSource()==BEditar){
                // Captura del producto seleccionado
    String nombreProductoAEditar = comboBox.getSelectedItem().toString();

    // Validación de selección en el JComboBox
    if (nombreProductoAEditar == null || nombreProductoAEditar.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Seleccione un producto para editar.");
        return;
    }

    // Captura de los nuevos datos ingresados por el usuario
    String nuevoCodigo = textField.getText();
    String nuevoNombre = textField_1.getText();
    float nuevoPrecio;
    int nuevaCantidad;
    String nuevaCategoria = textField_4.getText();

    // Validar que los campos de precio y cantidad sean valores numéricos
    try {
        nuevoPrecio = Float.parseFloat(textField_2.getText());
        nuevaCantidad = Integer.parseInt(textField_3.getText());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para el precio y la cantidad.");
        return;
    }

    // Llamar al método de ManejoCSV para modificar el producto en el archivo
    try {
        ManejoCSV manejoCSV = new ManejoCSV();
        manejoCSV.modificarProducto(nombreProductoAEditar, nuevoCodigo, nuevoPrecio, nuevaCantidad, nuevaCategoria);

        // Actualizar el ComboBox para reflejar los cambios
        comboBox.removeItem(nombreProductoAEditar);
        comboBox.addItem(nuevoNombre); // Agrega el nombre modificado al ComboBox

        // Mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Producto modificado exitosamente: " + nuevoNombre);

        // Limpiar los campos de texto después de la edición
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar el producto: " + ex.getMessage());
    }
            }
        	
        }
    }
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }



     private void cargarUsuariosEnComboBox() throws IOException {
        

      
        
        // Cargar los productos desde el archivo CSV al inventario
        ManejoCSV cargar = new ManejoCSV();
        Inventario inventario = cargar.cargarProductos();

        // Agregar nombres al JComboBox desde el inventario
        for (Producto produ : inventario.VerInventario()) {
            comboBox.addItem(produ.getNombre());
        }      

    }     
}
