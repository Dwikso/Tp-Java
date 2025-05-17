package modele;

/**
 * Énumération représentant les directions possibles dans le jeu
 * Chaque direction est associée à un déplacement horizontal (dx) et vertical (dy)
 */
public enum Direction {
  HAUT(0, -1),    // Déplacement vers le haut
  BAS(0, 1),      // Déplacement vers le bas
  GAUCHE(-1, 0),  // Déplacement vers la gauche
  DROITE(1, 0);   // Déplacement vers la droite (

  private final int dx, dy;  // Composantes du vecteur de déplacement

  /**
   * Constructeur d'une direction
   * @param dx Déplacement horizontal (-1 pour gauche, 1 pour droite, 0 sinon)
   * @param dy Déplacement vertical (-1 pour haut, 1 pour bas, 0 sinon)
   */
  Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  /**
   * @return Le déplacement horizontal associé à cette direction
   */
  public int getDx() {
    return dx;
  }

  /**
   * @return Le déplacement vertical associé à cette direction
   */
  public int getDy() {
    return dy;
  }
}
