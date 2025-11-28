import java.util.ArrayList;
import java.util.Scanner;

public class Batalla {

    private ArrayList <Personaje> listaHeroes;
    private ArrayList <Personaje> listaOrcos;


    public Batalla() {
        listaHeroes = new ArrayList<>();
        listaOrcos = new ArrayList<>();
    }


    public void crearPersonaje(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Elige tu personaje para la batalla: ");
        System.out.println("1- Seleccionar Caballero: ");
        System.out.println("2- Seleccioar Mago: ");
        System.out.println("3- Seleccionar Orco: ");

        int tipo = teclado.nextInt();
        teclado.nextLine();  // Limpia el buffer


        System.out.println("Introduce el NOMBRE del personaje: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduce la VIDA del personaje: ");
        int vida = teclado.nextInt();
        System.out.println("Introduce los puntos de ATAQUE del personaje: ");
        int ataque = teclado.nextInt();
        System.out.println("Introduce los puntos de DEFENSA del personaje: ");
        int defensa = teclado.nextInt();

        Personaje p = new Personaje(nombre, vida, ataque, defensa);
        
        switch (tipo) {
            case 1:
                listaHeroes.add(p);
                break;

            case 2:
                listaHeroes.add(p);
                break;

            case 3:
                listaOrcos.add(p);
                break;

            default:
                System.out.println("Personaje no valido.");
        }
    }


    public void iniciaBatalla() {
        if (listaHeroes.isEmpty() || listaOrcos.isEmpty()) {
            System.out.println("No hay suficientes personajes para la batalla.");
            return;
        }

        // Obtener el tamaño de la lista de héroes
        int totalHeroes = listaHeroes.size();
        int indiceHeroe = new java.util.Random().nextInt(totalHeroes);

        // Obtener el tamaño de la lista de orcos
        int totalOrcos = listaOrcos.size();
        int indiceOrco = new java.util.Random().nextInt(totalOrcos);

        // Seleccionar el personaje de las listas utilizando los índices aleatorios
        Personaje heroe = listaHeroes.get(indiceHeroe);
        Personaje orco = listaOrcos.get(indiceOrco);

        
        System.out.println("Comienza la batalla:");
        System.out.println("Heroe: " + heroe.getNombre());
        System.out.println("Orco: " + orco.getNombre());
    

        while (heroe.estaVivo() && orco.estaVivo()) {
            heroe.atacar(orco);
            orco.atacar(heroe);
        }
        if (heroe.estaVivo()) {
            System.out.println(heroe.getNombre() + " ha ganado la batalla");
        } 
        else if (orco.estaVivo()) {
            System.out.println(orco.getNombre() + " ha ganado la batalla");
        } 
    }


    public void muestraListas() {
        System.out.println("==== LISTA DE HEROES ====");
        if (listaHeroes.isEmpty()) {
            System.out.println("No hay heroes registrados");
        } 
        else {
            for (Personaje p: listaHeroes) {
                System.out.println("-------------------------");
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Vida: " + p.getVida());
                System.out.println("Ataque: " + p.getAtaque());
                System.out.println("Defensa: " + p.getDefensa());
                System.out.println("-------------------------");
            }
        }

        System.out.println("\n==== LISTA DE ORCOS ====");
        if (listaOrcos.isEmpty()) {
        System.out.println("No hay orcos registrados");
         } 
        else {
            for (Personaje p: listaOrcos) {
                System.out.println("-------------------------");
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Vida: " + p.getVida());
                System.out.println("Ataque: " + p.getAtaque());
                System.out.println("Defensa: " + p.getDefensa());
                System.out.println("-------------------------");
            }
        }
    }


    public void mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Selecciona una opcion:");
            System.out.println("1- Crear Personaje");
            System.out.println("2- Iniciar Batalla");
            System.out.println("3- Mostrar Listas");
            System.out.println("4- Salir");

            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    crearPersonaje();
                    break;

                case 2:
                    iniciaBatalla();
                    break;

                case 3:
                    muestraListas();
                    break;

                case 4:
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no valida, introduce un numero entre 1-4");
            }
        }
    }


    
}
