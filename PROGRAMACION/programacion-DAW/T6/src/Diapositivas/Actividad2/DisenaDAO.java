package Diapositivas.Actividad2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class DisenaDAO {
    public void insertar() {
        String sql = "INSERT INTO Disena VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Disena";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " + rs.getString("nombre") + " - " + rs.getString("fecha") + " - "
                                + rs.getInt("nota"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar() {
        String sql = "UPDATE Disena SET nombre=?, fecha=?, nota=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar() {
        String sql = "DELETE FROM Disena WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
