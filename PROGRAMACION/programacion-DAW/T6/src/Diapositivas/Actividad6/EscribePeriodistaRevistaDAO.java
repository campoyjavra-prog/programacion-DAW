package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EscribePeriodistaRevistaDAO {

    public void insertar(int idPeriodista, int numRegistroRevista) {
        String sql = "INSERT INTO Periodista_Escribe_Revista (id_periodista, num_registro_revista) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPeriodista);
            ps.setInt(2, numRegistroRevista);
            ps.executeUpdate();
            System.out.println("Relación Periodista-Revista insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar relación Periodista-Revista: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Periodista_Escribe_Revista";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID Periodista: %d | Num Reg Revista: %d",
                        rs.getInt("id_periodista"),
                        rs.getInt("num_registro_revista")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar relación Periodista-Revista: " + e.getMessage());
        }
    }

    public void borrar(int idPeriodista, int numRegistroRevista) {
        String sql = "DELETE FROM Periodista_Escribe_Revista WHERE id_periodista=? AND num_registro_revista=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPeriodista);
            ps.setInt(2, numRegistroRevista);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Relación Periodista-Revista borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar relación Periodista-Revista: " + e.getMessage());
        }
    }
}
