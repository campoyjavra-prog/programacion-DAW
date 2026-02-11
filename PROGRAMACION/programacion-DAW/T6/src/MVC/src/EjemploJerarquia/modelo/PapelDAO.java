package MVC.src.EjemploJerarquia.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PapelDAO {

    public void insertar(Papel papel) {
        // Insertamos fijando el tipo 'Papel' y dejando NULL los campos de Ebook
        // (tamano)
        String sql = "INSERT INTO Libro (id, isbn, titulo, descripcion, anio_publicacion, precio, tipo, fecha_impresion, lugar_impresion) VALUES (?, ?, ?, ?, ?, ?, 'Papel', ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, papel.getId());
            ps.setString(2, papel.getIsbn());
            ps.setString(3, papel.getTitulo());
            ps.setString(4, papel.getDescripcion());
            ps.setInt(5, papel.getAnioPublicacion());
            ps.setDouble(6, papel.getPrecio());
            ps.setDate(7, papel.getFechaImpresion());
            ps.setString(8, papel.getLugarImpresion());

            ps.executeUpdate();
            System.out.println("Libro de Papel insertado correctamente: " + papel.getTitulo());

        } catch (SQLException e) {
            System.err.println("Error al insertar papel: " + e.getMessage());
        }
    }

    public ArrayList<Papel> listar() {
        ArrayList<Papel> lista = new ArrayList<>();
        // Filtramos solo por tipo 'Papel'
        String sql = "SELECT * FROM Libro WHERE tipo = 'Papel'";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Papel p = new Papel(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("anio_publicacion"),
                        rs.getDouble("precio"),
                        rs.getDate("fecha_impresion"),
                        rs.getString("lugar_impresion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar libros de papel: " + e.getMessage());
        }
        return lista;
    }

    public void borrar(int id) {
        // Borramos solo si es de tipo Papel (opcional, pero más seguro)
        String sql = "DELETE FROM Libro WHERE id=? AND tipo='Papel'";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Libro de Papel borrado correctamente.");
            } else {
                System.out.println("No se encontró libro de papel con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error al borrar papel: " + e.getMessage());
        }
    }

    public void actualizar(Papel papel) {
        String sql = "UPDATE Libro SET isbn=?, titulo=?, descripcion=?, anio_publicacion=?, precio=?, fecha_impresion=?, lugar_impresion=? WHERE id=? AND tipo='Papel'";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, papel.getIsbn());
            ps.setString(2, papel.getTitulo());
            ps.setString(3, papel.getDescripcion());
            ps.setInt(4, papel.getAnioPublicacion());
            ps.setDouble(5, papel.getPrecio());
            ps.setDate(6, papel.getFechaImpresion());
            ps.setString(7, papel.getLugarImpresion());
            ps.setInt(8, papel.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Libro de Papel actualizado correctamente.");
            } else {
                System.out.println("No se encontró libro de papel con ID: " + papel.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar papel: " + e.getMessage());
        }
    }
}
