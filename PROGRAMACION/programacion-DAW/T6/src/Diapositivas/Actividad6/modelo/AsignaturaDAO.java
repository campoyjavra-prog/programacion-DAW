package Diapositivas.Actividad6.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {

    public void insertar(Asignatura asignatura) {
        String sql = "INSERT INTO Asignatura VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, asignatura.getCodigo());
            ps.setString(2, asignatura.getNombre());
            ps.setInt(3, asignatura.getNumeroHoras());
            ps.setInt(4, asignatura.getIdProfesor());
            ps.executeUpdate();
            System.out.println("Asignatura insertada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar asignatura: " + e.getMessage());
        }
    }

    public List<Asignatura> listar() {
        List<Asignatura> lista = new ArrayList<>();
        String sql = "SELECT * FROM Asignatura";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Asignatura a = new Asignatura(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("numero_horas"),
                        rs.getInt("id_profesor"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar asignaturas: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Asignatura asignatura) {
        String sql = "UPDATE Asignatura SET nombre=?, numero_horas=?, id_profesor=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, asignatura.getNombre());
            ps.setInt(2, asignatura.getNumeroHoras());
            ps.setInt(3, asignatura.getIdProfesor());
            ps.setString(4, asignatura.getCodigo());
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
