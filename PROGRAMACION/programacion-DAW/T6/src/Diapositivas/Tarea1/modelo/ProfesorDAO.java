package Diapositivas.Tarea1.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ActividadER.Conexion;

public class ProfesorDAO {
    public void insertar(Profesor p) {
        String sql = "INSERT INTO Profesor VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getNif());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido1());
            ps.setString(5, p.getApellido2());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
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
                        rs.getInt("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public void actualizar(Profesor p) {
        String sql = "UPDATE Profesor SET nombre=?, apellido1=?, apellido2=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido1());
            ps.setString(3, p.getApellido2());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Profesor WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
