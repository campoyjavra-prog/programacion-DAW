package clases;

enum Color{
    ROJO, VERDE, AZUL, AMARILLO, VIOLETA;
}
public class Pieza {
    int codigo;
    String nombre;
    String color;
    double precio;
    Categoria cat;

    //Constructores
    public Pieza(){

    }
    public Pieza(int codigo, String nombre, String color, double precio){
        this.codigo=codigo;
        this.nombre=nombre;
        this.color=color;
        this.precio=precio;
    }
    //Métodos
    public Categoria getCat() {
        return cat;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getColor() {
        return color;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    @Override
    public String toString() {
        if(cat!=null) 
            return "Pieza [codigo=" + codigo + ", nombre=" + nombre + ", color=" + color + ", precio=" + precio +"\n "+cat.toString()+"]";
        else return "Pieza [codigo=" + codigo + ", nombre=" + nombre + ", color=" + color + ", precio=" + precio +"]";
    }
    
}