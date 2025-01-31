/*
 * Classe DemoCarte
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class DemoCarte {
  /**
   * Méthode main
   * 
   * @param args
   */
  public static void main(String[] args) {

    // Création de trois cartes
    Carte carte = new Carte(Hauteur.AS, Couleur.PIQUE);
    Carte carte2 = new Carte(Hauteur.DEUX, Couleur.COEUR);
    Carte carte3 = new Carte(Hauteur.TROIS, Couleur.CARREAU);

    // Affichage des cartes
    carte.toString();
    carte2.toString();
    carte3.toString();
  }
}
