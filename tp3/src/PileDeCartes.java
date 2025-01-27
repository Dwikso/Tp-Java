/**
 * PileDeCartes
 *
 * @author Pellosse Quentin
 * @version 1.1
 */
public class PileDeCartes {
  private String[] pile;
  private static final int CAPACITE_MAX = 52;
  private int sommet; // Indique l'indice où la prochaine carte sera ajoutée

  // Constructeur
  public PileDeCartes() {
    pile = new String[CAPACITE_MAX];
    sommet = 0; // Initialise la pile comme vide
  }

  // Ajouter une carte sur le sommet de la pile
  public void ajouter(String carte) {
    if (sommet >= CAPACITE_MAX) {
      System.out.println("Erreur : la pile est pleine");
      return;
    }
    pile[sommet] = carte; // Ajoute la carte à l'indice sommet
    sommet++; // Augmente le sommet
  }

  // Retirer la carte au sommet de la pile
  public String retirerCarte() {
    if (estVide()) {
      System.out.println("Erreur : la pile est vide");
      return null; // Retourne null si la pile est vide
    }
    sommet--; // Réduit le sommet
    String carte = pile[sommet]; // Récupère la carte au sommet
    pile[sommet] = null; // Supprime la référence pour libérer de la mémoire
    return carte;
  }

  // Vérifier si la pile est vide
  public boolean estVide() {
    return sommet == 0;
  }

  // Obtenir le nombre actuel de cartes dans la pile
  public int taille() {
    return sommet;
  }

  // Afficher les cartes dans la pile (optionnel, utile pour débogage)
  public void afficherPile() {
    if (estVide()) {
      System.out.println("La pile est vide");
      return;
    }
    System.out.println("Pile (du sommet vers la base) :");
    for (int i = sommet - 1; i >= 0; i--) {
      System.out.println("- " + pile[i]);
    }
  }
}
