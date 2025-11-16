package ActividadesT3;

public class Actividad2 {
       public static void main(String[] args) {
        // Definimos un array bidimensional para los horarios
        String[][] horario = {
            {"IPE", "BaseDatos", "Programcion", "SistemasInformaticos", "Entornos"}, // Lunes
            {"Sostenibilidad", "IPE", "Entornos", "BaseDatos", "LMSGI"},    // Martes
            {"Programacion", "LMSGI", "SistemasInformaticos", "Entornos", "IPE"},  // Miércoles
            {"Entornos", "Digitalizacion", "Sostenibilidad", "BaseDatos", "Progrmacion"},   // Jueves
            {"LMSGI", "IPE", "Entornos", "Programacion", "SistemasInformaticos"} // Viernes
        };

        // Asignamos el valor 2 a díaHoy para mostrar las clases del miércoles
        int diaHoy = 2;  // Miércoles
        
        // Imprimimos las clases del día elegido
        System.out.println("Hoy tienes las siguientes clases: ");
        for (int i = 0; i < horario[diaHoy].length; i++) {
            System.out.println(horario[diaHoy][i]); // Imprime las clases del día seleccionado
        }
    }
}
