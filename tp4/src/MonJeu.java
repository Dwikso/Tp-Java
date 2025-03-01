import guilines.IJeuDesBilles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe représentant le jeu des billes.
 */
public class MonJeu implements IJeuDesBilles {
    private int[][] grille;
    private final int taille = 9;
    private final int couleursUtilisees = 3;
    private Random random = new Random();
    private int[] nouvellesCouleurs;
    private int score = 0;
    private static final int VIDE = -1;

    /**
     * Constructeur de la classe MonJeu.
     * Initialise la grille et ajoute des billes aléatoires.
     */
    public MonJeu() {
        grille = new int[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = VIDE;
            }
        }
        genererNouvellesCouleurs();
        ajouterBillesAleatoires(5);
    }

    /**
     * Supprime les alignements de billes entre deux points donnés.
     * 
     * @param x1 Coordonnée x du premier point.
     * @param y1 Coordonnée y du premier point.
     * @param x2 Coordonnée x du deuxième point.
     * @param y2 Coordonnée y du deuxième point.
     */
    public void supprimerAllignement(int x1, int y1, int x2, int y2) {
        // Implémentation à ajouter
    }

    /**
     * Retourne la couleur de la bille à la position donnée.
     * 
     * @param lig Ligne de la grille.
     * @param col Colonne de la grille.
     * @return Couleur de la bille.
     */
    public int getCouleur(int lig, int col) {
        return grille[lig][col];
    }

    /**
     * Retourne le nombre de billes ajoutées.
     * 
     * @return Nombre de billes ajoutées.
     */
    public int getNbBillesAjoutees() {
        return 3;
    }

    /**
     * Retourne le nombre de colonnes de la grille.
     * 
     * @return Nombre de colonnes.
     */
    public int getNbColonnes() {
        return taille;
    }

    /**
     * Retourne le nombre de couleurs utilisées dans le jeu.
     * 
     * @return Nombre de couleurs.
     */
    public int getNbCouleurs() {
        return couleursUtilisees;
    }

    /**
     * Retourne le nombre de lignes de la grille.
     * 
     * @return Nombre de lignes.
     */
    public int getNbLignes() {
        return taille;
    }

    /**
     * Retourne le score actuel du jeu.
     * 
     * @return Score actuel.
     */
    public int getScore() {
        return score;
    }

    /**
     * Retourne les nouvelles couleurs générées pour les billes.
     * 
     * @return Tableau des nouvelles couleurs.
     */
    public int[] getNouvellesCouleurs() {
        return nouvellesCouleurs;
    }

    /**
     * Ajoute un nombre donné de billes aléatoires sur la grille.
     * 
     * @param nombreDeBilles Nombre de billes à ajouter.
     */
    private void ajouterBillesAleatoires(int nombreDeBilles) {
        for (int n = 0; n < nombreDeBilles; n++) {
            int x, y;
            do {
                x = random.nextInt(taille);
                y = random.nextInt(taille);
            } while (grille[x][y] != VIDE);

            int couleur = nouvellesCouleurs[n % nouvellesCouleurs.length];
            grille[x][y] = couleur;
        }
        genererNouvellesCouleurs();
    }

    /**
     * Génère de nouvelles couleurs pour les billes.
     */
    private void genererNouvellesCouleurs() {
        nouvellesCouleurs = new int[3];
        for (int i = 0; i < 3; i++) {
            nouvellesCouleurs[i] = random.nextInt(couleursUtilisees);
        }
    }

    /**
     * Déplace une bille d'une position à une autre si un chemin libre existe.
     * 
     * @param x1 Coordonnée x de la position de départ.
     * @param y1 Coordonnée y de la position de départ.
     * @param x2 Coordonnée x de la position d'arrivée.
     * @param y2 Coordonnée y de la position d'arrivée.
     * @return Liste des cases modifiées.
     */
    public List<Point> deplace(int x1, int y1, int x2, int y2) {

        List<Point> casesModifiees = new ArrayList<>();

        if (grille[x1][y1] != VIDE && grille[x2][y2] == VIDE) {
            boolean[][] visite = new boolean[taille][taille];
            if (cheminLibre(x1, y1, x2, y2, visite)) {
                grille[x2][y2] = grille[x1][y1];
                grille[x1][y1] = VIDE;

                casesModifiees.add(new Point(x1, y1));
                casesModifiees.add(new Point(x2, y2));

                int saveScore = score;
                supprimerAlignements();

                if (saveScore == score) {
                    ajouterBillesAleatoires(3);
                }
            } else {
                System.out.println("Déplacement impossible : aucun chemin libre !");
            }
        } else {
            System.out.println("Déplacement non autorisé : Case de départ vide ou case d'arrivée occupée.");
        }

        return getCasesModifiees();
    }

    /**
     * Vérifie s'il existe un chemin libre entre deux positions.
     * 
     * @param x1     Coordonnée x de la position de départ.
     * @param y1     Coordonnée y de la position de départ.
     * @param x2     Coordonnée x de la position d'arrivée.
     * @param y2     Coordonnée y de la position d'arrivée.
     * @param visite Tableau des cases déjà visitées.
     * @return true si un chemin libre existe, false sinon.
     */
    private boolean cheminLibre(int x1, int y1, int x2, int y2, boolean[][] visite) {
        if (x1 == x2 && y1 == y2) {
            return true;
        }

        visite[x1][y1] = true;

        int[] directionX = { -1, 1, 0, 0 };
        int[] directionY = { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int newX = x1 + directionX[i];
            int newY = y1 + directionY[i];

            if (newX >= 0 && newX < taille && newY >= 0 && newY < taille && !visite[newX][newY]
                    && grille[newX][newY] == VIDE) {
                if (cheminLibre(newX, newY, x2, y2, visite)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Supprime les alignements de billes dans la grille.
     */
    private void supprimerAlignements() {
        boolean[][] aSupprimer = new boolean[taille][taille];
        int totalBillesSupprimees = 0;

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j <= taille - 5; j++) {
                int couleur = grille[i][j];
                if (couleur != VIDE && couleur == grille[i][j + 1] && couleur == grille[i][j + 2] &&
                        couleur == grille[i][j + 3] && couleur == grille[i][j + 4]) {
                    for (int k = 0; k < 5; k++)
                        aSupprimer[i][j + k] = true;
                }
            }
        }

        for (int j = 0; j < taille; j++) {
            for (int i = 0; i <= taille - 5; i++) {
                int couleur = grille[i][j];
                if (couleur != VIDE && couleur == grille[i + 1][j] && couleur == grille[i + 2][j] &&
                        couleur == grille[i + 3][j] && couleur == grille[i + 4][j]) {
                    for (int k = 0; k < 5; k++)
                        aSupprimer[i + k][j] = true;
                }
            }
        }

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (aSupprimer[i][j]) {
                    grille[i][j] = VIDE;
                    totalBillesSupprimees++;
                }
            }
        }

        if (totalBillesSupprimees > 0) {
            score += totalBillesSupprimees * 2;
        }
    }

    /**
     * Retourne la liste de toutes les cases de la grille.
     * 
     * @return Liste de toutes les cases.
     */
    public List<Point> getCasesModifiees() {
        List<Point> toutesLesCases = new ArrayList<>();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                toutesLesCases.add(new Point(i, j));
            }
        }
        return toutesLesCases;
    }

    /**
     * Réinitialise le jeu.
     */
    public void reinit() {
        score = 0;
        grille = new int[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = VIDE;
            }
        }
        genererNouvellesCouleurs();
        ajouterBillesAleatoires(5);
    }

    /**
     * Vérifie si la partie est finie.
     * 
     * @return true si la partie est finie, false sinon.
     */
    public boolean partieFinie() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == VIDE) {
                    return false;
                }
            }
        }
        return true;
    }
}
