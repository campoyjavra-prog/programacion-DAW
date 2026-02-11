package MVC.src.EjemploJerarquia.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO {

    public void insertar(Libro libro) {
        String sql = "INSERT INTO Libro (id, isbn, titulo, descripcion, anio_publicacion, precio, tipo, fecha_impresion, lugar_impresion, tamano) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, libro.getId());
            ps.setString(2, libro.getIsbn());
            ps.setString(3, libro.getTitulo());
            ps.setString(4, libro.getDescripcion());
            ps.setInt(5, libro.getAnioPublicacion());
            ps.setDouble(6, libro.getPrecio());

            if (libro instanceof Papel) {
                Papel papel = (Papel) libro;
                ps.setString(7, "Papel");
                ps.setDate(8, papel.getFechaImpresion());
                ps.setString(9, papel.getLugarImpresion());
                ps.setString(10, null); // tamano3
            } else if (libro instanceof Ebook) {
                Ebook ebook = (Ebook) libro;
                ps.setString(7, "Ebook");
                ps.setDate(8, null); // fecha_impresion
                ps.setString(9, null); // lugar_impresion
                ps.setString(10, ebook.getTamanio());
            }

            ps.executeUpdate();
            System.out.println("Libro insertado correctamente: " + libro.getTitulo());

        } catch (SQLException e) {
            System.err.println("Error al insertar libro: " + e.getMessage());
        }
    }

    public ArrayList<Libro> listar() {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Libro libro = null;

                if ("Papel".equalsIgnoreCase(tipo)) {
                    libro = new Papel(
                            rs.getInt("id"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getInt("anio_publicacion"),
                            rs.getDouble("precio"),
                            rs.getDate("fecha_impresion"),
                            rs.getString("lugar_impresion"));
                } else if ("Ebook".equalsIgnoreCase(tipo)) {
                    libro = new Ebook(
                            rs.getInt("id"),
                            rs.getString("isbn"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getInt("anio_publicacion"),
                            rs.getDouble("precio"),
                            rs.getString("tamano"));
                }

                if (libro != null) {
                    libros.add(libro);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar libros: " + e.getMessage());
        }
        return libros;
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

    // Método para buscar por ID (útil para verificar existencia antes de insertar o
    // borrar)
    public Libro buscarPorId(int id) {
        String sql = "SELECT * FROM Libro WHERE id=?";
        Libro libro = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("tipo");
                    if ("Papel".equalsIgnoreCase(tipo)) {
                        libro = new Papel(
                                rs.getInt("id"), rs.getString("isbn"), rs.getString("titulo"),
                                rs.getString("descripcion"),
                                rs.getInt("anio_publicacion"), rs.getDouble("precio"),
                                rs.getDate("fecha_impresion"), rs.getString("lugar_impresion"));
                    } else if ("Ebook".equalsIgnoreCase(tipo)) {
                        libro = new Ebook(
                                rs.getInt("id"), rs.getString("isbn"), rs.getString("titulo"),
                                rs.getString("descripcion"),
                                rs.getInt("anio_publicacion"), rs.getDouble("precio"), rs.getString("tamano"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar libro: " + e.getMessage());
        }
        return libro;
    }

    public void actualizar(Libro libro) {
        String sql = "UPDATE Libro SET isbn=?, titulo=?, descripcion=?, anio_publicacion=?, precio=?, fecha_impresion=?, lugar_impresion=?, tamano=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getDescripcion());
            ps.setInt(4, libro.getAnioPublicacion());
            ps.setDouble(5, libro.getPrecio());

            if (libro instanceof Papel) {
                Papel papel = (Papel) libro;
                ps.setDate(6, papel.getFechaImpresion());
                ps.setString(7, papel.getLugarImpresion());
                ps.setString(8, null);
            } else if (libro instanceof Ebook) {
                Ebook ebook = (Ebook) libro;
                ps.setDate(6, null);
                ps.setString(7, null);
                ps.setString(8, ebook.getTamanio());
            }

            ps.setInt(9, libro.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Libro actualizado correctamente: " + libro.getTitulo());
            } else {
                System.out.println("No se encontró el libro con ID: " + libro.getId());
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar libro: " + e.getMessage());
        }
    }
}
