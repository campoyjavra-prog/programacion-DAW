package Diapositivas.Actividad1;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Apartado1 {

    public static void main(String[] args) {
        listarJugadores();
    }

    public static void listarJugadores() {
        String sql = "SELECT Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo FROM jugadores WHERE Procedencia = 'Spain' AND Nombre_equipo = 'Lakers'";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Jugadores españoles de los Lakers:");
            System.out.println("----------------------------------");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Procedencia: " + rs.getString("Procedencia"));
                System.out.println("Altura: " + rs.getString("Altura"));
                System.out.println("Peso: " + rs.getInt("Peso"));
                System.out.println("Posición: " + rs.getString("Posicion"));
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
    }
}
