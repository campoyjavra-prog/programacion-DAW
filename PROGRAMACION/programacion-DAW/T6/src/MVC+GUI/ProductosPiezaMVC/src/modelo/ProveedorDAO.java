package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    public void insertar(int codigo, String direccion, String ciudad, String provincia) {
        String sql = "INSERT INTO proveedor VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, direccion);
            ps.setString(3, ciudad);
            ps.setString(4, provincia);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Proveedor> listar() {

        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Proveedor(
                        rs.getInt("codigo"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("provincia")));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return lista;
    }

    public void actualizar(int codigo, String nuevaDireccion) {
        String sql = "UPDATE proveedor SET direccion=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevaDireccion);
            ps.setInt(2, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int codigo) {
        String sql = "DELETE FROM proveedor WHERE codigo=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}