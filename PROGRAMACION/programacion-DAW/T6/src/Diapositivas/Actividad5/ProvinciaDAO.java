package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class ProvinciaDAO {
    public void insertar(int id, String nombre) {
        String sql = "INSERT INTO Provincia VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.executeUpdate();
            System.out.println("Provincia insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar provincia: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Provincia";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Provincia: %s",
                        rs.getInt("id"),
                        rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar provincias: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Provincia WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Provincia borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar provincia: " + e.getMessage());
        }
    }
}
