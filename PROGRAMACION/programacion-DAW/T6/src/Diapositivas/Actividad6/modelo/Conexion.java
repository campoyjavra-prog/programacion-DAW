package Diapositivas.Actividad6.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/daw";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // Ajustar si es necesario

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
