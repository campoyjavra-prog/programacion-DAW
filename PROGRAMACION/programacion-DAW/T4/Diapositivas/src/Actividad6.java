import java.util.ArrayList;

class Vuelo {
    String id, fecha, hora, origen, destino;
    int plazasTotales;

    public Vuelo(String id, String origen, String destino) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
    }
}

class Turista {
    String id, nombre, apellidos, telefono, direccion;
    
    // Relación "Toma" vuelo (N:N con atributo clase)
    // Podríamos crear clase intermedia, simplificamos con método
    public void tomarVuelo(Vuelo v, String clase) {
        System.out.println("Turista " + nombre + " reservó vuelo " + v.id + " en clase " + clase);
    }
}

class Hotel {
    String id, nombre, direccion, ciudad;
    int plazas;
    
    public Hotel(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    
    // Relación "Reserva" (N:N)
    public void registrarReserva(Turista t, String fechaEntrada, String regimen) {
        System.out.println("Reserva: " + t.nombre + " en Hotel " + this.nombre + " | Régimen: " + regimen);
    }
}

public class Actividad6 {
    public static void main(String[] args) {
        Turista t = new Turista(); 
        t.nombre = "Laura";
        
        Hotel h = new Hotel("Plaza Mayor", "Salamanca");
        Vuelo v = new Vuelo("IB300", "Madrid", "NY");
        
        t.tomarVuelo(v, "Business");
        h.registrarReserva(t, "10/08/2025", "Todo Incluido");
    }
}