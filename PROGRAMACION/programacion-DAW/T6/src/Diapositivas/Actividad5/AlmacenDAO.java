package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class AlmacenDAO {

    public void insertar(int id, String direccion, String telefono, int idLocalidad) {
        String sql = "INSERT INTO Almacen VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setInt(4, idLocalidad);
            ps.executeUpdate();
            System.out.println("Almacén insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar almacén: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Almacen";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Dirección: %s | Localidad: %d",
                        rs.getInt("id"),
                        rs.getString("direccion"),
                        rs.getInt("id_localidad")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar almacenes: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Almacen WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Almacén borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar almacén: " + e.getMessage());
        }
    }
}
