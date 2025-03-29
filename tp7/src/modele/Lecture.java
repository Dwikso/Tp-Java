package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
  public static List<String> lireCarte(String cheminFichier) {
    List<String> lignes = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
      String ligne;
      while ((ligne = reader.readLine()) != null) {
        lignes.add(ligne);
      }
    } catch (IOException e) {
      System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }
    return lignes;
  }
}
