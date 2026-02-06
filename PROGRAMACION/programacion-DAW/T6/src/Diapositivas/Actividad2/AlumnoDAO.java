package Diapositivas.Actividad2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class AlumnoDAO {
    public void insertar(int id, String grupo, int nif, String nombre, String apellido1, String apellido2) {
        String sql = "INSERT INTO Alumno VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, grupo);
            ps.setInt(3, nif);
            ps.setString(4, nombre);
            ps.setString(5, apellido1);
            ps.setString(6, apellido2);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Alumno";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " + rs.getString("grupo") + " - " + rs.getInt("nif") + " - "
                                + rs.getString("nombre") + " - " + rs.getString("apellido1") + " - "
                                + rs.getString("apellido2"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar(int id, String grupo, int nif, String nombre, String apellido1, String apellido2) {
        String sql = "UPDATE Alumno SET grupo=?, nif=?, nombre=?, apellido1=?, apellido2=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, grupo);
            ps.setInt(2, nif);
            ps.setString(3, nombre);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Alumno WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
