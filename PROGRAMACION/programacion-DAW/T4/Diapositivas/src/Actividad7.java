
// Enumerado para especialidad
enum Especialidad { FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR }

// --- PERSONAL ---
class Empleado {
    String nombre, dni;
    public Empleado(String n, String d) { nombre = n; dni = d; }
}

class Maquinista extends Empleado {
    double sueldo;
    String rango;
    public Maquinista(String n, String d, double s, String r) {
        super(n, d);
        this.sueldo = s;
        this.rango = r;
    }
}

class Mecanico extends Empleado {
    String telefono;
    Especialidad especialidad;
    public Mecanico(String n, String d, String t, Especialidad e) {
        super(n, d);
        this.telefono = t;
        this.especialidad = e;
    }
}

// --- MAQUINARIA ---
class Vagon {
    int numero;
    double cargaMaxima, cargaActual;
    String tipoMercancia;

    public Vagon(int numero, double max, double actual, String tipo) {
        this.numero = numero;
        this.cargaMaxima = max;
        this.cargaActual = actual;
        this.tipoMercancia = tipo;
    }
}

class Locomotora {
    String matricula;
    int potencia;
    int anio;
    Mecanico mecanicoResponsable;

    public Locomotora(String m, int p, int a, Mecanico mec) {
        this.matricula = m;
        this.potencia = p;
        this.anio = a;
        this.mecanicoResponsable = mec;
    }
}

class Tren {
    Locomotora locomotora;
    Vagon[] vagones; // ARRAY (Vector fijo)
    Maquinista maquinista;

    // Constructor que inicializa el array según el tamaño pedido
    public Tren(Locomotora loc, Maquinista maq, int numVagones) {
        this.locomotora = loc;
        this.maquinista = maq;
        this.vagones = new Vagon[numVagones]; // Inicializamos el array con el tamaño fijo
    }

    public void agregarVagon(int indice, Vagon v) {
        if (indice >= 0 && indice < vagones.length) {
            vagones[indice] = v;
        } else {
            System.out.println("Error: Índice de vagón fuera de rango.");
        }
    }
}

public class Actividad7 {
    public static void main(String[] args) {
        // Personal
        Maquinista pepe = new Maquinista("Pepe", "11A", 2000, "Senior");
        Mecanico luis = new Mecanico("Luis", "22B", "600123", Especialidad.MOTOR);

        // Locomotora
        Locomotora loco1 = new Locomotora("LOC-1", 5000, 2010, luis);

        // CREACIÓN DE TRENES (Arrays de tamaño 3, 4 y 2)
        
        // Tren 1 (3 vagones)
        Tren tren1 = new Tren(loco1, pepe, 3);
        tren1.agregarVagon(0, new Vagon(1, 1000, 500, "Madera"));
        tren1.agregarVagon(1, new Vagon(2, 1000, 500, "Madera"));
        tren1.agregarVagon(2, new Vagon(3, 1000, 200, "Hierro"));

        // Tren 2 (4 vagones)
        Tren tren2 = new Tren(loco1, pepe, 4); 
        // Se llenarían igual usando tren2.agregarVagon(0, vagon)...

        // Tren 3 (2 vagones)
        Tren tren3 = new Tren(loco1, pepe, 2);

        System.out.println("Trenes creados con estructuras de Arrays fijas.");
    }
}