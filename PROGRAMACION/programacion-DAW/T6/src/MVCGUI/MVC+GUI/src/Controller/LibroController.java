package Controller;

import View.LibroView;

import javax.swing.*;
import java.sql.SQLException;

import Model.Libro;
import Model.LibroDAO;
import java.net.URL;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

public class LibroController {
    private LibroView view;
    private LibroDAO dao = new LibroDAO();

    public LibroController(LibroView view) {
        this.view = view;
        initController();
        cargarTabla();
    }

    private void initController() {
        view.btnInsertar.addActionListener(e -> insertar());
        view.btnActualizar.addActionListener(e -> actualizar());
        view.btnEliminar.addActionListener(e -> eliminar());
        view.btnLimpiar.addActionListener(e -> limpiar());
        cargarTabla();

        view.tablaLibros.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });

        // Funcionalidad de pegar para la URL de la imagen
        view.txtImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                JPopupMenu menu = new JPopupMenu();
                JMenuItem itemPaste = new JMenuItem("Pegar URL");
                itemPaste.addActionListener(al -> {
                    try {
                        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
                                .getData(DataFlavor.stringFlavor);
                        view.txtImagen.setText(data);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                menu.add(itemPaste);
                menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    // METODOS

    private void insertar() {
        try { //Lectura datos de la vista (JTextField)
            int codigoLibro = Integer.parseInt(view.txtCodigoLibro.getText());
            String titulo = view.txtTitulo.getText();
            String editorial = view.txtEditorial.getText();
            String genero = view.txtGenero.getText();
            double precio = Double.parseDouble(view.txtPrecio.getText().replace(",", "."));
            String autor = view.txtAutor.getText();
            String imagen = view.txtImagen.getText().trim();
            if (imagen.isEmpty()) {
                imagen = "https://via.placeholder.com/150?text=No+Image";
            }
            // Llama al DAO y se crea el objeto Libro
            dao.insertar(new Libro(titulo, codigoLibro, editorial, genero, precio, autor, imagen));
            cargarTabla();
            limpiar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Datos numéricos inválidos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void actualizar() {
        int fila = view.tablaLibros.getSelectedRow();
        if (fila == -1) // Comprueba que hay una fila seleccionada
            return;

        try { // Lee datos del formulario → crea objeto → dao.actualizar(objeto)
            int codigoLibro = Integer.parseInt(view.txtCodigoLibro.getText());
            String titulo = view.txtTitulo.getText();
            String editorial = view.txtEditorial.getText();
            String genero = view.txtGenero.getText();
            double precio = Double.parseDouble(view.txtPrecio.getText().replace(",", "."));
            String autor = view.txtAutor.getText();
            String imagen = view.txtImagen.getText().trim();
            if (imagen.isEmpty()) {
                imagen = "https://via.placeholder.com/150?text=No+Image";
            }

            dao.actualizar(new Libro(titulo, codigoLibro, editorial, genero, precio, autor, imagen));
            cargarTabla();
            limpiar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Datos numéricos inválidos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void eliminar() {
        int fila = view.tablaLibros.getSelectedRow();
        if (fila == -1)
            return;
        int codigoLibro = Integer.parseInt(view.modeloTabla.getValueAt(fila, 1).toString()); // Obtiene el ID/clave de la tabla
                                                                                             
        try {
            dao.eliminar(codigoLibro);
            cargarTabla();
            limpiar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void seleccionarFila() {
        int fila = view.tablaLibros.getSelectedRow();
        if (fila == -1)
            return;
        view.txtTitulo.setText(view.tablaLibros.getValueAt(fila, 0).toString());
        view.txtCodigoLibro.setText(view.tablaLibros.getValueAt(fila, 1).toString());
        view.txtEditorial.setText(view.tablaLibros.getValueAt(fila, 2).toString());
        view.txtGenero.setText(view.tablaLibros.getValueAt(fila, 3).toString());
        view.txtPrecio.setText(view.tablaLibros.getValueAt(fila, 4).toString());
        view.txtAutor.setText(view.tablaLibros.getValueAt(fila, 5).toString());
        String imagenUrl = view.tablaLibros.getValueAt(fila, 6).toString();
        view.txtImagen.setText(imagenUrl);
        mostrarImagen(imagenUrl);
    }

    private void cargarTabla() {
        view.modeloTabla.setRowCount(0); // Borra todas las filas
        List<Libro> lista = dao.listar(); // Pide la lista al DAO
        for (Libro l : lista) { // Por cada elemento, añade una fila al modelo de la tabla
            view.modeloTabla.addRow(new Object[] {
                    l.getTitulo(),
                    l.getCodigoLibro(),
                    l.getEditorial(),
                    l.getGenero(),
                    l.getPrecio(),
                    l.getAutor(),
                    l.getImagen()
            });
        }
    }

    private void mostrarImagen(String urlStr) {
        try {
            URL url = new URL(urlStr);
            ImageIcon icon = new ImageIcon(url); // Descarga la imagen de internet
            
            java.awt.Image img = icon.getImage().getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
            view.lblImagen.setIcon(new ImageIcon(img)); // La muestra en el JLabel
        } catch (Exception e) {
            view.lblImagen.setIcon(null);
            view.lblImagen.setText("Error Imagen");
        }
    }

    private void limpiar() {
        view.txtTitulo.setText("");
        view.txtCodigoLibro.setText("");
        view.txtEditorial.setText("");
        view.txtGenero.setText("");
        view.txtPrecio.setText("");
        view.txtAutor.setText("");
        view.txtImagen.setText("");
        view.lblImagen.setIcon(null);
        view.lblImagen.setText("");
        view.tablaLibros.clearSelection();
    }
}
