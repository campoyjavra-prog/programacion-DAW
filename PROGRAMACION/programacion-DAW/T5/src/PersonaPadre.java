public class PersonaPadre {
    protected String nombre;
    protected int edad;
    protected double altura;
    protected int valor = 2;

    PersonaPadre() {

    }

    PersonaPadre(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void imprimeDatos() {
        System.out.println("Nombre: " + this.nombre + " Edad: " + this.edad + " Altura: " + this.altura);
    }
}
