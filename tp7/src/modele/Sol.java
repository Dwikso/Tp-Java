package modele;

/**
 * Classe représentant un sol vide dans le jeu
 * Le joueur peut se déplacer sur les sols
 */
public class Sol extends Case {
  @Override
  public char getChar() {
    return ' ';
  }
}
