package Diapositivas.Actividad2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class Examen_TeoricoDAO {
    public void insertar(int id, String titulo, String fecha, int numero_preguntas) {
        String sql = "INSERT INTO Examen_Teorico VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, titulo);
            ps.setString(3, fecha);
            ps.setInt(4, numero_preguntas);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Examen_Teorico";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " + rs.getString("titulo") + " - " + rs.getString("fecha") + " - "
                                + rs.getInt("numero_preguntas"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar(int id, String titulo, String fecha, int numero_preguntas) {
        String sql = "UPDATE Examen_Teorico SET titulo=?, fecha=?, numero_preguntas=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setString(2, fecha);
            ps.setInt(3, numero_preguntas);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Examen_Teorico WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
