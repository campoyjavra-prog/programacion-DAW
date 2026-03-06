package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PublicaSucursalRevistaDAO {

    public void insertar(int codigoSucursal, int numRegistroRevista) {
        String sql = "INSERT INTO Sucursal_Publica_Revista (codigo_sucursal, num_registro_revista) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigoSucursal);
            ps.setInt(2, numRegistroRevista);
            ps.executeUpdate();
            System.out.println("Relación Sucursal-Revista insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar relación Sucursal-Revista: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Sucursal_Publica_Revista";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Cod Sucursal: %d | Num Reg Revista: %d",
                        rs.getInt("codigo_sucursal"),
                        rs.getInt("num_registro_revista")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar relación Sucursal-Revista: " + e.getMessage());
        }
    }

    public void borrar(int codigoSucursal, int numRegistroRevista) {
        String sql = "DELETE FROM Sucursal_Publica_Revista WHERE codigo_sucursal=? AND num_registro_revista=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigoSucursal);
            ps.setInt(2, numRegistroRevista);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Sucursal-Revista borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar relación Sucursal-Revista: " + e.getMessage());
        }
    }
}
