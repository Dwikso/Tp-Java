/*
 * Classe DemoFileDeCartes
 *
 * @author Pellosse Quentin
 * @version 1.0
 */

public class DemoFileDeCartes {
  public static void main(String[] args) {
    FileDeCartes file = new FileDeCartes(); // Création d'une file de cartes

    file.ajouter(new Carte(Hauteur.AS, Couleur.PIQUE));
    file.ajouter(new Carte(Hauteur.DEUX, Couleur.COEUR));
    file.ajouter(new Carte(Hauteur.TROIS, Couleur.CARREAU));

    // Afficher la file avant retrait
    file.afficherFile();

    System.out.println("Carte retirée : " + file.retirerCarte());

    file.afficherFile();

    System.out.println("Carte retirée : " + file.retirerCarte());

    // Afficher la file après retrait
    file.afficherFile();

    // Vérifier la taille de la file
    System.out.println("Nombre de cartes dans la file : " + file.taille());

    // Vérifier si la file est vide
    System.out.println("La file est vide : " + file.estVide());
  }
}
