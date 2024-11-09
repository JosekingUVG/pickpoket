import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase InventarioGUI que representa la interfaz gráfica para la gestión del inventario.
 * Permite visualizar los productos, buscar por nombre y ordenar por diferentes atributos.
 */
public class InventarioGUI extends JFrame {
    private JPanel contentPane;
    private JTextField txtBuscar;
    private JComboBox<String> comboFiltro;
    private JTable tableInventario;
    private Inventario inventario; // Instancia compartida de Inventario

    /**
     * Constructor de la clase InventarioGUI.
     * Inicializa la interfaz gráfica y configura la instancia de Inventario.
     *
     * @param inventario la instancia de Inventario a gestionar.
     */
    public InventarioGUI(Inventario inventario) {
        this.inventario = inventario;
        inicializar();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cerrar solo esta ventana
        setSize(600, 400);  // Tamaño del JFrame
    }

    /**
     * Método principal para ejecutar InventarioGUI de forma independiente.
     * Crea una instancia de Inventario y muestra la ventana InventarioGUI.
     */
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        // Agregar productos de ejemplo para ver en el inventario
        inventario.AgregarProducto(new Producto("001", "Producto 1", 50.0f, 5, "Categoria 1"));
        inventario.AgregarProducto(new Producto("002", "Producto 2", 75.0f, 3, "Categoria 2"));

        InventarioGUI frame = new InventarioGUI(inventario);
        frame.setVisible(true);
    }

    /**
     * Método para inicializar los componentes de la interfaz gráfica.
     * Configura los campos de búsqueda, filtros y la tabla de inventario.
     */
    private void inicializar() {
        setTitle("Gestión de Inventario");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(10, 20, 300, 20);
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(320, 20, 100, 20);
        contentPane.add(btnBuscar);

        comboFiltro = new JComboBox<>(new String[]{"Ordenar por código", "Ordenar por nombre", "Ordenar por precio", "Ordenar por cantidad"});
        comboFiltro.setBounds(10, 50, 300, 20);
        contentPane.add(comboFiltro);

        JButton btnExportar = new JButton("Exportar a CSV");
        btnExportar.setBounds(430, 20, 140, 20);
        contentPane.add(btnExportar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 564, 270);
        contentPane.add(scrollPane);

        tableInventario = new JTable();
        tableInventario.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Código", "Nombre", "Precio", "Cantidad", "Categoría"}
        ));
        scrollPane.setViewportView(tableInventario);

        // Cargar los datos iniciales en la tabla
        actualizarTabla();

        // Acción del botón de búsqueda
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTabla(txtBuscar.getText());
            }
        });

        // Acción del botón de exportación a CSV
        btnExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarTablaACSV();
            }
        });
    }

    /**
     * Método para actualizar la tabla con todos los productos del inventario.
     * Filtra y ordena los productos según el texto de búsqueda y el criterio seleccionado.
     */
    public void actualizarTabla() {
        actualizarTabla(null); // Cargar sin filtro de búsqueda
    }

    private void actualizarTabla(String filtro) {
        String criterio = comboFiltro.getSelectedItem().toString().replace("Ordenar por ", "").toLowerCase();
        inventario.ordenarInventario(criterio);

        DefaultTableModel model = (DefaultTableModel) tableInventario.getModel();
        model.setRowCount(0);

        ArrayList<Producto> productos = inventario.VerInventario();
        for (Producto producto : productos) {
            if (filtro == null || producto.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                model.addRow(new Object[]{
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getCantidad(),
                    producto.getCategoria()
                });
            }
        }
    }

    /**
     * Método para exportar la tabla a un archivo CSV en la carpeta PickPoket/data.
     */
    private void exportarTablaACSV() {
        String filePath = "PickPoket/data/inventario.csv";  // Ruta relativa a la carpeta data
        System.out.println("Exportando a: " + filePath);  // Verificar ruta en consola

        try (FileWriter csvWriter = new FileWriter(filePath)) {
            csvWriter.append("Código,Nombre,Precio,Cantidad,Categoría\n");
            DefaultTableModel model = (DefaultTableModel) tableInventario.getModel();
            
            for (int i = 0; i < model.getRowCount(); i++) {
                csvWriter.append(model.getValueAt(i, 0).toString()).append(",");
                csvWriter.append(model.getValueAt(i, 1).toString()).append(",");
                csvWriter.append(model.getValueAt(i, 2).toString()).append(",");
                csvWriter.append(model.getValueAt(i, 3).toString()).append(",");
                csvWriter.append(model.getValueAt(i, 4).toString()).append("\n");
            }
            
            csvWriter.flush();
            JOptionPane.showMessageDialog(this, "Datos exportados a inventario.csv correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al exportar los datos: " + e.getMessage());
        }
    }
}