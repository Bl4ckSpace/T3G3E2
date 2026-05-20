package guardadoApuestas;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionApuestas {

    public ArrayList<Jugador> pedirApuestas(ArrayList<Integer> apuesta) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        int numJugadores = 1;
        ArrayList<Jugador> jugadores = new ArrayList<>(numJugadores);

        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Escribe tu nombre: ");
            nombre = teclado.nextLine();

            if (nombre.equalsIgnoreCase("INTRO")) {
                throw new Exception("Se introdujo INTRO. Fin de pedida de nombres.");
            }

            while (nombre.isEmpty() || nombre.equals(" ")) {
                System.out.println("Nombre inválido, escribe otro: ");
                nombre = teclado.nextLine();
            }

            for (int j = 1; j <= 5; j++) {
                apuesta.add((int) ((Math.random() * 49) + 1));
            }
            jugadores.add(new Jugador(nombre, apuesta));

            numJugadores++;
        }
        return jugadores;
    }
}
