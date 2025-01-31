import java.util.Random;

/*
 * Classe Jeu
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class Jeu {

  // Tableau de cartes
  private final Carte[] cartes;
  private final Random random = new Random();
  private int indexCarte;

  /*
   * Constructeur de la classe Jeu
   */
  public Jeu() {
    cartes = new Carte[52];
    int index = 0;

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
      carte.toString();
    }
  }

  /**
   * Méthode pour mélanger les cartes
   */
  public void melanger() {
    for (int i = 0; i < cartes.length; i++) {
      int index = i + random.nextInt(cartes.length - i);
      Carte temp = cartes[i];
      cartes[i] = cartes[index];
      cartes[index] = temp;
    }
  }

  /*
   * Méthode pour retirer une carte
   * 
   * @return la carte retirée
   */
  public Carte retirerCarte() {
    if (indexCarte < cartes.length) {
      return cartes[indexCarte++];
    }
    return null;
  }

}
