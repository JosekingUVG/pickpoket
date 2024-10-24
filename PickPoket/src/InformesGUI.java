import javax.swing.*;
import java.awt.*;

public class InformesGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    
     //Launch the application.
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InformesGUI frame = new InformesGUI();
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
    public InformesGUI() {
    	getContentPane().setBackground(new Color(173, 230, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300); // Tamaño del frame
        getContentPane().setLayout(null); // Layout donde me deja ponerlo en cualquier cuadrante 
        
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
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBounds(200, 61, 61, 16);
        panel_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("New label");
        lblNewLabel_4_1.setBounds(200, 18, 61, 16);
        panel_1.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_2 = new JLabel("Ganancias totales");
        lblNewLabel_2.setBounds(23, 18, 113, 16);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setForeground(new Color(183, 139, 255));
        lblNewLabel_2.setBackground(new Color(183, 172, 255));
        
        JLabel lblNoSe = new JLabel("No se");
        lblNoSe.setForeground(new Color(183, 139, 255));
        lblNoSe.setBounds(23, 107, 113, 16);
        panel_1.add(lblNoSe);
        
        JLabel lblNewLabel_4_2 = new JLabel("New label");
        lblNewLabel_4_2.setBounds(200, 107, 61, 16);
        panel_1.add(lblNewLabel_4_2);
        
        JLabel lblNewLabel = new JLabel("IVA Total");
        lblNewLabel.setBounds(23, 61, 113, 16);
        panel_1.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(183, 139, 255));
    }
}