package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuministroDAO {
    public void insertar(int codProv, int codPieza, int cantidad, Date fecha) {
        String sql = "INSERT INTO suministra VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codProv);
            ps.setInt(2, codPieza);
            ps.setInt(3, cantidad);
            ps.setDate(4, fecha);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Suministro> listar() {

        List<Suministro> lista = new ArrayList<>();
        String sql = "SELECT * FROM suministra";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Suministro(
                        rs.getInt("codigo_proveedor"),
                        rs.getInt("codigo_pieza"),
                        rs.getInt("cantidad"),
                        rs.getDate("fecha")));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return lista;
    }

    public void actualizarCantidad(int codProv, int codPieza, int cantidad) {
        String sql = "UPDATE suministra SET cantidad=? WHERE codigo_proveedor=? AND codigo_pieza=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cantidad);
            ps.setInt(2, codProv);
            ps.setInt(3, codPieza);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int codProv, int codPieza) {
        String sql = "DELETE FROM suministra WHERE codigo_proveedor=? AND codigo_pieza=?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codProv);
            ps.setInt(2, codPieza);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}