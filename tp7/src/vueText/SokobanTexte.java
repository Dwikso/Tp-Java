package vueText;

import java.util.Scanner;
import modele.Carte;
import modele.Lecture;
import modele.Direction;

/**
 * Classe représentant l'interface en mode texte du jeu Sokoban
 * Permet de jouer au jeu via la console
 */
public class SokobanTexte {
  private Carte carte; // La carte du jeu

  /**
   * Constructeur initialisant le jeu avec une carte
   * 
   * @param fichierCarte Chemin du fichier contenant la carte
   */
  public SokobanTexte(String fichierCarte) {
    carte = new Carte(Lecture.lireCarte(fichierCarte));
  }

  /**
   * Démarre la partie en mode texte
   * Gère la boucle de jeu et les entrées utilisateur
   */
  public void jouer() {
    Scanner scanner = new Scanner(System.in);
    boolean partieEnCours = true;

    while (partieEnCours) {
      // Affichage de la carte
      carte.afficherCarte();

      // Vérification si le niveau est terminé
      if (carte.estTerminee()) {
        System.out.println("Niveau terminé !");
        partieEnCours = false;
        continue;
      }

      // Lecture de la commande du joueur
      System.out.print("Entrez une commande (h: haut, b: bas, g: gauche, d: droite, q: quitter) : ");
      String commande = scanner.nextLine();

      // Traitement de la commande
      switch (commande.toLowerCase()) {
        case "h" -> carte.deplacerJoueur(Direction.HAUT);
        case "b" -> carte.deplacerJoueur(Direction.BAS);
        case "g" -> carte.deplacerJoueur(Direction.GAUCHE);
        case "d" -> carte.deplacerJoueur(Direction.DROITE);
        case "q" -> partieEnCours = false;
        default -> System.out.println("Commande invalide !");
      }
    }

    scanner.close();
  }

  /**
   * Point d'entrée du programme en mode texte
   * 
   * @param args Arguments de la ligne de commande (non utilisés)
   */
  public static void main(String[] args) {
    SokobanTexte jeu = new SokobanTexte("bin/map/map1.txt");
    jeu.jouer();
  }
}
