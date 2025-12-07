import java.util.ArrayList;

class Categoria {
    int codigo;
    String nombre;
    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}

class Pieza {
    int codigo;
    String nombre;
    String color;
    double precio;
    Categoria categoria; // Relación N:1 (Pieza pertenece a Categoría)

    public Pieza(int codigo, String nombre, String color, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.categoria = categoria;
    }
}

class Proveedor {
    int codigo;
    String direccion, ciudad, provincia;
    
    // Para la relación N:M con atributos (Suministra), usamos una clase intermedia o lista de relaciones
    ArrayList<Suministro> historialSuministros = new ArrayList<>();

    public Proveedor(int codigo, String direccion, String ciudad) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public void suministrar(Pieza p, int cantidad, String fecha) {
        Suministro s = new Suministro(this, p, cantidad, fecha);
        historialSuministros.add(s);
        System.out.println("Proveedor " + codigo + " suministró " + cantidad + " de " + p.nombre);
    }
}

// Clase para representar el rombo "Suministra" con sus atributos
class Suministro {
    Proveedor proveedor;
    Pieza pieza;
    int cantidad;
    String fecha;

    public Suministro(Proveedor proveedor, Pieza pieza, int cantidad, String fecha) {
        this.proveedor = proveedor;
        this.pieza = pieza;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        Categoria tornilleria = new Categoria(1, "Tornillería");
        Pieza tornillo = new Pieza(50, "Tornillo hex", "Plata", 0.10, tornilleria);
        Proveedor prov = new Proveedor(99, "Poligono Ind.", "Valencia");

        prov.suministrar(tornillo, 1000, "07/12/2025");
    }
}