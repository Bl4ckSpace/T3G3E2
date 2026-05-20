package generacionApuesta;

import guardadoApuestas.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GestionGeneracionApuesta {

    public ArrayList<Jugador> leerApuestas(ArrayList<Integer> apuestaGanadora) {
        ArrayList<Jugador> ganadores = new ArrayList<>();
        boolean finArchivo = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("apuestas.ser"))) {
            while (!finArchivo) {
                try {
                    Jugador jugador = (Jugador) ois.readObject();
                    Collections.sort(jugador.getApuesta());
                    Collections.sort(apuestaGanadora);

                    if (jugador.getApuesta().equals(apuestaGanadora)) {
                        ganadores.add(jugador);
                    }
                } catch (EOFException eofe) {
                    finArchivo = true;
                } catch (ClassNotFoundException e) {
                    System.out.println("Error al deserializar el jugador.");
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura de apuestas.");
        }
        return ganadores;
    }

    public ArrayList<Integer> generarApuestaGanadora() {
        ArrayList<Integer> apuesta = new ArrayList<>();
        while (apuesta.size() < 5) {
            int numero = (int) ((Math.random() * 49) + 1);
            if (!apuesta.contains(numero)) {
                apuesta.add(numero);
            }
        }
        return apuesta;
    }
}
