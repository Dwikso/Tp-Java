package vueTexte;

import modele.Carte;
import modele.Direction;
import modele.Lecture;

import java.util.List;
import java.util.Scanner;

public class SokobanTexte {
  public static void main(String[] args) {
    List<String> carteLignes = Lecture.lireCarte("bin/map/map1.txt");
    Carte carte = new Carte(carteLignes);
    Scanner scanner = new Scanner(System.in);

    while (true) {
      carte.afficherCarte();
      System.out.println("Déplacez-vous avec Z (haut), S (bas), Q (gauche), D (droite) ou X pour quitter : ");
      char input = scanner.next().charAt(0);

      Direction direction = null;
      switch (Character.toUpperCase(input)) {
        case 'Z' -> direction = Direction.HAUT;
        case 'S' -> direction = Direction.BAS;
        case 'Q' -> direction = Direction.GAUCHE;
        case 'D' -> direction = Direction.DROITE;
        case 'X' -> {
          System.out.println("Fin du jeu !");
          return;
        }
        default -> System.out.println("Commande invalide !");
      }

      if (direction != null) {
        carte.deplacerJoueur(direction);
      }
      if (carte.estTerminee()) {
        carte.afficherCarte();
        System.out.println("Fin du jeu !");
        return;
      }
    }
  }
}
