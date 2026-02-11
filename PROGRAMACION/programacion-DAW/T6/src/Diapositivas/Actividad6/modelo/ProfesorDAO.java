package Diapositivas.Actividad6.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    public void insertar(Profesor profesor) {
        String sql = "INSERT INTO Profesor VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, profesor.getId());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getApellido1());
            ps.setString(4, profesor.getApellido2());
            ps.setString(5, profesor.getEspecialidad());
            ps.setString(6, profesor.getTelefono());
            ps.executeUpdate();
            System.out.println("Profesor insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar profesor: " + e.getMessage());
        }
    }

    public List<Profesor> listar() {
        List<Profesor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Profesor";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Profesor p = new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("especialidad"),
                        rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar profesores: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Profesor profesor) {
        String sql = "UPDATE Profesor SET nombre=?, apellido1=?, apellido2=?, especialidad=?, telefono=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido1());
            ps.setString(3, profesor.getApellido2());
            ps.setString(4, profesor.getEspecialidad());
            ps.setString(5, profesor.getTelefono());
            ps.setInt(6, profesor.getId());
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Profesor actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar profesor: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Profesor WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Profesor borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar profesor: " + e.getMessage());
        }
    }
}
