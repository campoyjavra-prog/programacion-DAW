package Diapositivas.Actividad3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class AsignaturaDAO {

    public void insertar(String codigo, String nombre, int numeroHoras, int idProfesor) {
        String sql = "INSERT INTO Asignatura VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, numeroHoras);
            ps.setInt(4, idProfesor);
            ps.executeUpdate();
            System.out.println("Asignatura insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar asignatura: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Asignatura";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Cod: %s | Nombre: %s | Horas: %d | ID Profesor: %d",
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("numero_horas"),
                        rs.getInt("id_profesor")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar asignaturas: " + e.getMessage());
        }
    }

    public void actualizar(String codigo, String nombre, int numeroHoras, int idProfesor) {
        String sql = "UPDATE Asignatura SET nombre=?, numero_horas=?, id_profesor=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, numeroHoras);
            ps.setInt(3, idProfesor);
            ps.setString(4, codigo);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Asignatura actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar asignatura: " + e.getMessage());
        }
    }

    public void borrar(String codigo) {
        String sql = "DELETE FROM Asignatura WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Asignatura borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar asignatura: " + e.getMessage());
        }
    }
}
