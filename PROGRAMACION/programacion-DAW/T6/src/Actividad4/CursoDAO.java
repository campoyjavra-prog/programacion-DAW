package Actividad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class CursoDAO {

    public void insertar(int id, String nombre, String descripcion, int duracion, double coste) {
        String sql = "INSERT INTO Curso VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setInt(4, duracion);
            ps.setDouble(5, coste);
            ps.executeUpdate();
            System.out.println("Curso insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar curso: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Curso";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Nombre: %s | Desc: %s | Duración: %d h | Coste: %.2f",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("duracion"),
                        rs.getDouble("coste")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar cursos: " + e.getMessage());
        }
    }

    public void actualizar(int id, String nombre, String descripcion, int duracion, double coste) {
        String sql = "UPDATE Curso SET nombre=?, descripcion=?, duracion=?, coste=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setInt(3, duracion);
            ps.setDouble(4, coste);
            ps.setInt(5, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Curso actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar curso: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Curso WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Curso borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar curso: " + e.getMessage());
        }
    }
}
