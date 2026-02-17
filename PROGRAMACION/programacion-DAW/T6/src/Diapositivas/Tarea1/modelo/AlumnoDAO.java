package Diapositivas.Tarea1.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ActividadER.Conexion;

public class AlumnoDAO {
    public void insertar(Alumno a) {
        String sql = "INSERT INTO Alumno VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getId());
            ps.setString(2, a.getGrupo());
            ps.setInt(3, a.getNif());
            ps.setString(4, a.getNombre());
            ps.setString(5, a.getApellido1());
            ps.setString(6, a.getApellido2());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Alumno> listar() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM Alumno";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Alumno a = new Alumno(
                        rs.getInt("id"),
                        rs.getString("grupo"),
                        rs.getInt("nif"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public void actualizar(Alumno a) {
        String sql = "UPDATE Alumno SET grupo=?, nif=?, nombre=?, apellido1=?, apellido2=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getGrupo());
            ps.setInt(2, a.getNif());
            ps.setString(3, a.getNombre());
            ps.setString(4, a.getApellido1());
            ps.setString(5, a.getApellido2());
            ps.setInt(6, a.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Alumno WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
