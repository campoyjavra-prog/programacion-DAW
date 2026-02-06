package Diapositivas.Actividad2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class HaceDAO {
    public void insertar(int nota) {
        String sql = "INSERT INTO Hace VALUES (?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nota);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Hace";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("nota"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar(int nota) {
        String sql = "UPDATE Hace SET nota=? WHERE nota=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nota);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int nota) {
        String sql = "DELETE FROM Hace WHERE nota=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nota);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
