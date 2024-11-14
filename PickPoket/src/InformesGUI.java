import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InformesGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JLabel lblGananciasTotales;
    private JLabel lblIVATotal;
    private static final String RUTA_CSV = "PickPoket/data/inventario.csv"; // Ruta al archivo CSV

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

    public InformesGUI() {
        getContentPane().setBackground(new Color(173, 230, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Informe de Ganancias");
        lblNewLabel_1.setBounds(21, 6, 166, 16);
        getContentPane().add(lblNewLabel_1);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(183, 172, 255));
        panel.setBounds(6, 6, 205, 16);
        getContentPane().add(panel);

        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.setBounds(311, 215, 117, 29);
        getContentPane().add(btnNewButton);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(69, 45, 309, 158);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Ganancias totales:");
        lblNewLabel_2.setBounds(23, 18, 113, 16);
        lblNewLabel_2.setForeground(new Color(183, 139, 255));
        panel_1.add(lblNewLabel_2);

        lblGananciasTotales = new JLabel("0.00");
        lblGananciasTotales.setBounds(200, 18, 100, 16);
        panel_1.add(lblGananciasTotales);

        JLabel lblNewLabel = new JLabel("IVA Total:");
        lblNewLabel.setBounds(23, 61, 113, 16);
        lblNewLabel.setForeground(new Color(183, 139, 255));
        panel_1.add(lblNewLabel);

        lblIVATotal = new JLabel("0.00");
        lblIVATotal.setBounds(200, 61, 100, 16);
        panel_1.add(lblIVATotal);

        // Botón para calcular y mostrar los informes
        JButton btnCalcular = new JButton("Calcular Informes");
        btnCalcular.setBounds(150, 215, 150, 29);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarInformes();
            }
        });
        getContentPane().add(btnCalcular);

        // Panel de fondo
        JPanel panel_fondo = new JPanel();
        panel_fondo.setBackground(new Color(183, 172, 255));
        panel_fondo.setBounds(6, 6, 205, 16);
        getContentPane().add(panel_fondo);
    }

    /**
     * Actualiza los valores de ganancias e IVA en la interfaz gráfica.
     */
    private void actualizarInformes() {
        // Leer los productos desde el archivo CSV
        List<Producto> productos = Informes.leerProductosDesdeCSV(RUTA_CSV);
        
        // Calcular ganancias totales e IVA total
        double gananciasTotales = Informes.calcularGananciasTotales(productos);
        double ivaTotal = Informes.calcularIVATotal(productos);

        // Actualizar las etiquetas en la interfaz gráfica
        lblGananciasTotales.setText(String.format("%.2f", gananciasTotales));
        lblIVATotal.setText(String.format("%.2f", ivaTotal));
    }
}
