package modele;

public class Joueur {
  private int x, y;

  public Joueur(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void deplacer(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  public char getChar() {
    return '@';
  }

}
