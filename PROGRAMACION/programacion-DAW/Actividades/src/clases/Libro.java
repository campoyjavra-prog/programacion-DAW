package clases;

public class Libro {
     //Atributos
    private String isbn;
    private String titulo;
    private int anyo;
    private double precio;
    private Editorial editorial;
    
    //Constructores
    public Libro(){}
    public Libro(String isbn,String titulo, int anyo, double precio){
        this.isbn=isbn;
        this.titulo=titulo;
        this.anyo=anyo;
        this.precio=precio;
    }

    //Métodos (get y set)
    public void setISBN(String isbn){
        this.isbn=isbn;
    }
    public String getISBN(){
        return isbn;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setAnyo(int anyo){
        this.anyo=anyo;
    }
    public int getAnyo(){
        return anyo;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public double getPrecio(){
        return precio;
    }
    public void setEditorial(Editorial ed){
        //Opcion 1: una referencia
        this.editorial=ed;
        //Opcion 2: una copia
        // this.editorial=new Editorial();
        // this.editorial.setAnyo(ed.getAnyo());
        // this.editorial.setNombre(ed.getNombre());
        // this.editorial.setCodigo(ed.getCodigo());

    }
    public Editorial getEditorial(){
        return editorial;
    }
    public void imprimeLibro(){
        System.out.println("ISBN del libro: "+this.isbn);
        System.out.println("Nombre del libro: "+this.titulo);
        System.out.println("Año del libro: "+this.anyo);
        System.out.println("Precio del libro: "+this.precio);
        if(editorial!=null)
            this.editorial.imprimeEditorial();
    }
}
