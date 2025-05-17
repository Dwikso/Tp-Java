package modele;

/**
 * Classe représentant un sol avec une caisse
 * Le joueur peut pousser les caisses sur les sols
 */
public class Caisse extends Case {
  @Override
  public char getChar() {
    return '$';
  }
}
