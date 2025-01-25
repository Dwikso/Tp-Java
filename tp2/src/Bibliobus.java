/**
 * Classe Bibliobus
 * 
 * @author Pellosse Quentin
 * @version 1.0
 *
 */
public class Bibliobus {

    /**
     * Nom du bibliobus.
     */
    private final String nomBus;

    /**
     * Taille maximale du catalogue de livres.
     */
    private final int tailleCatalogue;

    /**
     * Tableau contenant les livres du catalogue.
     */
    private final Livre[] catalogue;

    /**
     * Nombre de livres actuellement dans le catalogue.
     */
    private int nbLivres;

    /**
     * Constructeur de la classe Bibliobus.
     * 
     * @param nomBus          Le nom du bibliobus.
     * @param tailleCatalogue La taille maximale du catalogue.
     */
    public Bibliobus(String nomBus, int tailleCatalogue) {
        this.nomBus = nomBus;
        this.tailleCatalogue = tailleCatalogue;
        this.catalogue = new Livre[tailleCatalogue];
        this.nbLivres = 0;
    }

    /**
     * Recherche l'indice d'un livre dans le catalogue à partir de son titre, auteur
     * et éditeur.
     * 
     * @param titre   Titre du livre.
     * @param auteur  Auteur du livre.
     * @param editeur Éditeur du livre.
     * @return L'indice du livre s'il existe, sinon -1.
     */
    public int indiceLivre(String titre, String auteur, String editeur) {
        for (int i = 0; i < nbLivres; i++) {
            Livre livre = catalogue[i];
            if (livre.getTitre().equals(titre) &&
                    livre.getAuteur().equals(auteur) &&
                    livre.getEditeur().equals(editeur)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Vérifie si un livre appartient déjà au catalogue.
     * 
     * @param titre   Titre du livre.
     * @param auteur  Auteur du livre.
     * @param editeur Éditeur du livre.
     * @return true si le livre existe, false sinon.
     */
    public boolean appartient(String titre, String auteur, String editeur) {
        return indiceLivre(titre, auteur, editeur) != -1;
    }

    /**
     * Ajoute un livre au catalogue.
     * 
     * @param titre       Titre du livre.
     * @param auteur      Auteur du livre.
     * @param editeur     Éditeur du livre.
     * @param genreString Genre du livre (sous forme de chaîne de caractères).
     * @return true si l'ajout est réussi, false sinon.
     */
    public boolean ajouterLivre(String titre, String auteur, String editeur, String genreString) {
        if (nbLivres >= tailleCatalogue) {
            System.out.println("Catalogue plein, impossible d'ajouter le livre.");
            return false;
        }
        if (appartient(titre, auteur, editeur)) {
            System.out.println("Le livre existe déjà dans le catalogue.");
            return false;
        }

        Genre genre = Genre.valueOf(genreString.toUpperCase());

        catalogue[nbLivres++] = new Livre(titre, auteur, editeur, 1, genre);
        return true;
    }

    /**
     * Ajoute un livre ou met à jour le nombre d'exemplaires s'il existe déjà.
     * 
     * @param titre         Titre du livre.
     * @param auteur        Auteur du livre.
     * @param editeur       Éditeur du livre.
     * @param genreString   Genre du livre (sous forme de chaîne de caractères).
     * @param nbExemplaires Nombre d'exemplaires à ajouter.
     * @return true si l'opération est réussie, false sinon.
     */
    public boolean ajouterOuMettreAJourLivre(String titre, String auteur, String editeur, String genreString,
            int nbExemplaires) {
        int index = indiceLivre(titre, auteur, editeur);
        if (index != -1) {
            catalogue[index].ajouterExemplaires(nbExemplaires);
            return true;
        }
        if (nbLivres >= tailleCatalogue) {
            System.out.println("Catalogue plein, impossible d'ajouter le livre.");
            return false;
        }

        Genre genre = Genre.valueOf(genreString.toUpperCase());

        catalogue[nbLivres++] = new Livre(titre, auteur, editeur, nbExemplaires, genre);
        return true;
    }

    /**
     * Affiche les informations sur tous les livres du catalogue.
     * 
     * @return Une chaîne de caractères contenant les informations sur les livres.
     */
    public String afficheCatalogue() {
        if (nbLivres == 0) {
            return "Le catalogue est vide.";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nbLivres; i++) {
            Livre livre = catalogue[i];
            result.append(livre.getTitre()).append("\n");
            result.append(livre.getAuteur()).append("\n");
            result.append(livre.getEditeur()).append("\n");
            result.append(livre.getGenre()).append("\n");
            result.append(livre.getNbExemplaires()).append("\n\n");
        }
        return result.toString();
    }

    /**
     * Retourne le nom du bibliobus.
     * 
     * @return Le nom du bibliobus.
     */
    public String getNomBus() {
        return nomBus;
    }

    /**
     * Retourne la taille maximale du catalogue.
     * 
     * @return La taille maximale du catalogue.
     */
    public int getTailleCatalogue() {
        return tailleCatalogue;
    }

    /**
     * Retourne le titre d'un livre à partir de son identifiant.
     * 
     * @param identifiant Identifiant du livre.
     * @return Le titre du livre.
     */
    public String getTitre(int identifiant) {
        return catalogue[identifiant].getTitre();
    }

    /**
     * Retourne l'auteur d'un livre à partir de son identifiant.
     * 
     * @param identifiant Identifiant du livre.
     * @return L'auteur du livre.
     */
    public String getAuteur(int identifiant) {
        return catalogue[identifiant].getAuteur();
    }

    /**
     * Retourne l'éditeur d'un livre à partir de son identifiant.
     * 
     * @param identifiant Identifiant du livre.
     * @return L'éditeur du livre.
     */
    public String getEditeur(int identifiant) {
        return catalogue[identifiant].getEditeur();
    }

    /**
     * Retourne le genre d'un livre à partir de son identifiant.
     * 
     * @param identifiant Identifiant du livre.
     * @return Le genre du livre.
     */
    public String getGenre(int identifiant) {
        return catalogue[identifiant].getGenre().toString();
    }

    /**
     * Retourne le nombre d'exemplaires d'un livre à partir de son identifiant.
     * 
     * @param identifiant Identifiant du livre.
     * @return Le nombre d'exemplaires.
     */
    public int getNbExemplaires(int identifiant) {
        return catalogue[identifiant].getNbExemplaires();
    }

    /**
     * Affiche les informations d'un livre donné par son identifiant.
     * 
     * @param identifiant L'identifiant du livre.
     * @return Les informations sur le livre ou un message d'erreur si l'identifiant
     *         est incorrect.
     */
    public String afficheLivre(int identifiant) {
        if (identifiant < 0 || identifiant >= nbLivres) {
            return "L'identifiant est incorrect.";
        }
        Livre livre = catalogue[identifiant];
        return livre.getTitre() + "\n" +
                livre.getAuteur() + "\n" +
                livre.getEditeur() + "\n" +
                livre.getGenre() + "\n" +
                livre.getNbExemplaires() + "\n";
    }

    /**
     * Fusionne un autre catalogue avec celui du bibliobus actuel.
     * Si des livres sont identiques, le nombre d'exemplaires est mis à jour.
     * 
     * @param bib Le bibliobus à fusionner.
     */
    public void fusion(Bibliobus bib) {
        for (int i = 0; i < bib.nbLivres; i++) {
            Livre livre = bib.catalogue[i];
            ajouterOuMettreAJourLivre(livre.getTitre(), livre.getAuteur(), livre.getEditeur(),
                    livre.getGenre().toString(), livre.getNbExemplaires());
        }
    }

    /**
     * Trie le catalogue des livres par ordre alphabétique des titres.
     */
    public void trierCatalogue() {
        for (int i = 0; i < this.nbLivres; i++) {
            int minIndex = i;

            for (int j = i + 1; j < this.nbLivres; j++) {
                if (catalogue[j].comparerTo(catalogue[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Livre temp = catalogue[i];
                catalogue[i] = catalogue[minIndex];
                catalogue[minIndex] = temp;
            }
        }
    }
}
