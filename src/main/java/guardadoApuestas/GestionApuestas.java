package guardadoApuestas;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionApuestas {

    public ArrayList<Jugador> pedirApuestas() throws Exception {
        String nombre = "";
        int numJugadores = 1;
        ArrayList<Jugador> jugadores = new ArrayList<>(numJugadores);

        try (Scanner teclado = new Scanner(System.in)) {
            while (!nombre.equalsIgnoreCase("INTRO")) {
                ArrayList<Integer> apuesta = new ArrayList<>();
                System.out.print("Nombre del jugador "+numJugadores+": ");
                nombre = teclado.nextLine();

                while (nombre.isEmpty() || nombre.equals(" ")) {
                    System.out.println("Por favor, escribe el nombre del jugador "+numJugadores+": ");
                    nombre = teclado.nextLine();
                }

                while (apuesta.size() < 5) {
                    int numero = (int) ((Math.random() * 49) + 1);
                    if (!apuesta.contains(numero)) {
                        apuesta.add(numero);
                    }
                }

                jugadores.add(new Jugador(nombre, apuesta));

                numJugadores++;
            }
            System.out.println("Se introdujo INTRO. Fin de pedida de nombres.");
        }
        return jugadores;
    }
}
