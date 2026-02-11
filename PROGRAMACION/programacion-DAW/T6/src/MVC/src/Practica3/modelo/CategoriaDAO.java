package MVC.src.Practica3.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MVC.src.EjemploJerarquia.modelo.Conexion;

public class CategoriaDAO {
    // CREATE
    public static void insertar(int codigo, String nombre) {
        String sql = "INSERT INTO categoria VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // READ (SELECT)
    public static void listar() {
        String sql = "SELECT * FROM categoria";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("codigo") + " - " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Categoria listar(int id) {
        String sql = "SELECT * FROM categoria where codigo=?";
        Categoria nuevo = null;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("codigo") + " - " + rs.getString("nombre"));
                nuevo = new Categoria(rs.getInt("codigo"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return nuevo;
    }

    // UPDATE
    public static void actualizar(int codigo, String nuevoNombre) {
        String sql = "UPDATE categoria SET nombre=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoNombre);
            ps.setInt(2, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void actualizar(Categoria objeto) {
        String sql = "UPDATE categoria SET nombre=? WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // DELETE
    public static void borrar(int codigo) {
        String sql = "DELETE FROM categoria WHERE codigo=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}