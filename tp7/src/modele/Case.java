package modele;

/**
 * Classe abstraite représentant une case du jeu
 * Sert de base pour tous les types de cases (Mur, Sol, Destination, etc.)
 */
public abstract class Case {
  /**
   * @return Le caractère représentant la case
   */
  public abstract char getChar();
}
