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

public class LibroView extends JPanel {
    // Campos
    public JTextField txtTitulo = new JTextField(5);
    public JTextField txtCodigoLibro = new JTextField(5);
    public JTextField txtEditorial = new JTextField(5);
    public JTextField txtGenero = new JTextField(5);
    public JTextField txtPrecio = new JTextField(5);
    public JTextField txtAutor = new JTextField(5);
    public JTextField txtImagen = new JTextField(5);
    public JLabel lblImagen = new JLabel();

    // Botones
    public JButton btnInsertar = new JButton("Insertar");
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnLimpiar = new JButton("Limpiar");

    // Tabla
    public DefaultTableModel modeloTabla = new DefaultTableModel(
            new Object[] { "Título", "Código", "Editorial", "Género", "Precio", "Autor", "Imagen" }, 0);
    public JTable tablaLibros = new JTable(modeloTabla);

    public LibroView() {
        setLayout(new BorderLayout());
        lblImagen.setHorizontalAlignment(JLabel.CENTER);
        lblImagen.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        lblImagen.setPreferredSize(new java.awt.Dimension(150, 200));

        // Panel Superior
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(txtTitulo);
        panelFormulario.add(new JLabel("Código Libro:"));
        panelFormulario.add(txtCodigoLibro);
        panelFormulario.add(new JLabel("Editorial:"));
        panelFormulario.add(txtEditorial);
        panelFormulario.add(new JLabel("Género:"));
        panelFormulario.add(txtGenero);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(txtPrecio);
        panelFormulario.add(new JLabel("Autor:"));
        panelFormulario.add(txtAutor);
        panelFormulario.add(new JLabel("URL Imagen:"));
        panelFormulario.add(txtImagen);

        // Panel Inferior
        JScrollPane scroll = new JScrollPane(tablaLibros);
        scroll.setBorder(
                BorderFactory.createTitledBorder("Libro"));
        // Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInsertar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(lblImagen, BorderLayout.EAST);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
