package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class LocalidadDAO {
    public void insertar(int id, String nombre, int idProvincia) {
        String sql = "INSERT INTO Localidad VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, idProvincia);
            ps.executeUpdate();
            System.out.println("Localidad insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar localidad: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Localidad";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Localidad: %s | ID Provincia: %d",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("id_provincia")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar localidades: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Localidad WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Localidad borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar localidad: " + e.getMessage());
        }
    }
}
