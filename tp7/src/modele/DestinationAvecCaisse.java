package modele;

/**
 * Classe représentant une destination avec une caisse
 * Une caisse correctement placée sur une destination
 */
public class DestinationAvecCaisse extends Case {
  @Override
  public char getChar() {
    return '*';
  }
}
