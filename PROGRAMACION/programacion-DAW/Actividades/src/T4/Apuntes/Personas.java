package T4.Apuntes;

public class Personas {

    String nombre; //Atributos por defecto public
    byte edad;
    double estatura;
    public int hijos;

    public Personas(){ //Constructor

    }

    public void setNombre(String nom){
        this.nombre = nom;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setEdad(byte anyos){
        this.edad = anyos;
    }

    public byte getEdad(){
        return this.edad;
    }

     public void setEstatura(double estatura){
        this.estatura = estatura;
    }

    public double getEstatura(){
        return this.estatura;
    }

    public void saludar(){ //Método
        System.out.println("Hola a todos, soy "+nombre);
    }

    public void imprimirDatos(){
        System.out.println("Te llamas "+nombre+", tienes "+edad+" años y mides "+estatura+"cm");
    }

    public static void main(String[] args) {

        Personas p1 = new Personas();
        Personas p2 = new Personas();
        Personas p3 = new Personas();

        // Iniciar los atributos con sus funciones

        p1.setNombre("Pepa");
        p1.setEdad((byte) 18);
        p1.setEstatura(1.87);

        p2.setNombre("Paco");
        p2.setEdad((byte) 51);
        p2.setEstatura(1.68);

        p3.setNombre("Miguel");
        p3.setEdad((byte) 27);
        p3.setEstatura(1.79);

    }

    public void obtenerEdad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEdad'");
    }
}
