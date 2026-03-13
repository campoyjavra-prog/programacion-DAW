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

public class UsuarioView extends JPanel {
    // Campos
    public JTextField txtNombre = new JTextField(5);
    public JTextField txtApellido1 = new JTextField(5);
    public JTextField txtApellido2 = new JTextField(5);
    public JTextField txtDni = new JTextField(5);
    public JTextField txtTelefono = new JTextField(5);

    // Botones
    public JButton btnInsertar = new JButton("Insertar");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnLimpiar = new JButton("Limpiar");

    // Tabla
    public DefaultTableModel modeloTabla = new DefaultTableModel(
        new Object[]{"DNI", "Nombre", "Primer Apellido", "Segundo Apellido", "Teléfono"}, 0
    );
    public JTable tablaUsuarios = new JTable(modeloTabla);

    public UsuarioView() {
        setLayout(new BorderLayout());

        // Panel Superior
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Primer Apellido:"));
        panelFormulario.add(txtApellido1);
        panelFormulario.add(new JLabel("Segundo Apellido:"));
        panelFormulario.add(txtApellido2);
        panelFormulario.add(new JLabel("DNI:"));
        panelFormulario.add(txtDni);
        panelFormulario.add(new JLabel("Teléfono:"));
        panelFormulario.add(txtTelefono);

        // Panel Inferior
        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBorder(
                BorderFactory.createTitledBorder("Usuario"));
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
