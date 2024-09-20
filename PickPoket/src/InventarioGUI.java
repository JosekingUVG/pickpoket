import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventarioGUI extends JFrame {
    private JPanel contentPane;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextArea textAreaInventario;
    private Inventario inventario;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InventarioGUI frame = new InventarioGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InventarioGUI() {
        inventario = new Inventario();

        setTitle("Gestión de Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 20, 80, 14);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(100, 17, 120, 20);
        contentPane.add(txtCodigo);
        txtCodigo.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 50, 80, 14);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 47, 120, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(10, 80, 80, 14);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 77, 120, 20);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String nombre = txtNombre.getText();
                Float precio = Float.parseFloat(txtPrecio.getText());

                Producto producto = new Producto (codigo, nombre, precio, getDefaultCloseOperation(), nombre);
                inventario.AgregarProducto(producto);
                actualizarInventario();
                limpiarCampos();
            }
        });
        btnAgregar.setBounds(10, 110, 210, 23);
        contentPane.add(btnAgregar);

        JButton btnEliminar = new JButton("Eliminar Producto");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                inventario.EliminarProducto(codigo);
                actualizarInventario();
                limpiarCampos();
            }
        });
        btnEliminar.setBounds(10, 140, 210, 23);
        contentPane.add(btnEliminar);

        JButton btnBuscar = new JButton("Buscar Producto");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                Producto producto = inventario.BuscarProducto(codigo);
                if (producto != null) {
                    txtNombre.setText(producto.getNombre());
                    txtPrecio.setText(String.valueOf(producto.getPrecio()));
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
            }
        });
        btnBuscar.setBounds(10, 170, 210, 23);
        contentPane.add(btnBuscar);

        textAreaInventario = new JTextArea();
        textAreaInventario.setBounds(10, 210, 414, 140);
        contentPane.add(textAreaInventario);

        actualizarInventario();
    }

    private void actualizarInventario() {
        ArrayList<Producto> productos = inventario.VerInventario();
        StringBuilder sb = new StringBuilder();
        for (Producto producto : productos) {
            sb.append("Código: ").append(producto.getCodigo())
              .append(", Nombre: ").append(producto.getNombre())
              .append(", Precio: ").append(producto.getPrecio()).append("\n");
        }
        textAreaInventario.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }
}
