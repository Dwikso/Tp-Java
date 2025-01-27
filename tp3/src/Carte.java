/*
 * Classe Carte
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class Carte {
  private final Hauteur rang;
  private final Couleur couleur;

  public Carte(Hauteur rang, Couleur couleur) {
    this.rang = rang;
    this.couleur = couleur;
  }

  /*
   * Accesseurs pour obtenir le rang de la carte
   * 
   * @return le rang de la carte
   */
  public Hauteur getRang() {
    return rang;
  }

  /*
   * Accesseurs pour obtenir la couleur de la carte
   * 
   * @return la couleur de la carte
   */
  public Couleur getCouleur() {
    return couleur;
  }

  /*
   * Méthode pour afficher la carte
   */
  public void afficher() {
    System.out.println("Carte de " + rang + " de couleur " + couleur);
  }
}
