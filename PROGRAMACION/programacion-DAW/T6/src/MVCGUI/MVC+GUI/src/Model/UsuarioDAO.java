package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    // READ
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT DNI, Nombre, Apellido1, Apellido2, Telefono FROM usuario";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getString("DNI"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido1"),
                        rs.getString("Apellido2"),
                        rs.getString("Telefono")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // CREATE
    public void insertar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuario (DNI, Nombre, Apellido1, Apellido2, Telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getDni());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido1());
            ps.setString(4, u.getApellido2());
            ps.setString(5, u.getTelefono());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void actualizar(Usuario u) throws SQLException {
        String sql = "UPDATE usuario SET Nombre=?, Apellido1=?, Apellido2=?, Telefono=? WHERE DNI=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido1());
            ps.setString(3, u.getApellido2());
            ps.setString(4, u.getTelefono());
            ps.setString(5, u.getDni());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(String dni) throws SQLException {
        String sql = "DELETE FROM usuario WHERE DNI=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ps.executeUpdate();
        }
    }
}
