
public class Persona4 {
    private String nombre;
    private String domicilio;
    String telefono;

    //Constructor
    public Persona4(){

    }
    public Persona4(String nombre, String domicilio, String telefono){
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.telefono=telefono;
    }

    //Métodos
    public String getDomicilio() {
        return domicilio;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void imprimePersona(){
        System.out.println("Se llama "+nombre+"\nVive en "+domicilio+"\nSu teléfono es: "+telefono);
    }
}
