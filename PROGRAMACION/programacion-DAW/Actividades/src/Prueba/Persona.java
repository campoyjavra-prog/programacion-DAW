package prueba;

public class Persona {
     protected String nombre;
    int edad;

    public Persona(){

    }
    public Persona(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public void setNombre(String cadena){
        this.nombre=cadena;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setEdad(int anyos){
        this.edad=anyos;
    }
    public int getEdad(){
        return this.edad;
    }

    public void imprimePersona(){
        System.out.println("Me llamo "+this.nombre+" y tengo "+this.edad+" años.");
    }
}
