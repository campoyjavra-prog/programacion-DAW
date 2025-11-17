package clases;

public class Editorial {
    private int codigo;
    private String nombre;
    private int anyo;

    public Editorial(){}
    public Editorial(int codigo, String nombre, int anyo){
        this.codigo=codigo;
        this.nombre=nombre;
        this.anyo=anyo;
    }

    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
    public int getCodigo(){
        return this.codigo;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setAnyo(int anyo){
        this.anyo=anyo;
    }
    public int getAnyo(){
        return this.anyo;
    }

    public void imprimeEditorial(){
        System.out.println("Nombre de editorial: "+this.nombre);
        System.out.println("Año de editorial: "+this.anyo);
    }
}
