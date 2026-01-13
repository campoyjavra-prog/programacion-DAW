import java.io.*;

public class LecturaEscritura {
    int partidasJugador1,partidasJugador2;
    
    public int getPartidasJugador1() {
        return partidasJugador1;
    }
    public void IncrementaPartidasJugador1(int cantidad){
        this.partidasJugador1+=cantidad;
    }
    public int getPartidasJugador2() {
        return partidasJugador2;
    }
    public void IncrementaPartidasJugador2(int cantidad){
        this.partidasJugador2+=cantidad;
    }
    public static void main (String[] args){
        LecturaEscritura objeto = new LecturaEscritura();
        //Lectura de datos
        objeto.leerDatos("./Tema5/numeros.txt");
        System.out.println("Victorias jugador1= "+objeto.getPartidasJugador1()+". Victorias jugador2= "+objeto.getPartidasJugador2());
        //Modificar tras la partida ...
        objeto.IncrementaPartidasJugador1(1);
        objeto.IncrementaPartidasJugador2(3);
        //Guardar los datos
        objeto.guardarDatos("./Tema5/numeros.txt");

    }
    //Función para leer de fichero
    public void leerDatos(String ruta) {
        File fichero = new File(ruta);
        if (!fichero.exists()) return; // Si no existe, empezamos en 0

        try{
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            //Leer la línea y coger cada número según sea jugador1 o jugador2
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("=");
                if (partes[0].equals("jugador1")) {
                    partidasJugador1 = Integer.parseInt(partes[1]);
                } else if (partes[0].equals("jugador2")) {
                    partidasJugador2 = Integer.parseInt(partes[1]);
                }
            }
            br.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    //Función para escribir
    public void guardarDatos(String ruta) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            //Escribir el formato de salida en fichero
            bw.write("jugador1=" + partidasJugador1);
            bw.newLine();
            bw.write("jugador2=" + partidasJugador2);
            bw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}