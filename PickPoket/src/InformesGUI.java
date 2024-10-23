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
        
        JLabel lblNewLabel = new JLabel("IVA Total");
        lblNewLabel.setForeground(new Color(183, 139, 255));
        lblNewLabel.setBounds(98, 106, 113, 16);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Informe de Ganancias");
        lblNewLabel_1.setBounds(21, 6, 166, 16);
        getContentPane().add(lblNewLabel_1);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(183, 172, 255));
        panel.setBounds(6, 6, 205, 16);
        getContentPane().add(panel);
        
        JLabel lblNewLabel_2 = new JLabel("Ganancias totales");
        lblNewLabel_2.setForeground(new Color(183, 139, 255));
        lblNewLabel_2.setBackground(new Color(183, 172, 255));
        lblNewLabel_2.setBounds(98, 54, 113, 16);
        getContentPane().add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.setBounds(311, 215, 117, 29);
        getContentPane().add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(78, 45, 300, 132);
        getContentPane().add(panel_1);
    }
}