package generacionApuesta;

import guardadoApuestas.Jugador;

import java.util.ArrayList;

public class PrincipalGeneracionApuesta {
    public static void main(String[] args) {
        GestionGeneracionApuesta gestionGeneracionApuesta = new GestionGeneracionApuesta();

        ArrayList<Integer> apuestaGanadora = gestionGeneracionApuesta.generarApuestaGanadora();
        ArrayList<Jugador> ganadores = gestionGeneracionApuesta.leerApuestas(apuestaGanadora);

        if (!ganadores.isEmpty()) {
            System.out.println("*** GANADOR/ES ***");
            for (Jugador ganador : ganadores) {
                System.out.println(ganador);
            }
        } else {
            System.out.println("No hay ganadores. La apuesta ganadora era: "+apuestaGanadora);
        }
    }
}
