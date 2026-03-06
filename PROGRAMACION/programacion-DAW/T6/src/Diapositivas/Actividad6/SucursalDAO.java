package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SucursalDAO {

    public void insertar(int codigo, String direccion, String telefono, String ciudad, String provincia) {
        String sql = "INSERT INTO Sucursal (codigo, direccion, telefono, ciudad, provincia) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, ciudad);
            ps.setString(5, provincia);
            ps.executeUpdate();
            System.out.println("Sucursal insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar sucursal: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Sucursal";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out
                        .println(String.format("Código: %d | Dirección: %s | Ciudad: %s | Provincia: %s | Teléfono: %s",
                                rs.getInt("codigo"),
                                rs.getString("direccion"),
                                rs.getString("ciudad"),
                                rs.getString("provincia"),
                                rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar sucursales: " + e.getMessage());
        }
    }

    public void borrar(int codigo) {
        String sql = "DELETE FROM Sucursal WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Sucursal borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar sucursal: " + e.getMessage());
        }
    }
}
