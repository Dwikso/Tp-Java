/**
 * PileDeCartes
 *
 * @author Pellosse Quentin
 * @version 1.0
 */
public class PileDeCartes {
  private Carte[] pile;
  private static final int CAPACITE_MAX = 52;
  private int sommet;

  /*
   * Constructeur de la classe PileDeCartes
   */
  public PileDeCartes() {
    pile = new Carte[CAPACITE_MAX];
    sommet = 0;
  }

  /**
   * Méthode pour ajouter une carte à la pile
   * 
   * @param carte la carte à ajouter
   */
  public void ajouter(Carte carte) {
    if (sommet >= CAPACITE_MAX) {
      System.out.println("Erreur : la pile est pleine");
      return;
    }
    pile[sommet] = carte;
    sommet++;
  }

  /**
   * Méthode pour retirer une carte de la pile
   * 
   * @return la carte retirée
   */
  public Carte retirerCarte() {
    if (estVide()) {
      System.out.println("Erreur : la pile est vide");
      return null;
    }
    sommet--;
    Carte carte = pile[sommet];
    pile[sommet] = null;
    return carte;
  }

  /**
   * Méthode pour vérifier si la pile est vide
   * 
   * @return true si la pile est vide, false sinon
   */
  public boolean estVide() {
    return sommet == 0;
  }

  /**
   * Méthode pour obtenir la taille de la pile
   * 
   * @return la taille de la pile
   */
  public int taille() {
    return sommet;
  }

  /**
   * Méthode pour afficher la pile
   */
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
