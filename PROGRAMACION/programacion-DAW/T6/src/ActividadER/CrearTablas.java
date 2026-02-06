package ActividadER;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablas {
    public static void main(String[] args) {
        String sqlCategoria = "CREATE TABLE IF NOT EXISTS categoria (" +
                "codigo INT PRIMARY KEY, " +
                "nombre VARCHAR(100)" +
                ")";

        String sqlProveedor = "CREATE TABLE IF NOT EXISTS proveedor (" +
                "codigo INT PRIMARY KEY, " +
                "direccion VARCHAR(150), " +
                "ciudad VARCHAR(100), " +
                "provincia VARCHAR(100)" +
                ")";

        String sqlPieza = "CREATE TABLE IF NOT EXISTS pieza (" +
                "codigo INT PRIMARY KEY, " +
                "nombre VARCHAR(100), " +
                "color VARCHAR(50), " +
                "precio DECIMAL(10,2), " +
                "codigo_categoria INT, " +
                "FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)" +
                ")";
        String sqlSuministra = "CREATE TABLE IF NOT EXISTS suministra (" +
                "codigo_proveedor INT, " +
                "codigo_pieza INT, " +
                "cantidad INT, " +
                "fecha DATE, " +
                "PRIMARY KEY (codigo_proveedor, codigo_pieza), " +
                "FOREIGN KEY (codigo_proveedor) REFERENCES proveedor(codigo), " +
                "FOREIGN KEY (codigo_pieza) REFERENCES pieza(codigo)" +
                ")";

        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlCategoria);
            stmt.executeUpdate(sqlProveedor);
            stmt.executeUpdate(sqlPieza);
            stmt.executeUpdate(sqlSuministra);
            System.out.println("Tablas creadas correctamente");
        } catch (SQLException e) {
            System.err.println("Error al crear las tablas: " + e.getMessage());
        }
    }
}