package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PeriodistaDAO {

    public void insertar(int id, String nombre, String apellido1, String apellido2, String telefono,
            String especialidad) {
        String sql = "INSERT INTO Periodista (id, nombre, apellido1, apellido2, telefono, especialidad) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido1);
            ps.setString(4, apellido2);
            ps.setString(5, telefono);
            ps.setString(6, especialidad);
            ps.executeUpdate();
            System.out.println("Periodista insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar periodista: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Periodista";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Nombre: %s %s %s | Tel: %s | Especialidad: %s",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("telefono"),
                        rs.getString("especialidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar periodistas: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Periodista WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Periodista borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar periodista: " + e.getMessage());
        }
    }
}
