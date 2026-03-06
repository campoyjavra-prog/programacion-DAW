package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RevistaDAO {

    public void insertar(int numeroRegistro, String titulo, String tipo, String periodicidad) {
        String sql = "INSERT INTO Revista (numero_registro, titulo, tipo, periodicidad) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numeroRegistro);
            ps.setString(2, titulo);
            ps.setString(3, tipo);
            ps.setString(4, periodicidad);
            ps.executeUpdate();
            System.out.println("Revista insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar revista: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Revista";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Nº Registro: %d | Título: %s | Tipo: %s | Periodicidad: %s",
                        rs.getInt("numero_registro"),
                        rs.getString("titulo"),
                        rs.getString("tipo"),
                        rs.getString("periodicidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar revistas: " + e.getMessage());
        }
    }

    public void borrar(int numeroRegistro) {
        String sql = "DELETE FROM Revista WHERE numero_registro=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numeroRegistro);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Revista borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar revista: " + e.getMessage());
        }
    }
}
