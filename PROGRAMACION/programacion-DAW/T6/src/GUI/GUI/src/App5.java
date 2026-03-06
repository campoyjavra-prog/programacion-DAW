package GUI.GUI.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App5 extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuEdicion, menuAyuda;
    private JMenuItem itemNuevo, itemAbrir, itemGuardar, itemSalir;
    private JMenuItem itemCortar, itemCopiar, itemPegar, itemSeleccionar;
    private JMenuItem itemAcerca;

    public App5() {
        setTitle("Bloc de Notas Simple");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        crearMenu();
    }

    private void crearMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Archivo
        menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        itemNuevo = new JMenuItem("Nuevo");
        itemAbrir = new JMenuItem("Abrir...");
        itemGuardar = new JMenuItem("Guardar");
        itemSalir = new JMenuItem("Salir");

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        // Edición
        menuEdicion = new JMenu("Edición");
        menuBar.add(menuEdicion);

        itemCortar = new JMenuItem("Cortar");
        itemCopiar = new JMenuItem("Copiar");
        itemPegar = new JMenuItem("Pegar");
        itemSeleccionar = new JMenuItem("Seleccionar todo");

        menuEdicion.add(itemCortar);
        menuEdicion.add(itemCopiar);
        menuEdicion.add(itemPegar);
        menuEdicion.add(itemSeleccionar);

        // Ayuda
        menuAyuda = new JMenu("Ayuda");
        menuBar.add(menuAyuda);

        itemAcerca = new JMenuItem("Acerca de...");
        menuAyuda.add(itemAcerca);

        // Action Listeners
        itemNuevo.addActionListener(e -> textArea.setText(""));
        itemSalir.addActionListener(e -> System.exit(0));
        itemSeleccionar.addActionListener(e -> textArea.selectAll());
        itemAcerca.addActionListener(e -> JOptionPane.showMessageDialog(this, "Bloc de Notas Simple\nVersión 1.0",
                "Acerca de", JOptionPane.INFORMATION_MESSAGE));

        // Atajos de teclado
        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        itemCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        itemPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        itemSeleccionar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App5().setVisible(true));
    }
}
