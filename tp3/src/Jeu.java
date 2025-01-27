/*
 * Classe Jeu
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class Jeu {

  // Tableau de cartes
  private final Carte[] cartes;

  /*
   * Constructeur de la classe Jeu
   */
  public Jeu() {
    cartes = new Carte[52];
    int index = 0;

    // Remplissage du tableau de cartes
    for (Hauteur hauteur : Hauteur.values()) {
      for (Couleur couleur : Couleur.values()) {
        cartes[index] = new Carte(hauteur, couleur);
        index++;
      }
    }
  }

  /**
   * Méthode pour afficher le jeu
   */
  public void afficher() {
    for (Carte carte : cartes) {
      carte.afficher();
    }
  }
}
