package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAO {
    // READ
    public ArrayList<Libro> listar() {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT Titulo, Codigo_Libro, Editorial, Genero, Precio, Autor, Libro_Imagen FROM libro";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                libros.add(new Libro(
                        rs.getString("Titulo"),
                        rs.getInt("Codigo_Libro"),
                        rs.getString("Editorial"),
                        rs.getString("Genero"),
                        rs.getDouble("Precio"),
                        rs.getString("Autor"),
                        rs.getString("Libro_Imagen")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    // CREATE
    public void insertar(Libro l) throws SQLException {
        String sql = "INSERT INTO libro (Titulo, Codigo_Libro, Editorial, Genero, Precio, Autor, Libro_Imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setInt(2, l.getCodigoLibro());
            ps.setString(3, l.getEditorial());
            ps.setString(4, l.getGenero());
            ps.setDouble(5, l.getPrecio());
            ps.setString(6, l.getAutor());
            ps.setString(7, l.getImagen());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void actualizar(Libro l) throws SQLException {
        String sql = "UPDATE libro SET Titulo=?, Editorial=?, Genero=?, Precio=?, Autor=?, Libro_Imagen=? WHERE Codigo_Libro=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getEditorial());
            ps.setString(3, l.getGenero());
            ps.setDouble(4, l.getPrecio());
            ps.setString(5, l.getAutor());
            ps.setString(6, l.getImagen());
            ps.setInt(7, l.getCodigoLibro());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int codigoLibro) throws SQLException {
        String sql = "DELETE FROM libro WHERE Codigo_Libro=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigoLibro);
            ps.executeUpdate();
        }
    }
}
