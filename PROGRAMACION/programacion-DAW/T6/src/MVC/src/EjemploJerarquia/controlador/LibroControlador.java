package MVC.src.EjemploJerarquia.controlador;

import java.util.ArrayList;

import MVC.src.EjemploJerarquia.modelo.Ebook;
import MVC.src.EjemploJerarquia.modelo.Libro;
import MVC.src.EjemploJerarquia.modelo.LibroDAO;
import MVC.src.EjemploJerarquia.modelo.Papel;
import MVC.src.EjemploJerarquia.vista.LIbroVista;

public class LibroControlador {

    private LibroDAO libroDAO;
    private LIbroVista vista;

    public LibroControlador(LIbroVista vista) {
        this.libroDAO = new LibroDAO();
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.getOpcionMenu();
            switch (opcion) {
                case 1:
                    Papel papel = vista.pedirDatosPapel();
                    guardarLibro(papel);
                    break;
                case 2:
                    Ebook ebook = vista.pedirDatosEbook();
                    guardarLibro(ebook);
                    break;
                case 3:
                    ArrayList<Libro> libros = listarLibros();
                    vista.mostrarLibros(libros);
                    break;
                case 4:
                    int id = vista.pedirIdLibro();
                    if (id != -1)
                        borrarLibro(id);
                    break;
                case 0:
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public void guardarLibro(Libro libro) {
        if (libro != null) {
            libroDAO.insertar(libro);
        } else {
            vista.mostrarMensaje("El libro no puede ser nulo.");
        }
    }

    public ArrayList<Libro> listarLibros() {
        return libroDAO.listar();
    }

    public void borrarLibro(int id) {
        libroDAO.borrar(id);
    }

    public Libro buscarLibro(int id) {
        return libroDAO.listar().stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }
}
