package Diapositivas.Actividad3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class MatriculaDAO {

    public void insertar(String refAlumno, int idCurso, String codAsignatura) {
        String sql = "INSERT INTO Matricula VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, refAlumno);
            ps.setInt(2, idCurso);
            ps.setString(3, codAsignatura);
            ps.executeUpdate();
            System.out.println("Matricula insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar matricula: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Matricula";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Alumno: %s | Curso ID: %d | Asignatura: %s",
                        rs.getString("ref_alumno"),
                        rs.getInt("id_curso"),
                        rs.getString("cod_asignatura")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar matriculas: " + e.getMessage());
        }
    }

    public void actualizar(String oldRefAlumno, int oldIdCurso, String oldCodAsignatura,
            String newRefAlumno, int newIdCurso, String newCodAsignatura) {
        String sql = "UPDATE Matricula SET ref_alumno=?, id_curso=?, cod_asignatura=? " +
                "WHERE ref_alumno=? AND id_curso=? AND cod_asignatura=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newRefAlumno);
            ps.setInt(2, newIdCurso);
            ps.setString(3, newCodAsignatura);

            ps.setString(4, oldRefAlumno);
            ps.setInt(5, oldIdCurso);
            ps.setString(6, oldCodAsignatura);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Matricula actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar matricula: " + e.getMessage());
        }
    }

    public void borrar(String refAlumno, int idCurso, String codAsignatura) {
        String sql = "DELETE FROM Matricula WHERE ref_alumno=? AND id_curso=? AND cod_asignatura=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, refAlumno);
            ps.setInt(2, idCurso);
            ps.setString(3, codAsignatura);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Matricula borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar matricula: " + e.getMessage());
        }
    }
}
