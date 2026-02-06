package Diapositivas.Actividad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class EmpleadoDAO {
    public void insertar(int id, String nombre, String apellido1, String apellido2, String direccion, String telefono,
            String tipo) {
        String sql = "INSERT INTO Empleado VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido1);
            ps.setString(4, apellido2);
            ps.setString(5, direccion);
            ps.setString(6, telefono);
            ps.setString(7, tipo);
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
                System.out.println(String.format("ID: %d | Nombre: %s %s %s | Tlf: %s | Tipo: %s",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("telefono"),
                        rs.getString("tipo")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
    }

    public void actualizar(int id, String nombre, String apellido1, String apellido2, String direccion, String telefono,
            String tipo) {
        String sql = "UPDATE Empleado SET nombre=?, apellido1=?, apellido2=?, direccion=?, telefono=?, tipo=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, tipo);
            ps.setInt(7, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Empleado actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
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
