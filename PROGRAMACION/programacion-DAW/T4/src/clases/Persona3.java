package clases;

public class Persona3 {
     private String cedula;
    private String nombre;
    private String apellido;
    private char genero;

    Fecha fechaNacimiento;
    Ciudad ciudadNacimiento;
    Ciudad ciudadResidencia;
    
    //Constructor
    public Persona3(){

    }
    public Persona3(String cedula, String nombre, String apellido, char genero){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.genero=genero;
    }
    //Métodos
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    ///
    public void setCiudadNacimiento(Ciudad nacimiento){
        this.ciudadNacimiento=nacimiento;
    }
    public Ciudad getCiudadNaciminento(){
        return this.ciudadNacimiento;
    }
    public void setFechaNacimiento(Fecha fecha){
        this.fechaNacimiento=fecha;
    }
    public void setCiudadResidencia(Ciudad ciudad){
        this.ciudadResidencia=ciudad;
    }
    public Ciudad getCiudadResidencia(){
        return this.ciudadResidencia;
    }
    public Fecha getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public void imprimePesona(){
        System.out.println("Datos de persona");
        if(fechaNacimiento!=null) fechaNacimiento.imprimeFecha();
        if(ciudadNacimiento!=null) ciudadNacimiento.imprimeCiudad();

    }
}
