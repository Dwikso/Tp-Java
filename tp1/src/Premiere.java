/**
 * Ma première classe en Java *
 * 
 * @author Pellosse Quentin
 * @version 1.0
 */

public class Premiere {
  private String message = "Bonjour le monde";

  /**
   * On utilise le constructeur par défaut
   */

  public Premiere() {
  }

  /**
   * Constrcteur avec paramètre
   * 
   * @param message Message initial à attribuer
   */
  public Premiere(String message) {
    this.message = message;
  }

  /**
   * Acceseur pour le MessageDigest
   * 
   * @return le MessageDigest
   */

  public String getMessage() {
    return message;
  }

  /**
   * Méthode pour modifier le MessageDigest
   * 
   * @param message Message à attribuer
   */

  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Cette methode affiche le contenue
   * message à l'écran
   */

  public void affiche() {
    System.out.println(message);
  }

  /**
   * Méthode principale de mon premier programme
   * 
   * @param args Arguments de la ligne de commande
   */

  public static void main(String[] args) {
    Premiere prem = new Premiere();
    prem.affiche();

    Premiere premParam = new Premiere("Bienvenue en Java");
    premParam.affiche();

    prem.setMessage("Message modifié");
    System.out.println("Message actuel : " + prem.getMessage());
    prem.affiche();

  }

}
