package Diapositivas.Actividad3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class AlumnoDAO {

    public void insertar(String numeroMatricula, String nombre, String apellido1, String apellido2,
            Date fechaNacimiento, String telefono) {
        String sql = "INSERT INTO Alumno VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, numeroMatricula);
            ps.setString(2, nombre);
            ps.setString(3, apellido1);
            ps.setString(4, apellido2);
            ps.setDate(5, fechaNacimiento);
            ps.setString(6, telefono);
            ps.executeUpdate();
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar alumno: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Alumno";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Matricula: %s | Nombre: %s %s %s | Nacimiento: %s | Tlf: %s",
                        rs.getString("numero_matricula"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar alumnos: " + e.getMessage());
        }
    }

    public void actualizar(String numeroMatricula, String nombre, String apellido1, String apellido2,
            Date fechaNacimiento, String telefono) {
        String sql = "UPDATE Alumno SET nombre=?, apellido1=?, apellido2=?, fecha_nacimiento=?, telefono=? WHERE numero_matricula=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setDate(4, fechaNacimiento);
            ps.setString(5, telefono);
            ps.setString(6, numeroMatricula);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Alumno actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar alumno: " + e.getMessage());
        }
    }

    public void borrar(String numeroMatricula) {
        String sql = "DELETE FROM Alumno WHERE numero_matricula=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, numeroMatricula);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Alumno borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar alumno: " + e.getMessage());
        }
    }
}
