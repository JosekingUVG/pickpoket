import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class InformesGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton volver;
    private static final String RUTA_VENTAS = "PickPoket/data/ventas.csv"; // Ruta al archivo CSV de ventas

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                InformesGUI frame = new InformesGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public InformesGUI() {
        inicializador();
    }

    private void inicializador() {
        setTitle("Informes de Ventas");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 230, 255));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Panel para la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 2), "Ventas", TitledBorder.CENTER, TitledBorder.TOP));
        panelTabla.setBackground(new Color(176, 230, 255));
        contentPane.add(panelTabla, BorderLayout.CENTER);
        panelTabla.setLayout(new BorderLayout());

        // Crear la tabla
        String[] columnNames = {"Fecha", "Nombre", "Cantidad", "Total", "IVA"};
        Object[][] data = {}; // Inicialmente vacío
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        JPanel tabla = new JPanel();
        tabla.setBackground(new Color(176, 230, 255));
        contentPane.add(tabla, BorderLayout.SOUTH);

        // Botón para cargar datos
        JButton btnCargarDatos = new JButton("Cargar Datos");
        btnCargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosDesdeCSV();
            }
        });
        tabla.add(btnCargarDatos, BorderLayout.NORTH);
        volver = new JButton("Volver");
        tabla.add(volver, BorderLayout.EAST);
        volver.addActionListener(escuchar);
    }
    private ActionListener escuchar = e -> {
        if (e.getSource() == volver) {
                AdminGUI fr = new AdminGUI();
                fr.setVisible(true);
                dispose();
        }
    };

    /**
     * Carga los datos desde el archivo CSV y los muestra en la tabla.
     */
    private void cargarDatosDesdeCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_VENTAS))) {
            String linea;
            DefaultTableModel model = new DefaultTableModel(new String[]{"Fecha", "Nombre", "Cantidad", "Total", "IVA"}, 0);
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(": ");
                String fecha = partes[0];
                String[] productosStr = partes[1].split(" \\| ");
                for (String productoStr : productosStr) {
                    String[] detalles = productoStr.split(", ");
                    String nombre = detalles[0];
                    int cantidad = Integer.parseInt(detalles[1]);
                    double total = Double.parseDouble(detalles[2]);
                    double iva = Double.parseDouble(detalles[3]);
                    model.addRow(new Object[]{fecha, nombre, cantidad, total, iva});
                }
            }
            table.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}