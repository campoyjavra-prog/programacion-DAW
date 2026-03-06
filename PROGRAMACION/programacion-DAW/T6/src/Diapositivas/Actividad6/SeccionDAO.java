package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeccionDAO {

    public void insertar(String titulo, String extension, int numRegistroRevista) {
        String sql = "INSERT INTO Seccion (titulo, extension, num_registro_revista) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setString(2, extension);
            ps.setInt(3, numRegistroRevista);
            ps.executeUpdate();
            System.out.println("Sección insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar sección: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Seccion";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Título: %s | Extensión: %s | Revista (Reg.): %d",
                        rs.getString("titulo"),
                        rs.getString("extension"),
                        rs.getInt("num_registro_revista")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar secciones: " + e.getMessage());
        }
    }

    public void borrar(String titulo, int numRegistroRevista) {
        String sql = "DELETE FROM Seccion WHERE titulo=? AND num_registro_revista=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setInt(2, numRegistroRevista);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Sección borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar sección: " + e.getMessage());
        }
    }
}
