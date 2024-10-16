import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;

public class ProductosGUI extends JFrame {
	// botones del gui 
	private JButton BAgregar;
	private JButton BEliminar;
	
	//Textos 
	

	private static final long serialVersionUID = 1L;
    private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosGUI frame = new ProductosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductosGUI() {
		inicializar();  
		
	}
	
	private void inicializar() {
	frame.getContentPane().setLayout(null);  // Desactiva el layout automático	
	Escucha MP_Accion = new Escucha();
	JPanel PanelAgregar = new JPanel();
	PanelAgregar.setBorder(new LineBorder(new Color(121, 129, 255)));
	PanelAgregar.setBackground(new Color(176, 230, 255));
	getContentPane().add(PanelAgregar, BorderLayout.NORTH);
	PanelAgregar.setLayout(new GridLayout(6, 2, 0, 0));
	
	JLabel lblNewLabel_1 = new JLabel("Codigo");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
	lblNewLabel_1.setBackground(new Color(131, 131, 255));
	lblNewLabel_1.setForeground(new Color(101, 127, 255));
	PanelAgregar.add(lblNewLabel_1);
	
	textField = new JTextField();
	PanelAgregar.add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("Nombre");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
	lblNewLabel_2.setForeground(new Color(101, 127, 255));
	PanelAgregar.add(lblNewLabel_2);
	
	textField_1 = new JTextField();
	PanelAgregar.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblPrecio = new JLabel("Precio");
	lblPrecio.setForeground(new Color(101, 127, 255));
	PanelAgregar.add(lblPrecio);
	
	textField_2 = new JTextField();
	PanelAgregar.add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblNewLabel_4 = new JLabel("Cantidad");
	lblNewLabel_4.setForeground(new Color(101, 127, 255));
	PanelAgregar.add(lblNewLabel_4);
	
	textField_3 = new JTextField();
	PanelAgregar.add(textField_3);
	textField_3.setColumns(10);
	
	JLabel lblNewLabel_3 = new JLabel("Categoria");
	lblNewLabel_3.setForeground(new Color(101, 127, 255));
	PanelAgregar.add(lblNewLabel_3);
	
	textField_4 = new JTextField();
	PanelAgregar.add(textField_4);
	textField_4.setColumns(10);
	
	BAgregar  = new JButton("AGREGAR");
	BAgregar.setBackground(new Color(101, 127, 255));
	BAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	PanelAgregar.add(BAgregar);
	
	JPanel PanelEliminar = new JPanel(new GridLayout(4, 2, 10, 10));
	PanelEliminar.setBorder(new CompoundBorder());
	PanelEliminar.setBackground(new Color(176, 230, 255));
	PanelEliminar.setForeground(new Color(101, 127, 255));
	getContentPane().add(PanelEliminar, BorderLayout.CENTER);
	
	JLabel lblNewLabel = new JLabel("Elimia un Producto");
	lblNewLabel.setForeground(new Color(131, 129, 255));
	PanelEliminar.add(lblNewLabel);
	
	JComboBox comboBox = new JComboBox();
	PanelEliminar.add(comboBox);
	
	JButton BEliminar = new JButton("Eliminar");
	BEliminar.setHorizontalAlignment(SwingConstants.LEFT);
	PanelEliminar.add(BEliminar);

	}
	private class Escucha implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	
		
	}
	
}
