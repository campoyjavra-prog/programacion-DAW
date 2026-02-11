package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class EscribeDAO {

    public void insertar(int idAutor, int idLibro) {
        String sql = "INSERT INTO Escribe VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAutor);
            ps.setInt(2, idLibro);
            ps.executeUpdate();
            System.out.println("Relación Escribe insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar en Escribe: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Escribe";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Autor ID: %d <-> Libro ID: %d",
                        rs.getInt("id_autor"),
                        rs.getInt("id_libro")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Escribe: " + e.getMessage());
        }
    }

    public void borrar(int idAutor, int idLibro) {
        String sql = "DELETE FROM Escribe WHERE id_autor=? AND id_libro=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAutor);
            ps.setInt(2, idLibro);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Escribe borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar de Escribe: " + e.getMessage());
        }
    }
}
