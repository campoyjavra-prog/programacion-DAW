package Diapositivas.Actividad1;

import common.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Apartado2 {
    public static void main(String[] args) {
        actualizarJugador(666, "Spain");
    }

    public static void actualizarJugador(int codigo, String nuevaProcedencia) {
        String sql = "UPDATE jugadores SET Procedencia = ? WHERE codigo = ?";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevaProcedencia);
            ps.setInt(2, codigo);

            ps.executeUpdate();
            System.out.println("Procedencia actualizada.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }
}
