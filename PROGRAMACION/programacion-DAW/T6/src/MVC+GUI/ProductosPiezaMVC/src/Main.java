import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controlador.CategoriaController;
import vista.CategoriaView;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IES Cura Valera");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50, 50, 300, 200);
        CategoriaView view = new CategoriaView();
        // PiezaView view2 = new PiezaView();
        // ProveedorView view3 = new ProveedorView();
        // SuministraView view4 = new SuministraView();
        tabbedPane.add("Categorias", view);
        // tabbedPane.add("Piezas", view2);
        // tabbedPane.add("Proveedores", view3);
        // tabbedPane.add("Suministra", view4);
        CategoriaController c1 = new CategoriaController(view);
        // PiezaController c2 = new PiezaController(view2);
        // ProveedorController c3 = new ProveedorController(view3);
        // SuministraController c4 = new SuministraController(view4);

        frame.setContentPane(tabbedPane);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
