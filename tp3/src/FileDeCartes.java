/**
 * FileDeCartes
 *
 * @author Pellosse Quentin
 * @version 1.0
 * 
 */
public class FileDeCartes {
  private Carte[] file;
  private int tete;
  private int queue;
  private int taille;
  private static final int CAPACITE_MAX = 52;

  public FileDeCartes() {
    file = new Carte[CAPACITE_MAX];
    tete = 0;
    queue = 0;
    taille = 0;
  }

  /**
   * Méthode pour ajouter une carte à la file
   * 
   * @param carte la carte à ajouter
   */
  public void ajouter(Carte carte) {
    if (taille == CAPACITE_MAX) {
      System.out.println("Erreur : la file est pleine");
      return;
    }

    file[queue] = carte;
    queue = (queue + 1) % CAPACITE_MAX;
    taille++;
  }

  /**
   * Méthode pour retirer une carte de la file
   * 
   * @return la carte retirée
   */
  public Carte retirerCarte() {
    if (taille == 0) {
      System.out.println("Erreur : la file est vide");
      return null;
    }
    Carte carte = file[tete];
    file[tete] = null;
    tete = (tete + 1) % CAPACITE_MAX;
    taille--;
    return carte;
  }

  /**
   * Méthode pour vérifier si la file est vide
   * 
   * @return true si la file est vide, false sinon
   */
  public boolean estVide() {
    return taille == 0;
  }

  /**
   * Méthode pour obtenir la taille de la file
   * 
   * @return la taille de la file
   */
  public int taille() {
    return taille;
  }

  /**
   * Méthode pour afficher la file
   */
  public void afficherFile() {
    if (taille == 0) {
      System.out.println("La file est vide");
      return;
    }

    System.out.println("File (du tête vers la queue) :");
    for (int i = 0; i < taille; i++) {
      int index = (tete + i) % CAPACITE_MAX;
      System.out.println("- " + file[index]);
    }
  }
}
