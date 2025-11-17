import clases.Categoria;
import clases.Pieza;
import clases.Proveedor;
import clases.ProveedorSuministraPieza;


public class ActividadProveedores {
    public static void main(String[] args) {
        //Crear CATEGORIA
        Categoria cat=new Categoria(1,"pieza1");
        System.out.println(cat.toString());
        //Crear proveedor
        Proveedor prove=new Proveedor(1,"asdfadsfsdf","Huércal Overa","Almería");
        System.out.println(prove.toString());
        //Crear la pieza
        Pieza pieza = new Pieza(1,"Alicates","AMARILLO",23.99);
        pieza.setCat(cat);
        System.out.println(pieza.toString());

        //Relación de suministra
        ProveedorSuministraPieza suministro = new ProveedorSuministraPieza(pieza,prove,30,"17/11/2025");
        System.out.println(suministro.toString());


    }
}