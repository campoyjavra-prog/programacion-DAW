package Actividad4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class EdicionDAO {

    public void insertar(int id, Date fechaInicio, Date fechaFin, String horario, String lugar, int idCurso,
            int idCapacitado) {
        String sql = "INSERT INTO Edicion VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setDate(2, fechaInicio);
            ps.setDate(3, fechaFin);
            ps.setString(4, horario);
            ps.setString(5, lugar);
            ps.setInt(6, idCurso);
            ps.setInt(7, idCapacitado);
            ps.executeUpdate();
            System.out.println("Edición insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar edición: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Edicion";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format(
                        "ID: %d | Fechas: %s - %s | Horario: %s | Lugar: %s | Curso: %d | Capacitador: %d",
                        rs.getInt("id"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getString("horario"),
                        rs.getString("lugar"),
                        rs.getInt("id_curso"),
                        rs.getInt("id_capacitado")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar ediciones: " + e.getMessage());
        }
    }

    public void actualizar(int id, Date fechaInicio, Date fechaFin, String horario, String lugar, int idCurso,
            int idCapacitado) {
        String sql = "UPDATE Edicion SET fecha_inicio=?, fecha_fin=?, horario=?, lugar=?, id_curso=?, id_capacitado=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, fechaInicio);
            ps.setDate(2, fechaFin);
            ps.setString(3, horario);
            ps.setString(4, lugar);
            ps.setInt(5, idCurso);
            ps.setInt(6, idCapacitado);
            ps.setInt(7, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Edición actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar edición: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Edicion WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Edición borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar edición: " + e.getMessage());
        }
    }
}
