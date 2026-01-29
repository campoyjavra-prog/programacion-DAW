package Diapositivas.Actividad1;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Apartado3 {
    public static void main(String[] args) {
        String nombre = "Pepe Gonzalez";
        String procedencia = "Peru";
        String altura = "6-5";
        int peso = 220;
        String posicion = "F";
        String nombreEquipo = "Lakers";

        insertarJugador(nombre, procedencia, altura, peso, posicion, nombreEquipo);
        eliminarJugador(nombre);
    }

    public static void insertarJugador(String nombre, String procedencia, String altura, int peso, String posicion,
            String nombreEquipo) {
        String sql = "INSERT INTO jugadores (Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, procedencia);
            ps.setString(3, altura);
            ps.setInt(4, peso);
            ps.setString(5, posicion);
            ps.setString(6, nombreEquipo);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Jugador " + nombre + " insertado correctamente.");
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    public static void eliminarJugador(String nombre) {
        String sql = "DELETE FROM jugadores WHERE Nombre = ?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Jugador " + nombre + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró al jugador " + nombre + " para eliminar.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
