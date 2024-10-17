import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class ProductosGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    // Componentes del GUI
    private JButton BAgregar;
    private JButton BEliminar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnEditarProducto;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductosGUI frame = new ProductosGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductosGUI() {
        inicializar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);  // Tamaño del JFrame
    }

    private void inicializar() {
        getContentPane().setLayout(new BorderLayout());

        // Panel para agregar productos
        JPanel PanelAgregar = new JPanel();
        PanelAgregar.setBorder(new LineBorder(new Color(121, 129, 255)));
        PanelAgregar.setBackground(new Color(176, 230, 255));
        PanelAgregar.setLayout(new GridLayout(6, 2, 0, 0));
        getContentPane().add(PanelAgregar, BorderLayout.NORTH);

        // Etiquetas y campos de texto para agregar productos
        PanelAgregar.add(new JLabel("Codigo", SwingConstants.LEFT));
        textField = new JTextField();
        PanelAgregar.add(textField);

        PanelAgregar.add(new JLabel("Nombre", SwingConstants.LEFT));
        textField_1 = new JTextField();
        PanelAgregar.add(textField_1);

        PanelAgregar.add(new JLabel("Precio", SwingConstants.LEFT));
        textField_2 = new JTextField();
        PanelAgregar.add(textField_2);

        PanelAgregar.add(new JLabel("Cantidad", SwingConstants.LEFT));
        textField_3 = new JTextField();
        PanelAgregar.add(textField_3);

        PanelAgregar.add(new JLabel("Categoria", SwingConstants.LEFT));
        textField_4 = new JTextField();
        PanelAgregar.add(textField_4);

        BAgregar = new JButton("AGREGAR");
        BAgregar.setBackground(new Color(101, 127, 255));
        PanelAgregar.add(BAgregar);
        
        btnEditarProducto = new JButton("EDITAR PRODUCTO");
        btnEditarProducto.setBackground(new Color(101, 127, 255));
        PanelAgregar.add(btnEditarProducto);

        // Panel para eliminar productos
        JPanel PanelEliminar = new JPanel(new GridLayout(4, 2, 10, 10));
        PanelEliminar.setBorder(new CompoundBorder());
        PanelEliminar.setBackground(new Color(176, 230, 255));
        getContentPane().add(PanelEliminar, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Elimina un Producto");
        PanelEliminar.add(lblNewLabel);

        comboBox = new JComboBox<>();
        PanelEliminar.add(comboBox);

        BEliminar = new JButton("Eliminar");
        BEliminar.setHorizontalAlignment(SwingConstants.LEFT);
        PanelEliminar.add(BEliminar);
        
       
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
        }
    }
    
    private void cargarUsuariosEnComboBox() throws IOException {
        CargarCSV usuarioLoader = new CargarCSV();
        List<Producto> productos =  usuarioLoader.cargarProductos(); // Usar el nombre correcto

        // Agregar nombres al JComboBox
        for (Producto producto : productos) {
            comboBox.addItem(producto.getNombre());
        }
    }

}

