package guardadoApuestas;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Integer> apuesta;

    public Jugador(String nombre, ArrayList<Integer> apuesta) {
        this.nombre = nombre;
        this.apuesta = apuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getApuesta() {
        return apuesta;
    }

    @Override
    public String toString() {
        StringBuilder apuestaCadena = new StringBuilder();
        for (Integer apuesta : this.apuesta) {
            apuestaCadena.append(apuesta);
        }
        return this.nombre+" -> "+apuestaCadena;
    }
}
