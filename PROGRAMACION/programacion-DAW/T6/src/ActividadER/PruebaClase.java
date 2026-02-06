package ActividadER;

public class PruebaClase {
    public static void main(String[] args) {
        CategoriaDAO.listar();
        // Filtrar por un id
        Categoria nuevo = CategoriaDAO.listar(1);
        if (nuevo == null) {
            System.out.println("La categoria con ID 1 no existe. Creándola...");
            CategoriaDAO.insertar(1, "Categoria Test");
            nuevo = CategoriaDAO.listar(1);
        }

        System.out.println(nuevo);

        if (nuevo != null) {
            nuevo.setNombre("OTRA COSA");
            CategoriaDAO.actualizar(1, nuevo.getNombre());
            CategoriaDAO.actualizar(nuevo);
        }
    }
}
