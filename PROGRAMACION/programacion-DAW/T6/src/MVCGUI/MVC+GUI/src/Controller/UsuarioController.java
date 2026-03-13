package Controller;

import View.UsuarioView;

import javax.swing.*;
import java.sql.SQLException;

import Model.Usuario;
import Model.UsuarioDAO;

import java.util.List;

public class UsuarioController {
    private UsuarioView view;
    private UsuarioDAO dao = new UsuarioDAO();

    public UsuarioController(UsuarioView view) {
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

        view.tablaUsuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarFila();
            }
        });
    }

    // METODOS

    private void insertar() {
        try {
            String dni = view.txtDni.getText();
            String telefono = view.txtTelefono.getText();
            String nombre = view.txtNombre.getText();
            String apellido1 = view.txtApellido1.getText();
            String apellido2 = view.txtApellido2.getText();

            dao.insertar(new Usuario(nombre, apellido1, apellido2, dni, telefono));
            cargarTabla();
            limpiar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error al insertar");
        }
    }

    private void actualizar() {
        int fila = view.tablaUsuarios.getSelectedRow();
        if (fila == -1)
            return;

        try {
            String dni = view.txtDni.getText();
            String telefono = view.txtTelefono.getText();
            String nombre = view.txtNombre.getText();
            String apellido1 = view.txtApellido1.getText();
            String apellido2 = view.txtApellido2.getText();

            dao.actualizar(new Usuario(nombre, apellido1, apellido2, dni, telefono));
            cargarTabla();
            limpiar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error al actualizar");
        }
    }

    private void eliminar() {
        int fila = view.tablaUsuarios.getSelectedRow();
        if (fila == -1)
            return;
        String idUsuario = view.modeloTabla.getValueAt(fila, 0).toString(); // DNI en col 0
        try {
            dao.eliminar(idUsuario);
            cargarTabla();
            limpiar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error Base de Datos: " + e.getMessage());
        }
    }

    private void seleccionarFila() {
        int fila = view.tablaUsuarios.getSelectedRow();
        if (fila == -1)
            return;
        view.txtDni.setText(view.tablaUsuarios.getValueAt(fila, 0).toString());
        view.txtNombre.setText(view.tablaUsuarios.getValueAt(fila, 1).toString());
        view.txtApellido1.setText(view.tablaUsuarios.getValueAt(fila, 2).toString());
        view.txtApellido2.setText(view.tablaUsuarios.getValueAt(fila, 3).toString());
        view.txtTelefono.setText(view.tablaUsuarios.getValueAt(fila, 4).toString());
    }

    private void cargarTabla() {
        view.modeloTabla.setRowCount(0);
        List<Usuario> lista = dao.listar();
        for (Usuario u : lista) {
            view.modeloTabla.addRow(new Object[] {
                    u.getDni(),
                    u.getNombre(),
                    u.getApellido1(),
                    u.getApellido2(),
                    u.getTelefono()
            });
        }
    }

    private void limpiar() {
        view.txtDni.setText("");
        view.txtTelefono.setText("");
        view.txtNombre.setText("");
        view.txtApellido1.setText("");
        view.txtApellido2.setText("");
        view.tablaUsuarios.clearSelection();
    }
}
