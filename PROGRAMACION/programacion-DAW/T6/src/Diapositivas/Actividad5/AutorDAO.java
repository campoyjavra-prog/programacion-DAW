package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class AutorDAO {
    public void insertar(int id, String nombre, String apellido1, String apellido2, String direccion, String telefono,
            String url, int idLocalidad) {
        String sql = "INSERT INTO Autor VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido1);
            ps.setString(4, apellido2);
            ps.setString(5, direccion);
            ps.setString(6, telefono);
            ps.setString(7, url);
            ps.setInt(8, idLocalidad);
            ps.executeUpdate();
            System.out.println("Autor insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar autor: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Autor";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Autor: %s %s | URL: %s | Localidad: %d",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("url"),
                        rs.getInt("id_localidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar autores: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Autor WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Autor borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar autor: " + e.getMessage());
        }
    }
}
