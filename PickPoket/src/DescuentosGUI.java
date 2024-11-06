import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DescuentosGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label;
    private JButton buscar, btnVolver, btnAceptarN, descuentosAplicados, btnAceptarC;
    private JComboBox<String> combobox, CBnombres, CBcategorias;
    private String[] tipo = {"Nombre", "Categoría"};
    private JTextField descuento1, descuento2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DescuentosGUI frame = new DescuentosGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DescuentosGUI() {
        inicializar();
    }

    public void inicializar() {
        Escucha escucha = new Escucha();
        
        setTitle("DESCUENTOS");
        setBounds(100, 100, 523, 346);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel de selección de descuento
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192)), "Descuentos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
        panel.setBackground(new Color(176, 230, 255));
        getContentPane().add(panel, BorderLayout.NORTH);
        
        label = new JLabel("Descuentos por: ");
        panel.add(label);
        
        combobox = new JComboBox<>(tipo);
        panel.add(combobox);
        
        buscar = new JButton("BUSCAR");
        panel.add(buscar);
        
        // Panel de descuentos aplicados
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 4), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
        panel_2.setBackground(new Color(176, 230, 255));
        getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(9, 2, 0, 0));
        
        descuentosAplicados = new JButton("DESCUENTOS APLICADOS");
        panel_2.add(descuentosAplicados);
        descuentosAplicados.setEnabled(true);

        // Campos y botones
        CBnombres = new JComboBox<>();
        CBcategorias = new JComboBox<>();
        descuento1 = new JTextField();
        descuento2 = new JTextField();
        
        btnAceptarN = new JButton("ACEPTAR");
        btnAceptarC = new JButton("ACEPTAR");
        btnVolver = new JButton("VOLVER");

        // Añadir acción a botones
        buscar.addActionListener(escucha);
        btnAceptarC.addActionListener(escucha);
        btnAceptarN.addActionListener(escucha);
        btnVolver.addActionListener(escucha);
        descuentosAplicados.addActionListener(escucha);

        cargarNombresProductos();
        cargarCategoriasProductos();
    }

    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ManejoCSV manejoCSV = new ManejoCSV();
            String nombre;
            float descuento;

            try {
                if (e.getSource() == buscar) {
                    if (combobox.getSelectedItem().equals("Nombre")) {
                        // Hacer visible la sección de Nombre
                        visiblesNombreTrue();
                    } else {
                        // Hacer visible la sección de Categoría
                        visiblesCategoriaTrue();
                    }
                } else if (e.getSource() == btnAceptarN) {
                    nombre = (String) CBnombres.getSelectedItem();
                    descuento = Float.parseFloat(descuento1.getText());
                    manejoCSV.aplicarDescuentoPorNombre(nombre, descuento);
                    JOptionPane.showMessageDialog(null, "Descuento aplicado");
                } else if (e.getSource() == btnAceptarC) {
                    nombre = (String) CBcategorias.getSelectedItem();
                    descuento = Float.parseFloat(descuento2.getText());
                    manejoCSV.aplicarDescuentoPorCategoria(nombre, descuento);
                    JOptionPane.showMessageDialog(null, "Descuento aplicado");
                } else if (e.getSource() == descuentosAplicados) {
                    new DescuentosAplicadosGUI().setVisible(true);
                    dispose();
                } else if (e.getSource() == btnVolver) {
                    new AdminGUI().setVisible(true);
                    dispose();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al aplicar el descuento: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numérico válido para el descuento");
            }
        }
    }

    private void cargarNombresProductos() {
		Inventario inventario = new ManejoCSV().cargarProductos();
		for (Producto produ : inventario.VerInventario()) {
			CBnombres.addItem(produ.getNombre());
		}
	}

    private void cargarCategoriasProductos() {
    Inventario inventario = new ManejoCSV().cargarProductos();
    for (Producto produ : inventario.VerInventario()) {
        CBcategorias.addItem(produ.getCategoria());
    }
}

    private void visiblesNombreTrue() {
        // Implementar la visibilidad de campos específicos según sea necesario
    }

    private void visiblesCategoriaTrue() {
        // Implementar la visibilidad de campos específicos según sea necesario
    }
}
