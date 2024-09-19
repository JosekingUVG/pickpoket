import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuarioejemplo;
	private JTextField txtContraseaejemplo;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_1;
	private JPanel panel_4;
	private JPanel panel_8;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JPanel panel_31;
	private JPanel panel_32;
	private JPanel panel_33;
	private JPanel panel_34;
	private JPanel panel_35;
	private JPanel panel_36;
	private JPanel panel_37;
	private JPanel panel_38;
	private JPanel panel_39;
	private JPanel panel_40;
	private JPanel panel_41;
	private JPanel panel_42;
	private JPanel panel_43;
	private JPanel panel_44;
	private JPanel panel_45;
	private JPanel panel_46;
	private JPanel panel_47;
	private JPanel panel_48;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setTitle("LOGIN");
		// Cambiar el icono de la ventana
        ImageIcon icon = new ImageIcon("jk.jpg");
        setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{1, 48, 70, 0, 0, 0, 86, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 104, 86, 103, 0};
		gbl_panel.rowHeights = new int[]{1, 29, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		panel_14 = new JPanel();
		panel_14.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_14.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 5, 5);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 3;
		gbc_panel_14.gridy = 1;
		panel.add(panel_14, gbc_panel_14);
		
		panel_18 = new JPanel();
		panel_18.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_18.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 0, 5, 5);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 4;
		gbc_panel_18.gridy = 1;
		panel.add(panel_18, gbc_panel_18);
		
		panel_30 = new JPanel();
		panel_30.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_30.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(0, 0, 5, 5);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 5;
		gbc_panel_30.gridy = 1;
		panel.add(panel_30, gbc_panel_30);
		
		lblNewLabel_2 = new JLabel("   LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		panel_31 = new JPanel();
		panel_31.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_31.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_31 = new GridBagConstraints();
		gbc_panel_31.insets = new Insets(0, 0, 5, 5);
		gbc_panel_31.fill = GridBagConstraints.BOTH;
		gbc_panel_31.gridx = 8;
		gbc_panel_31.gridy = 1;
		panel.add(panel_31, gbc_panel_31);
		
		panel_37 = new JPanel();
		panel_37.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_37.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_37 = new GridBagConstraints();
		gbc_panel_37.insets = new Insets(0, 0, 5, 5);
		gbc_panel_37.fill = GridBagConstraints.BOTH;
		gbc_panel_37.gridx = 9;
		gbc_panel_37.gridy = 1;
		panel.add(panel_37, gbc_panel_37);
		
		panel_38 = new JPanel();
		panel_38.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_38.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_38 = new GridBagConstraints();
		gbc_panel_38.insets = new Insets(0, 0, 5, 5);
		gbc_panel_38.fill = GridBagConstraints.BOTH;
		gbc_panel_38.gridx = 10;
		gbc_panel_38.gridy = 1;
		panel.add(panel_38, gbc_panel_38);
		
		panel_15 = new JPanel();
		panel_15.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_15.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(0, 0, 5, 5);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 3;
		gbc_panel_15.gridy = 2;
		panel.add(panel_15, gbc_panel_15);
		
		panel_19 = new JPanel();
		panel_19.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_19.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(0, 0, 5, 5);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 4;
		gbc_panel_19.gridy = 2;
		panel.add(panel_19, gbc_panel_19);
		
		panel_28 = new JPanel();
		panel_28.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_28.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.insets = new Insets(0, 0, 5, 5);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 5;
		gbc_panel_28.gridy = 2;
		panel.add(panel_28, gbc_panel_28);
		
		panel_29 = new JPanel();
		panel_29.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_29.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.insets = new Insets(0, 0, 5, 5);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 6;
		gbc_panel_29.gridy = 2;
		panel.add(panel_29, gbc_panel_29);
		
		panel_32 = new JPanel();
		panel_32.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_32.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_32 = new GridBagConstraints();
		gbc_panel_32.insets = new Insets(0, 0, 5, 5);
		gbc_panel_32.fill = GridBagConstraints.BOTH;
		gbc_panel_32.gridx = 8;
		gbc_panel_32.gridy = 2;
		panel.add(panel_32, gbc_panel_32);
		
		panel_39 = new JPanel();
		panel_39.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_39.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_39 = new GridBagConstraints();
		gbc_panel_39.insets = new Insets(0, 0, 5, 5);
		gbc_panel_39.fill = GridBagConstraints.BOTH;
		gbc_panel_39.gridx = 9;
		gbc_panel_39.gridy = 2;
		panel.add(panel_39, gbc_panel_39);
		
		panel_40 = new JPanel();
		panel_40.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_40.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_40 = new GridBagConstraints();
		gbc_panel_40.insets = new Insets(0, 0, 5, 5);
		gbc_panel_40.fill = GridBagConstraints.BOTH;
		gbc_panel_40.gridx = 10;
		gbc_panel_40.gridy = 2;
		panel.add(panel_40, gbc_panel_40);
		
		panel_13 = new JPanel();
		panel_13.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_13.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 5, 5);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 3;
		gbc_panel_13.gridy = 3;
		panel.add(panel_13, gbc_panel_13);
		
		panel_20 = new JPanel();
		panel_20.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_20.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.insets = new Insets(0, 0, 5, 5);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 4;
		gbc_panel_20.gridy = 3;
		panel.add(panel_20, gbc_panel_20);
		
		panel_27 = new JPanel();
		panel_27.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_27.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_27 = new GridBagConstraints();
		gbc_panel_27.insets = new Insets(0, 0, 5, 5);
		gbc_panel_27.fill = GridBagConstraints.BOTH;
		gbc_panel_27.gridx = 5;
		gbc_panel_27.gridy = 3;
		panel.add(panel_27, gbc_panel_27);
		
		JLabel lblNewLabel_1 = new JLabel("    USUARIO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		panel_33 = new JPanel();
		panel_33.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_33.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.insets = new Insets(0, 0, 5, 5);
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.gridx = 8;
		gbc_panel_33.gridy = 3;
		panel.add(panel_33, gbc_panel_33);
		
		panel_41 = new JPanel();
		panel_41.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_41.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_41 = new GridBagConstraints();
		gbc_panel_41.insets = new Insets(0, 0, 5, 5);
		gbc_panel_41.fill = GridBagConstraints.BOTH;
		gbc_panel_41.gridx = 9;
		gbc_panel_41.gridy = 3;
		panel.add(panel_41, gbc_panel_41);
		
		panel_42 = new JPanel();
		panel_42.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_42.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_42 = new GridBagConstraints();
		gbc_panel_42.insets = new Insets(0, 0, 5, 5);
		gbc_panel_42.fill = GridBagConstraints.BOTH;
		gbc_panel_42.gridx = 10;
		gbc_panel_42.gridy = 3;
		panel.add(panel_42, gbc_panel_42);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 12;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 64, 128));
		panel_3.setForeground(new Color(128, 128, 192));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 23;
		gbc_panel_3.gridy = 3;
		panel.add(panel_3, gbc_panel_3);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setForeground(new Color(128, 128, 192));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 25;
		gbc_panel_2.gridy = 3;
		panel.add(panel_2, gbc_panel_2);
		
		panel_16 = new JPanel();
		panel_16.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_16.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.insets = new Insets(0, 0, 5, 5);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 3;
		gbc_panel_16.gridy = 4;
		panel.add(panel_16, gbc_panel_16);
		
		panel_21 = new JPanel();
		panel_21.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_21.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.insets = new Insets(0, 0, 5, 5);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 4;
		gbc_panel_21.gridy = 4;
		panel.add(panel_21, gbc_panel_21);
		
		panel_26 = new JPanel();
		panel_26.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_26.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.insets = new Insets(0, 0, 5, 5);
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.gridx = 5;
		gbc_panel_26.gridy = 4;
		panel.add(panel_26, gbc_panel_26);
		
		txtUsuarioejemplo = new JTextField();
		txtUsuarioejemplo.setText("usuarioejemplo");
		GridBagConstraints gbc_txtUsuarioejemplo = new GridBagConstraints();
		gbc_txtUsuarioejemplo.anchor = GridBagConstraints.WEST;
		gbc_txtUsuarioejemplo.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuarioejemplo.gridx = 6;
		gbc_txtUsuarioejemplo.gridy = 4;
		panel.add(txtUsuarioejemplo, gbc_txtUsuarioejemplo);
		txtUsuarioejemplo.setColumns(10);
		
		panel_34 = new JPanel();
		panel_34.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_34.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_34 = new GridBagConstraints();
		gbc_panel_34.insets = new Insets(0, 0, 5, 5);
		gbc_panel_34.fill = GridBagConstraints.BOTH;
		gbc_panel_34.gridx = 8;
		gbc_panel_34.gridy = 4;
		panel.add(panel_34, gbc_panel_34);
		
		panel_43 = new JPanel();
		panel_43.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_43.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_43 = new GridBagConstraints();
		gbc_panel_43.insets = new Insets(0, 0, 5, 5);
		gbc_panel_43.fill = GridBagConstraints.BOTH;
		gbc_panel_43.gridx = 9;
		gbc_panel_43.gridy = 4;
		panel.add(panel_43, gbc_panel_43);
		
		panel_44 = new JPanel();
		panel_44.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_44.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_44 = new GridBagConstraints();
		gbc_panel_44.insets = new Insets(0, 0, 5, 5);
		gbc_panel_44.fill = GridBagConstraints.BOTH;
		gbc_panel_44.gridx = 10;
		gbc_panel_44.gridy = 4;
		panel.add(panel_44, gbc_panel_44);
		
		panel_12 = new JPanel();
		panel_12.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_12.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 3;
		gbc_panel_12.gridy = 5;
		panel.add(panel_12, gbc_panel_12);
		
		panel_22 = new JPanel();
		panel_22.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_22.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.insets = new Insets(0, 0, 5, 5);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 4;
		gbc_panel_22.gridy = 5;
		panel.add(panel_22, gbc_panel_22);
		
		panel_25 = new JPanel();
		panel_25.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_25.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 5;
		gbc_panel_25.gridy = 5;
		panel.add(panel_25, gbc_panel_25);
		
		JLabel lblNewLabel = new JLabel("  CONTRASEÑA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 5;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		panel_35 = new JPanel();
		panel_35.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_35.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_35 = new GridBagConstraints();
		gbc_panel_35.insets = new Insets(0, 0, 5, 5);
		gbc_panel_35.fill = GridBagConstraints.BOTH;
		gbc_panel_35.gridx = 8;
		gbc_panel_35.gridy = 5;
		panel.add(panel_35, gbc_panel_35);
		
		panel_45 = new JPanel();
		panel_45.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_45.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_45 = new GridBagConstraints();
		gbc_panel_45.insets = new Insets(0, 0, 5, 5);
		gbc_panel_45.fill = GridBagConstraints.BOTH;
		gbc_panel_45.gridx = 9;
		gbc_panel_45.gridy = 5;
		panel.add(panel_45, gbc_panel_45);
		
		panel_46 = new JPanel();
		panel_46.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_46.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_46 = new GridBagConstraints();
		gbc_panel_46.insets = new Insets(0, 0, 5, 5);
		gbc_panel_46.fill = GridBagConstraints.BOTH;
		gbc_panel_46.gridx = 10;
		gbc_panel_46.gridy = 5;
		panel.add(panel_46, gbc_panel_46);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 23;
		gbc_panel_1.gridy = 5;
		panel.add(panel_1, gbc_panel_1);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 24;
		gbc_panel_4.gridy = 5;
		panel.add(panel_4, gbc_panel_4);
		
		panel_17 = new JPanel();
		panel_17.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_17.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(0, 0, 5, 5);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 3;
		gbc_panel_17.gridy = 6;
		panel.add(panel_17, gbc_panel_17);
		
		panel_23 = new JPanel();
		panel_23.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_23.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.insets = new Insets(0, 0, 5, 5);
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 4;
		gbc_panel_23.gridy = 6;
		panel.add(panel_23, gbc_panel_23);
		
		panel_24 = new JPanel();
		panel_24.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_24.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(0, 0, 5, 5);
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 5;
		gbc_panel_24.gridy = 6;
		panel.add(panel_24, gbc_panel_24);
		
		txtContraseaejemplo = new JTextField();
		txtContraseaejemplo.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseaejemplo.setText("contraseñaejemplo");
		GridBagConstraints gbc_txtContraseaejemplo = new GridBagConstraints();
		gbc_txtContraseaejemplo.anchor = GridBagConstraints.WEST;
		gbc_txtContraseaejemplo.insets = new Insets(0, 0, 5, 5);
		gbc_txtContraseaejemplo.gridx = 6;
		gbc_txtContraseaejemplo.gridy = 6;
		panel.add(txtContraseaejemplo, gbc_txtContraseaejemplo);
		txtContraseaejemplo.setColumns(10);
		
		panel_36 = new JPanel();
		panel_36.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_36.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_36 = new GridBagConstraints();
		gbc_panel_36.insets = new Insets(0, 0, 5, 5);
		gbc_panel_36.fill = GridBagConstraints.BOTH;
		gbc_panel_36.gridx = 8;
		gbc_panel_36.gridy = 6;
		panel.add(panel_36, gbc_panel_36);
		
		panel_47 = new JPanel();
		panel_47.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_47.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_47 = new GridBagConstraints();
		gbc_panel_47.insets = new Insets(0, 0, 5, 5);
		gbc_panel_47.fill = GridBagConstraints.BOTH;
		gbc_panel_47.gridx = 9;
		gbc_panel_47.gridy = 6;
		panel.add(panel_47, gbc_panel_47);
		
		panel_48 = new JPanel();
		panel_48.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_48.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_48 = new GridBagConstraints();
		gbc_panel_48.insets = new Insets(0, 0, 5, 5);
		gbc_panel_48.fill = GridBagConstraints.BOTH;
		gbc_panel_48.gridx = 10;
		gbc_panel_48.gridy = 6;
		panel.add(panel_48, gbc_panel_48);
		
		panel_11 = new JPanel();
		panel_11.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_11.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 3;
		gbc_panel_11.gridy = 7;
		panel.add(panel_11, gbc_panel_11);
		
		panel_8 = new JPanel();
		panel_8.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_8.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 4;
		gbc_panel_8.gridy = 7;
		panel.add(panel_8, gbc_panel_8);
		
		panel_5 = new JPanel();
		panel_5.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_5.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 7;
		panel.add(panel_5, gbc_panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_6.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 6;
		gbc_panel_6.gridy = 7;
		panel.add(panel_6, gbc_panel_6);
		
		btnNewButton = new JButton("ACEPTAR");
		panel_6.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 64, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			//Boton ACEPTAR:
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		panel_7 = new JPanel();
		panel_7.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_7.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 8;
		gbc_panel_7.gridy = 7;
		panel.add(panel_7, gbc_panel_7);
		
		panel_9 = new JPanel();
		panel_9.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_9.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 9;
		gbc_panel_9.gridy = 7;
		panel.add(panel_9, gbc_panel_9);
		
		panel_10 = new JPanel();
		panel_10.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel_10.setBackground(new Color(216, 220, 254));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 10;
		gbc_panel_10.gridy = 7;
		panel.add(panel_10, gbc_panel_10);
	}
}
