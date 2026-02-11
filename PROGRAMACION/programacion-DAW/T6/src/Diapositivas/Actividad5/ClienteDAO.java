package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class ClienteDAO {
    public void insertar(int id, String nombre, String apellido1, String apellido2, String direccion, String email,
            String telefono, int idLocalidad) {
        String sql = "INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido1);
            ps.setString(4, apellido2);
            ps.setString(5, direccion);
            ps.setString(6, email);
            ps.setString(7, telefono);
            ps.setInt(8, idLocalidad);
            ps.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Cliente: %s %s | Email: %s | Localidad: %d",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("email"),
                        rs.getInt("id_localidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Cliente WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Cliente borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar cliente: " + e.getMessage());
        }
    }
}
