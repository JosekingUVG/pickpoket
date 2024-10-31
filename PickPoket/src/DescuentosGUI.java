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
	private JButton descuentosAplicados;
	private JButton btnAceptarC;
	private JComboBox combobox;
	private JComboBox CBnombres;
	private JComboBox CBcategorias;
	
	
	private String[] tipo = {"Nombre","Categoría"};
	private JTextField descuento1;
	private JTextField descuento2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	

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
		
		lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel);
		
		descuentosAplicados = new JButton("DESCUENTOS APLICADOS");
		panel_2.add(descuentosAplicados);
		descuentosAplicados.setEnabled(true);
		
		lblNewLabel_4 = new JLabel("");
		panel_2.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		panel_2.add(lblNewLabel_5);
		
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
		
		lblNewLabel_8 = new JLabel("");
		panel_2.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		panel_2.add(lblNewLabel_9);
		
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
		descuentosAplicados.addActionListener(escucha);

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
				if(combobox.getSelectedItem().equals("Nombre")){
					JOptionPane.showMessageDialog(null, "Buscar por Nombre");
					visiblesNombreTrue();
					enableNombreTrue();
					enableCategoriaFalse();
					visiblesCategoriaFalse(); 
				}else {
				
				JOptionPane.showMessageDialog(null, "Buscar por Categoría");
				    visiblesCategoriaTrue();
					enableCategoriaTrue();
					visiblesNombreFalse(); 
					enableNombreFalse();
				}

			} else if (e.getSource() == btnVolver) {
				JOptionPane.showMessageDialog(null, "Has presionado el botón: Volver");
				// Abrir la ventana de login
                AdminGUI loginGUI = new AdminGUI();
                loginGUI.setVisible(true);
                dispose(); // Cerrar la ventana actual
			} else if (e.getSource() == btnAceptarC) {
				ManejoCSV manejoCSV = new ManejoCSV();
				String nombre;
				float descuento;
				nombre=(String) CBcategorias.getSelectedItem();
				descuento=Float.parseFloat(descuento2.getText());
				try {
					manejoCSV.aplicarDescuentoPorCategoria(nombre, descuento);
					JOptionPane.showMessageDialog(null, "Descuento Aplicado");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e1.toString());
				}
				enableCategoriaFalse();

				
			} else if (e.getSource() == btnAceptarN) {
				ManejoCSV manejoCSV = new ManejoCSV();
				String nombre;
				float descuento;
				nombre=(String) CBnombres.getSelectedItem();
				descuento=Float.parseFloat(descuento1.getText());
				try {
					manejoCSV.aplicarDescuentoPorNombre(nombre, descuento);
					JOptionPane.showMessageDialog(null, "Descuento Aplicado");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e1.toString());
						}
						enableNombreFalse();

				
			} else if(e.getSource() == descuentosAplicados){
				// Abrir la ventana de login
                DescuentosAplicadosGUI loginGUI = new DescuentosAplicadosGUI();
                loginGUI.setVisible(true);
                dispose(); // Cerrar la ventana actual

			}
		}
	}
	public void visiblesCategoriaTrue(){
		
		 lblNewLabel_3.setVisible(true);
		 lblNewLabel_7.setVisible(true);
		 btnAceptarC.setVisible(true);
		 
		 
		 descuento2.setVisible(true);
		 CBcategorias.setVisible(true);

	}
	public void enableCategoriaTrue(){
		
		 lblNewLabel_3.setEnabled(true);
		 lblNewLabel_7.setEnabled(true);
		 btnAceptarC.setEnabled(true);
		 
		 
		 descuento2.setEnabled(true);
		 CBcategorias.setEnabled(true);

	}
	public void visiblesCategoriaFalse(){
		
		 lblNewLabel_3.setVisible(false);
		 lblNewLabel_7.setVisible(false);
		 btnAceptarC.setVisible(false);
		 
		 
		 descuento2.setVisible(false);
		 CBcategorias.setVisible(false);

	}
	public void enableCategoriaFalse(){
		
		 lblNewLabel_3.setEnabled(false);
		 lblNewLabel_7.setEnabled(false);
		 btnAceptarC.setEnabled(false);
		 
		 
		 descuento2.setEnabled(false);
		 CBcategorias.setEnabled(false);

	}
	public void visiblesNombreTrue(){
		
		 lblNewLabel_2.setVisible(true);
		 lblNewLabel_6.setVisible(true);
		 btnAceptarN.setVisible(true);
		 
		 descuento1.setVisible(true);
		 CBnombres.setVisible(true);

		

	}
	public void enableNombreTrue(){
		 
		 lblNewLabel_2.setEnabled(true);
		 lblNewLabel_6.setEnabled(true);
		 btnAceptarN.setEnabled(true);
		 
		 descuento1.setEnabled(true);
		 CBnombres.setEnabled(true);

	}

	public void visiblesNombreFalse(){
		
		 lblNewLabel_2.setVisible(false);
		 lblNewLabel_6.setVisible(false);
		 btnAceptarN.setVisible(false);
		 
		 descuento1.setVisible(false);
		 CBnombres.setVisible(false);

		

	}
	public void enableNombreFalse(){
		
		 lblNewLabel_2.setEnabled(false);
		 lblNewLabel_6.setEnabled(false);
		 btnAceptarN.setEnabled(false);
		 
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
