package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PrestamoView extends JPanel {
    // Campos
    public JTextField txtIdPrestamo = new JTextField(5);
    public JTextField txtCodigoLibro = new JTextField(5);
    public JTextField txtDniUsuario = new JTextField(5);

    // Botones
    public JButton btnInsertar = new JButton("Insertar");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnLimpiar = new JButton("Limpiar");

    // Tabla
    public DefaultTableModel modeloTabla = new DefaultTableModel(
        new Object[]{"ID Préstamo", "Código Libro", "DNI Usuario"}, 0
    );
    public JTable tablaPrestamos = new JTable(modeloTabla);

    public PrestamoView() {
        setLayout(new BorderLayout());

        // Panel Superior
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        panelFormulario.add(new JLabel("ID Préstamo:"));
        panelFormulario.add(txtIdPrestamo);
        panelFormulario.add(new JLabel("Código Libro:"));
        panelFormulario.add(txtCodigoLibro);
        panelFormulario.add(new JLabel("DNI Usuario:"));
        panelFormulario.add(txtDniUsuario);

        // Panel Inferior
        JScrollPane scroll = new JScrollPane(tablaPrestamos);
        scroll.setBorder(
                BorderFactory.createTitledBorder("Préstamo"));
        // Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInsertar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
