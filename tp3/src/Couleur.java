public enum Couleur {
  PIQUE("\u2660"),
  COEUR("\u2665"),
  CARREAU("\u2666"),
  TREFLE("\u2663");

  // SYmbole associé à la couleur
  private final String symbole;

  /*
   * Constructeur de la classe Couleur
   * 
   * @param symbole le symbole associé à la couleur
   */
  Couleur(String symbole) {
    this.symbole = symbole;
  }

  /*
   * Méthode pour obtenir le symbole associé à la couleur
   * 
   * @return le symbole associé à la couleur
   */
  public String toString() {
    return symbole;
  }
}
