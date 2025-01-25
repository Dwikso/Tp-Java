/**
 * Classe de démonstration pour tester les fonctionnalités de la classe
 * Bibliobus.
 * 
 * @author Pellosse Quentin
 * @version 1.0
 */
public class DemoBibliobus {

    /**
     * Point d'entrée principal pour la démonstration.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        Bibliobus bib1 = new Bibliobus("Bibliobus 1", 10);
        Bibliobus bib2 = new Bibliobus("Bibliobus 2", 10);

        bib1.ajouterLivre("Les Misérables", "Victor Hugo", "A. Lacroix", "roman");
        bib1.ajouterLivre("Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", "conte");
        bib1.ajouterLivre("1984", "George Orwell", "Secker & Warburg", "dystopie");

        bib2.ajouterLivre("L'Étranger", "Albert Camus", "Gallimard", "roman");
        bib2.ajouterLivre("1984", "George Orwell", "Secker & Warburg", "dystopie");

        System.out.println("Catalogue de " + bib1.getNomBus() + ":\n" + bib1.afficheCatalogue());
        System.out.println("Catalogue de " + bib2.getNomBus() + ":\n" + bib2.afficheCatalogue());

        System.out.println("Fusion des catalogues...");
        bib2.fusion(bib1);

        System.out.println("Catalogue fusionné de " + bib1.getNomBus() + ":\n" + bib1.afficheCatalogue());

        // Tri du catalogue fusionné
        System.out.println("Tri du catalogue...");
        bib1.trierCatalogue();
        System.out.println("Catalogue trié de " + bib1.getNomBus() + ":\n" + bib1.afficheCatalogue());

        String titreRecherche = "Le Petit Prince";
        String auteurRecherche = "Antoine de Saint-Exupéry";
        String editeurRecherche = "Gallimard";
        System.out.println("Recherche du livre \"" + titreRecherche + "\"...");
        boolean existe = bib1.appartient(titreRecherche, auteurRecherche, editeurRecherche);
        if (existe) {
            System.out.println("Le livre \"" + titreRecherche + "\" existe dans le catalogue.");
        } else {
            System.out.println("Le livre \"" + titreRecherche + "\" n'existe pas dans le catalogue.");
        }

        int identifiant = 1;
        System.out
                .println("Affichage du livre avec identifiant " + identifiant + ":\n" + bib1.afficheLivre(identifiant));
    }
}
