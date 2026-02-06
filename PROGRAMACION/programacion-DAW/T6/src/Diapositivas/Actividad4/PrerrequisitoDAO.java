package Diapositivas.Actividad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class PrerrequisitoDAO {

    public void insertar(int idCurso, int idRequisito, boolean esObligatorio) {
        String sql = "INSERT INTO Prerrequisito VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCurso);
            ps.setInt(2, idRequisito);
            ps.setBoolean(3, esObligatorio);
            ps.executeUpdate();
            System.out.println("Prerrequisito insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar prerrequisito: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Prerrequisito";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Curso ID: %d necesita Curso ID: %d | Obligatorio: %b",
                        rs.getInt("id_curso"),
                        rs.getInt("id_requisito"),
                        rs.getBoolean("es_obligatorio")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar prerrequisitos: " + e.getMessage());
        }
    }

    // Al igual que con Matricula, update de PK compuesta es raro, se puede hacer
    // borrando e insertando.
    public void borrar(int idCurso, int idRequisito) {
        String sql = "DELETE FROM Prerrequisito WHERE id_curso=? AND id_requisito=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCurso);
            ps.setInt(2, idRequisito);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Prerrequisito borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar prerrequisito: " + e.getMessage());
        }
    }
}
