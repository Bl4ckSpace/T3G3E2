package guardadoApuestas;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {
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
        return this.nombre+" -> "+this.apuesta;
    }
}
