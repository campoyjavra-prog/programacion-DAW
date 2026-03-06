package Diapositivas.Actividad1;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Apartado4 {

    public static void main(String[] args) {
        consultarEquiposLocales();
    }

    public static void consultarEquiposLocales() {
        String sql = "SELECT DISTINCT equipo_local FROM partidos WHERE puntos_local > 100 AND puntos_local > puntos_visitante AND temporada = '02/03'";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Equipos locales que ganaron anotando más de 100 puntos en la temporada 02/03:");

            while (rs.next()) {
                String equipoLocal = rs.getString("equipo_local");
                System.out.println("- " + equipoLocal);
            }

        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
    }
}
