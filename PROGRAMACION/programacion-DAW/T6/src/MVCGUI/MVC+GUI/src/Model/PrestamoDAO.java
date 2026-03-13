package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrestamoDAO {
    // READ
    public ArrayList<Prestamo> listar() {
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT ID_Prestamo, Codigo_Libro, DNI_Usuario FROM prestamo";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                prestamos.add(new Prestamo(
                        rs.getInt("ID_Prestamo"),
                        rs.getInt("Codigo_Libro"),
                        rs.getString("DNI_Usuario")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }

    // CREATE
    public void insertar(Prestamo p) throws SQLException {
        String sql = "INSERT INTO prestamo (ID_Prestamo, Codigo_Libro, DNI_Usuario) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPrestamo());
            ps.setInt(2, p.getCodigoLibro());
            ps.setString(3, p.getDniUsuario());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void actualizar(Prestamo p) throws SQLException {
        String sql = "UPDATE prestamo SET Codigo_Libro=?, DNI_Usuario=? WHERE ID_Prestamo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getCodigoLibro());
            ps.setString(2, p.getDniUsuario());
            ps.setInt(3, p.getIdPrestamo());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int idPrestamo) throws SQLException {
        String sql = "DELETE FROM prestamo WHERE ID_Prestamo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPrestamo);
            ps.executeUpdate();
        }
    }
}
