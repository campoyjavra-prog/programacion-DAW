
class Fecha {
    int dia, mes, anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public String getFechaCorta() { return dia + "/" + mes + "/" + anio; }
}

class Ciudad {
    int codigo;
    String nombre;
    int indicativo;

    public Ciudad(int codigo, String nombre, int indicativo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.indicativo = indicativo;
    }
}

class PersonaDetallada {
    private String cedula, nombre, apellido;
    private char genero;
    // Relaciones (Objetos)
    private Fecha fechaNacimiento;
    private Ciudad ciudadNacimiento;
    private Ciudad ciudadResidencia;

    // Constructor que recibe parámetros primitivos y crea los objetos dentro (según enunciado)
    public PersonaDetallada(String cedula, String nombre, String apellido, char genero, 
                            int dia, int mes, int anio, // Para fecha
                            String nombreCiudad, int codCiudad) { // Para ciudad (simplificado)
        
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        
        // Creamos los objetos aquí dentro
        this.fechaNacimiento = new Fecha(dia, mes, anio);
        this.ciudadNacimiento = new Ciudad(codCiudad, nombreCiudad, 91); // Valores por defecto o pasados
        this.ciudadResidencia = new Ciudad(codCiudad, nombreCiudad, 91); // Asumimos vive donde nace para el ejemplo
    }

    public void mostrarDatos() {
        System.out.println("Persona: " + nombre + " " + apellido);
        System.out.println("Nacido el: " + fechaNacimiento.getFechaCorta());
        System.out.println("Ciudad: " + ciudadNacimiento.nombre);
    }
}

public class Actividad2 {
    public static void main(String[] args) {
        // Al instanciar, pasamos datos sueltos y el constructor "monta" los objetos
        PersonaDetallada p = new PersonaDetallada("112233", "Maria", "Lopez", 'F', 15, 8, 1995, "Madrid", 28001);
        p.mostrarDatos();
    }
}
