/**
 * Demo Class Hauteur
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class DemoHauteur {
  /**
   * Méthode main
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Parcours de toutes les valeurs de l'énumération Hauteur
    for (Hauteur hauteur : Hauteur.values()) {
      // Affichage de chaque hauteur (symbole)
      System.out.println(hauteur.toString() + " : " + hauteur.getRang());
    }
  }
}
