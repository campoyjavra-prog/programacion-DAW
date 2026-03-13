import Controller.UsuarioController;
import Controller.LibroController;
import Controller.PrestamoController;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import View.UsuarioView;
import View.LibroView;
import View.PrestamoView;

public class InterfaceGUI {
    public static void main(String[] args) {
        configureTheme();
        JFrame frame = new JFrame("Gestión de Suministros");
        // crea el JTTabedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50, 50, 300, 200);
        UsuarioView usuarioView = new UsuarioView();
        LibroView libroView = new LibroView();
        PrestamoView prestamoView = new PrestamoView();
        // Añadir los paneles como pestañas
        tabbedPane.addTab("Libros", libroView);
        tabbedPane.add("Usuarios", usuarioView);
        tabbedPane.addTab("Prestamos", prestamoView);
        // Definir el controlador asociado a cada vista
        LibroController libroController = new LibroController(libroView);
        UsuarioController usuarioController = new UsuarioController(usuarioView);
        PrestamoController prestamoController = new PrestamoController(prestamoView);
        // Asociar el TabbedPane
        frame.setContentPane(tabbedPane);
        // TAmaño y visibilidad
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void configureTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }

        Color primary = Color.decode("#7DD3C0");
        Color secondary = Color.decode("#E8956F");
        Color tertiary = Color.decode("#C4B5A0");
        Color textDark = Color.decode("#000000");
        Color textLight = Color.decode("#FFFFFF");
        Color Fondo1 = Color.decode("#FFE4C4");

        UIManager.put("Panel.background", tertiary);
        UIManager.put("OptionPane.background", tertiary);
        UIManager.put("TabbedPane.background", tertiary);
        UIManager.put("TabbedPane.selected", secondary);
        UIManager.put("TabbedPane.foreground", textDark);

        // Botones
        UIManager.put("Button.background", primary);
        UIManager.put("Button.foreground", textLight);
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
        // textfield
        UIManager.put("TextField.foreground", textDark);
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 12));

        // Textos generales
        UIManager.put("Label.foreground", textDark);
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 12));
        UIManager.put("TitledBorder.titleColor", textDark);
        UIManager.put("TitledBorder.font", new Font("Arial", Font.BOLD, 14));

        // Tablas y ScrollPane
        UIManager.put("Table.background", Color.WHITE);
        UIManager.put("Table.foreground", textDark);
        UIManager.put("Table.selectionBackground", secondary);
        UIManager.put("Table.selectionForeground", textLight);
        UIManager.put("Table.font", new Font("Arial", Font.PLAIN, 12));
        UIManager.put("TableHeader.background", primary);
        UIManager.put("TableHeader.foreground", textLight);
        UIManager.put("TableHeader.font", new Font("Arial", Font.BOLD, 13));
        UIManager.put("ScrollPane.background", Fondo1);
        UIManager.put("Viewport.background", Fondo1);
    }
}
