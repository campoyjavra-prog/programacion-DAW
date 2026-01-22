package actividad20;

public class Actividad20 {

    public static void main(String[] args) {
        // Caja solo para Circulos
        CajaFiguras<Circulo> cajaCirculos = new CajaFiguras<>();
        
        // Añadimos varios circulos
        cajaCirculos.guardar(new Circulo("Circulo1", 5));
        cajaCirculos.guardar(new Circulo("Circulo2", 3));
        cajaCirculos.guardar(new Circulo("Circulo3", 7));

        // Caja solo para Rectangulos
        CajaFiguras<Rectangulo> cajaRectangulos = new CajaFiguras<>();
        
        // Añadimos varios rectangulos
        cajaRectangulos.guardar(new Rectangulo("Rectangulo1", 4, 6));
        cajaRectangulos.guardar(new Rectangulo("Rectangulo2", 5, 8));
        cajaRectangulos.guardar(new Rectangulo("Rectangulo3", 3, 5));

        // Caja general para cualquier Figura
        CajaFiguras<Figura> cajaGeneral = new CajaFiguras<>();
        
        // Añadimos circulos y rectangulos
        cajaGeneral.guardar(new Circulo("CirculoGeneral1", 4));
        cajaGeneral.guardar(new Rectangulo("RectanguloGeneral1", 6, 9));
        cajaGeneral.guardar(new Circulo("CirculoGeneral2", 6));

        // Mostramos contenido y area total de cada caja
        System.out.println("=== CAJA DE CIRCULOS ===");
        cajaCirculos.mostrarContenido();
        System.out.println("Area total: " + cajaCirculos.calcularAreaTotal());
        System.out.println();

        System.out.println("=== CAJA DE RECTANGULOS ===");
        cajaRectangulos.mostrarContenido();
        System.out.println("Area total: " + cajaRectangulos.calcularAreaTotal());
        System.out.println();

        System.out.println("=== CAJA GENERAL ===");
        cajaGeneral.mostrarContenido();
        System.out.println("Area total: " + cajaGeneral.calcularAreaTotal());
    }
}
