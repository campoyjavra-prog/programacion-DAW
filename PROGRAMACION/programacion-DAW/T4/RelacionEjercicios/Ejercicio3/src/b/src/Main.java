


// --------------------- CLASE PRINCIPAL (MAIN) ---------------------

public class Main {    
    public static void main(String[] args) {
        System.out.println("Iniciando sistema del Concesionario...\n");

        // 1. Catálogo (Marca -> Modelo -> Versión -> Extras)
        
        // Creamos una Marca
        Marca marcaFord = new Marca(1, "Ford");
        
        // Creamos un Modelo
        Modelo modeloFiesta = new Modelo(10, "Fiesta");
        marcaFord.agregarModelo(modeloFiesta); // Relación Marca-Modelo

        // Creamos dos Extras
        Extra aireAcond = new Extra(501, "Climatizador", "Aire automático", 500.0);
        Extra pinturaMet = new Extra(502, "Pintura Metalizada", "Color brillante", 300.0);

        // Creamos una Versión (Ej: Fiesta Titanium)
        Version versionTitanium = new Version(100, "Titanium", 120, 18000.0, "Gasolina");
        modeloFiesta.agregarVersion(versionTitanium); // Relación Modelo-Versión

        // Añadimos los extras a esta versión (Relación Versión-Extra)
        versionTitanium.agregarExtra(aireAcond);
        versionTitanium.agregarExtra(pinturaMet);

        // 2. Creación de Actores (Vendedor y Cliente)
        Vendedor vendedor1 = new Vendedor(1, "Carlos", "Sainz", "Perez");
        Cliente cliente1 = new Cliente(99, "Fernando", "Alonso");

        // 3. Flujo de Entrega de Coche Usado
        // El diagrama muestra que el Cliente entrega un Coche Usado que es de un Modelo.
        CocheUsado cocheViejo = new CocheUsado(88, "1234-ABC", 2000.0, modeloFiesta);
        
        // Realizamos la entrega (Relación "Entrega")
        cliente1.entregarCoche(cocheViejo, "07/12/2025");

        // 4. Flujo de Compra de Coche Nuevo
        CocheNuevo cocheNuevoVenta = new CocheNuevo(777, "9876-XYZ", versionTitanium);

        // Ahora registramos la Compra (Relación Ternaria: Cliente, Vendedor, Coche)
        Compra nuevaCompra = new Compra(cliente1, vendedor1, cocheNuevoVenta, "07/12/2025");
        
        // Generamos la factura para ver todos los datos relacionados
        nuevaCompra.generarFactura();
    }
}