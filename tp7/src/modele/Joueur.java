package modele;

/**
 * Classe représentant le joueur dans le jeu Sokoban
 * Gère la position et la direction du joueur
 */
public class Joueur {
  private int x, y;              // Position du joueur sur la carte
  private Direction direction;   // Direction actuelle du joueur

  /**
   * Constructeur créant un joueur à une position donnée
   * @param x Position horizontale initiale
   * @param y Position verticale initiale
   */
  public Joueur(int x, int y) {
    this.x = x;
    this.y = y;
    this.direction = Direction.BAS; // Direction par défaut
  }

  /**
   * @return La position horizontale du joueur
   */
  public int getX() {
    return x;
  }

  /**
   * @return La position verticale du joueur
   */
  public int getY() {
    return y;
  }

  /**
   * Déplace le joueur d'une certaine distance
   * Met à jour sa direction en fonction du déplacement
   * @param dx Déplacement horizontal
   * @param dy Déplacement vertical
   */
  public void deplacer(int dx, int dy) {
    this.x += dx;
    this.y += dy;
    // Mise à jour de la direction en fonction du déplacement
    if (dx == 0 && dy == -1) direction = Direction.HAUT;
    else if (dx == 0 && dy == 1) direction = Direction.BAS;
    else if (dx == -1 && dy == 0) direction = Direction.GAUCHE;
    else if (dx == 1 && dy == 0) direction = Direction.DROITE;
  }

  /**
   * @return Le caractère représentant le joueur
   */
  public char getChar() {
    return '@';
  }

  /**
   * @return La direction actuelle du joueur
   */
  public Direction getDirection() {
    return direction;
  }
}
