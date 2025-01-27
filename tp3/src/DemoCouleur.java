/**
 * Teste la classe Couleur.
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class DemoCouleur {

  /**
   * Méthode main
   * 
   * @param args
   */
  public static void main(String[] args) {

    // Parcours de toutes les valeurs de l'énumération Couleur
    for (Couleur couleur : Couleur.values()) {
      // Affichage de chaque couleur (symbole)r
      System.out.println(couleur);
    }
  }
}
