package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class CestaDAO {
    public void insertar(int id, Date fechaCompra, int idCliente) {
        String sql = "INSERT INTO Cesta VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setDate(2, fechaCompra);
            ps.setInt(3, idCliente);
            ps.executeUpdate();
            System.out.println("Cesta insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar cesta: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Cesta";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Fecha: %s | Cliente ID: %d",
                        rs.getInt("id"),
                        rs.getDate("fecha_compra"),
                        rs.getInt("id_cliente")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar cestas: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Cesta WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Cesta borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar cesta: " + e.getMessage());
        }
    }
}
