public enum Couleur {
  PIQUE("\u2660"), // symbole associé à la couleur pique
  COEUR("\u2665"), // symbole associé à la couleur coeur
  CARREAU("\u2666"), // symbole associé à la couleur carreau
  TREFLE("\u2663"); // symbole associé à la couleur trefle

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
