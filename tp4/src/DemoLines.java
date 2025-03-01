import guilines.Lines;
import guilines.IJeuDesBilles;

/**
 * Classe de démonstration pour le jeu des billes.
 */
public class DemoLines {
    /**
     * Méthode principale pour lancer l'application.
     * @param args Arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        IJeuDesBilles monJeu = new MonJeu();
        Lines fenetre = new Lines("LILines", monJeu);
    }
}
