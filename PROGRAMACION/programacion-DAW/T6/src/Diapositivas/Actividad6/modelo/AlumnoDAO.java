package Diapositivas.Actividad6.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    public void insertar(Alumno alumno) {
        String sql = "INSERT INTO Alumno VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alumno.getNumeroMatricula());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido1());
            ps.setString(4, alumno.getApellido2());
            ps.setDate(5, alumno.getFechaNacimiento());
            ps.setString(6, alumno.getTelefono());
            ps.executeUpdate();
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar alumno: " + e.getMessage());
        }
    }

    public List<Alumno> listar() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM Alumno";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Alumno a = new Alumno(
                        rs.getString("numero_matricula"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("telefono"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar alumnos: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Alumno alumno) {
        String sql = "UPDATE Alumno SET nombre=?, apellido1=?, apellido2=?, fecha_nacimiento=?, telefono=? WHERE numero_matricula=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido1());
            ps.setString(3, alumno.getApellido2());
            ps.setDate(4, alumno.getFechaNacimiento());
            ps.setString(5, alumno.getTelefono());
            ps.setString(6, alumno.getNumeroMatricula());
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
