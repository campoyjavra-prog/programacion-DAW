
package a.src;

import java.util.ArrayList;

// ------------------- CLASES DEL DOMINIO -------------------

// 1. Clase FABRICA
// Según el diagrama, una Fábrica "tiene" Productos (relación 1:n inversa)
class Fabrica {
    private String cuit;
    private String nombre;
    private String pais;
    private int cantEmp;
    private String gerente;

    public Fabrica(String cuit, String nombre, String pais, int cantEmp, String gerente) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.pais = pais;
        this.cantEmp = cantEmp;
        this.gerente = gerente;
    }

    public String getCuit() {
        return cuit;
    }

    public String getPais() {
        return pais;
    }

    public int getCantEmp() {
        return cantEmp;
    }

    public String getGerente() {
        return gerente;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para representar la fábrica como texto
    public String toString() {
        return "Fábrica [" + nombre + " - País: " + pais + "]";
    }
}

// 2. Clase PRODUCTO
// Según el diagrama, un producto tiene una fábrica (1,1)
class Producto {
    private int codigo;
    private String descripcion;
    private String color;
    private double costo;
    private Fabrica fabrica; // Relación: El producto tiene una fábrica asociada

    public Producto(int codigo, String descripcion, String color, double costo, Fabrica fabrica) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.color = color;
        this.costo = costo;
        this.fabrica = fabrica;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getColor() {
        return color;
    }

    public double getCosto() {
        return costo;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }
}

// 3. Clase TARJETA
// Según el diagrama, la tarjeta pertenece a un Cliente
class Tarjeta {
    private String numero;
    private String nombreTitular;
    private int codigoSeguridad;
    private String fechaVenc; // Usamos String para simplificar fecha

    public Tarjeta(String numero, String nombreTitular, int codigoSeguridad, String fechaVenc) {
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaVenc = fechaVenc;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public String getFechaVenc() {
        return fechaVenc;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Visa/Mastercard terminada en " + numero;
    }
}

// 4. Clase CLIENTE
// El cliente tiene una lista de tarjetas (relación 1:n) y puede comprar en
// sucursales
class Cliente {
    private int codigo;
    private String nombre;
    private String ciudad;
    private String dni;
    private String fechaNac;

    // Lista para almacenar las tarjetas del cliente
    private ArrayList<Tarjeta> misTarjetas;

    public Cliente(int codigo, String nombre, String ciudad, String dni, String fechaNac) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.misTarjetas = new ArrayList<>(); // Inicializamos la lista vacía
    }

    // Método para agregar una tarjeta al cliente (Relación utiliza)
    public void agregarTarjeta(Tarjeta t) {
        misTarjetas.add(t);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Tarjeta> getMisTarjetas() {
        return misTarjetas;
    }

    // Simulación de la relación "Compra" con Sucursal y Descuento
    public void comprar(Sucursal sucursal, Producto prod, double descuento) {
        System.out.println("--- Ticket de Compra ---");
        System.out.println("Cliente: " + this.nombre);
        System.out.println("Sucursal: " + sucursal.getCiudad());
        System.out.println("Producto: " + prod.getDescripcion());

        // El precio de venta suele ser mayor al costo, aquí simulamos un precio final
        double precioVenta = prod.getCosto() * 1.5;
        double precioFinal = precioVenta - descuento;

        System.out.println("Precio lista: $" + precioVenta);
        System.out.println("Descuento aplicado: -$" + descuento);
        System.out.println("TOTAL A PAGAR: $" + precioFinal);
        System.out.println("------------------------");
    }
}

// 5. Clase Auxiliar DOMICILIO (Para Empleado)
// El diagrama muestra domicilio con atributos compuestos (calle, numero,
// ciudad)
class Domicilio {
    private String calle;
    private int numero;
    private String ciudad;

    public Domicilio(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + ciudad;
    }
}

// 6. Clase EMPLEADO
class Empleado {
    private int legajo;
    private String dni;
    private String nombre;
    private Domicilio domicilio;
    private ArrayList<String> telefonos;

    public Empleado(int legajo, String dni, String nombre, Domicilio domicilio) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefonos = new ArrayList<>();
    }

    public void agregarTelefono(String tel) {
        telefonos.add(tel);
    }

    public int getLegajo() {
        return legajo;
    }

    public String getDni() {
        return dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInfo() {
        return nombre + " (Legajo: " + legajo + ")";
    }
}

// 7. Clase SUCURSAL
class Sucursal {
    private int numero;
    private String domicilio;
    private String ciudad;

    // Relación con Empleados (1:n)
    private ArrayList<Empleado> listaEmpleados;

    // Inventario de productos disponibles (Relación vende)
    private ArrayList<Producto> stockProductos;

    public Sucursal(int numero, String domicilio, String ciudad) {
        this.numero = numero;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.listaEmpleados = new ArrayList<>();
        this.stockProductos = new ArrayList<>();
    }

    // Método para registrar la relación "Trabaja"
    public void contratarEmpleado(Empleado e, String horario, String dia) {
        // En un sistema real crearíamos una clase intermedia, pero aquí lo simulamos
        listaEmpleados.add(e);
        System.out.println("RRHH: Empleado " + e.getNombre() + " asignado a sucursal " + this.ciudad + " [" + dia
                + " - " + horario + "]");
    }

    // Método para añadir productos que la sucursal "vende"
    public void agregarProductoStock(Producto p) {
        stockProductos.add(p);
    }

    public int getNumero() {
        return numero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Producto> getStockProductos() {
        return stockProductos;
    }

    public String getCiudad() {
        return ciudad;
    }
}
