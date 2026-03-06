package Diapositivas.Actividad1;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Apartado5 {

    public static void main(String[] args) {
        consultarMaximosAnotadoresPorTemporada();
    }

    public static void consultarMaximosAnotadoresPorTemporada() {
        String sql = "SELECT jugadores.Nombre, estadisticas.temporada, estadisticas.Puntos_por_partido " +
                "FROM jugadores, estadisticas " +
                "WHERE estadisticas.jugador = jugadores.codigo AND " +
                "(temporada, Puntos_por_partido) IN (" +
                "SELECT temporada, MAX(Puntos_por_partido) " +
                "FROM estadisticas GROUP BY temporada" +
                ") " +
                "ORDER BY estadisticas.temporada";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Máximos anotadores por temporada:");
            System.out.printf("%-30s | %-12s | %-20s\n", "Nombre", "Temporada", "Puntos por partido");
            System.out.println("-------------------------------+--------------+---------------------");

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String temporada = rs.getString("temporada");
                double puntos = rs.getDouble("Puntos_por_partido");

                System.out.printf("%-30s | %-12s | %-20.2f\n", nombre, temporada, puntos);
            }

        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
    }
}
