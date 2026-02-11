package MVC.src.Practica2.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAO {
    // READ (lista de Persona)
    public ArrayList<Persona> listar() {
        ArrayList<Persona> personas = new ArrayList<>();
        String sql = "SELECT id, nombre, email FROM persona";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                personas.add(new Persona(rs.getInt("id"),
                        rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    // CREATE
    public void insertar(Persona p) {
        String sql = "INSERT INTO persona (nombre, email) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void actualizar(Persona p) {
        String sql = "UPDATE persona SET nombre=?, email=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getEmail());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void eliminar(int id) {
        String sql = "DELETE FROM persona WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
