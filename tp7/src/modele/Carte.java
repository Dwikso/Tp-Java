package modele;

import java.util.List;

/**
 * Classe représentant la carte du jeu Sokoban
 * Gère le plateau de jeu, le joueur et les règles de déplacement
 */
public class Carte {
  private int largeur, hauteur; // Dimensions de la carte
  private Case[][] plateau; // Plateau de jeu contenant les cases
  private Joueur joueur; // Le joueur sur la carte

  /**
   * Constructeur qui initialise la carte à partir d'une liste de lignes
   * 
   * @param lignes Liste des lignes représentant la carte
   */
  public Carte(List<String> lignes) {
    this.hauteur = lignes.size();
    this.largeur = lignes.get(0).length();
    this.plateau = new Case[hauteur][largeur];

    // Parcours de chaque ligne pour créer le plateau
    for (int y = 0; y < hauteur; y++) {
      String ligne = lignes.get(y);
      for (int x = 0; x < largeur; x++) {
        char c = ligne.charAt(x);
        // Création des cases en fonction du caractère lu
        switch (c) {
          case '#' -> plateau[y][x] = new Mur(); // Mur
          case '.' -> plateau[y][x] = new Destination(); // Destination
          case '$' -> plateau[y][x] = new Caisse(); // Caisse sur sol
          case '*' -> plateau[y][x] = new DestinationAvecCaisse(); // Caisse sur destination
          case '@' -> { // Joueur sur sol
            plateau[y][x] = new Sol();
            joueur = new Joueur(x, y);
          }
          case '+' -> { // Joueur sur destination
            plateau[y][x] = new Destination();
            joueur = new Joueur(x, y);
          }
          default -> plateau[y][x] = new Sol(); // Sol vide
        }
      }
    }
  }

  /**
   * Affiche la carte dans la console
   */
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

  /**
     * Déplace le joueur dans la direction spécifiée.
     * Gère les collisions avec les murs et le déplacement des caisses.
     *
     * @param direction Direction dans laquelle déplacer le joueur
     */
    public void deplacerJoueur(Direction direction) {
        int newX = joueur.getX() + direction.getDx();
        int newY = joueur.getY() + direction.getDy();

        Case caseDevant = plateau[newY][newX];

        // Vérification si c'est un mur
        if (caseDevant instanceof Mur) {
            return;
        }

        // Vérification si c'est une caisse
        if (caseDevant instanceof Caisse || caseDevant instanceof DestinationAvecCaisse) {
            int derriereX = newX + direction.getDx();
            int derriereY = newY + direction.getDy();


            Case caseDerriere = plateau[derriereY][derriereX];

            // Vérifier si la caisse peut être poussée
            if (caseDerriere instanceof Sol || caseDerriere instanceof Destination) {
                plateau[newY][newX] = (caseDevant instanceof DestinationAvecCaisse) ? new Destination() : new Sol();
                plateau[derriereY][derriereX] = (caseDerriere instanceof Destination) ? new DestinationAvecCaisse() : new Caisse();
            } else {
                return;
            }
        }

        // Déplacement du joueur
        joueur.deplacer(direction.getDx(), direction.getDy());
    }


  /**
   * Vérifie si le niveau est terminé (toutes les destinations sont occupées)
   * 
   * @return true si le niveau est terminé, false sinon
   */
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


  /**
   * @return La largeur de la carte
   */
  public int getLargeur() {
    return largeur;
  }

  /**
   * @return La hauteur de la carte
   */
  public int getHauteur() {
    return hauteur;
  }

  /**
   * @return La direction actuelle du joueur
   */
  public Direction getDirectionJoueur() {
    return joueur.getDirection();
  }

  /**
   * Retourne le caractère à afficher à une position donnée
   * 
   * @param x Position horizontale
   * @param y Position verticale
   * @return Le caractère à afficher
   */
  public char getChar(int x, int y) {
    if (joueur.getX() == x && joueur.getY() == y) {
      return joueur.getChar();
    }
    return plateau[y][x].getChar();
  }
}
