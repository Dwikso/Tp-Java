package modele;

import java.util.List;

public class Carte {
  private int largeur, hauteur;
  private Case[][] plateau;
  private Joueur joueur;

  public Carte(List<String> lignes) {
    this.hauteur = lignes.size();
    this.largeur = lignes.get(0).length();
    this.plateau = new Case[hauteur][largeur];

    for (int y = 0; y < hauteur; y++) {
      String ligne = lignes.get(y);
      for (int x = 0; x < largeur; x++) {
        char c = ligne.charAt(x);
        switch (c) {
          case '#' -> plateau[y][x] = new Mur();
          case '.' -> plateau[y][x] = new Destination();
          case '$' -> plateau[y][x] = new SolAvecCaisse();
          case '*' -> plateau[y][x] = new DestinationAvecCaisse();
          case '@' -> {
            plateau[y][x] = new Sol();
            joueur = new Joueur(x, y);
          }
          case '+' -> {
            plateau[y][x] = new Destination();
            joueur = new Joueur(x, y);
          }
          default -> plateau[y][x] = new Sol();
        }
      }
    }
  }

  public void afficherCarte() {
    for (int y = 0; y < hauteur; y++) {
      for (int x = 0; x < largeur; x++) {
        if (joueur.getX() == x && joueur.getY() == y) {
          System.out.print(joueur.getChar());
        } else {
          System.out.print(plateau[y][x].getChar());
        }
      }
      System.out.println();
    }
  }

  public void deplacerJoueur(Direction direction) {
    int newX = joueur.getX() + direction.getDx();
    int newY = joueur.getY() + direction.getDy();

    if (newX < 0 || newX >= largeur || newY < 0 || newY >= hauteur) {
      return;
    }

    Case caseDevant = plateau[newY][newX];

    if (caseDevant instanceof Mur) {
      return;
    }

    if (caseDevant instanceof SolAvecCaisse || caseDevant instanceof DestinationAvecCaisse) {
      int derriereX = newX + direction.getDx();
      int derriereY = newY + direction.getDy();

      if (derriereX < 0 || derriereX >= largeur || derriereY < 0 || derriereY >= hauteur) {
        return;
      }

      Case caseDerriere = plateau[derriereY][derriereX];

      if (caseDerriere instanceof Sol || caseDerriere instanceof Destination) {
        plateau[newY][newX] = (caseDevant instanceof DestinationAvecCaisse) ? new Destination() : new Sol();

        plateau[derriereY][derriereX] = (caseDerriere instanceof Destination) ? new DestinationAvecCaisse()
            : new SolAvecCaisse();
      } else {
        return;
      }
    }

    joueur.deplacer(direction.getDx(), direction.getDy());
  }

  public boolean estTerminee() {
    for (int y = 0; y < hauteur; y++) {
      for (int x = 0; x < largeur; x++) {
        if (plateau[y][x] instanceof Destination) {
          return false;
        }
      }
    }
    return true;
  }
}
