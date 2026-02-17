package Diapositivas.Tarea1.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ActividadER.Conexion;

public class Examen_TeoricoDAO {
    public void insertar(Examen_Teorico e) {
        String sql = "INSERT INTO Examen_Teorico VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, e.getId());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getFecha());
            ps.setInt(4, e.getNumeroPreguntas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Examen_Teorico> listar() {
        List<Examen_Teorico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Examen_Teorico";
        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Examen_Teorico(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("fecha"),
                        rs.getInt("numero_preguntas")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista;
    }

    public void actualizar(Examen_Teorico e) {
        String sql = "UPDATE Examen_Teorico SET titulo=?, fecha=?, numero_preguntas=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getFecha());
            ps.setInt(3, e.getNumeroPreguntas());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void borrar(int id) {
        String sql = "DELETE FROM Examen_Teorico WHERE id=?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
