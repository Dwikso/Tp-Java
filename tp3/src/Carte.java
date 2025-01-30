/*
 * Classe Carte
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class Carte {
  private final Hauteur rang; // le rang de la carte
  private final Couleur couleur; // la couleur de la carte

  public Carte(Hauteur rang, Couleur couleur) {
    this.rang = rang; // initialisation du rang de la carte
    this.couleur = couleur; // initialisation de la couleur de la carte
  }

  /*
   * Accesseurs pour obtenir le rang de la carte
   * 
   * @return le rang de la carte
   */
  public Hauteur getRang() {
    return this.rang;
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
   * 
   * @return une chaîne de caractères représentant la carte
   */
  @Override
  public String toString() {
    return rang + " de " + couleur;
  }
}
