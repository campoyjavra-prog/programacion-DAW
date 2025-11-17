package clases;

public class Persona {
    String nombre;
    String DNI;
    String fecha;
    String direccion;
    Boolean genero;
    Boolean estadoCivil;

    public Persona(){

    }
    public Persona(String nombre, String DNI, String fecha, String direccion, Boolean genero,Boolean estado){
        this.nombre=nombre;
        this.DNI=DNI;
        this.fecha=fecha;
        this.direccion=direccion;
        this.genero=genero;
        this.estadoCivil=estado;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setDNI(String DNI){
        this.DNI=DNI;
    }
    public String getDNI(){
        return this.DNI;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
    public String getFecha(){
        return this.fecha;
    }

    public void imprimePersona(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("DNI: "+this.DNI);
        System.out.println("Fecha nacimiento: "+this.fecha);
        System.out.println("Dirección: "+this.direccion);
    }
}
