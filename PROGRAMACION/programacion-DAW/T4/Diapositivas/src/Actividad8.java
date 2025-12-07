import java.util.ArrayList;

class Libro {
    String nombre, autor, categoria;
    int totalEjemplares;
    int prestados;

    public Libro(String nombre, String autor, String categoria, int total) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.totalEjemplares = total;
        this.prestados = 0;
    }

    // Devuelve true si se pudo modificar (había stock)
    public boolean modificarExistencias(int num) {
        if (num > 0) { // Devolución
            prestados--;
            return true;
        } else { // Préstamo (num es -1 o negativo)
            if (prestados < totalEjemplares) {
                prestados++;
                return true;
            }
            return false;
        }
    }
}

class Usuario {
    String nombre;
    int codigo;
    ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String n, int c) { nombre = n; codigo = c; }

    public void prestarLibro(Libro libro) {
        // Verificamos si ya tiene este libro
        if (librosPrestados.contains(libro)) {
            System.out.println("Error: Ya tienes este libro prestado.");
            return;
        }

        if (libro.modificarExistencias(-1)) {
            librosPrestados.add(libro);
            System.out.println("Libro '" + libro.nombre + "' prestado a " + nombre);
        } else {
            System.out.println("No quedan ejemplares de " + libro.nombre);
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.remove(libro)) {
            libro.modificarExistencias(1);
            System.out.println("Libro devuelto.");
        } else {
            System.out.println("No tenías este libro.");
        }
    }
}

class Biblioteca {
    String nombre;
    ArrayList<Libro> catalogo = new ArrayList<>();

    public Biblioteca(String n) { nombre = n; }

    public void agregarLibro(Libro l) { catalogo.add(l); }

    public Libro buscarLibro(String titulo) {
        for (Libro l : catalogo) {
            if (l.nombre.equalsIgnoreCase(titulo)) return l;
        }
        return null;
    }
    
    // Extra: Buscar por autor
    public void buscarPorAutor(String autor) {
        System.out.println("Libros de " + autor + ":");
        for (Libro l : catalogo) {
            if (l.autor.equalsIgnoreCase(autor)) System.out.println(" - " + l.nombre);
        }
    }
}

public class Actividad8 {
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca("Municipal");
        Libro l1 = new Libro("El Quijote", "Cervantes", "Novela", 2);
        
        biblio.agregarLibro(l1);

        Usuario user = new Usuario("Ana", 1);

        // Prueba 1: Préstamo exitoso
        user.prestarLibro(l1);

        // Prueba 2: Intentar prestar el mismo libro (error)
        user.prestarLibro(l1);
        
        // Prueba 3: Devolver y buscar por autor
        user.devolverLibro(l1);
        biblio.buscarPorAutor("Cervantes");
    }
}