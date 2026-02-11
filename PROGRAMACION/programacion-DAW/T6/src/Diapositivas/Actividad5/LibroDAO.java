package Diapositivas.Actividad5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ActividadER.Conexion;

public class LibroDAO {

    public void insertar(int id, String isbn, String titulo, String descripcion, int anio, String tipo, double precio,
            Date fechaImpresion, String lugarImpresion, String tamanio) {
        String sql = "INSERT INTO Libro VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, isbn);
            ps.setString(3, titulo);
            ps.setString(4, descripcion);
            ps.setInt(5, anio);
            ps.setString(6, tipo);
            ps.setDouble(7, precio);
            ps.setDate(8, fechaImpresion);
            ps.setString(9, lugarImpresion);
            ps.setString(10, tamanio);
            ps.executeUpdate();
            System.out.println("Libro insertado correctamente: " + titulo);
        } catch (SQLException e) {
            System.err.println("Error al insertar libro: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Libro";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                String extra = "";
                if ("Papel".equalsIgnoreCase(tipo)) {
                    extra = String.format("Impreso: %s en %s", rs.getDate("fecha_impresion"),
                            rs.getString("lugar_impresion"));
                } else {
                    extra = "Tamaño: " + rs.getString("tamanio");
                }

                System.out.println(String.format("ID: %d | [%s] %s | %s | %.2f€ | %s",
                        rs.getInt("id"),
                        tipo,
                        rs.getString("titulo"),
                        rs.getString("isbn"),
                        rs.getDouble("precio"),
                        extra));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar libros: " + e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Libro WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Libro borrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al borrar libro: " + e.getMessage());
        }
    }
}
