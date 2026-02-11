package Diapositivas.Actividad5;

import java.sql.Date;

public class Prueba_Actividad5 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("    INICIO DE LA DEMOSTRACIÓN ACTIVIDAD 5");
        System.out.println("=========================================");

        // 1. GESTIÓN GEOGRÁFICA
        System.out.println("\n--- 1. GESTIÓN GEOGRÁFICA ---");
        ProvinciaDAO provDao = new ProvinciaDAO();
        LocalidadDAO locDao = new LocalidadDAO();

        System.out.println("[INSERT] Insertando Provincia Madrid...");
        provDao.insertar(28, "Madrid");

        System.out.println("[INSERT] Insertando Localidad Alcorcón en Madrid...");
        locDao.insertar(1, "Alcorcón", 28);

        locDao.listar();

        // 2. GESTIÓN DE ENTIDADES VINCULADAS A LOCALIDAD
        System.out.println("\n--- 2. CREACIÓN DE ENTIDADES PRINCIPALES ---");
        ClienteDAO cliDao = new ClienteDAO();
        AutorDAO autDao = new AutorDAO();
        EditorialDAO editDao = new EditorialDAO();
        AlmacenDAO almDao = new AlmacenDAO();

        System.out.println("[INSERT] Cliente: Juan Perez...");
        cliDao.insertar(100, "Juan", "Perez", "Gomez", "Calle Mayor 1", "juan@test.com", "600111222", 1);

        System.out.println("[INSERT] Autor: Stephen King...");
        autDao.insertar(200, "Stephen", "King", "", "Maine St", "555-666", "www.stephenking.com", 1);

        System.out.println("[INSERT] Editorial: Planeta...");
        editDao.insertar(300, "Planeta", "Avda Diagonal", "911223344", "www.planeta.es", 1);

        System.out.println("[INSERT] Almacén Central...");
        almDao.insertar(400, "Polígono Ind.", "918887766", 1);

        // 3. GESTIÓN DE PRODUCTOS (LIBROS)
        System.out.println("\n--- 3. GESTIÓN DE LIBROS ---");
        LibroDAO libroDao = new LibroDAO();

        System.out.println("[INSERT] Libro Papel: 'IT'...");
        libroDao.insertar(1000, "978-1-2345", "IT", "Payaso que da miedo", 1986, "Papel", 25.50,
                Date.valueOf("2020-01-01"), "Madrid", null);

        System.out.println("[INSERT] Libro Ebook: 'Misery'...");
        libroDao.insertar(1001, "978-5-4321", "Misery", "Escritor secuestrado", 1987, "Ebook", 9.99, null, null, "5MB");

        libroDao.listar();

        // 4. GESTIÓN DE RELACIONES N:N (ESCRIBE, PUBLICA, ALMACENA)
        System.out.println("\n--- 4. RELACIONES AUTOR-LIBRO-EDITORIAL-ALMACEN ---");
        EscribeDAO escDao = new EscribeDAO();
        PublicaDAO pubDao = new PublicaDAO();
        AlmacenaDAO almacenaDao = new AlmacenaDAO();

        System.out.println("[INSERT] Stephen King escribe IT y Misery...");
        escDao.insertar(200, 1000);
        escDao.insertar(200, 1001);

        System.out.println("[INSERT] Planeta publica IT...");
        pubDao.insertar(300, 1000);

        System.out.println("[INSERT] Almacén guarda 50 copias de IT...");
        almacenaDao.insertar(1000, 400, 50);

        // 5. GESTIÓN DE COMPRAS (CESTA Y CONTIENE)
        System.out.println("\n--- 5. GESTIÓN DE COMPRAS (CESTA) ---");
        CestaDAO cestaDao = new CestaDAO();
        ContieneDAO contDao = new ContieneDAO();

        System.out.println("[INSERT] Cliente Juan crea una cesta...");
        cestaDao.insertar(5000, Date.valueOf("2024-02-06"), 100);

        System.out.println("[INSERT] Añadiendo IT a la cesta...");
        contDao.insertar(5000, 1000, 1);

        cestaDao.listar();
        contDao.listar();

        // 6. LIMPIEZA TOTAL (Orden Inverso)
        System.out.println("\n--- 6. LIMPIEZA (DELETE) ---");

        System.out.println("[DELETE] Relaciones...");
        contDao.borrar(5000, 1000);
        cestaDao.borrar(5000); // Cesta depende de Cliente

        almacenaDao.borrar(1000, 400);
        pubDao.borrar(300, 1000);
        escDao.borrar(200, 1000);
        escDao.borrar(200, 1001);

        System.out.println("[DELETE] Libros...");
        libroDao.borrar(1000);
        libroDao.borrar(1001);

        System.out.println("[DELETE] Entidades...");
        almDao.borrar(400);
        editDao.borrar(300);
        autDao.borrar(200);
        cliDao.borrar(100);

        System.out.println("[DELETE] Geografía...");
        locDao.borrar(1);
        provDao.borrar(28);

        System.out.println("\n=========================================");
        System.out.println("       FIN DE LA DEMOSTRACIÓN");
        System.out.println("=========================================");
    }
}
