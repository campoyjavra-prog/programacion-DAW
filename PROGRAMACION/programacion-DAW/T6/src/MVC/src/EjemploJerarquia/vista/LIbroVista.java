package MVC.src.EjemploJerarquia.vista;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import MVC.src.EjemploJerarquia.modelo.Ebook;
import MVC.src.EjemploJerarquia.modelo.Libro;
import MVC.src.EjemploJerarquia.modelo.Papel;

public class LIbroVista {

    private static Scanner scanner = new Scanner(System.in);

    public int getOpcionMenu() {
        System.out.println("\n--- GESTIÓN DE LIBROS (JERARQUÍA) ---");
        System.out.println("1. Insertar Libro PAPEL");
        System.out.println("2. Insertar Libro EBOOK");
        System.out.println("3. Listar todos los libros");
        System.out.println("4. Borrar libro por ID");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Papel pedirDatosPapel() {
        System.out.println("\n--- NUEVO LIBRO DE PAPEL ---");
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Año Publicación: ");
            int anio = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Fecha Impresión (YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            Date fecha = Date.valueOf(fechaStr);

            System.out.print("Lugar Impresión: ");
            String lugar = scanner.nextLine();

            return new Papel(id, isbn, titulo, descripcion, anio, precio, fecha, lugar);
        } catch (Exception e) {
            System.out.println("Error en los datos: " + e.getMessage());
            return null;
        }
    }

    public Ebook pedirDatosEbook() {
        System.out.println("\n--- NUEVO LIBRO EBOOK ---");
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Año Publicación: ");
            int anio = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Tamaño (ej: 5MB): ");
            String tamano = scanner.nextLine();

            return new Ebook(id, isbn, titulo, descripcion, anio, precio, tamano);
        } catch (Exception e) {
            System.out.println("Error en los datos: " + e.getMessage());
            return null;
        }
    }

    public void mostrarLibros(ArrayList<Libro> libros) {
        System.out.println("\n--- LISTADO DE LIBROS ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

    public int pedirIdLibro() {
        System.out.print("Introduce el ID del libro: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID no válido.");
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
