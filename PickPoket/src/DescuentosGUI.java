import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class DescuentosGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JButton buscar;
	private JButton btnVolver;
	private JButton btnAceptarN;
	private JButton btnAceptarC;
	private JComboBox combobox;
	private JComboBox CBnombres;
	private JComboBox CBcategorias;
	
	
	private String[] tipo = {"Nombre","Categoría"};
	private JTextField fechaInicio1;
	private JTextField fechaFin1;
	private JTextField fechaInicio2;
	private JTextField fechaFin2;
	private JTextField descuento1;
	private JTextField descuento2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DescuentosGUI frame = new DescuentosGUI();
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
	public DescuentosGUI() {
		
		inicializar();
	}
	public void inicializar() {
		Escucha escucha=new Escucha();
		
		setTitle("DESCUENTOS");
		setBounds(100, 100, 523, 346);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192), new Color(128, 128, 192), new Color(128, 128, 192)), "Descuentos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		panel.setBackground(new Color(176, 230, 255));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		
		label = new JLabel("Descuenntos por: ");
		panel.add(label);
		
		combobox = new JComboBox(tipo);
		panel.add(combobox);
		
		buscar = new JButton("BUSCAR");
		panel.add(buscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 192), new Color(128, 128, 192), new Color(128, 128, 192), new Color(128, 128, 192)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		panel_1.setBackground(new Color(176, 230, 255));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 192), 4), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 255, 255)));
		panel_2.setBackground(new Color(176, 230, 255));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(9, 2, 0, 0));
		
		lblNewLabel = new JLabel("Fecha Inicio");
		lblNewLabel.setEnabled(false);
		panel_2.add(lblNewLabel);
		
		fechaInicio1 = new JTextField();
		fechaInicio1.setEnabled(false);
		panel_2.add(fechaInicio1);
		fechaInicio1.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Fecha Inicio");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setVisible(false);
		panel_2.add(lblNewLabel_4);
		
		fechaInicio2 = new JTextField();
		fechaInicio2.setEnabled(false);
		fechaInicio2.setVisible(false);
		panel_2.add(fechaInicio2);
		fechaInicio2.setColumns(10);
		
		
		lblNewLabel_1 = new JLabel("Fecha Fin");
		lblNewLabel_1.setEnabled(false);
		panel_2.add(lblNewLabel_1);
		
		fechaFin1 = new JTextField();
		fechaFin1.setEnabled(false);
		panel_2.add(fechaFin1);
		fechaFin1.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Fecha Fin");
		lblNewLabel_5.setEnabled(false);
		lblNewLabel_5.setVisible(false);
		panel_2.add(lblNewLabel_5);
		
		fechaFin2 = new JTextField();
		fechaFin2.setEnabled(false);
		fechaFin2.setVisible(false);
		panel_2.add(fechaFin2);
		fechaFin2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setEnabled(false);
		panel_2.add(lblNewLabel_2);
		
		CBnombres = new JComboBox();
		CBnombres.setEnabled(false);
		panel_2.add(CBnombres);
		
		lblNewLabel_3 = new JLabel("Categoría");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setVisible(false);
		panel_2.add(lblNewLabel_3);
		
		CBcategorias = new JComboBox();
		CBcategorias.setEnabled(false);
		CBcategorias.setVisible(false);
		panel_2.add(CBcategorias);
		
		lblNewLabel_6 = new JLabel("%Descuento");
		lblNewLabel_6.setEnabled(false);
		panel_2.add(lblNewLabel_6);
		
		descuento1 = new JTextField();
		descuento1.setEnabled(false);
		panel_2.add(descuento1);
		descuento1.setColumns(10);
		
		lblNewLabel_7 = new JLabel("%Descuento");
		lblNewLabel_7.setEnabled(false);
		lblNewLabel_7.setVisible(false);
		panel_2.add(lblNewLabel_7);
		
		descuento2 = new JTextField();
		descuento2.setEnabled(false);
		descuento2.setVisible(false);
		panel_2.add(descuento2);
		descuento2.setColumns(10);
		
		btnAceptarN = new JButton("ACEPTAR");
		btnAceptarN.setEnabled(false);
		panel_2.add(btnAceptarN);
		
		btnAceptarC = new JButton("ACEPTAR");
		btnAceptarC.setEnabled(false);
		btnAceptarC.setVisible(false);
		panel_2.add(btnAceptarC);
		
		btnVolver = new JButton("VOLVER");
		panel_1.add(btnVolver);

		//Escuchar los botones:
		btnVolver.addActionListener(escucha);
		btnAceptarC.addActionListener(escucha);
		btnAceptarN.addActionListener(escucha);
		buscar.addActionListener(escucha);

	//Cargar los combobx
	//CARGAR LOS PRODUCTOS EN EL COMBOBOX
      
	try {
		// Llenar el JComboBox con los productos del archivo
		cargarNombresProductos();
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("Error al cargar productos: " + e.getMessage());
	}	
	//CARGAR LOS PRODUCTOS EN EL COMBOBOX
      
	try {
		// Llenar el JComboBox con los productos del archivo
		cargarCategoriasProductos();
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("Error al cargar productos: " + e.getMessage());
	}
		
		
		
	}
	private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buscar) {
				JOptionPane.showMessageDialog(null, "Buscar por Nombre");
				JOptionPane.showMessageDialog(null, "Buscar por Categoría");
			} else if (e.getSource() == btnVolver) {
				JOptionPane.showMessageDialog(null, "Has presionado el botón: Volver");
			} else if (e.getSource() == btnAceptarC) {
				JOptionPane.showMessageDialog(null, "Descuento Aplicado");
			} else if (e.getSource() == btnAceptarN) {
				JOptionPane.showMessageDialog(null, "Descuento Aplicado");
			}
		}
	}
	public void visiblesCategoriaTrue(){
		lblNewLabel_4.setVisible(true);
		 lblNewLabel_5.setVisible(true);
		 lblNewLabel_3.setVisible(true);
		 lblNewLabel_7.setVisible(true);
		 btnAceptarC.setVisible(true);
		 
		 fechaInicio2.setVisible(true);
		 fechaFin2.setVisible(true);
		 descuento2.setVisible(true);
		 CBcategorias.setVisible(true);

	}
	public void enableCategoriaTrue(){
		lblNewLabel_4.setEnabled(true);
		 lblNewLabel_5.setEnabled(true);
		 lblNewLabel_3.setEnabled(true);
		 lblNewLabel_7.setEnabled(true);
		 btnAceptarC.setEnabled(true);
		 
		 fechaInicio2.setEnabled(true);
		 fechaFin2.setEnabled(true);
		 descuento2.setEnabled(true);
		 CBcategorias.setEnabled(true);

	}
	public void visiblesCategoriaFalse(){
		lblNewLabel_4.setVisible(false);
		 lblNewLabel_5.setVisible(false);
		 lblNewLabel_3.setVisible(false);
		 lblNewLabel_7.setVisible(false);
		 btnAceptarC.setVisible(false);
		 
		 fechaInicio2.setVisible(false);
		 fechaFin2.setVisible(false);
		 descuento2.setVisible(false);
		 CBcategorias.setVisible(false);

	}
	public void enableCategoriaFalse(){
		lblNewLabel_4.setEnabled(false);
		 lblNewLabel_5.setEnabled(false);
		 lblNewLabel_3.setEnabled(false);
		 lblNewLabel_7.setEnabled(false);
		 btnAceptarC.setEnabled(false);
		 
		 fechaInicio2.setEnabled(false);
		 fechaFin2.setEnabled(false);
		 descuento2.setEnabled(false);
		 CBcategorias.setEnabled(false);

	}
	public void visiblesNombreTrue(){
		lblNewLabel.setVisible(true);
		 lblNewLabel_1.setVisible(true);
		 lblNewLabel_2.setVisible(true);
		 lblNewLabel_6.setVisible(true);
		 btnAceptarN.setVisible(true);
		 fechaInicio1.setVisible(true);
		 fechaFin1.setVisible(true);
		 descuento1.setVisible(true);
		 CBnombres.setVisible(true);

		

	}
	public void enableNombreTrue(){
		 lblNewLabel.setEnabled(true);
		 lblNewLabel_1.setEnabled(true);
		 lblNewLabel_2.setEnabled(true);
		 lblNewLabel_6.setEnabled(true);
		 btnAceptarN.setEnabled(true);
		 fechaInicio1.setEnabled(true);
		 fechaFin1.setEnabled(true);
		 descuento1.setEnabled(true);
		 CBnombres.setEnabled(true);

	}

	public void visiblesNombreFalse(){
		lblNewLabel.setVisible(false);
		 lblNewLabel_1.setVisible(false);
		 lblNewLabel_2.setVisible(false);
		 lblNewLabel_6.setVisible(false);
		 btnAceptarN.setVisible(false);
		 fechaInicio1.setVisible(false);
		 fechaFin1.setVisible(false);
		 descuento1.setVisible(false);
		 CBnombres.setVisible(false);

		

	}
	public void enableNombreFalse(){
		 lblNewLabel.setEnabled(false);
		 lblNewLabel_1.setEnabled(false);
		 lblNewLabel_2.setEnabled(false);
		 lblNewLabel_6.setEnabled(false);
		 btnAceptarN.setEnabled(false);
		 fechaInicio1.setEnabled(false);
		 fechaFin1.setEnabled(false);
		 descuento1.setEnabled(false);
		 CBnombres.setEnabled(false);

	}

	private void cargarNombresProductos() throws IOException {
   
        // Cargar los productos desde el archivo CSV al inventario
        ManejoCSV cargar = new ManejoCSV();
        Inventario inventario = cargar.cargarProductos();

        // Agregar nombres al JComboBox desde el inventario
        for (Producto produ : inventario.VerInventario()) {
            CBnombres.addItem(produ.getNombre());
        }      

    }

	private void cargarCategoriasProductos() throws IOException {
        

      
        
        // Cargar los productos desde el archivo CSV al inventario
        ManejoCSV cargar = new ManejoCSV();
        Inventario inventario = cargar.cargarProductos();

        // Agregar nombres al JComboBox desde el inventario
        for (Producto produ : inventario.VerInventario()) {
            CBcategorias.addItem(produ.getCategoria());
        }      

    }

}
