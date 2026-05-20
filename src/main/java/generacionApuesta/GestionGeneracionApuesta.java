package generacionApuesta;

import guardadoApuestas.Jugador;

import java.io.*;
import java.util.ArrayList;

public class GestionGeneracionApuesta {

    public ArrayList<Jugador> leerApuestas(ArrayList<Integer> apuestaGanadora) {
        ArrayList<Jugador> ganadores = new ArrayList<>();
        boolean finArchivo = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("apuestas.ser"))) {
            while (!finArchivo) {
                try {
                    Jugador jugador = (Jugador) ois.readObject();

                    if (jugador.getApuesta().equals(apuestaGanadora)) {
                        ganadores.add(jugador);
                    }
                } catch (EOFException eofe) {
                    finArchivo = true;
                } catch (ClassNotFoundException e) {
                    System.out.println("No se encontró el archivo.");
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura de apuestas.");
        }
        return ganadores;
    }

    public ArrayList<Integer> generarApuestaGanadora() {
        ArrayList<Integer> apuesta = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            apuesta.add((int) ((Math.random() * 49) + 1));
        }
        return apuesta;
    }
}
