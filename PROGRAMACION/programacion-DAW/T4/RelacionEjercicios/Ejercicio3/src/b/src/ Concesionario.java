import java.util.ArrayList;

// --------------------- CLASES BASICAS (Entidades) ---------------------

// 1. CLASE EXTRA
// En el diagrama, Extra tiene una relación N:N con Versión y un precio en la relación.
// Para simplificar, asumiremos que el precio es parte del Extra.
class Extra {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    public Extra(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public double getPrecio() { 
        return precio;
    }
    
    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}

// 2. CLASE VERSION
// Una Versión "Tiene" Extras y pertenece a un Modelo (aunque la relación Modelo->Version la gestionamos desde Modelo o aquí).
class Version {
    private int id;
    private String nombre;
    private int potencia;
    private double precioBase;
    private String tipoCombustible;
    
    // Lista de extras que tiene esta versión (Relación N:N)
    private ArrayList<Extra> listaExtras;

    public Version(int id, String nombre, int potencia, double precioBase, String tipoCombustible) {
        this.id = id;
        this.nombre = nombre;
        this.potencia = potencia;
        this.precioBase = precioBase;
        this.tipoCombustible = tipoCombustible;
        this.listaExtras = new ArrayList<>();
    }

    // Método para añadir extras a la configuración de esta versión
    public void agregarExtra(Extra extra) {
        this.listaExtras.add(extra);
    }

    public String getNombre() {
        return nombre; 
    }
    public double getPrecioBase() {
        return precioBase; 
    }

    public ArrayList<Extra> getListaExtras() { 
        return listaExtras; 
    }
    
    // Método calculado para saber precio total con extras
    public double getPrecioConExtras() {
        double total = precioBase;
        for (Extra e : listaExtras) {
            total += e.getPrecio();
        }
        return total;
    }
}

// 3. CLASE MODELO
// Un Modelo "Tiene" Versiones. Y pertenece a una Marca.
class Modelo {
    private int id;
    private String nombre;
    
    // Relación 1:N (Un modelo tiene varias versiones)
    private ArrayList<Version> versiones;

    public Modelo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.versiones = new ArrayList<>();
    }

    public void agregarVersion(Version v) {
        this.versiones.add(v);
    }

    public String getNombre() {
        return nombre; 
    }
    
    // Método auxiliar para buscar una versión
    public Version getVersion(int index) {
        if(index < versiones.size()) return versiones.get(index);
        return null;
    }
}

// 4. CLASE MARCA
// La Marca es la entidad superior (1:N con Modelo).
class Marca {
    private int id;
    private String nombre;
    private ArrayList<Modelo> modelos;

    public Marca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.modelos = new ArrayList<>();
    }

    public void agregarModelo(Modelo m) {
        this.modelos.add(m);
    }
    
    public String getNombre() { 
        return nombre; 
    }
}

// 5. CLASE COCHE NUEVO
// Es el objeto físico. Tiene una matricula y pertenece a una Versión específica.
// Está involucrado en la relación "Compra".
class CocheNuevo {
    private int id;
    private String matricula;
    private Version version; 

    public CocheNuevo(int id, String matricula, Version version) {
        this.id = id;
        this.matricula = matricula;
        this.version = version;
    }

    public String getMatricula() {
        return matricula;
    }

    public Version getVersion() { 
        return version; 
    }
    
    @Override
    public String toString() {
        return "Coche Nuevo [Matrícula: " + matricula + " | " + version.getNombre() + "]";
    }
}

// 6. CLASE VENDEDOR
class Vendedor {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    

    public Vendedor(int id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1;
    }
}

// 7. CLASE COCHE USADO
// Este coche se "Entrega" por parte de un cliente y "Tiene" una relación con un Modelo.
class CocheUsado {
    private int id;
    private String matricula;
    private double precioTasacion;
    private String nombre; 
    private Modelo modelo; // Relación "Tiene" (N:1) con Modelo

    public CocheUsado(int id, String matricula, double precioTasacion, Modelo modelo) {
        this.id = id;
        this.matricula = matricula;
        this.precioTasacion = precioTasacion;
        this.modelo = modelo;
    }
    
    public double getPrecioTasacion() { 
        return precioTasacion;
    }

    public String getInfo() {
        return "Usado: " + modelo.getNombre() + " (" + matricula + ")"; 
    }
}

// 8. CLASE CLIENTE
// El cliente puede comprar coches nuevos y entregar coches usados.
class Cliente {
    private int id;
    private String nombre;
    private String apellido1;
    

    // Listas para guardar el historial del cliente
    private ArrayList<CocheUsado> cochesEntregados; 
    
    public Cliente(int id, String nombre, String apellido1) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.cochesEntregados = new ArrayList<>();
    }

    public String getNombre() { return nombre + " " + apellido1; }

    // Relación "Entrega": El cliente entrega un coche usado
    public void entregarCoche(CocheUsado coche, String fecha) {
        this.cochesEntregados.add(coche);
        System.out.println(">>> " + this.getNombre() + " ha entregado un " + coche.getInfo() + " en fecha " + fecha);
        System.out.println("    Tasación: $" + coche.getPrecioTasacion());
    }
}

// 9. CLASE COMPRA (Relación Ternaria)
// Conecta Cliente, Vendedor y CocheNuevo. Tiene atributo "fecha".
class Compra {
    private Cliente cliente;
    private Vendedor vendedor;
    private CocheNuevo coche;
    private String fecha;

    public Compra(Cliente cliente, Vendedor vendedor, CocheNuevo coche, String fecha) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.coche = coche;
        this.fecha = fecha;
    }

    public void generarFactura() {
        System.out.println("\n========== FACTURA COMPRA ==========");
        System.out.println("Fecha: " + fecha);
        System.out.println("Vendedor: " + vendedor.getNombreCompleto());
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("---------------------------------------");
        System.out.println("Vehículo: " + coche.toString());
        
        // Accedemos a los datos de la versión a través del coche
        Version v = coche.getVersion();
        System.out.println("Precio Base Versión: $" + v.getPrecioBase());
        
        System.out.println("Extras incluidos:");
        for(Extra e : v.getListaExtras()) {
            System.out.println(" - " + e.toString());
        }
        
        System.out.println("---------------------------------------");
        System.out.println("TOTAL A PAGAR: $" + v.getPrecioConExtras());
        System.out.println("=======================================\n");
    }
}

