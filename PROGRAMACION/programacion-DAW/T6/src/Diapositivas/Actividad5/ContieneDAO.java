package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class ContieneDAO {

    public void insertar(int idCesta, int idLibro, int cantidad) {
        String sql = "INSERT INTO Contiene VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCesta);
            ps.setInt(2, idLibro);
            ps.setInt(3, cantidad);
            ps.executeUpdate();
            System.out.println("Relación Contiene insertada correctamente (Cantidad: " + cantidad + ").");
        } catch (SQLException e) {
            System.err.println("Error al insertar en Contiene: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Contiene";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Cesta ID: %d | Libro ID: %d | Cantidad: %d",
                        rs.getInt("id_cesta"),
                        rs.getInt("id_libro"),
                        rs.getInt("cantidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Contiene: " + e.getMessage());
        }
    }

    public void borrar(int idCesta, int idLibro) {
        String sql = "DELETE FROM Contiene WHERE id_cesta=? AND id_libro=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCesta);
            ps.setInt(2, idLibro);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Contiene borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar de Contiene: " + e.getMessage());
        }
    }
}
