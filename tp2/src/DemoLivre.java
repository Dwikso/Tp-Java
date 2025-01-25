/**
 * Classe de démonstration pour tester les fonctionnalités de la classe Livre.
 * 
 * @author Pellosse Quentin
 * @version 1.0
 *
 */

public class DemoLivre {

    /**
     * Méthode main.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        Livre livre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", 1,
                Genre.LITTERATURE_FRANCAISE);

        System.out.println("=== Informations du livre ===");
        System.out.println(livre);

        Livre autreLivre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", 1,
                Genre.LITTERATURE_FRANCAISE);
        System.out.println("\n=== Est représentatif d'une autre œuvre ? ===");
        System.out.println("Résultat : " + livre.estRepresentatif(autreLivre));

        Livre autreLivre2 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", 1,
                Genre.LITTERATURE_FRANCAISE);
        System.out.println("\n=== Les deux livres sont-ils identiques ? ===");
        System.out.println("Résultat : " + livre.equals(autreLivre2));

        Livre nouveauLivre = livre.nouvelEditeur("Folio");
        System.out.println("\n=== Nouveau livre avec un éditeur différent ===");
        System.out.println(nouveauLivre);

        System.out.println("\n=== Ajout d'exemplaires ===");
        livre.ajouterExemplaires(2);
        System.out.println(livre);

        System.out.println("\n=== Retirer un exemplaire ===");
        livre.retirerExemplaire();
        System.out.println(livre);

        System.out.println("\n=== Le livre est-il encore présent dans la bibliothèque ? ===");
        System.out.println("Résultat : " + livre.estPresent());
    }
}
