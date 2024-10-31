import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DescuentosAplicadosGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton volver;
    private JButton quitar;
    private JComboBox<String> CBcargar;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DescuentosAplicadosGUI frame = new DescuentosAplicadosGUI();
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
    public DescuentosAplicadosGUI() {
        inicializar();
        cargarDatosDescuentos(); // Cargar datos de descuentos.csv al iniciar la GUI
    }

    public void inicializar() {
        Escucha escucha= new Escucha();
        setTitle("DESCUENTOS APLICADOS");
        setBounds(100, 100, 523, 346);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 230, 255));
        panel.setBorder(new LineBorder(new Color(128, 128, 192), 4));
        getContentPane().add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("QUITAR DESCUENTO: ");
        panel.add(lblNewLabel);
        
        CBcargar = new JComboBox<>();
        panel.add(CBcargar);
        
        quitar = new JButton("QUITAR");
        panel.add(quitar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(176, 230, 255));
        panel_1.setBorder(new LineBorder(new Color(128, 128, 192), 4));
        getContentPane().add(panel_1, BorderLayout.CENTER);
        
        // Configurar el modelo de la tabla
        tableModel = new DefaultTableModel(new String[]{"Nombre", "Descuento (%)", "Precio con Descuento", "Precio Original"}, 0);
        table = new JTable(tableModel);
        table.setBorder(new LineBorder(new Color(128, 128, 192), 3));
        panel_1.setLayout(new BorderLayout());
        panel_1.add(table.getTableHeader(), BorderLayout.NORTH); // Agregar encabezados de columna
        panel_1.add(table, BorderLayout.CENTER); // Agregar la tabla al panel

        volver = new JButton("Volver");
        panel_1.add(volver, BorderLayout.SOUTH);
        //Escuchar los botones:
        quitar.addActionListener(escucha);
        volver.addActionListener(escucha);
    }


    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
			if (e.getSource() == quitar) {
                String nombre;
                ManejoCSV manejo = new ManejoCSV();
                nombre=(String) CBcargar.getSelectedItem();
                try {
                    manejo.restaurarPrecioOriginal(nombre);
                    JOptionPane.showMessageDialog(null, "Descuento quitado correctamente");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    
                    JOptionPane.showMessageDialog(null, "Error al restaurar el precio original: " + e1.getMessage());
                    
                }

            }else if (e.getSource() == volver) {
                DescuentosGUI volviendo= new DescuentosGUI();
                volviendo.setVisible(true); // Mostrar la ventana
                dispose(); // Cerrar la ventana
                
            }
        }
    }

    /**
     * Cargar datos de descuentos.csv en el JTable.
     */
    private void cargarDatosDescuentos() {
        String rutaCSV = "data/descuentos.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) { // Asegurar que la línea tiene todas las columnas
                    // Agregar la fila al modelo de la tabla
                    tableModel.addRow(new Object[]{datos[0], datos[1], datos[2], datos[3]});
                    CBcargar.addItem(datos[0]); // Añadir el nombre del producto al JComboBox
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
