package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PiezaDAO {
    public void insertar(int codigo, String nombre, String color, double precio, int codCategoria) {
        String sql = "INSERT INTO pieza VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, color);
            ps.setDouble(4, precio);
            ps.setInt(5, codCategoria);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Pieza> listar() {

        List<Pieza> lista = new ArrayList<>();
        String sql = "SELECT * FROM pieza";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Pieza(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("color"),
                        rs.getDouble("precio"),
                        rs.getInt("codigo_categoria")));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return lista;
    }

    public void actualizarPrecio(int codigo, double precio) {
        String sql = "UPDATE pieza SET precio=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, precio);
            ps.setInt(2, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int codigo) {
        String sql = "DELETE FROM pieza WHERE codigo=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}