import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBD {
    public static void main(String[] args) {
        // crearPersona("Rafael Campoy Javier", "campoyjavra@gmail.com");
        // crearPersona("Alunmno1", "campoyjavra@gmail.com");
        // crearPersona("Alunmno2", "campoyjavra@gmail.com");
        // crearPersona("Alunmno3", "campoyjavra@gmail.com");

        // Leer el contenido de la tabla personas
        // listarPersonas();
        // listarPersonaByID(2);

        // Actualizar el contenido de personas
        // actualizarPersona(3, "alumno1@gmail.com");
        // listarPersonas();

        // Borrar registros en personas
        eliminarPersona("campoyjavra@gmail.com");
    }

    public static void crearPersona(String nombre, String email) {
        String sql = "INSERT INTO persona (nombre, email) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, email);

            ps.executeUpdate();
            System.out.println("Persona creada.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public static void listarPersonas() {
        String sql = "SELECT id, nombre, email FROM persona";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + ": " +
                                rs.getString("nombre") + " - " +
                                rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }

    public static void actualizarPersona(int id, String nuevoEmail) {
        String sql = "UPDATE persona SET email = ? WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEmail);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Persona actualizada.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    public static void eliminarPersona(String correo) {
        String sql = "DELETE FROM persona WHERE email = ?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.executeUpdate();
            System.out.println("Persona eliminada.");

        } catch (SQLException e) {
            System.err.println("Error al borrar: " + e.getMessage());
        }
    }
}
