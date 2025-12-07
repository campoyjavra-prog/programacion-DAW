
public class Pais {
    
    // 1. Atributos de la clase 
    private String nombre;
    private long poblacion; // Usamos long porque la población puede ser muy grande
    private double pib;

    // 2. Constructor con parámetros
    public Pais(String nombre, long poblacion, double pib) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pib = pib;
    }

    // 3. Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    public double getPib() {
        return pib;
    }

    public void setPib(double pib) {
        this.pib = pib;
    }

    // 4. Método para devolver el PIB per cápita
    // Fórmula: (PIB * 100000) / población
    public double calcularPibPerCapita() {
        double resultado;
        resultado = (this.pib * 100000) / this.poblacion;
        return resultado;
    }

    // --- CLASE MAIN PARA PROBAR EL CÓDIGO ---
    public static void main(String[] args) {
        
        System.out.println("--- INICIO DEL PROGRAMA PAÍS ---");

        //(Ejemplo: España)
        // Población aprox: 47 millones, PIB ficticio para el ejemplo
        Pais miPais = new Pais("España", 47000000L, 14000.50);

        // Usamos los getters para mostrar la información original
        System.out.println("Datos del país ingresado:");
        System.out.println("Nombre: " + miPais.getNombre());
        System.out.println("Población: " + miPais.getPoblacion());
        System.out.println("PIB: " + miPais.getPib());

        // Calculamos el PIB per cápita usando el método creado
        double rentaPerCapita = miPais.calcularPibPerCapita();

        System.out.println("--------------------------------");
        System.out.println("El PIB per cápita calculado es: " + rentaPerCapita);
        
        
    }
}