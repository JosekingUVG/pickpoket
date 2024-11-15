import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
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
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VendedorGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFormattedTextField fechaTF;
    private MaskFormatter dateFormatter;
    private JButton volver;
    private JButton agregar;
    private JButton vender;
    private JComboBox<String> producto;
    private JComboBox<Integer> cantidad;
    private JLabel precio;
    private Venta venta;
    private Venta ventaActual;
    private Inventario inventario;

    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VendedorGUI frame = new VendedorGUI();
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
    public VendedorGUI() {
        inicializador();
        
    }

    private void inicializador() {
        // Crear un objeto que escuche los botones
        Escucha MP_microfono = new Escucha();
        
        // Configurar el JFrame
        setTitle("VENDEDORES");
        setBounds(100, 100, 523, 346);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 230, 255));
        Border etched = new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 12, true), "Selecciona una opción", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 128, 192)));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(176, 230, 255));
        panel.add(panel_1, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Fecha(dd/mm/yyyy)");
        panel_1.add(lblNewLabel);
        
        try {
            dateFormatter = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateFormatter.setPlaceholderCharacter('_');
        
        fechaTF = new JFormattedTextField(dateFormatter);
        panel_1.add(fechaTF);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(176, 230, 255));
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(4, 3, 0, 0));
        
        JLabel aa = new JLabel("Producto");
        aa.setFont(new Font("Tahoma", Font.BOLD, 11));
        aa.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(aa);
        
        JLabel aaa = new JLabel("");
        panel_2.add(aaa);
        
        JLabel aaaa = new JLabel("Cantidad");
        aaaa.setFont(new Font("Tahoma", Font.BOLD, 11));
        aaaa.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(aaaa);
        
        producto = new JComboBox<>();
        panel_2.add(producto);
        
        JLabel a = new JLabel("");
        panel_2.add(a);
        
        cantidad = new JComboBox<>();
        panel_2.add(cantidad);
        
        JLabel tt = new JLabel("Total Q.");
        tt.setHorizontalAlignment(SwingConstants.RIGHT);
        tt.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_2.add(tt);
        
        precio = new JLabel("0");
        precio.setHorizontalAlignment(SwingConstants.CENTER);
        precio.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_2.add(precio);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(176, 230, 255));
        panel.add(panel_3, BorderLayout.SOUTH);
        
        volver = new JButton("Volver");
        panel_3.add(volver);
        
        JLabel lbl = new JLabel("                                                                         ");
        panel_3.add(lbl);
        
        vender = new JButton("Vender");
        panel_3.add(vender);
        
        agregar = new JButton("Agregar");
        panel_2.add(agregar);

        try {
            cargarNombresProductos();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
        
        // Listener para actualizar la cantidad basada en el producto seleccionado
        producto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizarCantidad();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Listener para actualizar la cantidad basada en el producto seleccionado
        producto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizarCantidad();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Listener para actualizar el precio basado en la cantidad seleccionada
        cantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecio();
            }
        });

        //Agregar acciones a los botones
        volver.addActionListener(MP_microfono);
        agregar.addActionListener(MP_microfono);
        vender.addActionListener(MP_microfono);

    }

    private class Escucha implements ActionListener {
        @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == volver) {
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
        dispose();
    } else if (e.getSource() == agregar) {
        agregarProductoAVenta();
    } else if (e.getSource() == vender) {
        try {
            realizarVenta();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
    }
}

    }
    
    private void cargarNombresProductos() throws IOException {
        ManejoCSV cargar = new ManejoCSV();
        inventario = cargar.cargarProductos();
        for (Producto produ : inventario.VerInventario()) {
            producto.addItem(produ.getNombre());
        }
    }

    private void actualizarCantidad() throws IOException {
        cantidad.removeAllItems();
        
        String productoSeleccionado = (String) producto.getSelectedItem();
        for (Producto produ : inventario.VerInventario()) {
            if (produ.getNombre().equals(productoSeleccionado)) {
                for (int i = 1; i <= produ.getCantidad(); i++) {
                    cantidad.addItem(i);
                }
                break;
            }
        }
    }

    private void actualizarPrecio() {
        String productoSeleccionado = (String) producto.getSelectedItem();
        Integer cantidadSeleccionada = (Integer) cantidad.getSelectedItem();

        if (productoSeleccionado != null && cantidadSeleccionada != null) {
            for (Producto produ : inventario.VerInventario()) {
                if (produ.getNombre().equals(productoSeleccionado)) {
                    float total = (float) (cantidadSeleccionada * produ.getPrecio()*1.12);
                    precio.setText(String.valueOf(total));
                    break;
                }
            }
        }
    }

    public void realizarVenta() throws IOException {
           // Obtener la lista de productos de la venta
    String mensaje = obtenerListaProductosVenta(ventaActual);
    if (mensaje == null || mensaje.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: No se pudo obtener la lista de productos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Detener si no se pudo obtener la lista
    }

    // Mostrar los productos en un mensaje
    JOptionPane.showMessageDialog(null, mensaje);

    // Intentar registrar la venta en el archivo CSV
    try {
        ManejoCSV manejoCSV = new ManejoCSV();
        manejoCSV.registrarVentaEnCSV(ventaActual);
        JOptionPane.showMessageDialog(null, "Venta realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar la venta actual después de realizar la venta
        ventaActual = null; // O puedes crear una nueva instancia si prefieres
    } catch (IOException e) {
        // En caso de error al guardar en el CSV
        JOptionPane.showMessageDialog(null, "Error al registrar la venta en el archivo CSV: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    

private void agregarProductoAVenta() {
    if (ventaActual == null) {
        String fechaVenta = fechaTF.getText();
        ventaActual = new Venta("V001", fechaVenta);
    }

    String nombreProducto = (String) producto.getSelectedItem();
    int cantidadSeleccionada = (int) cantidad.getSelectedItem();

    try {
        ManejoCSV manejoCSV = new ManejoCSV();
        List<Producto> inventario = manejoCSV.obtenerProductos();

        Producto productoSeleccionado = null;
        for (Producto p : inventario) {
            if (p.getNombre().equals(nombreProducto)) {
                productoSeleccionado = p;
                break;
            }
        }

        if (productoSeleccionado != null && productoSeleccionado.getCantidad() >= cantidadSeleccionada) {
            productoSeleccionado.setCantidad(productoSeleccionado.getCantidad() - cantidadSeleccionada);

            Producto productoAVenta = new Producto(
                productoSeleccionado.getCodigo(),
                productoSeleccionado.getNombre(),
                productoSeleccionado.getPrecio(),
                cantidadSeleccionada,
                productoSeleccionado.getCategoria()
            );

            // Agregar el producto a la venta actual
            ventaActual.agregarProducto(productoAVenta);

            // Actualizar el inventario en el archivo CSV
            manejoCSV.modificarProducto(
                productoSeleccionado.getNombre(),
                productoSeleccionado.getCodigo(),
                productoSeleccionado.getPrecio(),
                productoSeleccionado.getCantidad(),
                productoSeleccionado.getCategoria()
            );

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Producto agregado a la venta y actualizado en el inventario.");
        } else {
            JOptionPane.showMessageDialog(null, "Cantidad no disponible en el inventario.");
        }
    } catch (IOException ex) {
        System.out.println("Error al actualizar el inventario: " + ex.getMessage());
    }
}

public String obtenerListaProductosVenta(Venta venta) {
    StringBuilder detalleVenta = new StringBuilder();
    detalleVenta.append("Fecha de venta: ").append(venta.getFecha()).append("\n");
    detalleVenta.append("Productos vendidos:\n");

    for (Producto producto : venta.getListaProductos()) { // Cambié a getListaProductos()
        detalleVenta.append("- ")
                    .append(producto.getNombre())
                    .append(" (Cantidad: ")
                    .append(producto.getCantidad())
                    .append(", Precio: ")
                    .append(producto.getPrecio())
                    .append(")\n");
    }

    return detalleVenta.toString();
}
}
