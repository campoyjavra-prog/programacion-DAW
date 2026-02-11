package MVC.src.Practica1.modelo;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    public ArrayList<Persona> listarPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        String sql = "SELECT id, nombre, email FROM persona";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                personas.add(
                        new Persona(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println("Error DAO: " + e.getMessage());
        }
        return personas;
    }
}
