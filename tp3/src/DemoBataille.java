/*
 * Classe DemoBataille
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class DemoBataille {
    public static void main(String[] args) {
        Bataille bataille = new Bataille();
        System.out.println("Début de la partie");
        bataille.jouerPartie();
        System.out.println("Fin de la partie");
    }
}
