package Diapositivas.Actividad6;

import common.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemplarDAO {

    public void insertar(Date fecha, int numeroPaginas, int numeroEjemplares, int numRegistroRevista) {
        String sql = "INSERT INTO Ejemplar (fecha, numero_paginas, numero_ejemplares, num_registro_revista) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, fecha);
            ps.setInt(2, numeroPaginas);
            ps.setInt(3, numeroEjemplares);
            ps.setInt(4, numRegistroRevista);
            ps.executeUpdate();
            System.out.println("Ejemplar insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar ejemplar: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Ejemplar";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(String.format("Fecha: %s | Nº Páginas: %d | Nº Ejemplares: %d | Revista (Reg.): %d",
                        rs.getDate("fecha"),
                        rs.getInt("numero_paginas"),
                        rs.getInt("numero_ejemplares"),
                        rs.getInt("num_registro_revista")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar ejemplares: " + e.getMessage());
        }
    }

    public void borrar(Date fecha, int numRegistroRevista) {
        String sql = "DELETE FROM Ejemplar WHERE fecha=? AND num_registro_revista=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, fecha);
            ps.setInt(2, numRegistroRevista);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Ejemplar borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar ejemplar: " + e.getMessage());
        }
    }
}
