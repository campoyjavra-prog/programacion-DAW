package modelo;

public class Pieza {

    private int codigo;
    private String nombre;
    private String color;
    private double precio;
    private int codCategoria;

    public Pieza(int codigo, String nombre, String color, double precio, int codCategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.codCategoria = codCategoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodCategoria() {
        return codCategoria;
    }
}