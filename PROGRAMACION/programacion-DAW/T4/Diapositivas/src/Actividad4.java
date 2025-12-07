import java.util.ArrayList;

class Seccion {
    String titulo;
    int extension; // num palabras o paginas
    public Seccion(String titulo, int extension) {
        this.titulo = titulo;
        this.extension = extension;
    }
}

class Ejemplar {
    String fecha;
    int numEjemplares;
    public Ejemplar(String fecha, int numEjemplares) {
        this.fecha = fecha;
        this.numEjemplares = numEjemplares;
    }
}

class Revista {
    String titulo, tipo, periodicidad;
    int numRegistro;
    ArrayList<Seccion> secciones = new ArrayList<>();
    ArrayList<Ejemplar> ejemplares = new ArrayList<>();

    public Revista(String titulo, String periodicidad) {
        this.titulo = titulo;
        this.periodicidad = periodicidad;
    }

    public void agregarSeccion(String titulo, int ext) {
        secciones.add(new Seccion(titulo, ext));
    }
}

class Sucursal {
    String codigo, direccion, ciudad;
    ArrayList<Revista> revistasPublicadas = new ArrayList<>(); // Relacion N:M "Publica"

    public void publicarRevista(Revista r) {
        revistasPublicadas.add(r);
    }
}

class Periodista {
    String nombre, apellidos;
    ArrayList<Revista> revistasDondeEscribe = new ArrayList<>(); // Relacion N:N "Escribe"
}

public class Actividad4 {
    public static void main(String[] args) {
        Revista r = new Revista("Hola Java", "Mensual");
        r.agregarSeccion("Programación", 5);
        
        Sucursal s = new Sucursal();
        s.publicarRevista(r);
        
        System.out.println("Revista creada: " + r.titulo);
    }
}