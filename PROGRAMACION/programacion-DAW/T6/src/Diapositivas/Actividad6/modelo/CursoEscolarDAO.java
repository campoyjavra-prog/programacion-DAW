package Diapositivas.Actividad6.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoEscolarDAO {

    public void insertar(CursoEscolar curso) {
        String sql = "INSERT INTO Curso_Escolar VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, curso.getId());
            ps.setInt(2, curso.getAnioInicio());
            ps.setInt(3, curso.getAnioFin());
            ps.executeUpdate();
            System.out.println("Curso escolar insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar curso escolar: " + e.getMessage());
        }
    }

    public List<CursoEscolar> listar() {
        List<CursoEscolar> lista = new ArrayList<>();
        String sql = "SELECT * FROM Curso_Escolar";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CursoEscolar c = new CursoEscolar(
                        rs.getInt("id"),
                        rs.getInt("anio_inicio"),
                        rs.getInt("anio_fin"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar cursos escolares: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(CursoEscolar curso) {
        String sql = "UPDATE Curso_Escolar SET anio_inicio=?, anio_fin=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, curso.getAnioInicio());
            ps.setInt(2, curso.getAnioFin());
            ps.setInt(3, curso.getId());
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
