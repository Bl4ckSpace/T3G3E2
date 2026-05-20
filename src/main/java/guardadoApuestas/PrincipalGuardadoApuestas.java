package guardadoApuestas;

public class PrincipalGuardadoApuestas {
    public static void main(String[] args) {
        GestionGuardadoApuestas gestionGuardadoApuestas = new GestionGuardadoApuestas();
        GestionApuestas gestionApuestas = new GestionApuestas();

        gestionGuardadoApuestas.guardarApuesta(gestionApuestas);
    }
}
