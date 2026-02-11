package Diapositivas.Actividad6.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    public void insertar(Matricula matricula) {
        String sql = "INSERT INTO Matricula VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula.getRefAlumno());
            ps.setInt(2, matricula.getIdCurso());
            ps.setString(3, matricula.getCodAsignatura());
            ps.executeUpdate();
            System.out.println("Matrícula insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar matrícula: " + e.getMessage());
        }
    }

    public List<Matricula> listar() {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Matricula";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Matricula m = new Matricula(
                        rs.getString("ref_alumno"),
                        rs.getInt("id_curso"),
                        rs.getString("cod_asignatura"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar matrículas: " + e.getMessage());
        }
        return lista;
    }

    // Actualizar requiere pk antigua y nueva porque todos los campos son PK
    public void actualizar(Matricula oldMatricula, Matricula newMatricula) {
        String sql = "UPDATE Matricula SET ref_alumno=?, id_curso=?, cod_asignatura=? WHERE ref_alumno=? AND id_curso=? AND cod_asignatura=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newMatricula.getRefAlumno());
            ps.setInt(2, newMatricula.getIdCurso());
            ps.setString(3, newMatricula.getCodAsignatura());

            ps.setString(4, oldMatricula.getRefAlumno());
            ps.setInt(5, oldMatricula.getIdCurso());
            ps.setString(6, oldMatricula.getCodAsignatura());

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Matrícula actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar matrícula: " + e.getMessage());
        }
    }

    public void borrar(Matricula matricula) {
        String sql = "DELETE FROM Matricula WHERE ref_alumno=? AND id_curso=? AND cod_asignatura=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula.getRefAlumno());
            ps.setInt(2, matricula.getIdCurso());
            ps.setString(3, matricula.getCodAsignatura());
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Matrícula borrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar matrícula: " + e.getMessage());
        }
    }
}
