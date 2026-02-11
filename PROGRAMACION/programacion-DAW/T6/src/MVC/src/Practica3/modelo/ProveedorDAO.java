package MVC.src.Practica3.modelo;

import java.sql.*;

import MVC.src.EjemploJerarquia.modelo.Conexion;

public class ProveedorDAO {

    public void insertar(int codigo, String direccion, String ciudad, String provincia) {
        String sql = "INSERT INTO proveedor VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.setString(2, direccion);
            ps.setString(3, ciudad);
            ps.setString(4, provincia);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM proveedor";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("codigo") + " - " + rs.getString("ciudad"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar(int codigo, String nuevaDireccion) {
        String sql = "UPDATE proveedor SET direccion=? WHERE codigo=?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevaDireccion);
            ps.setInt(2, codigo);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int codigo) {
        String sql = "DELETE FROM proveedor WHERE codigo=?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codigo);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}