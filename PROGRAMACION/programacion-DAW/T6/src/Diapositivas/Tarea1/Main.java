package Diapositivas.Tarea1;

import Diapositivas.Tarea1.controlador.Controlador;
import Diapositivas.Tarea1.vista.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
    }
}
