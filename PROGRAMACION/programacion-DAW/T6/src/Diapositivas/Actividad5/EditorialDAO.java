package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class EditorialDAO {

    public void insertar(int id, String nombre, String direccion, String telefono, String url, int idLocalidad) {
        String sql = "INSERT INTO Editorial VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, telefono);
            ps.setString(5, url);
            ps.setInt(6, idLocalidad);
            ps.executeUpdate();
            System.out.println("Editorial insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar editorial: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Editorial";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Editorial: %s | Localidad: %d",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("id_localidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar editoriales: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Editorial WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Editorial borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar editorial: " + e.getMessage());
        }
    }
}
