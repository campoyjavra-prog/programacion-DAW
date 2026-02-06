package Diapositivas.Actividad3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class ProfesorDAO {

    public void insertar(int id, String nombre, String apellido1, String apellido2, String especialidad,
            String telefono) {
        String sql = "INSERT INTO Profesor VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido1);
            ps.setString(4, apellido2);
            ps.setString(5, especialidad);
            ps.setString(6, telefono);
            ps.executeUpdate();
            System.out.println("Profesor insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar profesor: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Profesor";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Nombre: %s %s %s | Especialidad: %s | Tlf: %s",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("especialidad"),
                        rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar profesores: " + e.getMessage());
        }
    }

    public void actualizar(int id, String nombre, String apellido1, String apellido2, String especialidad,
            String telefono) {
        String sql = "UPDATE Profesor SET nombre=?, apellido1=?, apellido2=?, especialidad=?, telefono=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, especialidad);
            ps.setString(5, telefono);
            ps.setInt(6, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Profesor actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar profesor: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Profesor WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Profesor borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar profesor: " + e.getMessage());
        }
    }
}
