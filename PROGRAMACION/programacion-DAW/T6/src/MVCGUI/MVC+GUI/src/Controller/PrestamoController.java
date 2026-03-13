package Controller;

import View.PrestamoView;

import javax.swing.*;
import java.sql.SQLException;

import Model.Prestamo;
import Model.PrestamoDAO;

import java.util.List;

public class PrestamoController {
    private PrestamoView view;
    private PrestamoDAO dao = new PrestamoDAO();

    public PrestamoController(PrestamoView view) {
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

        view.tablaPrestamos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });
    }

    // METODOS

    private void insertar() {
        try {
            int idPrestamo = Integer.parseInt(view.txtIdPrestamo.getText());
            int idLibro = Integer.parseInt(view.txtCodigoLibro.getText());
            String dniUsuario = view.txtDniUsuario.getText();

            dao.insertar(new Prestamo(idPrestamo, idLibro, dniUsuario));
            cargarTabla();
            limpiar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Datos numéricos inválidos. Verifique IDs.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void actualizar() {
        int fila = view.tablaPrestamos.getSelectedRow();
        if (fila == -1)
            return;

        try {
            int idPrestamo = Integer.parseInt(view.txtIdPrestamo.getText());
            int idLibro = Integer.parseInt(view.txtCodigoLibro.getText());
            String dniUsuario = view.txtDniUsuario.getText();

            dao.actualizar(new Prestamo(idPrestamo, idLibro, dniUsuario));
            cargarTabla();
            limpiar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Datos numéricos inválidos. Verifique IDs.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void eliminar() {
        int fila = view.tablaPrestamos.getSelectedRow();
        if (fila == -1)
            return;
        int idPrestamo = Integer.parseInt(view.modeloTabla.getValueAt(fila, 0).toString());
        try {
            dao.eliminar(idPrestamo);
            cargarTabla();
            limpiar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void seleccionarFila() {
        int fila = view.tablaPrestamos.getSelectedRow();
        if (fila == -1)
            return;
        view.txtIdPrestamo.setText(view.tablaPrestamos.getValueAt(fila, 0).toString());
        view.txtCodigoLibro.setText(view.tablaPrestamos.getValueAt(fila, 1).toString());
        view.txtDniUsuario.setText(view.tablaPrestamos.getValueAt(fila, 2).toString());
    }

    private void cargarTabla() {
        view.modeloTabla.setRowCount(0);
        List<Prestamo> lista = dao.listar();
        for (Prestamo p : lista) {
            view.modeloTabla.addRow(new Object[] {
                    p.getIdPrestamo(),
                    p.getCodigoLibro(),
                    p.getDniUsuario(),
                    "",
                    ""
            });
        }
    }

    private void limpiar() {
        view.txtIdPrestamo.setText("");
        view.txtCodigoLibro.setText("");
        view.txtDniUsuario.setText("");
        view.tablaPrestamos.clearSelection();
    }
}
