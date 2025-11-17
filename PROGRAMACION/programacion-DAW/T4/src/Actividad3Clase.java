
import clases.Editorial;
import clases.Libro;

public class Actividad3Clase {
    public static void main(String[] args) {
        //Crear los objetos
        Libro libro1=new Libro("12312535232424","La isla del tesoro",1987,19.95);
        Editorial ed1= new Editorial(1,"Santillana",1984);

        //Imprimir el contenido
        libro1.imprimeLibro();
        ed1.imprimeEditorial();
        libro1.setEditorial(ed1);
        System.out.println("-----------------------------");
        ed1.setAnyo(2025);
        libro1.imprimeLibro();
    }
}

