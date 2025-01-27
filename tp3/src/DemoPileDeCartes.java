public class DemoPileDeCartes {
  public static void main(String[] args) {
    PileDeCartes pile = new PileDeCartes();

    // Ajouter des cartes à la pile
    pile.ajouter("As de Coeur");
    pile.ajouter("Roi de Pique");
    pile.ajouter("Dame de Trèfle");

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
