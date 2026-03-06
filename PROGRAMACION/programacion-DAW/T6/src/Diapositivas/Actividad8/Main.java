package Diapositivas.Actividad8;

import Diapositivas.Actividad8.controlador.Controlador;
import Diapositivas.Actividad8.vista.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
    }
}
