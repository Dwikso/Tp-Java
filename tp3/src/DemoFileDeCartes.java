public class DemoFileDeCartes {
  public static void main(String[] args) {
    FileDeCartes file = new FileDeCartes();

    // Ajouter des cartes à la pile
    file.ajouter("As de Coeur");
    file.ajouter("Roi de Pique");
    file.ajouter("Dame de Trèfle");

    // Afficher la pile
    file.afficherFile();

    // Retirer une carte
    System.out.println("Carte retirée : " + file.retirerCarte());

    // Afficher la pile après le retrait
    file.afficherFile();

    // Vérifier la taille de la pile
    System.out.println("Nombre de cartes dans la pile : " + file.taille());

    // Vérifier si la pile est vide
    System.out.println("La pile est vide : " + file.estVide());
  }
}
