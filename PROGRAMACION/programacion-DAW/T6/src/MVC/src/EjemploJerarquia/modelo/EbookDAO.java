package MVC.src.EjemploJerarquia.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EbookDAO {

    public void insertar(Ebook ebook) {
        // Insertamos fijando el tipo 'Ebook' y dejando NULL los campos de Papel
        // (fecha_impresion, lugar_impresion)
        String sql = "INSERT INTO Libro (id, isbn, titulo, descripcion, anio_publicacion, precio, tipo, tamano) VALUES (?, ?, ?, ?, ?, ?, 'Ebook', ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ebook.getId());
            ps.setString(2, ebook.getIsbn());
            ps.setString(3, ebook.getTitulo());
            ps.setString(4, ebook.getDescripcion());
            ps.setInt(5, ebook.getAnioPublicacion());
            ps.setDouble(6, ebook.getPrecio());
            ps.setString(7, ebook.getTamanio());

            ps.executeUpdate();
            System.out.println("Ebook insertado correctamente: " + ebook.getTitulo());

        } catch (SQLException e) {
            System.err.println("Error al insertar ebook: " + e.getMessage());
        }
    }

    public ArrayList<Ebook> listar() {
        ArrayList<Ebook> lista = new ArrayList<>();
        // Filtramos solo por tipo 'Ebook'
        String sql = "SELECT * FROM Libro WHERE tipo = 'Ebook'";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ebook e = new Ebook(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("anio_publicacion"),
                        rs.getDouble("precio"),
                        rs.getString("tamano"));
                lista.add(e);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar ebooks: " + e.getMessage());
        }
        return lista;
    }

    public void borrar(int id) {
        // Borramos solo si es de tipo Ebook
        String sql = "DELETE FROM Libro WHERE id=? AND tipo='Ebook'";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Ebook borrado correctamente.");
            } else {
                System.out.println("No se encontró ebook con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error al borrar ebook: " + e.getMessage());
        }
    }

    public void actualizar(Ebook ebook) {
        String sql = "UPDATE Libro SET isbn=?, titulo=?, descripcion=?, anio_publicacion=?, precio=?, tamano=? WHERE id=? AND tipo='Ebook'";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ebook.getIsbn());
            ps.setString(2, ebook.getTitulo());
            ps.setString(3, ebook.getDescripcion());
            ps.setInt(4, ebook.getAnioPublicacion());
            ps.setDouble(5, ebook.getPrecio());
            ps.setString(6, ebook.getTamanio());
            ps.setInt(7, ebook.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Ebook actualizado correctamente.");
            } else {
                System.out.println("No se encontró ebook con ID: " + ebook.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar ebook: " + e.getMessage());
        }
    }
}
