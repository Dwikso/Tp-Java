package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire pour la lecture des fichiers de carte
 * Permet de charger une carte depuis un fichier texte
 */
public class Lecture {
  /**
   * Lit un fichier de carte et retourne son contenu sous forme de liste de lignes
   * 
   * @param fichier Chemin du fichier à lire
   * @return Liste des lignes du fichier
   */
  public static List<String> lireCarte(String fichier) {
    List<String> lignes = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
      String ligne;
      while ((ligne = br.readLine()) != null) {
        lignes.add(ligne);
      }
    } catch (Exception e) {
      System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }
    return lignes;
  }
}
