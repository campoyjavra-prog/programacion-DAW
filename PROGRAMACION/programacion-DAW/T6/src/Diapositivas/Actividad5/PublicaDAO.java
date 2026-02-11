package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class PublicaDAO {

    public void insertar(int idEditorial, int idLibro) {
        String sql = "INSERT INTO Publica VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEditorial);
            ps.setInt(2, idLibro);
            ps.executeUpdate();
            System.out.println("Relación Publica insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar en Publica: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Publica";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Editorial ID: %d <-> Libro ID: %d",
                        rs.getInt("id_editorial"),
                        rs.getInt("id_libro")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Publica: " + e.getMessage());
        }
    }

    public void borrar(int idEditorial, int idLibro) {
        String sql = "DELETE FROM Publica WHERE id_editorial=? AND id_libro=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEditorial);
            ps.setInt(2, idLibro);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Publica borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar de Publica: " + e.getMessage());
        }
    }
}
