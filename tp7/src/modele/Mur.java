package modele;

/**
 * Classe représentant un mur dans le jeu
 * Le joueur ne peut pas traverser les murs
 */
public class Mur extends Case {
  @Override
  public char getChar() {
    return '#';
  }
}
