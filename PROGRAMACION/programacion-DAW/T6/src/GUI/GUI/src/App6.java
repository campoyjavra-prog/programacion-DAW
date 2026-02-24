import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App6 extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel panelContenido, panelMenu;
    private JButton btnInicio, btnAdmin, btnAyuda;

    public App6() {
        setTitle("Aplicación con menú");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// Centrará el Frame
        // Layout principal
        setLayout(new BorderLayout());
        // ===== MENÚ SUPERIOR =====
        panelMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnInicio = new JButton("Inicio");
        btnAdmin = new JButton("Admin");
        btnAyuda = new JButton("Ayuda");
        panelMenu.add(btnInicio);
        panelMenu.add(btnAdmin);
        panelMenu.add(btnAyuda);
        add(panelMenu, BorderLayout.NORTH);
        // ===== CONTENIDO CENTRAL =====
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);
        panelContenido.add(crearPanelInicio(), "INICIO");
        panelContenido.add(crearPanelAdmin(), "ADMIN");
        panelContenido.add(crearPanelAyuda(), "AYUDA");
        add(panelContenido, BorderLayout.CENTER);
        // ===== ASOCIAR LISTENERS =====
        btnInicio.addActionListener(this);
        btnAdmin.addActionListener(this);
        btnAyuda.addActionListener(this);
        setVisible(true);
    }

    // ===== PANELES =====
    private JPanel crearPanelInicio() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pantalla de inicio"));
        return panel;
    }

    private JPanel crearPanelAdmin() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de administración"));
        return panel;
    }

    private JPanel crearPanelAyuda() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pantalla de ayuda"));
        return panel;
    }

    // ===== ACTION LISTENER =====
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnInicio) {
            cardLayout.show(panelContenido, "INICIO");
        } else if (source == btnAdmin) {
            cardLayout.show(panelContenido, "ADMIN");
        } else if (source == btnAyuda) {
            cardLayout.show(panelContenido, "AYUDA");
        }
    }

    public static void main(String[] args) {
        new App6();
    }
}
