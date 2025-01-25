/**
 * Classe qui permet de lancer une application de test sur l'étudiant.
 * 
 * @author Pellosse Quentin
 * @version 1.0
 */

public class TestEtudiant {
  public static void main(String[] args) {
    Etudiant e1 = new Etudiant("Dupont", "Jean");
    Etudiant e2 = new Etudiant("Durand", "Paul");
    System.out.println(e1);
    System.out.println(e2);
    e1.ajouteNote(15);
    e2.ajouteNote(17);
    e1.ajouteNote(1);
    e2.ajouteNote(8);
    e1.calculeMoyenne();
    e2.calculeMoyenne();
    e1.estAdmis();
    e2.estAdmis();
    System.out.println(e1);
    System.out.println(e2);

  }
}
