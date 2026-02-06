package Actividad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class RecibeDAO {

    public void insertar(int idEmpleado, int idEdicion) {
        String sql = "INSERT INTO Recibe VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idEdicion);
            ps.executeUpdate();
            System.out.println("Relación Recibe insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar relación Recibe: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Recibe";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Empleado ID: %d <-> Edición ID: %d",
                        rs.getInt("id_empleado"),
                        rs.getInt("id_edicion")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar relaciones Recibe: " + e.getMessage());
        }
    }

    public void borrar(int idEmpleado, int idEdicion) {
        String sql = "DELETE FROM Recibe WHERE id_empleado=? AND id_edicion=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idEdicion);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Recibe borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar relación Recibe: " + e.getMessage());
        }
    }
}
