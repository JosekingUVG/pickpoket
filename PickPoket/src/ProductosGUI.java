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
    private JButton bregresar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnEditarProducto;
    private JComboBox<String> comboBox;
    private JButton bEliminar;

    public static void main(String[] args) {
       /*  EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {*/
                    ProductosGUI frame = new ProductosGUI();
                    frame.setVisible(true);
         /*       } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    public ProductosGUI() {
        inicializar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);  // Tamaño del JFrame
    }

    private void inicializar() {
    	Escucha escucha = new Escucha();
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
        
        bEliminar = new JButton("Eliminar");
        bEliminar.setHorizontalAlignment(SwingConstants.LEFT);
        PanelEliminar.add(bEliminar);

        bregresar = new JButton("Regresar");
        bregresar.setHorizontalAlignment(SwingConstants.LEFT);
        PanelEliminar.add(bregresar);
        
       
        //CARGAR LOS PRODUCTOS EN EL COMBOBOX
      
		 try {
	            // Llenar el JComboBox con los productos del archivo
	            cargarUsuariosEnComboBox();
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Error al cargar productos: " + e.getMessage());
	        }
        
        //Escuchar los botones:
        bregresar.addActionListener(escucha);
        btnEditarProducto.addActionListener(escucha);
        BAgregar.addActionListener(escucha);
        bEliminar.addActionListener(escucha);
        
    }

    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Aquí se pueden definir las acciones de los botones
        	if (e.getSource() == bregresar) {
                JOptionPane.showMessageDialog(null, "Has presionado el botón: Volver");
                AdminGUI fr = new AdminGUI();
                fr.setVisible(true);
                dispose();
            } else if (e.getSource() == btnEditarProducto) {
            	JOptionPane.showMessageDialog(null, "Has presionado el botón: Editar Producto");
                EditaProductoGUI frs = new EditaProductoGUI();
                frs.setVisible(true);
                dispose();
            } else if(e.getSource() == BAgregar){
                // Agregar un nuevo producto al archivo
                Producto producto = new Producto();
                producto.setCodigo(textField.getText());
                producto.setNombre(textField_1.getText());
                producto.setPrecio(Float.parseFloat(textField_2.getText()));
                producto.setCantidad(Integer.parseInt(textField_3.getText()));
                producto.setCategoria(textField_4.getText());

                Inventario inventario = new Inventario();
                inventario.AgregarProducto(producto);

                ManejoCSV guardar = new ManejoCSV();
                guardar.guardarProductos(inventario);
                

                // usar el nombre correcto del método
                // agregarProductoAlArchivo(producto);
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");

            } else if(
                e.getSource() == bEliminar
            ){
                String nombreProductoAEliminar = comboBox.getSelectedItem().toString();
ManejoCSV manejoCSV = new ManejoCSV();

try {
    // Eliminar del archivo CSV usando el nombre del producto
    manejoCSV.eliminarProductoPorNombre(nombreProductoAEliminar);
    
    // Actualizar ComboBox
    comboBox.removeItem(nombreProductoAEliminar);
    JOptionPane.showMessageDialog(null, "Producto eliminado: " + nombreProductoAEliminar);

} catch (IOException ex) {
    JOptionPane.showMessageDialog(null, "Error al eliminar el producto del archivo CSV: " + ex.getMessage());
}
 }
}

                
                

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

