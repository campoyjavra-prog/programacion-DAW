package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoDAO {

    public void insertar(int id, String nif, String nombre, String apellido1, String apellido2, String telefono,
            int codigoSucursal) {
        // La relación Trabaja 1:N significa que Empleado tiene foreign key a Sucursal
        String sql = "INSERT INTO Empleado (id, nif, nombre, apellido1, apellido2, telefono, codigo_sucursal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nif);
            ps.setString(3, nombre);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.setString(6, telefono);
            ps.setInt(7, codigoSucursal);
            ps.executeUpdate();
            System.out.println("Empleado insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Empleado";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | NIF: %s | Nombre: %s %s %s | Tel: %s | Cod. Sucursal: %d",
                        rs.getInt("id"),
                        rs.getString("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("telefono"),
                        rs.getInt("codigo_sucursal")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Empleado WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Empleado borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar empleado: " + e.getMessage());
        }
    }
}
