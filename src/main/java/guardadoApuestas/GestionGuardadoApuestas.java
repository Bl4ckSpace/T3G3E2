package guardadoApuestas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionGuardadoApuestas {

    public void guardarApuesta(GestionApuestas gestionApuestas) {
        ArrayList<Integer> apuesta = new ArrayList<>(5);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("apuestas.ser"))) {
            ArrayList<Jugador> jugadores = gestionApuestas.pedirApuestas(apuesta);
            for (Jugador jugador : jugadores) {
                oos.writeObject(jugador);
            }
        } catch (IOException ioe ) {
            System.out.println("Error de escritura de apuestas.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
