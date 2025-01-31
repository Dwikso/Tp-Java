/*
 * Classe DemoPileDeCartes
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class DemoPileDeCartes {
  public static void main(String[] args) {
    PileDeCartes pile = new PileDeCartes(); // Création d'une pile de cartes

    // Ajouter des cartes à la pile
    pile.ajouter(new Carte(Hauteur.AS, Couleur.PIQUE));
    pile.ajouter(new Carte(Hauteur.DEUX, Couleur.COEUR));
    pile.ajouter(new Carte(Hauteur.TROIS, Couleur.CARREAU));

    // Afficher la pile
    pile.afficherPile();

    // Retirer une carte
    System.out.println("Carte retirée : " + pile.retirerCarte());

    // Afficher la pile après le retrait
    pile.afficherPile();

    // Vérifier la taille de la pile
    System.out.println("Nombre de cartes dans la pile : " + pile.taille());

    // Vérifier si la pile est vide
    System.out.println("La pile est vide : " + pile.estVide());
  }
}
