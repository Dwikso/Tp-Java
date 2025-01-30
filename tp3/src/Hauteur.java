public enum Hauteur {
  DEUX(2),
  TROIS(3),
  QUATRE(4),
  CINQ(5),
  SIX(6),
  SEPT(7),
  HUIT(8),
  NEUF(9),
  DIX(10),
  VALET(11),
  DAME(12),
  ROI(13),
  AS(14);

  private final int valeur; // rang de la carte

  /*
   * Constructeur de la classe Hauteur
   *
   * @param valeur le rang de la carte
   */
  private Hauteur(int valeur) {
    this.valeur = valeur;
  }

  /*
   * Méthode pour obtenir le rang de la carte
   * 
   * @return le rang de la carte
   */
  @Override
  public String toString() {
    return this.name();
  }

  /*
   * Méthode pour obtenir le rang de la carte
   * 
   * @return le rang de la carte
   */
  public int getRang() {
    return this.valeur;
  }

}
