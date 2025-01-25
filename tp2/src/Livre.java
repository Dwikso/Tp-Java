/**
 * Classe Livre
 * 
 * @author Pellosse Quentin
 * @version 1.0
 */

// Définition de l'énumération des genres

public class Livre {
    private final String titre; // Titre du livre
    private final String auteur; // Auteur du livre
    private final String editeur; // Éditeur du livre
    private int nbExemplaires; // Nombre d'exemplaires
    private final Genre genre; // Genre du livre

    /**
     * Constructeur de la classe Livre
     * 
     * @param titre         Le titre du livre
     * @param auteur        L'auteur du livre
     * @param editeur       L'éditeur du livre
     * @param nbExemplaires Le nombre d'exemplaires
     * @param genre         Le genre du livre
     */
    public Livre(String titre, String auteur, String editeur, int nbExemplaires, Genre genre) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.genre = genre;
        this.nbExemplaires = nbExemplaires;
    }

    /**
     * Affiche les informations du livre
     * 
     * @return Une chaîne de caractères contenant les informations du livre
     */
    public String toString() {
        return "Titre : " + titre + "\nAuteur : " + auteur + "\nEditeur : " + editeur +
                "\nExemplaires : " + nbExemplaires + "\nGenre : " + genre;
    }

    /**
     * Vérifie si un livre est identique à un autre livre
     * Deux livres sont identiques s'ils ont le même titre, auteur, éditeur, et
     * genre.
     * 
     * @param l L'autre objet à comparer
     * @return true si les deux livres sont identiques, false sinon
     */
    public boolean equals(Livre l) {
        if (l == null) {
            return false;
        }
        return this.titre.equals(l.titre) &&
                this.auteur.equals(l.auteur) &&
                this.editeur.equals(l.editeur);
    }

    /**
     * Vérifie si deux livres représentent la même œuvre.
     * Deux livres sont considérés comme représentatifs de la même œuvre s'ils ont
     * le même titre, le même auteur, et le même genre.
     * 
     * @param l L'autre livre à comparer
     * @return true si les deux livres représentent la même œuvre, false sinon
     */
    public boolean estRepresentatif(Livre l) {
        return this.titre.equals(l.titre) &&
                this.auteur.equals(l.auteur) &&
                this.genre == l.genre;
    }

    /**
     * Crée un nouveau livre avec le même titre, auteur, genre,
     * mais avec un éditeur différent et un seul exemplaire.
     * 
     * @param nouvelEditeur Le nouvel éditeur pour le livre
     * @return Un nouvel objet Livre avec le nouvel éditeur
     */
    public Livre nouvelEditeur(String nouvelEditeur) {
        return new Livre(this.titre, this.auteur, nouvelEditeur, 1, this.genre);
    }

    /**
     * Getter pour le titre
     * 
     * @return titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Getter pour l'auteur
     * 
     * @return auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Getter pour l'éditeur
     * 
     * @return editeur
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * Getter pour le nombre d'exemplaires
     * 
     * @return nbExemplaires
     */
    public int getNbExemplaires() {
        return nbExemplaires;
    }

    /**
     * Getter pour le genre
     * 
     * @return genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Incrémente le nombre d'exemplaires.
     * 
     * @param nb Le nombre d'exemplaires à ajouter
     */
    public void ajouterExemplaires(int nb) {
        if (nb > 0) {
            this.nbExemplaires += nb;
        }
    }

    /**
     * Incrémente le nombre d'exemplaires de 1.
     */
    public void incrementExemplaires() {
        this.nbExemplaires++;
    }

    /**
     * Décrémente le nombre d'exemplaires si possible.
     */
    public void retirerExemplaire() {
        if (this.nbExemplaires > 0) {
            this.nbExemplaires--;
        }
    }

    /**
     * Vérifie si le livre est présent dans la bibliothèque.
     * 
     * @return true si le livre est présent, false sinon
     */
    public boolean estPresent() {
        return this.nbExemplaires > 0;
    }

    /**
     * Compare le livre courant avec un autre livre.
     *
     * @param l le livre à comparer avec le livre courant
     * @return -1 si le livre courant est plus petit, 1 s'il est plus grand, 0 s'ils
     *         sont équivalent
     */
    public int comparerTo(Livre l) {
        int genreComparaison = this.getGenre().compareTo(l.getGenre());
        if (genreComparaison != 0) {
            return genreComparaison < 0 ? -1 : 1;
        }

        int auteurComparaison = this.getAuteur().compareTo(l.getAuteur());
        if (auteurComparaison != 0) {
            return auteurComparaison < 0 ? -1 : 1;
        }

        int titreComparaison = this.getTitre().compareTo(l.getTitre());
        if (titreComparaison != 0) {
            return titreComparaison < 0 ? -1 : 1;
        }
        return 0;
    }

}
