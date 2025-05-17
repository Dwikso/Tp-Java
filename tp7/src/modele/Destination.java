package modele;

/**
 * Classe représentant une destination dans le jeu
 * Les caisses doivent être poussées sur les destinations pour terminer le niveau
 */
public class Destination extends Case {
  @Override
  public char getChar() {
    return '.';
  }
}
