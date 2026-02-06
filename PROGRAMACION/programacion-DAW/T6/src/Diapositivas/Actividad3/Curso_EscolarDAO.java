package Diapositivas.Actividad3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class Curso_EscolarDAO {

    public void insertar(int id, int anioInicio, int anioFin) {
        String sql = "INSERT INTO Curso_Escolar VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, anioInicio);
            ps.setInt(3, anioFin);
            ps.executeUpdate();
            System.out.println("Curso escolar insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar curso escolar: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Curso_Escolar";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Año: %d - %d",
                        rs.getInt("id"),
                        rs.getInt("anio_inicio"),
                        rs.getInt("anio_fin")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar cursos escolares: " + e.getMessage());
        }
    }

    public void actualizar(int id, int anioInicio, int anioFin) {
        String sql = "UPDATE Curso_Escolar SET anio_inicio=?, anio_fin=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, anioInicio);
            ps.setInt(2, anioFin);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Curso escolar actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar curso escolar: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Curso_Escolar WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Curso escolar borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar curso escolar: " + e.getMessage());
        }
    }
}
