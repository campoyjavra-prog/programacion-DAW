package clases;

public class Ciudad {
    private int codigo;
    private String nombre;
    private int indicativo;

    //Constructor
    public Ciudad(){

    }
    public Ciudad(int codigo, String nombre, int indicativo){
        this.codigo=codigo;
        this.nombre=nombre;
        this.indicativo=indicativo;
    }
    //Métodos get y set
    public int getCodigo() {
        return codigo;
    }
    public int getIndicativo() {
        return indicativo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setIndicativo(int indicativo) {
        this.indicativo = indicativo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void imprimeCiudad(){
        System.out.println("Imprime ciudad");
    }

}
