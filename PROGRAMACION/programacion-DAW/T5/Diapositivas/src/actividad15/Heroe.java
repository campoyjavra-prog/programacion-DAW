public class Heroe {
    private String nombre;
    private String editorial;

    public Heroe(String nombre, String editorial) {
        this.nombre = nombre;
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + "', editorial='" + editorial + "'";
    }
}

//