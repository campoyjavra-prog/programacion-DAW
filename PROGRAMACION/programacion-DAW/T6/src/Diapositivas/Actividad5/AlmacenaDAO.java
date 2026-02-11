package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class AlmacenaDAO {

    public void insertar(int idLibro, int idAlmacen, int stock) {
        String sql = "INSERT INTO Almacena VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ps.setInt(2, idAlmacen);
            ps.setInt(3, stock);
            ps.executeUpdate();
            System.out.println("Relación Almacena insertada correctamente (Stock: " + stock + ").");
        } catch (SQLException e) {
            System.err.println("Error al insertar en Almacena: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Almacena";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Libro ID: %d | Almacén ID: %d | Stock: %d",
                        rs.getInt("id_libro"),
                        rs.getInt("id_almacen"),
                        rs.getInt("stock")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Almacena: " + e.getMessage());
        }
    }

    public void borrar(int idLibro, int idAlmacen) {
        String sql = "DELETE FROM Almacena WHERE id_libro=? AND id_almacen=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ps.setInt(2, idAlmacen);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Almacena borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar de Almacena: " + e.getMessage());
        }
    }
}
