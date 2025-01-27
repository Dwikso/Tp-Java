/**
 * FileDeCartes
 *
 * @author Pellosse Quentin
 * @version 1.0
 * 
 */

public class FileDeCartes {
  private String[] file;
  private int tete;
  private int queue;
  private int taille;
  private static final int CAPACITE_MAX = 52;

  public FileDeCartes() {
    file = new String[CAPACITE_MAX];
    tete = 0;
    queue = 0;
    taille = 0;
  }

  public void ajouter(String carte) {
    if (taille == CAPACITE_MAX) {
      System.out.println("Erreur : la file est pleine");
    }

    file[queue] = carte;
    queue = (queue + 1) % CAPACITE_MAX;
    taille++;
  }

  public String retirerCarte() {
    if (taille == 0) {
      System.out.println("Erreur : la file est vide");
    }
    String carte = file[tete];
    file[tete] = null;
    tete = (tete + 1) % CAPACITE_MAX;
    taille--;
    return carte;
  }

  public boolean estVide() {
    return taille == 0;
  }

  public int taille() {
    return taille;
  }

  public void afficherFile() {
    if (taille == 0) {
      System.out.println("La file est vide");
      return;
    }
    System.out.println("File (du tete vers la queue) :");
    for (int i = tete; i < queue; i++) {
      System.out.println("- " + file[i]);
    }
  }

}
