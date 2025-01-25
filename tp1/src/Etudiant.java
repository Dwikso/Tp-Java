/**
 * Classe qui modélise la gestion d'un étudiant dans une université.
 * 
 * @author Pellosse Quentin
 * @version 1.0
 */

public class Etudiant {
  public final static int MAXNOTES = 5;
  public final static int MINVALUE = 0;
  public final static int MAXVALUE = 20;
  public final static int NBNOTESREQUISES = 5;

  private boolean admis = false;

  private String nom;
  private String prenom;

  // private Formation formation;

  private float[] lesNotes = new float[MAXNOTES];
  private int nbNote = 0;

  /**
   * Constructeur d'un étudiant.
   * 
   * @param nom    : le nom de l'étudiant.
   * @param prenom : le prénom de l'étudiant.
   */

  public Etudiant(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
  }

  /**
   * accesseur pour le nom de l'étudiant
   * 
   * @return le nom de l'étudiant
   */
  public String getNom() {
    return nom;
  }

  /**
   * accesseur pour le prénom de l'étudiant
   * 
   * @return le prénom de l'étudiant
   */

  public String getPrenom() {
    return prenom;
  }

  /**
   * retourne une présentation textuelle de l'étudiant
   * son nom, son prenom, son nombre de notes
   */

  public String toString() {
    return prenom + " " + nom + ", " + nbNote + " note(s)" + " admis : " + admis;
  }

  /**
   * ajoute une note à l'étudiant dans la limite de la capacité de l'étudiant
   * 
   * @param note : la note qu'on veut ajouter à l'étudiant
   * @return vrai si l'ajout a pu être fait
   */

  public boolean ajouteNote(float note) {
    if (estAdmis()) {
      System.out.println("L'étudiant est déjà admis");
    }
    if (nbNote < lesNotes.length) {
      lesNotes[nbNote] = note;
      nbNote++;
      return true;
    }
    return false;
  }

  /**
   * retourne le nombre de notes de l'étudiant
   *
   * @return le nombre de notes de l'étudiant
   */

  public int getNbNote() {
    return nbNote;
  }

  /**
   * Calcule la moyenne des notes de l'étudiant
   *
   * @param prend le tableau de notes de l'étudiant
   * @return la moyenne des notes de l'étudiant
   */

  public float calculeMoyenne() {
    if (nbNote == 0) {
      System.out.println("Aucune note pour calculer la moyenne");
      return 0;
    }
    float somme = 0;
    for (int i = 0; i < lesNotes.length; i++) {
      somme += lesNotes[i];
    }
    return somme / nbNote;
  }

  /**
   * Renvoie vrai si l'étudiant est admis
   *
   * @return true si l'étudiant est admis
   */

  public boolean estAdmis() {
    if (calculeMoyenne() >= 10) {
      this.admis = true;
      return true;
    }
    return false;
  }
}
