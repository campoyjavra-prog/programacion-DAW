package Diapositivas.Actividad2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class ProfesorDAO {
    public void insertar(int id, int nif, String nombre, String apellido1, String apellido2) {
        String sql = "INSERT INTO Profesor VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, nif);
            ps.setString(3, nombre);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar(int id, int nif, String nombre, String apellido1, String apellido2) {
        String sql = "SELECT * FROM Profesor";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " + rs.getString("nombre") + " - " + rs.getString("apellido1") + " - "
                                + rs.getString("apellido2"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar(int id, int nif, String nombre, String apellido1, String apellido2) {
        String sql = "UPDATE Profesor SET nombre=?, apellido1=?, apellido2=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, nif);
            ps.setString(3, nombre);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Profesor WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
