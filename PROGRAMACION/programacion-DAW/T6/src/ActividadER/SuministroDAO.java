package ActividadER;

import java.sql.*;

public class SuministroDAO {

    public void insertar(int codProv, int codPieza, int cantidad, Date fecha) {
        String sql = "INSERT INTO suministra VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codProv);
            ps.setInt(2, codPieza);
            ps.setInt(3, cantidad);
            ps.setDate(4, fecha);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM suministra";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "Proveedor " + rs.getInt("codigo_proveedor") +
                                " - Pieza " + rs.getInt("codigo_pieza") +
                                " Cantidad: " + rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizarCantidad(int codProv, int codPieza, int cantidad) {
        String sql = "UPDATE suministra SET cantidad=? WHERE codigo_proveedor=? AND codigo_pieza=?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

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

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, codProv);
            ps.setInt(2, codPieza);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
